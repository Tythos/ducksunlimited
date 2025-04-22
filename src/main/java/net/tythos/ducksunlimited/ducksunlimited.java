package net.tythos.ducksunlimited;

// import net.tythos.ducksunlimited.duck.DuckEntity;
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
import net.tythos.ducksunlimited.cube.CubeEntity;
import net.tythos.ducksunlimited.duck.DuckEntity;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "ducksunlimited";

    public static final Identifier CUBE_ID = Identifier.of(MOD_ID, "cube");

    public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registries.ENTITY_TYPE,
            CUBE_ID,
            EntityType.Builder.create(CubeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, CUBE_ID)));

    public static final Identifier DUCK_ID = Identifier.of(MOD_ID, "duck");

    public static final EntityType<DuckEntity> DUCK = Registry.register(
            Registries.ENTITY_TYPE,
            DUCK_ID,
            EntityType.Builder.create(DuckEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, DUCK_ID)));

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(DuckCommands::register);

        FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createAttributes());
    }
}
