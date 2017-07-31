package me.jacky1356400.exchangers.proxy;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.ExchangersItems;
import me.jacky1356400.exchangers.Recipes;
import me.jacky1356400.exchangers.handler.network.PacketHandler;
import me.jacky1356400.exchangers.integration.EnderIOIntegration;
import me.jacky1356400.exchangers.integration.MekanismIntegration;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e){
        File configDir = e.getModConfigurationDirectory();
        config = new Configuration(new File(configDir.getPath(), "exchangers.cfg"));
        Config.readConfig();
        ExchangersItems.init();
        if (Config.enderIOModule) {
            if (Loader.isModLoaded("enderio")) {
                EnderIOIntegration.init();
            }
        }
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded("thermalexpansion")) {
                ThermalExpansionIntegration.init();
            }
        }
        if (Config.mekanismModule) {
            if (Loader.isModLoaded("mekanism")) {
                MekanismIntegration.init();
            }
        }
        Recipes.init();
        PacketHandler.registerMessages(Exchangers.MODID);
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}
