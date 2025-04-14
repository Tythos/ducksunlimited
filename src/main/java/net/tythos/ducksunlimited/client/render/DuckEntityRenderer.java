package net.tythos.ducksunlimited.client.render;

import net.tythos.ducksunlimited.entity.DuckEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ChickenEntityRenderState;

public class DuckEntityRenderer extends GeoEntityRenderer<DuckEntity, DuckEntityRenderState> {
    public DuckEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckEntityModel());
    }

    @Override
    public GeoEntityRenderer<DuckEntity, DuckEntityRenderState> withScale(float scale) {
        return super.withScale(scale);
    }

    @Override
    public ChickenEntityRenderState createRenderState() {
        return new ChickenEntityRenderState();
    }
}