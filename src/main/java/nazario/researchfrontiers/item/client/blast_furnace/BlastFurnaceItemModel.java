package nazario.researchfrontiers.item.client.blast_furnace;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import nazario.researchfrontiers.item.BlastFurnaceItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BlastFurnaceItemModel extends GeoModel<BlastFurnaceItem> {
    @Override
    public Identifier getModelResource(BlastFurnaceItem animatable) {
        return ResearchFrontiers.id("geo/blast_furnace.geo.json");
    }

    @Override
    public Identifier getTextureResource(BlastFurnaceItem animatable) {
        return ResearchFrontiers.id("textures/block/blast_furnace.png");
    }

    @Override
    public Identifier getAnimationResource(BlastFurnaceItem animatable) {
        return ResearchFrontiers.id("animations/blast_furnace.animation.json");
    }
}
