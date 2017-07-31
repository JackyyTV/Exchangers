package me.jacky1356400.exchangers.proxy;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.handler.network.PacketHandler;
import me.jacky1356400.exchangers.init.ModRegistry;
import me.jacky1356400.exchangers.util.Data;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File configDir = e.getModConfigurationDirectory();
        config = new Configuration(new File(configDir.getPath(), "exchangers.cfg"));
        Config.readConfig();
        MinecraftForge.EVENT_BUS.register(new ModRegistry());
        PacketHandler.registerMessages(Data.MODID);
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}
