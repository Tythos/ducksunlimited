package net.tythos.ducksunlimited;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class CustomScreen extends Screen {
    public CustomScreen(Text title) {
        super(title);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        System.out.println("Rendering screen...");

        // Fill the ENTIRE screen with a solid red color
        context.fill(0, 0, this.width, this.height, 0xFFFF0000);

        // Draw some very visible text
        context.drawText(
                this.textRenderer,
                "THIS IS THE CUSTOM SCREEN",
                this.width / 2 - 50,
                this.height / 2,
                0xFFFFFFFF, // White color
                true);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return true;
    }

    // Add this to ensure the screen doesn't instantly close
    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}