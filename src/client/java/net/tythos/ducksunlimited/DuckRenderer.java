package net.tythos.ducksunlimited;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.ChickenEntityRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.ChickenEntityRenderer;

public class DuckRenderer extends MobEntityRenderer<DuckEntity, DuckEntityRenderState> {
    private static final Identifier TEXTURE = Identifier.of(DucksUnlimited.MOD_ID, "textures/entity/duck.png");

    public DuckRenderer(EntityRendererFactory.Context context) {
        super(context, new ChickenEntityModel<DuckEntityRenderState>(context.getPart(EntityModelLayers.CHICKEN)), 0.3F);
    }

    @Override
    public Identifier getTexture(DuckEntityRenderState duckEntityRenderState) {
        return TEXTURE;
    }
}
