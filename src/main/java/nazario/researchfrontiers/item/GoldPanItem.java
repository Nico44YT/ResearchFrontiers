package nazario.researchfrontiers.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class GoldPanItem extends Item {
    public GoldPanItem(Settings settings) {
        super(settings.maxDamage(64));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.WATER);

        if (blockHitResult.getType() == HitResult.Type.MISS) return TypedActionResult.pass(itemStack);

        if (blockHitResult.getType() != HitResult.Type.BLOCK) return TypedActionResult.pass(itemStack);

            BlockPos blockPos = blockHitResult.getBlockPos();

            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();





            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack, world.isClient());
    }

}
