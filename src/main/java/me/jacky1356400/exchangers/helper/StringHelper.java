package me.jacky1356400.exchangers.helper;

import me.jacky1356400.exchangers.util.Data;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.text.NumberFormat;

public final class StringHelper {

    public static boolean displayShiftForDetail = true;

    private StringHelper() {

    }

    @SideOnly(Side.CLIENT)
    public static String getShiftText() {
        return TextFormatting.GRAY
                + localize("tooltip.holdShift", TextFormatting.YELLOW.toString() + TextFormatting.ITALIC
                + localize("tooltip.holdShift.shift") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public static String formatNumber(long number) {
        return NumberFormat.getInstance().format(number);
    }

    @SideOnly(Side.CLIENT)
    public static String localize(String unlocalized, Object... args) {
        return localize(unlocalized, true, args);
    }

    @SideOnly(Side.CLIENT)
    public static String localize(String unlocalized, boolean prefix, Object... args) {
        String toLocalize = (prefix ? Data.MODID + "." : "") + unlocalized;
        if (args != null && args.length > 0) {
            return I18n.format(toLocalize, args);
        } else {
            return I18n.format(toLocalize);
        }
    }

}
