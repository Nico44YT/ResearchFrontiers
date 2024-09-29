package nazario.researchfrontiers.item.client.blast_furnace;

import nazario.researchfrontiers.item.BlastFurnaceItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BlastFurnaceItemRenderer extends GeoItemRenderer<BlastFurnaceItem> {
    public BlastFurnaceItemRenderer() {
        super(new BlastFurnaceItemModel());
    }
}
