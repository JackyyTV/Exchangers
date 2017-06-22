package me.jacky1356400.exchangers.helper;

import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

import java.text.NumberFormat;

import static net.minecraft.util.text.translation.I18n.translateToLocal;
import static net.minecraft.util.text.translation.I18n.translateToLocalFormatted;

public final class StringHelper
{
    public static final String BLACK = "§0";
    public static final String BLUE = "§1";
    public static final String GREEN = "§2";
    public static final String TEAL = "§3";
    public static final String RED = "§4";
    public static final String PURPLE = "§5";
    public static final String ORANGE = "§6";
    public static final String LIGHT_GRAY = "§7";
    public static final String GRAY = "§8";
    public static final String LIGHT_BLUE = "§9";
    public static final String BRIGHT_GREEN = "§a";
    public static final String BRIGHT_BLUE = "§b";
    public static final String LIGHT_RED = "§c";
    public static final String PINK = "§d";
    public static final String YELLOW = "§e";
    public static final String WHITE = "§f";
    public static final String OBFUSCATED = "§k";
    public static final String BOLD = "§l";
    public static final String STRIKETHROUGH = "§m";
    public static final String UNDERLINE = "§n";
    public static final String ITALIC = "§o";
    public static final String END = "§r";
    public static boolean displayShiftForDetail = true;

    private StringHelper() {

    }

    public static String getTierText(int tier) {
        return localize("tooltip.tier", tier);
    }

    public static String getShiftText() {
        return TextFormatting.GRAY + localize("tooltip.holdShift", TextFormatting.YELLOW.toString() + TextFormatting.ITALIC + localize("tooltip.holdShift.shift") + TextFormatting.RESET + TextFormatting.GRAY);
    }

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public static String formatNumber(long number) {
        return NumberFormat.getInstance().format(number);
    }

    public static String localize(String unlocalized, Object... args) {
        return localize(unlocalized, true, args);
    }

    public static String localize(String unlocalized, boolean prefix, Object... args) {
        String toLocalize = (prefix ? Exchangers.PREFIX : "") + unlocalized;
        if(args != null && args.length > 0) {
            return translateToLocalFormatted(toLocalize, args);
        }
        else {
            return translateToLocal(toLocalize);
        }
    }

}
