package nazario.researchfrontiers.block;

import nazario.liby.block.MultiBlockEntity;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BigOvenBlockEntity extends MultiBlockEntity {
    public BigOvenBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.BIG_OVEN_ENTITY, pos, state);
    }
}
