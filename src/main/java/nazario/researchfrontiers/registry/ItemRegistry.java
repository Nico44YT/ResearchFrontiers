package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemRegistry {
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, ResearchFrontiers.id(name), item);
    }

    public static void register() {}
}
