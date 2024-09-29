package nazario.researchfrontiers.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import nazario.researchfrontiers.ResearchFrontiers;

public class ModItems {

    // Definition des Lithium-Items ohne Item-Gruppe
    public static final Item LITHIUM = new Item(new Item.Settings());

    // Registriere das Lithium-Item im Minecraft-Registry
    public static void registerItems() {
        // Verwendung von Identifier.of() anstelle des privaten Konstruktors
        Registry.register(Registries.ITEM, Identifier.of(ResearchFrontiers.MOD_ID, "lithium"), LITHIUM);
    }
}
