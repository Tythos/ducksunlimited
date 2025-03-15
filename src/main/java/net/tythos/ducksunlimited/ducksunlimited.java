package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityDimensions;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "DucksUnlimited";

    public static final EntityType<DuckEntity> DUCK = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "duck"),
            EntityType.Builder.create(SpawnGroup.CREATURE, DuckEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 0.8F))
                    .build());

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(DUCK, DuckEntity.createAttributes());
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            SpawnDuckCommand.register(dispatcher);
        });
    }
}
