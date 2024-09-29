package nazario.researchfrontiers.item;

import nazario.researchfrontiers.item.client.blast_furnace.BlastFurnaceItemRenderer;
import nazario.researchfrontiers.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.BlockItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;


public class BlastFurnaceItem extends BlockItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public BlastFurnaceItem(Settings settings) {
        super(BlockRegistry.BLAST_FURNACE, settings);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public Object getRenderProvider() {
        return new GeoRenderProvider() {
            @Override
            public @Nullable BuiltinModelItemRenderer getGeoItemRenderer() {
                return new BlastFurnaceItemRenderer();
            }
        };
    }
}
