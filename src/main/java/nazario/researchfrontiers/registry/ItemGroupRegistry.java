package nazario.researchfrontiers.registry;

import nazario.liby.registry.auto.LibyAutoRegister;
import nazario.liby.item.LibyItemGroup;
import nazario.liby.registry.helper.LibyItemGroupRegister;
import nazario.researchfrontiers.ResearchFrontiers;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;


@LibyAutoRegister(priority = 10)
public class ItemGroupRegistry {

    public static final LibyItemGroupRegister REGISTER = new LibyItemGroupRegister(ResearchFrontiers.MOD_ID);

    public static final LibyItemGroup RESOURCE_GROUP = new LibyItemGroup("resource", Text.translatable("itemGroup.research_frontiers.resources"), new ItemStack(ItemRegistry.STEEL_INGOT));
    public static final LibyItemGroup MACHINES_GROUP = new LibyItemGroup("machines", Text.translatable("itemGroup.research_frontiers.machines"), new ItemStack(BlockRegistry.BLAST_FURNACE));
    public static final LibyItemGroup BUILDING_GROUP = new LibyItemGroup("building", Text.translatable("itemGroup.research_frontiers.building"), new ItemStack(BlockRegistry.FIRE_CLAY_BRICKS));


   public static void register() {
       RESOURCE_GROUP.addItem(ItemRegistry.FIRE_CLAY_BRICK, ItemRegistry.STEEL_INGOT, ItemRegistry.LITHIUM, BlockRegistry.WET_FIRE_CLAY_BRICK);
       MACHINES_GROUP.addItem(BlockRegistry.BLAST_FURNACE, BlockRegistry.RESEARCH_TABLE, BlockRegistry.WORKBENCH);
       BUILDING_GROUP.addItem(BlockRegistry.FIRE_CLAY_BRICKS, BlockRegistry.FIRE_CLAY_BRICKS_STAIRS, BlockRegistry.FIRE_CLAY_BRICKS_SLAB, BlockRegistry.FIRE_CLAY_BRICKS_WALL);

       REGISTER.registerItemGroups(RESOURCE_GROUP, MACHINES_GROUP, BUILDING_GROUP);
   }
}
