package net.tythos.ducksunlimited;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.tythos.ducksunlimited.ModEntities;

public class DucksUnlimitedClient {
    public static <E extends Entity> void registerEntityRenderer(
            EntityType<E> entityType,
            EntityRendererProvider<E> entityRendererProvider) {
        EntityRendererRegistry.register(entityType, entityRendererProvider);
    }

    public static void setRenderType(Block block, RenderType renderType) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, renderType);
    }

    public static void init() {
        registerEntityRenderer(ModEntities.DUCK.get(), DuckRenderer::new);
    }
}
