package jackyy.exchangers.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ImageButtonExt extends ImageButton {

    private final WidgetSprites sprites;
    private boolean disabled;

    public ImageButtonExt(int x, int y, int width, int height, WidgetSprites sprites, Button.OnPress onPress) {
        this(x, y, width, height, sprites, onPress, CommonComponents.EMPTY);
    }

    public ImageButtonExt(int x, int y, int width, int height, WidgetSprites sprites, Button.OnPress onPress, Component title) {
        super(x, y, width, height, sprites, onPress, title);
        this.sprites = sprites;
    }

    public ImageButtonExt(int width, int height, WidgetSprites sprites, Button.OnPress onPress, Component title) {
        this(0, 0, width, height, sprites, onPress, title);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        ResourceLocation resourcelocation = this.sprites.get(this.isActive(), (this.isHovered() && !this.disabled));
        guiGraphics.blitSprite(resourcelocation, this.getX(), this.getY(), this.width, this.height);
    }

    public void setButtonDisabled(boolean disable) {
        this.disabled = disable;
        this.active = !disable;
    }

}
