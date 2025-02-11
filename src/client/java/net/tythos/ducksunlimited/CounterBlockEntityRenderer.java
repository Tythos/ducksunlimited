package net.tythos.ducksunlimited;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.math.RotationAxis;

public class CounterBlockEntityRenderer implements BlockEntityRenderer<CounterBlockEntity> {
    BlockEntityRendererFactory.Context ctx;

    public CounterBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.ctx = context;
    }

    @Override
    public void render(CounterBlockEntity entity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5, 1, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.scale(1 / 18f, 1 / 18f, 1 / 18f);
        String text = entity.getClicks() + "";
        TextRenderer textRenderer = this.ctx.getTextRenderer();
        float width = textRenderer.getWidth(text);
        textRenderer.draw(
                text, -width / 2, -4f, 0xffffff, false, matrices.peek().getPositionMatrix(), vertexConsumers,
                TextRenderer.TextLayerType.SEE_THROUGH, 0, light);
        matrices.pop();
    }
}
