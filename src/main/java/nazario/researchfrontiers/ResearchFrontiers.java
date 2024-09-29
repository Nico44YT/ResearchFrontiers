package nazario.researchfrontiers;

import nazario.researchfrontiers.events.ServerConnectionEvents;
import nazario.researchfrontiers.registry.BlockEntityRegistry;
import nazario.researchfrontiers.registry.BlockRegistry;
import nazario.researchfrontiers.registry.ItemRegistry;
import nazario.researchfrontiers.registry.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import nazario.researchfrontiers.registry.ModItems;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.util.Identifier;
public class ResearchFrontiers implements ModInitializer {

    public static final String MOD_ID = "research_frontiers";

    @Override
    public void onInitialize() {
        BlockRegistry.register();
        ItemRegistry.register();
        BlockEntityRegistry.register();
        ModItemGroups.registerItemGroups();
        ModItems.registerItems();
        ServerPlayConnectionEvents.JOIN.register(ServerConnectionEvents.JOIN_EVENT.invoker());
        ServerPlayConnectionEvents.DISCONNECT.register(ServerConnectionEvents.LEAVE_EVENT.invoker());
        ServerPlayConnectionEvents.INIT.register(ServerConnectionEvents.INIT_EVENT.invoker());

    }

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}
