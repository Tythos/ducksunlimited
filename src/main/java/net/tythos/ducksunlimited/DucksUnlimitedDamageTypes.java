package net.tythos.ducksunlimited;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DucksUnlimitedDamageTypes {
    public static final RegistryKey<DamageType> TATER_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            Identifier.of("ducksunlimited", "tater"));
}
