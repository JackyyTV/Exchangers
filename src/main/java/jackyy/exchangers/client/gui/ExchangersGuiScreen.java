package jackyy.exchangers.client.gui;

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
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.client.config.HoverChecker;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExchangersGuiScreen extends GuiScreen {

    private final ResourceLocation GUI_IMAGE = new ResourceLocation(Reference.MODID, "textures/gui/gui_exchanger.png");
    private static final int W = 180;
    private static final int H = 150;
    private String chance;

    private GuiButtonImageExt decreaseRangeButton;
    private GuiButtonImageExt increaseRangeButton;
    private GuiButtonToggle modeSwitchButton;
    private GuiButtonToggle forceDropItemsButton;
    private GuiButtonToggle directionalPlacementButton;
    private GuiButtonToggle fuzzyPlacementButton;
    private GuiButtonToggle voidItemsButton;

    private GuiTextField fuzzyPlacementChanceField;

    private HoverChecker decreaseRangeHoverChecker;
    private HoverChecker increaseRangeHoverChecker;
    private HoverChecker modeSwitchHoverChecker;
    private HoverChecker forceDropItemsHoverChecker;
    private HoverChecker directionalPlacementHoverChecker;
    private HoverChecker fuzzyPlacementHoverChecker;
    private HoverChecker fuzzyPlacementChanceHoverChecker;
    private HoverChecker voidItemsHoverChecker;

    public ExchangersGuiScreen() {
        this.width = W;
        this.height = H;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        int relativeX = (this.width - W) / 2;
        int relativeY = (this.height - H) / 2;
        ItemStack stack = mc.player.getHeldItemMainhand();
        chance = Integer.toString(stack.getTagCompound().getInteger("fuzzyPlacementChance"));
        decreaseRangeButton = new GuiButtonImageExt(0, relativeX + 54, relativeY + 31, 10, 15, 180, 0, 15, 30, GUI_IMAGE);
        increaseRangeButton = new GuiButtonImageExt(1, relativeX + 116, relativeY + 31, 10, 15, 190, 0, 15, 30, GUI_IMAGE);
        modeSwitchButton = new GuiButtonToggle(2, relativeX + 20, relativeY + 66, 20, 20, "\u29C8");
        forceDropItemsButton = new GuiButtonToggle(3, relativeX + 60, relativeY + 66, 20, 20, "\u2B0A");
        directionalPlacementButton = new GuiButtonToggle(4, relativeX + 100, relativeY + 66, 20, 20, "\u2927");
        fuzzyPlacementButton = new GuiButtonToggle(5, relativeX + 52, relativeY + 106, 20, 20, "\u224B");
        voidItemsButton = new GuiButtonToggle(6, relativeX + 140, relativeY + 66, 20, 20, "\u2A37");
        this.addButton(decreaseRangeButton);
        this.addButton(increaseRangeButton);
        this.addButton(modeSwitchButton);
        this.addButton(forceDropItemsButton);
        this.addButton(directionalPlacementButton);
        this.addButton(fuzzyPlacementButton);
        this.addButton(voidItemsButton);
        decreaseRangeHoverChecker = new HoverChecker(decreaseRangeButton, 0);
        increaseRangeHoverChecker = new HoverChecker(increaseRangeButton, 0);
        modeSwitchHoverChecker = new HoverChecker(modeSwitchButton, 0);
        forceDropItemsHoverChecker = new HoverChecker(forceDropItemsButton, 0);
        directionalPlacementHoverChecker = new HoverChecker(directionalPlacementButton, 0);
        fuzzyPlacementHoverChecker = new HoverChecker(fuzzyPlacementButton, 0);
        voidItemsHoverChecker = new HoverChecker(voidItemsButton, 0);
        fuzzyPlacementChanceField = new GuiTextField(0, this.fontRenderer, relativeX + 92, relativeY + 108, 26, 16);
        fuzzyPlacementChanceField.setMaxStringLength(3);
        fuzzyPlacementChanceField.setText(chance);
        fuzzyPlacementChanceHoverChecker = new HoverChecker(fuzzyPlacementChanceField.y, fuzzyPlacementChanceField.y + fuzzyPlacementChanceField.height,
                fuzzyPlacementChanceField.x, fuzzyPlacementChanceField.x + fuzzyPlacementChanceField.width, 0);
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        FontRenderer fontRenderer = mc.fontRenderer;
        ItemStack stack = mc.player.getHeldItemMainhand();
        ItemExchangerBase exchanger = (ItemExchangerBase) stack.getItem();
        NBTTagCompound tag = stack.getTagCompound();
        this.drawDefaultBackground();
        int relativeX = (this.width - W) / 2;
        int relativeY = (this.height - H) / 2;
        mc.getTextureManager().bindTexture(GUI_IMAGE);
        this.drawTexturedModalRect(relativeX, relativeY, 0, 0, W, H);
        this.itemRender.renderItemAndEffectIntoGUI(stack, relativeX + 82, relativeY + 8);
        int range = tag.getInteger("range");
        String exchangeRange = ExchangerHandler.rangeList[range];
        fontRenderer.drawString(exchangeRange, relativeX + 90 - fontRenderer.getStringWidth(exchangeRange) / 2.0f, relativeY + 34, -1, true);
        fuzzyPlacementChanceField.drawTextBox();
        fontRenderer.drawString("%", relativeX + 121, relativeY + 112, -1, true);
        super.drawScreen(mouseX, mouseY, partialTicks);
        decreaseRangeButton.setButtonDisabled(range == 0);
        increaseRangeButton.setButtonDisabled(range == exchanger.getMaxRange());
        forceDropItemsButton.setButtonToggled(tag.getBoolean("forceDropItems"));
        directionalPlacementButton.setButtonToggled(tag.getBoolean("directionalPlacement"));
        fuzzyPlacementButton.setButtonToggled(tag.getBoolean("fuzzyPlacement"));
        voidItemsButton.setButtonToggled(tag.getBoolean("voidItems"));
        if (decreaseRangeHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(Collections.singletonList(StringHelper.localize(Reference.MODID, "tooltip.decrease_range_button")), mouseX, mouseY);
        }
        if (increaseRangeHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(Collections.singletonList(StringHelper.localize(Reference.MODID, "tooltip.increase_range_button")), mouseX, mouseY);
        }
        int mode = tag.getInteger("mode");
        if (modeSwitchHoverChecker.checkHover(mouseX, mouseY)) {
            switch (mode) {
                case 0:
                    drawToolTip(
                            Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.mode_switch_button"),
                                    StringHelper.localize(Reference.MODID, "tooltip.current_mode", TextFormatting.GREEN + ModePlane.getDisplayName())),
                            mouseX, mouseY
                    );
                    break;
                case 1:
                    drawToolTip(
                            Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.mode_switch_button"),
                                    StringHelper.localize(Reference.MODID, "tooltip.current_mode", TextFormatting.GREEN + ModeHorizontalCol.getDisplayName())),
                            mouseX, mouseY
                    );
                    break;
                case 2:
                    drawToolTip(
                            Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.mode_switch_button"),
                                    StringHelper.localize(Reference.MODID, "tooltip.current_mode", TextFormatting.GREEN + ModeVerticalCol.getDisplayName())),
                            mouseX, mouseY
                    );
                    break;
            }
        }
        if (forceDropItemsHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(
                    Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.force_drop_items_button_name"),
                            StringHelper.localize(Reference.MODID, "tooltip.force_drop_items_button_desc"),
                            StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("forceDropItems")))),
                    mouseX, mouseY
            );
        }
        if (directionalPlacementHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(
                    Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.directional_placement_button_name"),
                            StringHelper.localize(Reference.MODID, "tooltip.directional_placement_button_desc"),
                            StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("directionalPlacement")))),
                    mouseX, mouseY
            );
        }
        if (fuzzyPlacementHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(
                    Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_button_name"),
                            StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_button_desc"),
                            StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("fuzzyPlacement")))),
                    mouseX, mouseY
            );
        }
        if (voidItemsHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(
                    Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.void_items_button_name"),
                            StringHelper.localize(Reference.MODID, "tooltip.void_items_button_desc"),
                            StringHelper.localize(Reference.MODID, "tooltip.state", Reference.getStateString(tag.getBoolean("voidItems")))),
                    mouseX, mouseY
            );
        }
        if (fuzzyPlacementChanceHoverChecker.checkHover(mouseX, mouseY)) {
            drawToolTip(
                    Arrays.asList(StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_chance_box_name"),
                            StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement_chance_box_desc")),
                    mouseX, mouseY
            );
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        fuzzyPlacementChanceField.updateCursorCounter();
    }

    private void drawToolTip(List<String> tooltips, int x, int y) {
        GuiUtils.drawHoveringText(tooltips, x, y, width, height, 200, fontRenderer);
    }

    @Override
    protected void actionPerformed(@Nonnull GuiButton button) throws IOException {
        switch (button.id) {
            case 0:
                NetworkHandler.INSTANCE.sendToServer(new PacketDecreaseRange());
                break;
            case 1:
                NetworkHandler.INSTANCE.sendToServer(new PacketIncreaseRange());
                break;
            case 2:
                NetworkHandler.INSTANCE.sendToServer(new PacketSwitchMode());
                break;
            case 3:
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleForceDropItems());
                break;
            case 4:
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleDirectionalPlacement());
                break;
            case 5:
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleFuzzyPlacement());
                break;
            case 6:
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleVoidItems());
                break;
            default:
                super.actionPerformed(button);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        fuzzyPlacementChanceField.mouseClicked(mouseX, mouseY, mouseButton);
        if (!fuzzyPlacementChanceField.isFocused()) {
            if (!fuzzyPlacementChanceField.getText().isEmpty()) {
                parseFuzzyPlacementChance(fuzzyPlacementChanceField, 1, 100);
            }
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (Character.isDigit(typedChar) || Keyboard.KEY_BACK == keyCode || Keyboard.KEY_DELETE == keyCode
                || Keyboard.KEY_LEFT == keyCode || Keyboard.KEY_RIGHT == keyCode || Keyboard.KEY_HOME == keyCode || Keyboard.KEY_END == keyCode) {
            fuzzyPlacementChanceField.textboxKeyTyped(typedChar, keyCode);
        }
        if (fuzzyPlacementChanceField.isFocused()) {
            if (Keyboard.KEY_ESCAPE == keyCode || Keyboard.KEY_RETURN == keyCode || Keyboard.KEY_NUMPADENTER == keyCode) {
                if (!fuzzyPlacementChanceField.getText().isEmpty()) {
                    fuzzyPlacementChanceField.setFocused(false);
                    parseFuzzyPlacementChance(fuzzyPlacementChanceField, 1, 100);
                }
            }
        } else {
            if (Keys.OPEN_GUI_KEY.getKeyCode() == keyCode || mc.gameSettings.keyBindInventory.getKeyCode() == keyCode) {
                mc.displayGuiScreen(null);
            }
            super.keyTyped(typedChar, keyCode);
        }
    }

    private void parseFuzzyPlacementChance(GuiTextField field, int min, int max) {
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
    public boolean doesGuiPauseGame() {
        return false;
    }


}
