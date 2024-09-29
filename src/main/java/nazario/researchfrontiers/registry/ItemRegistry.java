package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemRegistry {

    public static Item FIRE_CLAY_BRICK = registerSimpleItem("fire_clay_brick", 16);

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, ResearchFrontiers.id(name), item);
    }

    public static Item registerSimpleItem(String name) {
        return registerSimpleItem(name, 64);
    }

    public static Item registerSimpleItem(String name, int maxCount) {
        return registerItem(name, new Item(new Item.Settings().maxCount(maxCount)));
    }

    public static void register() {}
}
