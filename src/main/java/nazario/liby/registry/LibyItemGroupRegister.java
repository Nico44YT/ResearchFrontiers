package nazario.liby.registry;

import nazario.researchfrontiers.ResearchFrontiers;
import nazario.researchfrontiers.registry.BlockRegistry;
import nazario.researchfrontiers.registry.ItemRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LibyItemGroupRegister extends LibyRegister {
    public LibyItemGroupRegister(String namespace) {
        super(namespace);
    }

    public ItemGroup registerItemGroup(String name, ItemConvertible icon, Text displayName, ItemConvertible... items) {
        return Registry.register(Registries.ITEM_GROUP,
                Identifier.of(namespace, name),
                FabricItemGroup.builder().icon(() -> new ItemStack(icon))
                        .displayName(displayName)
                        .entries((displayContext, entries) -> {
                            for(ItemConvertible item : items) {
                                entries.add(item);
                            }
                        })
                        .special().build());
    }
}
