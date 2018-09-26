package jackyy.exchangers.helper;

import jackyy.exchangers.Exchangers;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import org.lwjgl.input.Keyboard;

import java.text.NumberFormat;

@SuppressWarnings("deprecation")
public class StringHelper {

    public static String getTierText(int tier) {
        return localize("tooltip.tier", tier);
    }

    public static String getShiftText() {
        return TextFormatting.GRAY + localize("tooltip.hold_shift", TextFormatting.YELLOW.toString() + TextFormatting.ITALIC + localize("tooltip.hold_shift.shift") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static String getCtrlText() {
        return TextFormatting.GRAY + localize("tooltip.hold_ctrl", TextFormatting.AQUA.toString() + TextFormatting.ITALIC + localize("tooltip.hold_ctrl.ctrl") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isCtrlKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
    }

    public static String formatNumber(long number) {
        return NumberFormat.getInstance().format(number);
    }

    public static String formatHarvestLevel(int harvestLevel) {
        return localize("harvest_level." + harvestLevel).equals(Exchangers.MODID + "." + "harvest_level." + harvestLevel) ? String.valueOf(harvestLevel) : localize("harvest_level." + harvestLevel);
    }

    public static String localize(String unlocalized, Object... args) {
        String toLocalize = Exchangers.MODID + "." + unlocalized;
        if (args != null && args.length > 0) {
            return I18n.translateToLocalFormatted(toLocalize, args);
        }
        else {
            return I18n.translateToLocal(toLocalize);
        }
    }

}
