package nazario.researchfrontiers.registry;

import nazario.liby.registry.LibyBlockRegister;
import nazario.liby.registry.LibyRegistry;
import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.Cable;
import nazario.researchfrontiers.block.WetFireClayBrickBlock;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnace;
import nazario.researchfrontiers.block.ResearchTable;
import nazario.researchfrontiers.block.WorkbenchBlock;
import net.minecraft.block.*;
import net.minecraft.item.Item;

public class BlockRegistry implements LibyRegistry {

    public static final LibyBlockRegister REGISTER = new LibyBlockRegister(ResearchFrontiers.MOD_ID);

    public static Block CABLE_BLOCK = REGISTER.registerBlock("cable", new Cable.Block(AbstractBlock.Settings.create()));
    public static Block FIRE_CLAY_BRICKS = REGISTER.registerBlock("fire_clay_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), new Item.Settings());
    public static Block FIRE_CLAY_BRICKS_SLAB = REGISTER.registerBlock("fire_clay_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(BlockRegistry.FIRE_CLAY_BRICKS).solid()), new Item.Settings());
    public static Block FIRE_CLAY_BRICKS_STAIRS = REGISTER.registerBlock("fire_clay_brick_stairs", new StairsBlock(BlockRegistry.FIRE_CLAY_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BRICK_STAIRS)), new Item.Settings());
    public static Block FIRE_CLAY_BRICKS_WALL = REGISTER.registerBlock("fire_clay_brick_wall", new WallBlock(AbstractBlock.Settings.copy(BlockRegistry.FIRE_CLAY_BRICKS).solid()), new Item.Settings());

    public static Block RESEARCH_TABLE = REGISTER.registerBlock("research_table", new ResearchTable(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)), new Item.Settings());
    public static Block WORKBENCH = REGISTER.registerBlock("workbench", new WorkbenchBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)), new Item.Settings());

    public static Block BLAST_FURNACE = REGISTER.registerBlock("blast_furnace", new BlastFurnace(AbstractBlock.Settings.copy(Blocks.COBBLESTONE)), new Item.Settings());

    public static Block WET_FIRE_CLAY_BRICK = REGISTER.registerBlock("wet_fire_clay_brick", new WetFireClayBrickBlock(AbstractBlock.Settings.copy(Blocks.WET_SPONGE).strength(0.1f, 0.1f)), new Item.Settings());


    public static void register() {}
}
