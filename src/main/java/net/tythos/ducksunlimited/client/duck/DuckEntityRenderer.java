package net.tythos.ducksunlimited.client.duck;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.tythos.ducksunlimited.DucksUnlimited;
import net.tythos.ducksunlimited.duck.DuckEntity;

public class DuckEntityRenderer extends MobEntityRenderer<DuckEntity, DuckEntityRenderState, DuckEntityModel> {
    public DuckEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckEntityModel(context.getPart(DuckEntityModel.DUCK)), 0.75f);
    }

    @Override
    public Identifier getTexture(DuckEntityRenderState state) {
        return Identifier.of(DucksUnlimited.MOD_ID, "textures/entity/duck/duck.png");
    }

    @Override
    public DuckEntityRenderState createRenderState() {
        return new DuckEntityRenderState();
    }

    @Override
    public void render(DuckEntityRenderState state, MatrixStack matrixStack,
            VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public void updateRenderState(DuckEntity duckEntity, DuckEntityRenderState duckEntityRenderState, float f) {
        super.updateRenderState(duckEntity, duckEntityRenderState, f);
        duckEntityRenderState.idleAnimationState.copyFrom(duckEntity.idleAnimationState);
    }
}