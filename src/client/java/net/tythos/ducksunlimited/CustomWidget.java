package net.tythos.ducksunlimited;

import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;

public class CustomWidget extends ClickableWidget {
    public CustomWidget(int x, int y, int width, int height) {
        super(x, y, width, height, Text.empty());
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        int startColor = 0xFF00FF00;
        int endColor = 0xFF0000FF;
        context.fillGradient(getX(), getY(), getX() + this.width, getY() + this.height, startColor, endColor);
        if (isHovered()) {
            startColor = 0xFFFF0000;
            endColor = 0xFF00FFFF;
        }
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
        return;
    }
}
