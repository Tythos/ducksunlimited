package net.tythos.ducksunlimited;

public class DucksUnlimitedClient {
    public static final EntityType<DuckEntity> DUCK = Registry.register(Registries.ENTITY_TYPE, Identifier.of(DucksUnlimited.MOD_ID, "duck"), EntityType.Builder.create(DuckEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("cube"));

    public static void init() {
        EntityRendererRegistry.register()
    }
}
