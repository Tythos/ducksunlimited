package net.tythos.ducksunlimited;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.ArmorMaterial;
import java.util.Map;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.item.ArmorItem;

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

        public static final RegistryKey<Item> SUPERBONKER_9000_KEY = RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of("ducksunlimited", "superbonker_9000"));

        // define custom material, armor
        public static final int BASE_DURABILITY = 15;
        public static final RegistryKey<EquipmentAsset> PLUTONIUM_ARMOR_MATERIAL_KEY = RegistryKey
                        .of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of("ducksunlimited", "plutonium"));
        public static final ArmorMaterial INSTANCE = new ArmorMaterial(BASE_DURABILITY, Map.of(
                        EquipmentType.HELMET, 3,
                        EquipmentType.CHESTPLATE, 8,
                        EquipmentType.LEGGINGS, 6,
                        EquipmentType.BOOTS, 3),
                        5,
                        SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                        0.0F,
                        0.0F,
                        null,
                        PLUTONIUM_ARMOR_MATERIAL_KEY);
        public static final RegistryKey<Item> PLUTONIUM_HELMET_KEY = RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of("ducksunlimited", "plutonium_helmet"));
        public static final Item PLUTONIUM_HELMET = register(
                        new ArmorItem(
                                        INSTANCE,
                                        EquipmentType.HELMET,
                                        new Item.Settings().registryKey(PLUTONIUM_HELMET_KEY)
                                                        .maxDamage(EquipmentType.HELMET.getMaxDamage(
                                                                        BASE_DURABILITY))),
                        PLUTONIUM_HELMET_KEY);
        public static final RegistryKey<Item> PLUTONIUM_CHESTPLATE_KEY = RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of("ducksunlimited", "plutonium_chestplate"));
        public static final Item PLUTONIUM_CHESTPLATE = register(
                        new ArmorItem(INSTANCE, EquipmentType.CHESTPLATE,
                                        new Item.Settings().registryKey(PLUTONIUM_CHESTPLATE_KEY).maxDamage(
                                                        EquipmentType.CHESTPLATE.getMaxDamage(BASE_DURABILITY))),
                        PLUTONIUM_CHESTPLATE_KEY);
        public static final RegistryKey<Item> PLUTONIUM_LEGGINGS_KEY = RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of("ducksunlimited", "plutonium_leggings"));
        public static final Item PLUTONIUM_LEGGINGS = register(
                        new ArmorItem(INSTANCE, EquipmentType.LEGGINGS,
                                        new Item.Settings().registryKey(PLUTONIUM_LEGGINGS_KEY).maxDamage(
                                                        EquipmentType.LEGGINGS.getMaxDamage(BASE_DURABILITY))),
                        PLUTONIUM_LEGGINGS_KEY);
        public static final RegistryKey<Item> PLUTONIUM_BOOTS_KEY = RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of("ducksunlimited", "plutonium_boots"));
        public static final Item PLUTONIUM_BOOTS = register(
                        new ArmorItem(INSTANCE, EquipmentType.BOOTS,
                                        new Item.Settings().registryKey(PLUTONIUM_BOOTS_KEY)
                                                        .maxDamage(EquipmentType.BOOTS.getMaxDamage(
                                                                        BASE_DURABILITY))),
                        PLUTONIUM_BOOTS_KEY);

        // register custom item definitions

        public static final Item SUSPICIOUS_SUBSTANCE = register(
                        new Item(new Item.Settings().registryKey(SUSPICIOUS_SUBSTANCE_KEY)),
                        SUSPICIOUS_SUBSTANCE_KEY);

        public static final Item TEH_NOMZ = register(
                        new Item(new Item.Settings().registryKey(TEH_NOMZ_KEY)
                                        .food(new FoodComponent.Builder().build())),
                        TEH_NOMZ_KEY);

        public static final ToolMaterial PLUTONIUM_MATERIAL = new ToolMaterial(
                        BlockTags.INCORRECT_FOR_WOODEN_TOOL,
                        455,
                        5.0F,
                        1.5F,
                        22,
                        null);

        public static final Item SUPERBONKER_9000 = register(
                        new SwordItem(PLUTONIUM_MATERIAL, 1f, 1f,
                                        new Item.Settings().registryKey(SUPERBONKER_9000_KEY)),
                        SUPERBONKER_9000_KEY);

        // initialize mod with entries

        public static void initialize() {
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                                .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                                .register((itemGroup) -> itemGroup.add(ModItems.TEH_NOMZ));
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                                .register((itemGroup) -> itemGroup.add(ModItems.SUPERBONKER_9000));
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                                .register((itemGroup) -> itemGroup.add(ModItems.PLUTONIUM_HELMET));
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                                .register((itemGroup) -> itemGroup.add(ModItems.PLUTONIUM_CHESTPLATE));
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                                .register((itemGroup) -> itemGroup.add(ModItems.PLUTONIUM_LEGGINGS));
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                                .register((itemGroup) -> itemGroup.add(ModItems.PLUTONIUM_BOOTS));
        }
}
