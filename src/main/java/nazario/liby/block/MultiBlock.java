package nazario.liby.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public abstract class MultiBlock extends BlockWithEntity {
    public static final BooleanProperty DESTROYED = BooleanProperty.of("destroyed");
    public static final BooleanProperty PARENT = BooleanProperty.of("parent");
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING; // Add facing property for horizontal placement

    public final BlockPos[] childBlocks;

    protected MultiBlock(Settings settings, BlockPos[] childBlocks) {
        super(settings.pistonBehavior(PistonBehavior.BLOCK));

        this.childBlocks = childBlocks;
    }

    @Override
    public void onPlaced(World world, BlockPos masterPos, BlockState masterState, @Nullable LivingEntity placer, ItemStack itemStack) {
        Direction facing = placer.getHorizontalFacing(); // Get player's facing direction

        if (world.getBlockEntity(masterPos) instanceof MultiBlockEntity multiblockEntity) {
            multiblockEntity.setParentPos(masterPos);
        }

        for (int i = 0; i < childBlocks.length; i++) {
            BlockPos rotatedChildPos = rotateBlockPos(childBlocks[i], facing); // Rotate based on facing
            BlockPos childWorldPos = masterPos.add(rotatedChildPos);

            world.setBlockState(childWorldPos, masterState.with(PARENT, false));

            ((MultiBlockEntity) world.getBlockEntity(childWorldPos)).setParentPos(masterPos);
        }
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(DESTROYED, false).with(FACING, ctx.getHorizontalPlayerFacing());
    }

    // Helper method to rotate BlockPos based on the facing direction
    private BlockPos rotateBlockPos(BlockPos pos, Direction facing) {
        return switch (facing) {
            case NORTH -> pos; // No rotation needed for NORTH
            case SOUTH -> new BlockPos(-pos.getX(), pos.getY(), -pos.getZ());
            case WEST -> new BlockPos(pos.getZ(), pos.getY(), -pos.getX());
            case EAST -> new BlockPos(-pos.getZ(), pos.getY(), pos.getX());
            default -> pos;
        };
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
        return state;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.equals(newState)) return;

        if(state.get(PARENT)) {
            for (int i = 0; i < childBlocks.length; i++) {
                BlockPos rotatedChildPos = rotateBlockPos(childBlocks[i], state.get(FACING));
                BlockPos childWorldPos = pos.add(rotatedChildPos);

                BlockState childState = world.getBlockState(childWorldPos);
                if (childState.getBlock() instanceof MultiBlock && !childState.get(PARENT)) {
                    world.setBlockState(childWorldPos, state.with(PARENT, false).with(DESTROYED, true));
                }
            }
            //world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            super.onStateReplaced(state, world, pos, newState, moved);
            return;
        }

        if(newState.getBlock() instanceof MultiBlock) {
            if(newState.get(DESTROYED) && !newState.get(PARENT)) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }

        if(state.getBlock() instanceof MultiBlock) {
            if(!state.get(DESTROYED) && !state.get(PARENT)) {
                MultiBlockEntity entity = (MultiBlockEntity)world.getBlockEntity(pos);

                if(entity == null) return;

                BlockPos parentPos = entity.parentPos;
                this.onStateReplaced(world.getBlockState(parentPos), world, parentPos, Blocks.AIR.getDefaultState(), moved);
            }
        }

        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!state.get(PARENT)) {
            MultiBlockEntity entity = (MultiBlockEntity)world.getBlockEntity(pos);
            if(entity.parentPos == null) return super.onUse(state, world, pos, player, hit);
            return onMultiBlockUse(world, state, world.getBlockState(entity.parentPos), pos, entity.parentPos, player, hit);
        }

        return onMultiBlockUse(world, state, state, pos, pos, player, hit);
    }

    public ActionResult onMultiBlockUse(World world, BlockState state, BlockState parentState, BlockPos pos, BlockPos parentPos, PlayerEntity player ,BlockHitResult hit) {
        return ActionResult.PASS;
    }


    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!state.get(PARENT)) {
            MultiBlockEntity entity = (MultiBlockEntity)world.getBlockEntity(pos);
            if(entity.parentPos == null) return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
            return onMultiBlockWithItem(world, stack, player, hand, hit, state, world.getBlockState(entity.parentPos), pos, entity.parentPos);
        }

        return onMultiBlockWithItem(world, stack, player, hand, hit, state, state, pos, pos);
    }

    public ItemActionResult onMultiBlockWithItem(World world, ItemStack stack, PlayerEntity player, Hand hand, BlockHitResult hit, BlockState state, BlockState parentState, BlockPos pos, BlockPos parentPos) {
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PARENT, FACING, DESTROYED); // Add FACING to block properties
    }
}
