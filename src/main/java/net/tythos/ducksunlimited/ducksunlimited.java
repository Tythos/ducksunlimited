package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;

public class ducksunlimited implements ModInitializer {
	public static final String MOD_ID = "ducksunlimited";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Potion TATER_POTION = Registry.register(Registries.POTION,
			Identifier.of("ducksunlimited", "tater"),
			new Potion("tater", new StatusEffectInstance(StatusEffects.SPEED, 3600, 0)));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					Potions.WATER,
					Items.POTATO,
					Registries.POTION.getEntry(TATER_POTION));
		});
		ModBlocks.initialize();
		ModBlockEntities.initialize();
	}
}