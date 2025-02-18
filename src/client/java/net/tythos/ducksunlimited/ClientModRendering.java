package net.tythos.ducksunlimited;

import org.joml.Matrix4f;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.BufferRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class ClientModRendering {
    static float totalTickDelta = 0;

    public static void drawDiamond(DrawContext drawContext, RenderTickCounter tickDeltaManager) {
        MatrixStack matrices = drawContext.getMatrices();
        totalTickDelta += tickDeltaManager.getTickDelta(true);
        matrices.push();
        float scaleAmount = 1.0f; // MathHelper.sin(totalTickDelta / 10F) / 2F + 1.5F;
        matrices.scale(scaleAmount, scaleAmount, 1F);

        float rotationAmount = (float) (totalTickDelta / 50F % 360);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotation(rotationAmount));
        // matrices.translate(-20f, -40f, 0f);

        Matrix4f transformationMatrix = matrices.peek().getPositionMatrix();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP,
                VertexFormats.POSITION_COLOR);
        buffer.vertex(transformationMatrix, 20, 20, 5).color(0xFF414141);
        buffer.vertex(transformationMatrix, 5, 40, 5).color(0xFF000000);
        buffer.vertex(transformationMatrix, 35, 40, 5).color(0xFF000000);
        buffer.vertex(transformationMatrix, 20, 60, 5).color(0xFF414141);
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        BufferRenderer.drawWithGlobalProgram(buffer.end());

        matrices.pop();
    }

    public static void initialize() {
        HudRenderCallback.EVENT.register(ClientModRendering::drawDiamond);
    }
}
