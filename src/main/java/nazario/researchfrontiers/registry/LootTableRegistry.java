package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class LootTableRegistry {

    public static final RegistryKey<LootTable> GOLD_WASHING = register("actions/gold_washing");


    public static void register() {}

    private static RegistryKey<LootTable> register(String id) {
        return registerLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE, ResearchFrontiers.id(id)));
    }

    private static RegistryKey<LootTable> registerLootTable(RegistryKey<LootTable> key) {
        if (LootTables.getAll().add(key)) {
            return key;
        } else {
            throw new IllegalArgumentException(String.valueOf(key.getValue()) + " is already a registered built-in loot table");
        }
    }

}
