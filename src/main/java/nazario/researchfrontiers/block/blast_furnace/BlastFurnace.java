package nazario.researchfrontiers.block.blast_furnace;

import com.mojang.serialization.MapCodec;
import com.teamresourceful.resourcefullib.client.highlights.base.Highlight;
import com.teamresourceful.resourcefullib.client.highlights.base.Highlightable;
import nazario.researchfrontiers.ResearchFrontiers;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class BlastFurnace extends BlockWithEntity {

    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(3, 0, 3, 13, 13, 13),
            Block.createCuboidShape(13, 0, 3, 16, 13, 13),
            Block.createCuboidShape(0, 0, 3, 3, 13, 13),
            Block.createCuboidShape(3, 0, 0, 13, 13, 3),
            Block.createCuboidShape(3, 0, 13, 13, 13, 16),
            Block.createCuboidShape(0, 0, 0, 16, 1, 16),
            Block.createCuboidShape(1, 0, 1, 3, 13, 3),
            Block.createCuboidShape(13, 0, 1, 15, 13, 3),
            Block.createCuboidShape(1, 0, 13, 3, 13, 15),
            Block.createCuboidShape(13, 0, 13, 15, 13, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final MapCodec<BlastFurnace> CODEC = createCodec(BlastFurnace::new);


    public static final EnumProperty<BlastFurnaceState> OPEN = EnumProperty.of("door", BlastFurnaceState.class);

    public BlastFurnace(Settings settings) {
        super(settings);
        // Set the default state with OPEN set to false
        this.setDefaultState(this.stateManager.getDefaultState().with(OPEN, BlastFurnaceState.CLOSED));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Ensure the block is placed with OPEN set to false
        return this.getDefaultState().with(OPEN, BlastFurnaceState.CLOSED);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.isSneaking()) {
            // Toggle the OPEN state when the player is sneaking
            world.setBlockState(pos, state.cycle(OPEN));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        // Pass the current state with the correct OPEN value to the block entity
        return new BlastFurnaceEntity(pos, state);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OPEN);
    }

    @Override
    protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1f;
    }
}
