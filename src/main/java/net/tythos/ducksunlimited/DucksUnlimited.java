package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "ducksunlimited";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing DucksUnlimited");
    }
}