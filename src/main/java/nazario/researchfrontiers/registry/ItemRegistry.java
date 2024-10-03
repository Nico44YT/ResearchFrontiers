package nazario.researchfrontiers.registry;

import nazario.liby.registry.LibyItemRegister;
import nazario.liby.registry.LibyRegistry;
import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.item.GoldPanItem;
import nazario.researchfrontiers.item.WaterReactiveItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemRegistry implements LibyRegistry {
    public static final LibyItemRegister REGISTER = new LibyItemRegister(ResearchFrontiers.MOD_ID);


    public static Item STEEL_INGOT = REGISTER.registerItem("steel_ingot", new Item(new Item.Settings()));
    public static Item FIRE_CLAY_BRICK = REGISTER.registerItem("fire_clay_brick", new Item(new Item.Settings()));
    public static Item LITHIUM = REGISTER.registerItem("lithium", new WaterReactiveItem(new Item.Settings()));

    public static Item GOLD_PAN = REGISTER.registerItem("gold_pan", new GoldPanItem(new Item.Settings()));

    public static void register() {}
}
