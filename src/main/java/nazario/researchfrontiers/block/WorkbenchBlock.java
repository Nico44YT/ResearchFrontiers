package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.researchfrontiers.block.custom.TwoWideBlock;
import nazario.researchfrontiers.block.custom.TwoWideBlockSide;
import nazario.researchfrontiers.util.VoxelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.text.Text;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class WorkbenchBlock extends TwoWideBlock {
    public static final MapCodec<WorkbenchBlock> CODEC = createCodec(WorkbenchBlock::new);
    private static final Text TITLE = Text.translatable("container.workbench");

    private static final VoxelShape LEFT_SHAPE = Stream.of(
            Block.createCuboidShape(-14, 0, 2, 14, 14, 14),
            Block.createCuboidShape(-16, 14, 0, 16, 16, 16),
            Block.createCuboidShape(-16, 16, 14, 16, 24, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape RIGHT_SHAPE = Stream.of(
            Block.createCuboidShape(2, 0, 2, 30, 14, 14),
            Block.createCuboidShape(0, 14, 0, 32, 16, 16),
            Block.createCuboidShape(0, 16, 14, 32, 24, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public WorkbenchBlock(Settings settings) {
        super(settings);

        settings.pistonBehavior(PistonBehavior.BLOCK);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return state.get(SIDE).equals(TwoWideBlockSide.LEFT) ? BlockRenderType.MODEL : BlockRenderType.INVISIBLE;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int rotation = switch(state.get(FACING)) {
            case DOWN -> 0;
            case UP -> 0;
            case NORTH -> 180;
            case SOUTH -> 0;
            case WEST -> 90;
            case EAST -> 270;
        };

        return VoxelUtil.rotate(state.get(SIDE).equals(TwoWideBlockSide.LEFT) ? LEFT_SHAPE : RIGHT_SHAPE, rotation);
    }
}
