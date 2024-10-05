package nazario.researchfrontiers.block;

import nazario.liby.block.LibyMultiBlockEntity;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class WorkbenchBlockEntity extends LibyMultiBlockEntity {
    public WorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.WORKBENCH, pos, state);
    }
}
