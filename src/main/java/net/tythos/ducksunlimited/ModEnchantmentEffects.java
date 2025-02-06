package net.tythos.ducksunlimited;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.tythos.ducksunlimited.enchantment.effect.LightningEnchantmentEffect;
import com.mojang.serialization.MapCodec;

public class ModEnchantmentEffects {
    public static final RegistryKey<Enchantment> THUNDERING = of("thundering");
    public static MapCodec<LightningEnchantmentEffect> LIGHTNING_EFFECT = register("lightning_effect",
            LightningEnchantmentEffect.CODEC);

    private static RegistryKey<Enchantment> of(String path) {
        Identifier id = Identifier.of("ducksunlimited", path);
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
    }

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of("ducksunlimited", id), codec);
    }

    public static void registerModEnchantmentEffects() {
        ducksunlimited.LOGGER.info("Registering EnchantmentEffects for ducksunlimited");
    }
}
