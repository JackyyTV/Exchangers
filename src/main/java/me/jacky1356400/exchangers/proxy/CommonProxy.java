package me.jacky1356400.exchangers.proxy;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Recipes;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.ExchangersItems;
import net.minecraftforge.common.config.Configuration;
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
    }

    public void init(FMLInitializationEvent e){
        Exchangers.logger.info("proxy");
        Recipes.init();
    }

    public void postInit(FMLPostInitializationEvent e){

    }

}
