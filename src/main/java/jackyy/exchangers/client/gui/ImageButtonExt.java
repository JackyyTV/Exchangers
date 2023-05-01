package jackyy.exchangers.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ImageButtonExt extends ImageButton {

    private final ResourceLocation resourceLocation;
    private final int xTexStart;
    private final int yTexStart;
    private final int yDiffText;
    private final int yDiffText2;
    private final int textureWidth;
    private final int textureHeight;
    private boolean disabled;

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, Button.IPressable onPress) {
        this(x, y, width, height, xTexStart, yTexStart, altTextureOffset, altTextureOffset2, resourceLocation, 256, 256, onPress);
    }

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, int textureWidth, int textureHeight, Button.IPressable onPress) {
        this(x, y, width, height, xTexStart, yTexStart, altTextureOffset, altTextureOffset2, resourceLocation, textureWidth, textureHeight, onPress, StringTextComponent.EMPTY);
    }

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, int textureWidth, int textureHeight, Button.IPressable onPress, ITextComponent title) {
        this(x, y, width, height, xTexStart, yTexStart, altTextureOffset, altTextureOffset2, resourceLocation, textureWidth, textureHeight, onPress, EMPTY_TOOLTIP, title);
    }

    public ImageButtonExt(int x, int y, int width, int height, int xTexStart, int yTexStart, int altTextureOffset, int altTextureOffset2, ResourceLocation resourceLocation, int textureWidth, int textureHeight, Button.IPressable onPress, Button.ITooltip onTooltip, ITextComponent title) {
        super(x, y, width, height, xTexStart, yTexStart, altTextureOffset, resourceLocation, textureWidth, textureHeight, onPress, onTooltip, title);
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.xTexStart = xTexStart;
        this.yTexStart = yTexStart;
        this.yDiffText = altTextureOffset;
        this.yDiffText2 = altTextureOffset2;
        this.resourceLocation = resourceLocation;
    }

    @Override
    public void renderWidget(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getTextureManager().bindTexture(this.resourceLocation);
        int i = this.yTexStart;
        if (this.isHovered() && !this.disabled) {
            i += this.yDiffText;
        }
        if (this.disabled) {
            i += this.yDiffText2;
        }
        RenderSystem.enableDepthTest();
        blit(matrixStack, this.x, this.y, (float)this.xTexStart, (float)i, this.width, this.height, this.textureWidth, this.textureHeight);
    }

    public void setButtonDisabled(boolean disable) {
        this.disabled = disable;
        this.active = !disable;
    }

}
