package me.jacky1356400.exchangers.proxy;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Recipes;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.ExchangersItems;
import me.jacky1356400.exchangers.handler.ExchangerHandler;
import me.jacky1356400.exchangers.handler.KeyBindingsHandler;
import me.jacky1356400.exchangers.handler.RenderOverlayHandler;
import me.jacky1356400.exchangers.handler.WorldEventHandler;
import me.jacky1356400.exchangers.handler.network.PacketHandler;
import me.jacky1356400.exchangers.util.Exchange;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
        PacketHandler.registerMessages(Exchangers.MODID);
        ExchangerHandler.initSpecialBlockLists();
    }

    public void init(FMLInitializationEvent e){
        WorldEventHandler handler = new WorldEventHandler();
        Exchangers.logger.info("proxy");
        Recipes.init();
        FMLCommonHandler.instance().bus().register(handler);
        MinecraftForge.EVENT_BUS.register(new RenderOverlayHandler());
        FMLCommonHandler.instance().bus().register(new KeyBindingsHandler());
    }

    public void postInit(FMLPostInitializationEvent e){

    }

}
