package nazario.researchfrontiers.registry;

import nazario.liby.registry.auto.LibyAutoRegister;
import nazario.liby.registry.helper.LibyBlockEntityRegister;
import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.BigOvenBlockEntity;
import nazario.researchfrontiers.block.Cable;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import net.minecraft.block.entity.BlockEntityType;

@LibyAutoRegister(priority = 3)
public class BlockEntityRegistry {
    public static final LibyBlockEntityRegister REGISTER = new LibyBlockEntityRegister(ResearchFrontiers.MOD_ID);

    public static BlockEntityType<BlastFurnaceEntity> BLAST_FURNACE_ENTITY;

    public static BlockEntityType<Cable.BlockEntity> CABLE_BLOCK_ENTITY;

    public static BlockEntityType<BigOvenBlockEntity> BIG_OVEN_ENTITY;

    public static void register() {
        BLAST_FURNACE_ENTITY = REGISTER.registerType("blast_furnace", BlockEntityType.Builder.create(BlastFurnaceEntity::new, BlockRegistry.BLAST_FURNACE).build());

        CABLE_BLOCK_ENTITY = REGISTER.registerType("cable_block", BlockEntityType.Builder.create(Cable.BlockEntity::new, BlockRegistry.CABLE_BLOCK).build());

        BIG_OVEN_ENTITY = REGISTER.registerType("big_oven", BlockEntityType.Builder.create(BigOvenBlockEntity::new, BlockRegistry.BIG_OVEN).build());
    }
}
