package nazario.researchfrontiers.registry;

import nazario.liby.registry.LibyItemGroupRegister;
import nazario.liby.registry.LibyRegistry;
import nazario.researchfrontiers.ResearchFrontiers;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;


public class ItemGroupRegistry implements LibyRegistry {

    public static final LibyItemGroupRegister REGISTER = new LibyItemGroupRegister(ResearchFrontiers.MOD_ID);

    public static final ItemGroup RESOURCE_GROUP = REGISTER.registerItemGroup("resource", ItemRegistry.STEEL_INGOT, Text.translatable("itemGroup.research_frontiers.resources"),
            ItemRegistry.STEEL_INGOT,
            ItemRegistry.FIRE_CLAY_BRICK,
            ItemRegistry.LITHIUM,
            BlockRegistry.WET_FIRE_CLAY_BRICK
    );

    public static final ItemGroup MACHINES_GROUP = Registry.register(Registries.ITEM_GROUP,
            ResearchFrontiers.id("machines"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BlockRegistry.RESEARCH_TABLE))
                    .displayName(Text.translatable("itemGroup.research_frontiers.machines"))
                    .entries((ctx, entries) -> {
                        entries.add(BlockRegistry.BLAST_FURNACE);
                        entries.add(BlockRegistry.RESEARCH_TABLE);
                        entries.add(BlockRegistry.WORKBENCH);
                    }).build()
            );

    public static final ItemGroup BUILDING_GROUP = Registry.register(Registries.ITEM_GROUP,
            ResearchFrontiers.id("building"),
            FabricItemGroup.builder().icon(() -> new ItemStack(BlockRegistry.FIRE_CLAY_BRICKS))
                    .displayName(Text.translatable("itemGroup.research_frontiers.building"))
                    .entries((ctx, entries) -> {
                        entries.add(BlockRegistry.FIRE_CLAY_BRICKS);
                        entries.add(BlockRegistry.FIRE_CLAY_BRICKS_STAIRS);
                        entries.add(BlockRegistry.FIRE_CLAY_BRICKS_SLAB);
                        entries.add(BlockRegistry.FIRE_CLAY_BRICKS_WALL);
                    }).build()
    );

   public static void register() {
   }
}
