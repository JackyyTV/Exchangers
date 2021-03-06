package jackyy.exchangers.client.gui;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import jackyy.exchangers.client.keybind.Keys;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.handler.mode.ModeHorizontalCol;
import jackyy.exchangers.handler.mode.ModePlane;
import jackyy.exchangers.handler.mode.ModeVerticalCol;
import jackyy.exchangers.handler.network.NetworkHandler;
import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class ExchangersGuiScreen extends Screen {

    private static Minecraft mc = Minecraft.getInstance();
    private final ResourceLocation GUI_IMAGE = new ResourceLocation(Reference.MODID, "textures/gui/gui_exchanger.png");
    private static final int W = 180;
    private static final int H = 150;
    private String chance;

    private ImageButtonExt decreaseRangeButton;
    private ImageButtonExt increaseRangeButton;
    private ToggleButton modeSwitchButton;
    private ToggleButton forceDropItemsButton;
    private ToggleButton directionalPlacementButton;
    private ToggleButton fuzzyPlacementButton;
    private ToggleButton voidItemsButton;

    private TextFieldWidget fuzzyPlacementChanceField;

    public ExchangersGuiScreen() {
        super(new TranslationTextComponent("screen.exchangers.exchanger_gui.title"));
        this.width = W;
        this.height = H;
    }

    @Override
    public void init() {
        int relativeX = (this.width - W) / 2;
        int relativeY = (this.height - H) / 2;
        ItemStack stack = mc.player.getHeldItemMainhand();
        CompoundNBT tag = stack.getTag();
        chance = Integer.toString(tag.getInt("fuzzyPlacementChance"));
        decreaseRangeButton = new ImageButtonExt(relativeX + 54, relativeY + 31, 10, 15, 180, 0, 15, 30, GUI_IMAGE,
                button -> NetworkHandler.sendToServer(new PacketDecreaseRange()));
        increaseRangeButton = new ImageButtonExt(relativeX + 116, relativeY + 31, 10, 15, 190, 0, 15, 30, GUI_IMAGE,
                button -> NetworkHandler.sendToServer(new PacketIncreaseRange()));
        modeSwitchButton = new ToggleButton(relativeX + 20, relativeY + 66, 20, 20, new StringTextComponent("\u29C8"),
                button -> NetworkHandler.sendToServer(new PacketSwitchMode()));
        forceDropItemsButton = new ToggleButton(relativeX + 60, relativeY + 66, 20, 20, new StringTextComponent("\u2B0A"),
                button -> NetworkHandler.sendToServer(new PacketToggleForceDropItems()));
        directionalPlacementButton = new ToggleButton(relativeX + 100, relativeY + 66, 20, 20, new StringTextComponent("\u2927"),
                button -> NetworkHandler.sendToServer(new PacketToggleDirectionalPlacement()));
        fuzzyPlacementButton = new ToggleButton(relativeX + 52, relativeY + 106, 20, 20, new StringTextComponent("\u224B"),
                button -> NetworkHandler.sendToServer(new PacketToggleFuzzyPlacement()));
        voidItemsButton = new ToggleButton(relativeX + 140, relativeY + 66, 20, 20, new StringTextComponent("\u2A37"),
                button -> NetworkHandler.sendToServer(new PacketToggleVoidItems()));
        this.addButton(decreaseRangeButton);
        this.addButton(increaseRangeButton);
        this.addButton(modeSwitchButton);
        this.addButton(forceDropItemsButton);
        this.addButton(directionalPlacementButton);
        this.addButton(fuzzyPlacementButton);
        this.addButton(voidItemsButton);
        fuzzyPlacementChanceField = new TextFieldWidget(this.font, relativeX + 92, relativeY + 108, 26, 16, StringTextComponent.EMPTY);
        fuzzyPlacementChanceField.setMaxStringLength(3);
        fuzzyPlacementChanceField.setText(chance);
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        FontRenderer fontRenderer = mc.fontRenderer;
        ItemStack stack = mc.player.getHeldItemMainhand();
        ItemExchangerBase exchanger = (ItemExchangerBase) stack.getItem();
        CompoundNBT tag = stack.getTag();
        this.renderBackground(matrixStack);
        int relativeX = (this.width - W) / 2;
        int relativeY = (this.height - H) / 2;
        mc.getTextureManager().bindTexture(GUI_IMAGE);
        this.blit(matrixStack, relativeX, relativeY, 0, 0, W, H);
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, relativeX + 82, relativeY + 8);
        int range = tag.getInt("range");
        String exchangeRange = ExchangerHandler.rangeList[range];
        fontRenderer.drawStringWithShadow(matrixStack, exchangeRange, relativeX + 90 - fontRenderer.getStringWidth(exchangeRange) / 2.0f, relativeY + 34, -1);
        fuzzyPlacementChanceField.render(matrixStack, mouseX, mouseY, partialTicks);
        fontRenderer.drawStringWithShadow(matrixStack, "%", relativeX + 121, relativeY + 112, -1);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        decreaseRangeButton.setButtonDisabled(range == 0);
        increaseRangeButton.setButtonDisabled(range == exchanger.getMaxRange());
        forceDropItemsButton.setButtonToggled(tag.getBoolean("forceDropItems"));
        directionalPlacementButton.setButtonToggled(tag.getBoolean("directionalPlacement"));
        fuzzyPlacementButton.setButtonToggled(tag.getBoolean("fuzzyPlacement"));
        voidItemsButton.setButtonToggled(tag.getBoolean("voidItems"));
        if (decreaseRangeButton.isHovered()) {
            drawToolTip(matrixStack, Collections.singletonList(StringHelper.localize(Reference.MODID, "tooltip.decrease_range_button")), mouseX, mouseY);
        }
        if (increaseRangeButton.isHovered()) {
            drawToolTip(matrixStack, Collections.singletonList(StringHelper.localize(Reference.MODID, "tooltip.increase_range_button")), mouseX, mouseY);
        }
        if (modeSwitchButton.isHovered()) {
            int mode = tag.getInt("mode");
            switch (mode) {
                case 0:
                    this.drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.mode_switch_button"),
                            StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModePlane.getDisplayName().mergeStyle(TextFormatting.GREEN))), mouseX, mouseY);
                    break;
                case 1:
                    this.drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.mode_switch_button"),
                            StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModeHorizontalCol.getDisplayName().mergeStyle(TextFormatting.GREEN))), mouseX, mouseY);
                    break;
                case 2:
                    this.drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.mode_switch_button"),
                            StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModeVerticalCol.getDisplayName().mergeStyle(TextFormatting.GREEN))), mouseX, mouseY);
                    break;
            }
        }
        if (forceDropItemsButton.isHovered()) {
            drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.force_drop_items_button_name"),
                    StringHelper.localize(Reference.MODID, "tooltip.force_drop_items_button_desc"),
                    StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("forceDropItems")))), mouseX, mouseY);
        }
        if (directionalPlacementButton.isHovered()) {
            drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.directional_placement_button_name"),
                    StringHelper.localize(Reference.MODID, "tooltip.directional_placement_button_desc"),
                    StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("directionalPlacement")))), mouseX, mouseY);
        }
        if (fuzzyPlacementButton.isHovered()) {
            drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_button_name"),
                    StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_button_desc"),
                    StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("fuzzyPlacement")))), mouseX, mouseY);
        }
        if (voidItemsButton.isHovered()) {
            drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.void_items_button_name"),
                    StringHelper.localize(Reference.MODID, "tooltip.void_items_button_desc"),
                    StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("voidItems")))), mouseX, mouseY);
        }
        if (fuzzyPlacementChanceField.isMouseOver(mouseX, mouseY)) {
            drawToolTip(matrixStack, ImmutableList.of(StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_chance_box_name"),
                    StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_chance_box_desc")), mouseX, mouseY
            );
        }
    }

    private void drawToolTip(MatrixStack matrixStack, List<ITextComponent> tooltips, int x, int y) {
        GuiUtils.drawHoveringText(matrixStack, tooltips, x, y, width, height, 200, font);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        fuzzyPlacementChanceField.mouseClicked(mouseX, mouseY, button);
        if (!fuzzyPlacementChanceField.isFocused()) {
            if (!fuzzyPlacementChanceField.getText().isEmpty()) {
                parseFuzzyPlacementChance(fuzzyPlacementChanceField, 1, 100);
                return super.mouseClicked(mouseX, mouseY, button);
            } else {
                fuzzyPlacementChanceField.setText(chance);
            }
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (GLFW.GLFW_KEY_BACKSPACE == keyCode || GLFW.GLFW_KEY_DELETE == keyCode || GLFW.GLFW_KEY_LEFT == keyCode
                || GLFW.GLFW_KEY_RIGHT == keyCode || GLFW.GLFW_KEY_HOME == keyCode || GLFW.GLFW_KEY_END == keyCode) {
            return fuzzyPlacementChanceField.keyPressed(keyCode, scanCode, modifiers);
        }
        if (fuzzyPlacementChanceField.isFocused()) {
            if (GLFW.GLFW_KEY_ESCAPE == keyCode || GLFW.GLFW_KEY_ENTER == keyCode || GLFW.GLFW_KEY_KP_ENTER == keyCode) {
                if (!fuzzyPlacementChanceField.getText().isEmpty()) {
                    fuzzyPlacementChanceField.changeFocus(false);
                    parseFuzzyPlacementChance(fuzzyPlacementChanceField, 1, 100);
                    return true;
                }
            }
        } else {
            if (GLFW.GLFW_KEY_ESCAPE == keyCode || Keys.OPEN_GUI_KEY.getKey().getKeyCode() == keyCode || mc.gameSettings.keyBindInventory.getKey().getKeyCode() == keyCode) {
                this.closeScreen();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        if (fuzzyPlacementChanceField.isFocused()) {
            if (Character.isDigit(codePoint)) {
                fuzzyPlacementChanceField.charTyped(codePoint, modifiers);
            }
        }
        return super.charTyped(codePoint, modifiers);
    }

    private void parseFuzzyPlacementChance(TextFieldWidget field, int min, int max) {
        try {
            int value = Integer.parseInt(field.getText());
            boolean valid = value >= min && value <= max;
            if (valid) {
                NetworkHandler.INSTANCE.sendToServer(new PacketSetFuzzyPlacementChance(value));
                this.chance = String.valueOf(value);
            } else {
                NetworkHandler.INSTANCE.sendToServer(new PacketSetFuzzyPlacementChance(max));
                this.chance = String.valueOf(max);
                field.setText(String.valueOf(max));
            }
        } catch (NumberFormatException exception) {
            NetworkHandler.INSTANCE.sendToServer(new PacketSetFuzzyPlacementChance(max));
            this.chance = String.valueOf(max);
            field.setText(String.valueOf(max));
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

}
