package jackyy.exchangers.proxy;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.handler.EventsHandler;
import jackyy.exchangers.handler.network.PacketHandler;
import jackyy.exchangers.integration.EnderIOIntegration;
import jackyy.exchangers.integration.ImmersiveEngineeringIntegration;
import jackyy.exchangers.integration.MekanismIntegration;
import jackyy.exchangers.integration.ThermalExpansionIntegration;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.registry.ModItems;
import jackyy.exchangers.registry.ModRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        ModItems.init();
        if (ModConfig.modules.enderIOModule) {
            if (Loader.isModLoaded(Exchangers.EIO)) {
                EnderIOIntegration.init();
            }
        }
        if (ModConfig.modules.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                ThermalExpansionIntegration.init();
            }
        }
        if (ModConfig.modules.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
                MekanismIntegration.init();
            }
        }
        if (ModConfig.modules.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                ImmersiveEngineeringIntegration.init();
            }
        }
        ModRecipes.init();
        PacketHandler.registerMessages(Exchangers.MODID);
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}
