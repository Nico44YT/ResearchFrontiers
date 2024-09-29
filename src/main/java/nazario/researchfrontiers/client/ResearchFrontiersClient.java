package nazario.researchfrontiers.client;

import nazario.researchfrontiers.block.blast_furnace.client.BlastFurnaceRenderer;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ResearchFrontiersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(BlockEntityRegistry.BLAST_FURNACE_ENTITY, BlastFurnaceRenderer::new);
    }
}
