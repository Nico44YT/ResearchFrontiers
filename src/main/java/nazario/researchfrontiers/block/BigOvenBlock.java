package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.liby.block.LibyMultiBlock;
import nazario.liby.block.LibyMultiBlockShapes;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BigOvenBlock extends LibyMultiBlock {
    public BigOvenBlock(Settings settings) {
        super(settings, LibyMultiBlockShapes.THREE_BY_THREE);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(BigOvenBlock::new);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return state.get(PARENT)?BlockRenderType.MODEL:BlockRenderType.INVISIBLE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BigOvenBlockEntity(pos, state);
    }
}
