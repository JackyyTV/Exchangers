package jackyy.exchangers.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

public class ToggleButton extends Button {
    private boolean toggled;

    public ToggleButton(int x, int y, int width, int height, Component title, OnPress pressedAction) {
        super(x, y, width, height, title, pressedAction);
    }

    @Override @SuppressWarnings("deprecation")
    public void renderButton(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fontrenderer = minecraft.font;
        minecraft.getTextureManager().getTexture(WIDGETS_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        int i = this.getYImage(this.isHoveredOrFocused() || this.toggled);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        this.blit(matrixStack, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
        this.blit(matrixStack, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
        this.renderBg(matrixStack, minecraft, mouseX, mouseY);
        int j = getFGColor();
        drawCenteredString(matrixStack, fontrenderer, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j | Mth.ceil(this.alpha * 255.0F) << 24);
    }

    public void setButtonToggled(boolean toggle) {
        this.toggled = toggle;
    }

}
