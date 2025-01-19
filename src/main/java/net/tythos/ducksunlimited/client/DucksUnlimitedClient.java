package net.tythos.ducksunlimited.client;

import net.fabricmc.api.ClientModInitializer;
import net.tythos.ducksunlimited.DucksUnlimited;

public class DucksUnlimitedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DucksUnlimited.LOGGER.info("Initializing DucksUnlimited Client");
    }
}