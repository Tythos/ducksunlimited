package net.tythos.ducksunlimited;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.tythos.ducksunlimited.command.DuckCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DucksUnlimited implements ModInitializer {
    public static final String MOD_ID = "DucksUnlimited";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing DucksUnlimited mod");
        CommandRegistrationCallback.EVENT.register(
            (dispatcher, registryAccess, environment) -> DuckCommand.register(dispatcher)
        );
    }
}
