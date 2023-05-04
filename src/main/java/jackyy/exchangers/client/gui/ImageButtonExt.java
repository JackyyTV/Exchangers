package jackyy.exchangers.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ImageButtonExt extends ImageButton {

    private final ResourceLocation resourceLocation;
    private final int xTexStart;
    private final int yTexStart;
    private final int yDiffText;
    private final int yDiffText2;
    private final int textureWidth;
    private final int textureHeight;
    private boolean disabled;

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, OnPress onPress) {
        this(x, y, width, height, xTexStart, yTexStart, altTextureOffset, altTextureOffset2, resourceLocation, 256, 256, onPress);
    }

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, int textureWidth, int textureHeight, OnPress onPress) {
        this(x, y, width, height, xTexStart, yTexStart, altTextureOffset, altTextureOffset2, resourceLocation, textureWidth, textureHeight, onPress, Component.empty());
    }

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, int textureWidth, int textureHeight, OnPress onPress, Component title) {
        super(x, y, width, height, xTexStart, yTexStart, altTextureOffset, resourceLocation, textureWidth, textureHeight, onPress, title);
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.xTexStart = xTexStart;
        this.yTexStart = yTexStart;
        this.yDiffText = altTextureOffset;
        this.yDiffText2 = altTextureOffset2;
        this.resourceLocation = resourceLocation;
    }

    @Override
    public void renderWidget(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.setShaderTexture(0, this.resourceLocation);
        int i = this.yTexStart;
        if (this.isHovered() && !this.disabled) {
            i += this.yDiffText;
        } else if (this.disabled) {
            i += this.yDiffText2;
        }
        RenderSystem.enableDepthTest();
        GuiComponent.blit(matrixStack, this.getX(), this.getY(), (float)this.xTexStart, (float)i, this.width, this.height, this.textureWidth, this.textureHeight);
    }

    public void setButtonDisabled(boolean disable) {
        this.disabled = disable;
        this.active = !disable;
    }

}
