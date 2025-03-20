package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "DucksUnlimited";

    public static void init() {
        ModEntities.init();
        ModSounds.init();
    }

    @Override
    public void onInitialize() {
    }

    public static Identifier get_resource_location(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
