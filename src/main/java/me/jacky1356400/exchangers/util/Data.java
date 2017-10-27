package me.jacky1356400.exchangers.util;

import me.jacky1356400.exchangers.init.ModRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final String EIO = "enderio";
    public static final String MEK = "mekanism";
    public static final String THERMAL = "thermalexpansion";
    public static final String IE = "immersiveengineering";
    public static final String VERSION = "1.12-2.5";
    public static final String MCVERSION = "[1.12,)";
    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";
    public static final EnumRarity TIER_1 = EnumHelper.addRarity("TIER_1", TextFormatting.GREEN, "Tier 1");
    public static final String DEPENDS
            = "required-after:redstoneflux;"
            + "after:enderio;"
            + "after:thermalfoundation;"
            + "after:thermalexpansion;"
            + "after:mekanism;"
            + "after:immersiveengineering;";
    public static final String GUIFACTORY = "me.jacky1356400.exchangers.ConfigGuiFactory";
    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModRegistry.OBSIDIAN);
        }
    };

}
