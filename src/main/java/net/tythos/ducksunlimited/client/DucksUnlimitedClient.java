package net.tythos.ducksunlimited.client;

import net.tythos.ducksunlimited.DucksUnlimited;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.tythos.ducksunlimited.client.render.DuckEntityRenderer;
import net.tythos.ducksunlimited.client.render.CubeEntityModel;
import net.tythos.ducksunlimited.client.render.CubeEntityRenderer;

@Environment(EnvType.CLIENT)
public class DucksUnlimitedClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DucksUnlimited.MOD_ID + "_client");

    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(
            Identifier.of(DucksUnlimited.MOD_ID, "cube"), "main");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Duck Mod Client");
        // EntityRendererRegistry.register(DucksUnlimited.DUCK,
        // DuckEntityRenderer::new);

        EntityRendererRegistry.INSTANCE.register(DucksUnlimited.CUBE, (context) -> {
            return new CubeEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);
    }
}
