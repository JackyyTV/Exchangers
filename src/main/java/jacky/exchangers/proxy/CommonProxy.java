package jacky.exchangers.proxy;

import java.io.File;

import jacky.exchangers.Config;
import jacky.exchangers.Exchangers;
import jacky.exchangers.handler.RenderOverlayHandler;
import jacky.exchangers.handler.WorldEventHandler;
import jacky.exchangers.handler.network.PacketHandler;
import jacky.exchangers.helper.DirectionHelper;
import jacky.exchangers.init.ModRegistry;
import jacky.exchangers.integration.EnderIOIntegration;
import jacky.exchangers.integration.MekanismIntegration;
import jacky.exchangers.integration.ThermalExpansionIntegration;
import jacky.exchangers.item.ItemExchanger;
import jacky.exchangers.util.Data;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public static Configuration config;

	public void preInit(FMLPreInitializationEvent e) {
		File configDir = e.getModConfigurationDirectory();
		config = new Configuration(new File(configDir.getPath(), "exchangers.cfg"));
		Config.readConfig();
		MinecraftForge.EVENT_BUS.register(new ModRegistry());
		if ((Config.enderIOModule = true) && (Loader.isModLoaded(Data.EIO))) {
			EnderIOIntegration.init();
		}
		if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded(Data.THERMAL))) {
			ThermalExpansionIntegration.init();
		}
		if ((Config.mekanismModule = true) && (Loader.isModLoaded(Data.MEK))) {
			MekanismIntegration.init();
		}
		PacketHandler.registerMessages(Data.MODID);
	}

	public void init(FMLInitializationEvent e) {
		Exchangers.logger.info("proxy");
		MinecraftForge.EVENT_BUS.register(new RenderOverlayHandler());
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler());
	}

	public void postInit(FMLPostInitializationEvent e) {
		ItemExchanger.initSpecialBlockLists();
		DirectionHelper.initFacings();
	}

}
