package me.jacky1356400.exchangers.proxy;

import java.io.File;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.handler.RenderOverlayHandler;
import me.jacky1356400.exchangers.handler.WorldEventHandler;
import me.jacky1356400.exchangers.handler.network.PacketHandler;
import me.jacky1356400.exchangers.helper.DirectionHelper;
import me.jacky1356400.exchangers.init.ModRegistry;
import me.jacky1356400.exchangers.integration.EnderIOIntegration;
import me.jacky1356400.exchangers.integration.MekanismIntegration;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import me.jacky1356400.exchangers.item.ItemExchanger;
import me.jacky1356400.exchangers.util.Data;
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
		/*
		if ((Config.enderIOModule = true) && (Loader.isModLoaded(Data.EIO))) {
			EnderIOIntegration.init();
		}
		if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded(Data.THERMAL))) {
			ThermalExpansionIntegration.init();
		}
		if ((Config.mekanismModule = true) && (Loader.isModLoaded(Data.MEK))) {
			MekanismIntegration.init();
		}
		*/
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
