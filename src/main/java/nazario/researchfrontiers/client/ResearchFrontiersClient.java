package nazario.researchfrontiers.client;

import nazario.researchfrontiers.block.blast_furnace.client.BlastFurnaceRenderer;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import nazario.researchfrontiers.registry.BlockRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class ResearchFrontiersClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(BlockEntityRegistry.BLAST_FURNACE_ENTITY, BlastFurnaceRenderer::new);
    }
}
