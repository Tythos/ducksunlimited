package net.tythos.ducksunlimited;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.component.type.FoodComponent;

public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);
        return registeredItem;
    }

    // declare custom item keys

    public static final RegistryKey<Item> SUSPICIOUS_SUBSTANCE_KEY = RegistryKey.of(RegistryKeys.ITEM,
            Identifier.of("ducksunlimited", "suspicious_substance"));

    public static final RegistryKey<Item> TEH_NOMZ_KEY = RegistryKey.of(RegistryKeys.ITEM,
            Identifier.of("ducksunlimited", "teh_nomz"));

    // register custom item definitions

    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item(new Item.Settings().registryKey(SUSPICIOUS_SUBSTANCE_KEY)),
            SUSPICIOUS_SUBSTANCE_KEY);

    public static final Item TEH_NOMZ = register(
            new Item(new Item.Settings().registryKey(TEH_NOMZ_KEY).food(new FoodComponent.Builder().build())),
            TEH_NOMZ_KEY);

    // initialize mod with entries

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.TEH_NOMZ));
    }
}
