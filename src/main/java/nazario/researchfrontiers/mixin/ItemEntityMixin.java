package nazario.researchfrontiers.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.sound.SoundEvents;
import java.util.Random;@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

    private int tickCounter = 0;
    private boolean isBurning = false;
    private int explosionTime = 0;
    private boolean isInWater = false;

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo info) {
        ItemEntity itemEntity = (ItemEntity) (Object) this;
        World world = itemEntity.getWorld();
        BlockPos itemPos = itemEntity.getBlockPos();

        // Check if the item is in water
        if (world.isWater(itemPos)) {
            isInWater = true;
            if (!isBurning) {
                // Start burning if the item is in water
                itemEntity.setOnFireFor(100); // 100 ticks = 5 seconds of fire
                isBurning = true;
                tickCounter = 0; // reset timer
                explosionTime = new Random().nextInt(3) + 2; // generate a random time between 2 and 5 seconds
            }

            // Make the item swim on the water's surface
            itemEntity.setVelocity(itemEntity.getVelocity().add(0, 0.005, 0));
        } else if (isInWater) {
            // Trigger an explosion when the item is picked up from water
            world.createExplosion(itemEntity, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 4.0f, World.ExplosionSourceType.TNT);
            itemEntity.discard();
            isInWater = false;
        }

        // If the item is burning, track the time
        if (isBurning) {
            tickCounter++;

            // Add particles
            world.addParticle(ParticleTypes.FLAME, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 0.0, 0.0, 0.0);
            world.addParticle(ParticleTypes.SMOKE, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 0.0, 0.0, 0.0);

            // Play oven sound
            world.playSound(null, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f);

            // After the random time, make the item explode
            if (tickCounter >= explosionTime * 20) { // convert seconds to ticks
                float explosionStrength = 2.0f + (itemEntity.getStack().getCount() * 0.5f); // adjust explosion strength based on stack size
                world.createExplosion(itemEntity, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), explosionStrength, World.ExplosionSourceType.TNT);
                itemEntity.discard(); // Remove the item entity after the explosion
            }
        }
    }
}