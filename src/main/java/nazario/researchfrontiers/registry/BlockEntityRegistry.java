package nazario.researchfrontiers.registry;

import nazario.liby.registry.auto.LibyAutoRegister;
import nazario.liby.registry.helper.LibyBlockEntityRegister;
import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.BigOvenBlockEntity;
import nazario.researchfrontiers.block.Cable;
import nazario.researchfrontiers.block.WorkbenchBlockEntity;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import net.minecraft.block.entity.BlockEntityType;

@LibyAutoRegister(priority = 3)
public class BlockEntityRegistry {
    public static final LibyBlockEntityRegister REGISTER = new LibyBlockEntityRegister(ResearchFrontiers.MOD_ID);
    public static final BlockEntityType<WorkbenchBlockEntity> WORKBENCH = REGISTER.registerType("workbench", BlockEntityType.Builder.create(WorkbenchBlockEntity::new, BlockRegistry.WORKBENCH).build());

    public static BlockEntityType<BlastFurnaceEntity> BLAST_FURNACE_ENTITY = REGISTER.registerType("blast_furnace", BlockEntityType.Builder.create(BlastFurnaceEntity::new, BlockRegistry.BLAST_FURNACE).build());

    public static BlockEntityType<Cable.BlockEntity> CABLE_BLOCK_ENTITY = REGISTER.registerType("cable_block", BlockEntityType.Builder.create(Cable.BlockEntity::new, BlockRegistry.CABLE_BLOCK).build());

    public static BlockEntityType<BigOvenBlockEntity> BIG_OVEN_ENTITY = REGISTER.registerType("big_oven", BlockEntityType.Builder.create(BigOvenBlockEntity::new, BlockRegistry.BIG_OVEN).build());;

    public static void register() {

    }
}
