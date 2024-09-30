package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ItemGroupRegistry {
    public static final ItemGroup RESOURCE_GROUP = Registry.register(Registries.ITEM_GROUP,
            ResearchFrontiers.id("resource"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ItemRegistry.STEEL_INGOT))
                    .displayName(Text.translatable("itemGroup.research_frontiers.resources"))
                            .entries((displayContext, entries) -> {
                                entries.add(ItemRegistry.STEEL_INGOT);
                                entries.add(ItemRegistry.FIRE_CLAY_BRICK);
                                entries.add(ItemRegistry.LITHIUM);
                                entries.add(BlockRegistry.WET_FIRE_CLAY_BRICK);
                            }).build());


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
