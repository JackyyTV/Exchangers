package jackyy.exchangers.proxy;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.ExchangersItems;
import jackyy.exchangers.Recipes;
import jackyy.exchangers.handler.EventsHandler;
import jackyy.exchangers.handler.network.PacketHandler;
import jackyy.exchangers.integration.EnderIOIntegration;
import jackyy.exchangers.integration.ImmersiveEngineeringIntegration;
import jackyy.exchangers.integration.MekanismIntegration;
import jackyy.exchangers.integration.ThermalExpansionIntegration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File configDir = e.getModConfigurationDirectory();
        config = new Configuration(new File(configDir.getPath(), "Exchangers.cfg"));
        Config.readConfig();
        ExchangersItems.init();
        if (Config.enderIOModule) {
            if (Loader.isModLoaded(Exchangers.EIO)) {
                EnderIOIntegration.init();
            }
        }
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                ThermalExpansionIntegration.init();
            }
        }
        if (Config.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
                MekanismIntegration.init();
            }
        }
        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                ImmersiveEngineeringIntegration.init();
            }
        }
        Recipes.init();
        PacketHandler.registerMessages(Exchangers.MODID);
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}
