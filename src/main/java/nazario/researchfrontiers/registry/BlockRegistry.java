package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.ResearchTable;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockRegistry {

    public static Block RESEARCH_TABLE = registerBlock("research_table", new ResearchTable(AbstractBlock.Settings.create()), new Item.Settings());

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, ResearchFrontiers.id(name), block);
    }

    private static Block registerBlock(String name, Block block, Item.Settings settings) {
        ItemRegistry.registerItem(name, new BlockItem(block, settings));
        return registerBlock(name, block);
    }

    public static void register() {}
}
