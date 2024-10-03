package nazario.researchfrontiers.registry;

import nazario.liby.registry.LibyRegistry;
import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.Cable;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class BlockEntityRegistry implements LibyRegistry {
    public static BlockEntityType<BlastFurnaceEntity> BLAST_FURNACE_ENTITY;

    public static BlockEntityType<Cable.BlockEntity> CABLE_BLOCK_ENTITY;

    public static void register() {
        BLAST_FURNACE_ENTITY = registerType("blast_furnace", BlockEntityType.Builder.create(BlastFurnaceEntity::new, BlockRegistry.BLAST_FURNACE).build());

        CABLE_BLOCK_ENTITY = registerType("cable_block", BlockEntityType.Builder.create(Cable.BlockEntity::new, BlockRegistry.CABLE_BLOCK).build());
    }

    public static <T extends BlockEntityType<?>> T registerType(String name, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, ResearchFrontiers.id(name), blockEntityType);
    }
}
