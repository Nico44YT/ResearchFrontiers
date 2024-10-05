package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.liby.block.LibyMultiBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WorkbenchBlock extends LibyMultiBlock {
    public WorkbenchBlock(Settings settings) {
        super(settings, new BlockPos[]{
                new BlockPos(0, 0, 0),
                new BlockPos(-1, 0, 0)
        });
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(WorkbenchBlock::new);
    }

    @Override
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WorkbenchBlockEntity(pos, state);
    }

    @Override
    public ActionResult onMultiBlockUse(World world, BlockState state, BlockState parentState, BlockPos pos, BlockPos parentPos, PlayerEntity player, BlockHitResult hit) {
        if(world.isClient) return ActionResult.PASS;

        player.sendMessage(Text.literal("Hello from Workbench!"));

        return ActionResult.SUCCESS;
    }
}
