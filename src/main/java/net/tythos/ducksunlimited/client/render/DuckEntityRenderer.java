package net.tythos.ducksunlimited.client.render;

import net.tythos.ducksunlimited.DucksUnlimited;
import net.tythos.ducksunlimited.entity.DuckEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.ChickenEntityRenderState;
import net.minecraft.util.Identifier;

public class DuckEntityRenderer extends MobEntityRenderer<DuckEntity, ChickenEntityRenderState, DuckEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(DucksUnlimited.MOD_ID, "textures/entity/duck.png");

    public DuckEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckEntityModel(context.getPart(EntityModelLayers.CHICKEN)), 0.3f);
    }

    @Override
    public Identifier getTexture(ChickenEntityRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public ChickenEntityRenderState createRenderState() {
        return new ChickenEntityRenderState();
    }
}