package nazario.researchfrontiers.block.blast_furnace.client;

import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BlastFurnaceRenderer extends GeoBlockRenderer<BlastFurnaceEntity> {
    public BlastFurnaceRenderer(BlockEntityRendererFactory.Context ctx) {
        super(new BlastFurnaceModel());
    }
}
