package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.researchfrontiers.block.custom.TwoWideBlock;
import net.minecraft.block.BlockState;
import net.minecraft.screen.*;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorkbenchBlock extends TwoWideBlock {
    public static final MapCodec<WorkbenchBlock> CODEC = createCodec(WorkbenchBlock::new);
    private static final Text TITLE = Text.translatable("container.workbench");
    public WorkbenchBlock(Settings settings) {
        super(settings);
    }
}
