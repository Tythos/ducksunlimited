package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "DucksUnlimited";

    public static void init() {
        ModEntities.init();
        ModSounds.init();
    }

    @Override
    public void onInitialize() {
    }
}
