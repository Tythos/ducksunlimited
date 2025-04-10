package net.tythos.ducksunlimited;

import net.tythos.ducksunlimited.entity.DuckEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.tythos.ducksunlimited.command.DuckCommands;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "ducksunlimited";

    public static final EntityType<DuckEntity> DUCK = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "duck"),
            EntityType.Builder.create(DuckEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.4f, 0.7f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, "duck"))));

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(DUCK, DuckEntity.createDuckAttributes());

        CommandRegistrationCallback.EVENT.register(DuckCommands::register);
    }
}
