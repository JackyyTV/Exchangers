package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Exchangers.MODID, version = Exchangers.VERSION, name = Exchangers.MODNAME, dependencies = Exchangers.DEPENDS, guiFactory = Exchangers.GUIFACTORY, useMetadata = true)
public class Exchangers {

    public static final String VERSION = "1.11.2-1.6";
    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";
    public static final String DEPENDS
            = "after:enderio;"
            + "after:thermalfoundation;"
            + "after:thermalexpansion;"
            + "after:mekanism;"
            + "after:immersiveengineering;";
    public static final String GUIFACTORY = "me.jacky1356400.exchangers.ConfigGuiFactory";
    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ExchangersItems.obsidianExchanger);
        }
    };
    public static final EnumRarity TIER_1 = EnumHelper.addRarity("TIER_1", TextFormatting.GREEN, "Tier 1");

    public static Logger logger = LogManager.getLogger(MODNAME);

    @SidedProxy(serverSide = "me.jacky1356400.exchangers.proxy.CommonProxy", clientSide = "me.jacky1356400.exchangers.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
