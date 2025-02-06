package net.tythos.ducksunlimited;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.tag.ItemTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import java.util.concurrent.CompletableFuture;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.tythos.ducksunlimited.enchantment.effect.LightningEnchantmentEffect;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;

public class EnchantmentGenerator extends FabricDynamicRegistryProvider {
    public EnchantmentGenerator(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        System.out.println("REGISTERING ENCHANTS");
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        register(entries, ModEnchantmentEffects.THUNDERING, Enchantment.builder(
                Enchantment.definition(
                        registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        10, // probability of enchantment showing up in table
                        3, // maximum level of enchantment
                        Enchantment.leveledCost(1, 10), // base cost for level 1
                        Enchantment.leveledCost(1, 10), // base cost for max level
                        5, // anvil cost
                        AttributeModifierSlot.HAND))
                .addEffect(
                        EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new LightningEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.4f, 0.2f))));
    }

    private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder,
            ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }

    @Override
    public String getName() {
        return "referenceDocEnchantmentGenerator";
    }
}
