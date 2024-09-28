package nazario.researchfrontiers.block;

import com.mojang.serialization.MapCodec;
import nazario.researchfrontiers.research.screen.ResearchScreen;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ResearchTable extends Block {
    public ResearchTable(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient) return super.onUse(state, world, pos, player, hit);
        MinecraftClient.getInstance().setScreen(new ResearchScreen(Text.literal("Research")));
        return super.onUse(state, world, pos, player, hit);
    }
}
