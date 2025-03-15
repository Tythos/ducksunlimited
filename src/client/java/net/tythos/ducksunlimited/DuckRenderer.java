package net.tythos.ducksunlimited;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import net.tythos.ducksunlimited.DucksUnlimited;
import net.tythos.ducksunlimited.DuckEntity;

public class DuckRenderer extends MobEntityRenderer<DuckEntity, LivingEntityRenderState, DuckModel> {
    private static final Identifier TEXTURE = Identifier.of(DucksUnlimited.MOD_ID, "textures/entity/duck.png");

    public DuckRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckModel(context.getPart(EntityModelLayers.CHICKEN)), 0.3F);
    }

    @Override
    public Identifier getTexture(DuckEntity entity) {
        return TEXTURE;
    }
}
