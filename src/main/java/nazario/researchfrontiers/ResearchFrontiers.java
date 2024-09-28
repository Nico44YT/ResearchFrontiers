package nazario.researchfrontiers;

import nazario.researchfrontiers.block.BlockRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class ResearchFrontiers implements ModInitializer {

    public static final String MOD_ID = "researchfrontiers";

    @Override
    public void onInitialize() {
        BlockRegistry.register();
    }

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}
