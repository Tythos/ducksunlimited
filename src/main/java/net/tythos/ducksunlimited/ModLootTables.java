package net.tythos.ducksunlimited;

import net.minecraft.registry.RegistryKey;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTables {
    public static RegistryKey<LootTable> TEST_CHEST_LOOT = RegistryKey.of(RegistryKeys.LOOT_TABLE,
            Identifier.of("ducksunlimited", "chests/test_loot"));
}
