package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.liby.block.MultiBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BigOvenBlock extends MultiBlock {
    public BigOvenBlock(Settings settings) {
        super(settings, new BlockPos[]{
                new BlockPos(1, 0, 0),
                new BlockPos(0, 0, -1),
                new BlockPos(1, 0, -1),
                new BlockPos(-1, 0, 0),
                new BlockPos(1, 0, -1),
                new BlockPos(-1, 0, -1),
                new BlockPos(0, 1, 0),
                new BlockPos(1, 1, 0),
                new BlockPos(0, 1, -1),
                new BlockPos(1, 1, -1),
                new BlockPos(-1, 1, 0),
                new BlockPos(1, 1, -1),
                new BlockPos(-1, 1, -1),
                new BlockPos(0, 2, 0),
                new BlockPos(1, 2, 0),
                new BlockPos(0, 2, -1),
                new BlockPos(1, 2, -1),
                new BlockPos(-1, 2, 0),
                new BlockPos(1, 2, -1),
                new BlockPos(-1, 2, -1),
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
