package nazario.researchfrontiers.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup TEST_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ResearchFrontiers.MOD_ID, "test_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .displayName(Text.literal("Test"))
                            .entries((displayContext, entries) -> {
                                entries.add(Items.DIAMOND);


                            }).build());



   public static void registerItemGroups() {

   }
}
