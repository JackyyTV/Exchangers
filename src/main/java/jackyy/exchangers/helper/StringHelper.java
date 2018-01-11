package jackyy.exchangers.helper;

import java.text.NumberFormat;

import org.lwjgl.input.Keyboard;

import jackyy.exchangers.Exchangers;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

public class StringHelper {

    public static String getTierText(int tier) {
        return localize("tooltip.tier", tier);
    }

    public static String getShiftText() {
        return TextFormatting.GRAY + localize("tooltip.hold_shift", TextFormatting.YELLOW.toString() + TextFormatting.ITALIC + localize("tooltip.hold_shift.shift") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public static String formatNumber(long number) {
        return NumberFormat.getInstance().format(number);
    }

    @SuppressWarnings("deprecation")
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
