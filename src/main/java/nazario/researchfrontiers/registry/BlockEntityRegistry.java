package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.block.blast_furnace.BlastFurnaceEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockEntityRegistry {
    public static BlockEntityType<BlastFurnaceEntity> BLAST_FURNACE_ENTITY;

    public static void register() {
        BLAST_FURNACE_ENTITY = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                ResearchFrontiers.id("blast_furnace"),
                FabricBlockEntityTypeBuilder.create(BlastFurnaceEntity::new, BlockRegistry.BLAST_FURNACE).build()
        );
    }
}
