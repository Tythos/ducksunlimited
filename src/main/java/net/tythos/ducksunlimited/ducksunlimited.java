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
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.tythos.ducksunlimited.command.DuckCommands;
import net.tythos.ducksunlimited.entity.CubeEntity;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "ducksunlimited";

    // public static final EntityType<DuckEntity> DUCK = Registry.register(
    // Registries.ENTITY_TYPE,
    // Identifier.of(MOD_ID, "duck"),
    // EntityType.Builder.create(DuckEntity::new,
    // SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("duck"));

    public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "cube"),
            EntityType.Builder.create(CubeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.75f, 0.75f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, "cube"))));

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(DuckCommands::register);

        FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());
    }
}
