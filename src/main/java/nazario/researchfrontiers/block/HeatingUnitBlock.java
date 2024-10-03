package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class HeatingUnitBlock extends BlockWithEntity {

    HeatingUnitType type;
    int maxHeat;

    public HeatingUnitBlock(HeatingUnitType type, Settings settings, int maxHeat) {
        super(settings);

        this.type = type;
        this.maxHeat = maxHeat;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

}
