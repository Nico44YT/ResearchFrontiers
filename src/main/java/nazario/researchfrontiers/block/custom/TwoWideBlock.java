package nazario.researchfrontiers.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public abstract class TwoWideBlock extends HorizontalFacingBlock {

    public static final EnumProperty<TwoWideBlockSide> SIDE = EnumProperty.of("side", TwoWideBlockSide.class);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public TwoWideBlock(Settings settings) {
        super(settings);

        settings.pistonBehavior(PistonBehavior.BLOCK);
    }


    /**
     * Override @canPlaceAt(BlockState state, WorldView world, BlockPos pos, BlockPos adjacentPos)
     * @param state
     * @param world
     * @param pos
     * @return
     */
    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction facing = state.get(FACING).rotateYClockwise();
        BlockPos adjacentPos = pos.offset(facing);

        return canPlaceAt(state, world, pos, adjacentPos);
    }


    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos, BlockPos adjacentPos) {
        if (world.getBlockState(pos).getBlock() == Blocks.AIR && world.getBlockState(adjacentPos).getBlock() == Blocks.AIR) {
            return true;
        }
        return false;
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Direction facing = state.get(FACING).rotateYClockwise();

        if (state.get(SIDE).equals(TwoWideBlockSide.LEFT)) {
            return onUse(state, world, pos, pos.offset(facing), player, hit);
        } else {
            return onUse(world.getBlockState(pos.offset(facing.getOpposite())), world, pos.offset(facing.getOpposite()), pos, player, hit);
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos basePos, BlockPos adjacentPos, PlayerEntity player, BlockHitResult hit) {
        return super.onUse(state, world, basePos, player, hit);
    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        Direction facing = state.get(FACING).rotateYClockwise();
        BlockPos adjacentPos = pos.offset(facing);
        world.setBlockState(adjacentPos, state.with(SIDE, TwoWideBlockSide.RIGHT));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(SIDE, TwoWideBlockSide.LEFT).with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        Direction facing = state.get(FACING).rotateYClockwise();

        if(state.get(SIDE).equals(TwoWideBlockSide.LEFT)) {
            world.setBlockState(pos.offset(facing), Blocks.AIR.getDefaultState());
        } else {
            world.setBlockState(pos.offset(facing.getOpposite()), Blocks.AIR.getDefaultState());
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SIDE, FACING);
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
