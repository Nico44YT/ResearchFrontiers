package nazario.researchfrontiers;

import nazario.liby.registry.auto.LibyRegistryLoader;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class ResearchFrontiers implements ModInitializer {

    public static final String MOD_ID = "research_frontiers";

    @Override
    public void onInitialize() {
        LibyRegistryLoader.load("nazario.researchfrontiers.registry");
    }

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}
