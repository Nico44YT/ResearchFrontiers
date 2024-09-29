package nazario.researchfrontiers.block.blast_furnace.client;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class BlastFurnaceModel extends GeoModel<BlastFurnaceEntity> {
    @Override
    public Identifier getModelResource(BlastFurnaceEntity animatable) {
        return ResearchFrontiers.id("geo/blast_furnace.geo.json");
    }

    @Override
    public Identifier getTextureResource(BlastFurnaceEntity animatable) {
        return ResearchFrontiers.id("textures/block/blast_furnace.png");
    }

    @Override
    public Identifier getAnimationResource(BlastFurnaceEntity animatable) {
        return ResearchFrontiers.id("animations/blast_furnace.animation.json");
    }
}
