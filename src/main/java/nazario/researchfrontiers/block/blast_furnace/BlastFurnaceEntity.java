package nazario.researchfrontiers.block.blast_furnace;

import nazario.researchfrontiers.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.RenderUtil;

public class BlastFurnaceEntity extends BlockEntity implements GeoBlockEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private BlockState prevState;

    private boolean initAnim = false;

    public BlastFurnaceEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.BLAST_FURNACE_ENTITY, pos, state);
        prevState = state;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        try{
            BlockState state = world.getBlockState(pos);

            if(!initAnim) {
                switch(state.get(BlastFurnace.OPEN)) {
                    case OPEN -> tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.furnace.open", Animation.LoopType.HOLD_ON_LAST_FRAME));
                    case CLOSED -> tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.furnace.close", Animation.LoopType.HOLD_ON_LAST_FRAME));
                }

                initAnim = true;
            }

            if(!state.get(BlastFurnace.OPEN).equals(prevState.get(BlastFurnace.OPEN))) {
                switch(state.get(BlastFurnace.OPEN)) {
                    case OPEN -> tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.furnace.open", Animation.LoopType.HOLD_ON_LAST_FRAME));
                    case CLOSED -> tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.furnace.close", Animation.LoopType.HOLD_ON_LAST_FRAME));
                }

                prevState = state;
            }
        }catch (Exception ignore) {};

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtil.getCurrentTick();
    }
}
