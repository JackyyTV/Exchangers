package jackyy.exchangers.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonImageExt extends GuiButtonImage {

    private final ResourceLocation resourceLocation;
    private final int xTexStart;
    private final int yTexStart;
    private final int yDiffText;
    private final int yDiffText2;
    private boolean disabled;

    public GuiButtonImageExt(int buttonId, int xIn, int yIn, int widthIn, int heightIn, int textureOffestX, int textureOffestY, int altTextureOffset, int altTextureOffset2, ResourceLocation resource) {
        super(buttonId, xIn, yIn, widthIn, heightIn, textureOffestX, textureOffestY, altTextureOffset, resource);
        this.xTexStart = textureOffestX;
        this.yTexStart = textureOffestY;
        this.yDiffText = altTextureOffset;
        this.yDiffText2 = altTextureOffset2;
        this.resourceLocation = resource;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            mc.getTextureManager().bindTexture(this.resourceLocation);
            GlStateManager.disableDepth();
            int i = this.xTexStart;
            int j = this.yTexStart;
            if (this.hovered && !this.disabled) {
                j += this.yDiffText;
            }
            if (this.disabled) {
                j += this.yDiffText2;
            }
            this.drawTexturedModalRect(this.x, this.y, i, j, this.width, this.height);
            GlStateManager.enableDepth();
        }
    }

    public void setButtonDisabled(boolean disable) {
        this.disabled = disable;
        this.enabled = !disable;
    }

}
