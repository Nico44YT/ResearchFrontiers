package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.WetFireClayBrickBlock;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnace;
import nazario.researchfrontiers.block.ResearchTable;
import nazario.researchfrontiers.block.WorkbenchBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockRegistry {

    public static Block FIRE_CLAY_BRICKS = registerBlock("fire_clay_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), new Item.Settings());
    public static Block FIRE_CLAY_BRICKS_SLABS = registerBlock("fire_clay_brick_slabs", new SlabBlock(AbstractBlock.Settings.copy(Blocks.BRICK_SLAB)), new Item.Settings());
    public static Block FIRE_CLAY_BRICKS_STAIRS = registerBlock("fire_clay_brick_stairs", new StairsBlock(BlockRegistry.FIRE_CLAY_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BRICK_STAIRS)), new Item.Settings());

    public static Block RESEARCH_TABLE = registerBlock("research_table", new ResearchTable(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)), new Item.Settings());
    public static Block WORKBENCH = registerBlock("workbench", new WorkbenchBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)), new Item.Settings());

    public static Block BLAST_FURNACE = registerBlock("blast_furnace", new BlastFurnace(AbstractBlock.Settings.copy(Blocks.COBBLESTONE)), new Item.Settings());

    public static Block WET_FIRE_CLAY_BRICK = registerBlock("wet_fire_clay_brick", new WetFireClayBrickBlock(AbstractBlock.Settings.copy(Blocks.WET_SPONGE).strength(0.1f, 0.1f)), new Item.Settings());

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, ResearchFrontiers.id(name), block);
    }

    private static Block registerBlock(String name, Block block, Item.Settings settings) {
        ItemRegistry.registerItem(name, new BlockItem(block, settings));
        return registerBlock(name, block);
    }

    public static void register() {}
}
