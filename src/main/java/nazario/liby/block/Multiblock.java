package nazario.liby.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class Multiblock extends BlockWithEntity {
    public static final BooleanProperty PARENT = BooleanProperty.of("parent");
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING; // Add facing property for horizontal placement

    public final BlockPos[] childBlocks;

    protected Multiblock(Settings settings, BlockPos[] childBlocks) {
        super(settings.pistonBehavior(PistonBehavior.BLOCK));

        this.childBlocks = childBlocks;
    }

    @Override
    public void onPlaced(World world, BlockPos masterPos, BlockState masterState, @Nullable LivingEntity placer, ItemStack itemStack) {
        Direction facing = placer.getHorizontalFacing(); // Get player's facing direction
        BlockState stateWithFacing = masterState.with(FACING, facing); // Set the block facing direction

        world.setBlockState(masterPos, stateWithFacing.with(PARENT, true));
        if (world.getBlockEntity(masterPos) instanceof MultiblockEntity multiblockEntity) {
            multiblockEntity.setParentPos(masterPos);
        }

        for (int i = 0; i < childBlocks.length; i++) {
            BlockPos rotatedChildPos = rotateBlockPos(childBlocks[i], facing); // Rotate based on facing
            BlockPos childWorldPos = masterPos.add(rotatedChildPos);

            world.setBlockState(childWorldPos, stateWithFacing.with(PARENT, false));

            ((MultiblockEntity) world.getBlockEntity(childWorldPos)).setParentPos(masterPos);
        }
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
        Direction facing = state.get(FACING); // Get the block's facing direction

        if (state.get(PARENT)) {
            for (int i = 0; i < childBlocks.length; i++) {
                BlockPos rotatedChildPos = rotateBlockPos(childBlocks[i], facing); // Rotate child position on break
                BlockPos childWorldPos = pos.add(rotatedChildPos);

                world.setBlockState(childWorldPos, Blocks.AIR.getDefaultState());
            }
        } else {
            BlockPos parentPos = ((MultiblockEntity) world.getBlockEntity(pos)).parentPos;

            if (parentPos == null) return super.onBreak(world, pos, state, player);

            for (int i = 0; i < childBlocks.length; i++) {
                BlockPos rotatedChildPos = rotateBlockPos(childBlocks[i], facing); // Rotate child position on break
                BlockPos childWorldPos = parentPos.add(rotatedChildPos);

                world.setBlockState(childWorldPos, Blocks.AIR.getDefaultState());
            }

            world.setBlockState(parentPos, Blocks.AIR.getDefaultState());
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PARENT, FACING); // Add FACING to block properties
    }
}
