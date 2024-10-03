package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.liby.block.Multiblock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BigOvenBlock extends Multiblock {
    public BigOvenBlock(Settings settings) {
        super(settings, new BlockPos[]{
                new BlockPos(1, 0, 0)
        });
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(BigOvenBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BigOvenBlockEntity(pos, state);
    }
}
