package net.tythos.ducksunlimited.client.cube;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.tythos.ducksunlimited.DucksUnlimited;
import net.tythos.ducksunlimited.cube.CubeEntity;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityRenderState, CubeEntityModel> {
    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(CubeEntityModel.CUBE)), 0.75f);
    }

    @Override
    public Identifier getTexture(CubeEntityRenderState state) {
        return Identifier.of(DucksUnlimited.MOD_ID, "textures/entity/cube/cube.png");
    }

    @Override
    public CubeEntityRenderState createRenderState() {
        return new CubeEntityRenderState();
    }

    @Override
    public void render(CubeEntityRenderState state, MatrixStack matrixStack,
            VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public void updateRenderState(CubeEntity cubeEntity, CubeEntityRenderState cubeEntityRenderState, float f) {
        super.updateRenderState(cubeEntity, cubeEntityRenderState, f);
        cubeEntityRenderState.idleAnimationState.copyFrom(cubeEntity.idleAnimationState);
    }
}
