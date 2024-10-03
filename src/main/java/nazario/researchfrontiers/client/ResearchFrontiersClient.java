package nazario.researchfrontiers.client;


import nazario.researchfrontiers.block.Cable;
import nazario.researchfrontiers.block.blast_furnace.client.BlastFurnaceRenderer;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import nazario.researchfrontiers.registry.BlockRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class ResearchFrontiersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(BlockEntityRegistry.BLAST_FURNACE_ENTITY, BlastFurnaceRenderer::new);

        ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
            @Override
            public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
                if (world != null && pos != null) {
                    Object renderData = world.getBlockEntityRenderData(pos);
                    if (renderData instanceof Integer color) {
                        return color;
                    }
                }
                return 0xFFFFFF; // Default color
            }
        }, BlockRegistry.CABLE_BLOCK);
    }
}
