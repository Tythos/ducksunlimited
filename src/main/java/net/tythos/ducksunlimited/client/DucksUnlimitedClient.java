package net.tythos.ducksunlimited.client;

import net.tythos.ducksunlimited.DucksUnlimited;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.tythos.ducksunlimited.client.render.DuckEntityRenderer;

@Environment(EnvType.CLIENT)
public class DucksUnlimitedClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DucksUnlimited.MOD_ID + "_client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Duck Mod Client");
        EntityRendererRegistry.register(DucksUnlimited.DUCK, DuckEntityRenderer::new);
    }
}
