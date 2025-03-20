package net.tythos.ducksunlimited;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.tythos.ducksunlimited.DuckEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.minecraft.util.Identifier;

public class DuckRenderer extends GeoEntityRenderer<DuckEntity> {
    public DuckRenderer(EntityRendererProvider.Context context) {
        super(context, new DuckModel());
    }

    @Override
    public GeoEntityRenderer<DuckEntity> withScale(float scale) {
        return super.withScale(scale);
    }

    @Override
    public void preRender(PoseStack poseStack, DuckEntity animatable, BakedGeoModel model,
            @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender,
            float partialTick, int packedLight, int packedOverlay, int color) {
        this.scaleHeight = this.scaleWidth = 1.0f;
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight,
                packedOverlay, color);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(DuckEntity entity) {
        return entity.getTexture().texture;
    }

    @Override
    public RenderType getRenderType(DuckEntity animatable, Identifier texture,
            @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
