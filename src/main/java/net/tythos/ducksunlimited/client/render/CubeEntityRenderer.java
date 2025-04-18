package net.tythos.ducksunlimited.client.render;

import net.tythos.ducksunlimited.DucksUnlimited;
import net.tythos.ducksunlimited.client.DucksUnlimitedClient;
import net.tythos.ducksunlimited.entity.CubeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {
    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(DucksUnlimitedClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return Identifier.of(DucksUnlimited.MOD_ID, "textures/entity/cube.png");
    }
}
