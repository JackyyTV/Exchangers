package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

	//Categories
	private static final String CATEGORY_MODULES = "modules";
	private static final String CATEGORY_TWEAKS_VANILLA = "vanilla tweaks";
	private static final String CATEGORY_TWEAKS_EIO = "ender io tweaks";
	private static final String CATEGORY_TWEAKS_TE = "thermal expansion tweaks";
	private static final String CATEGORY_TWEAKS_MEKANISM = "mekanism tweaks";
	private static final String CATEGORY_RECIPES = "recipe tweaks";

	//Modules
	public static boolean vanillaModule;
	public static boolean enderIOModule;
	public static boolean thermalExpansionModule;
	public static boolean mekanismModule;
	public static boolean specialModule;

	//Recipes
	public static boolean vanillaProgressiveRecipes;
	public static boolean enderIOProgressiveRecipes;
	public static boolean thermalExpansionProgressiveRecipes;
	public static boolean mekanismProgressiveRecipes;

	//Vanilla
	public static int woodMaxDmg;
	public static int stoneMaxDmg;
	public static int goldMaxDmg;
	public static int ironMaxDmg;
	public static int diaMaxDmg;
	public static int emeMaxDmg;
	public static int obsMaxDmg;

	//Ender IO
	public static int conductiveMaxEnergy;
	public static int conductivePerBlockUse;
	public static int pulsatingMaxEnergy;
	public static int pulsatingPerBlockUse;
	public static int electricalSteelMaxEnergy;
	public static int electricalSteelPerBlockUse;
	public static int energeticMaxEnergy;
	public static int energeticPerBlockUse;
	public static int darkSteelMaxEnergy;
	public static int darkSteelPerBlockUse;
	public static int vibrantMaxEnergy;
	public static int vibrantPerBlockUse;

	//Thermal Expansion
	public static int leadstoneMaxEnergy;
	public static int leadstonePerBlockUse;
	public static int hardenedMaxEnergy;
	public static int hardenedPerBlockUse;
	public static int reinforcedMaxEnergy;
	public static int reinforcedPerBlockUse;
	public static int signalumMaxEnergy;
	public static int signalumPerBlockUse;
	public static int resonantMaxEnergy;
	public static int resonantPerBlockUse;

	//Mekanism
	public static int basicMaxEnergy;
	public static int basicPerBlockUse;
	public static int advancedMaxEnergy;
	public static int advancedPerBlockUse;
	public static int eliteMaxEnergy;
	public static int elitePerBlockUse;
	public static int ultimateMaxEnergy;
	public static int ultimatePerBlockUse;

	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initConfig(cfg);
		} catch (Exception e) {
			Exchangers.logger.error("ERROR LOADING CONFIG", e);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}

	private static void initConfig(Configuration cfg) {

		//Modules
		vanillaModule = cfg.getBoolean("Vanilla Module", CATEGORY_MODULES, true,
				"If true, enables recipes for vanilla-based exchangers.");
		enderIOModule = cfg.getBoolean("Ender IO Module", CATEGORY_MODULES, false,
				"[Not implemented!] If true, enables recipes for Ender IO-based exchangers (Requires Ender IO to be installed).");
		thermalExpansionModule = cfg.getBoolean("Thermal Expansion Module", CATEGORY_MODULES, true,
				"If true, enables recipes for Thermal Expansion-based exchangers (Requires Thermal Expansion to be installed).");
		mekanismModule = cfg.getBoolean("Mekanism Module", CATEGORY_MODULES, false,
				"[Not implemented!] If true, enables recipes for Mekanism-based exchangers (Requires Mekanism to be installed).");
		specialModule = cfg.getBoolean("Special Module", CATEGORY_MODULES, true,
				"If true, enables recipes for special exchangers (e.g. Tuberous Exchanger).");

		//Recipes
		cfg.addCustomCategoryComment(CATEGORY_RECIPES,
				"Progressive recipes - requires the previous tier to craft the next tier exchanger, which means more expensive.");
		vanillaProgressiveRecipes = cfg.getBoolean("Vanilla Progressive Recipes", CATEGORY_RECIPES, true,
				"[Not implemented!] If true, enables progressive recipes for vanilla-based exchangers.");
		enderIOProgressiveRecipes = cfg.getBoolean("Ender IO Progressive Recipes", CATEGORY_RECIPES, true,
				"[Not implemented!] If true, enables progressive recipes for Ender IO-based exchangers.");
		thermalExpansionProgressiveRecipes = cfg.getBoolean("Thermal Expansion Progressive Recipes", CATEGORY_RECIPES,
				true, "[Not implemented!] If true, enables progressive recipes for Thermal Expansion-based exchangers.");
		mekanismProgressiveRecipes = cfg.getBoolean("Mekanism Progressive Recipes", CATEGORY_RECIPES, true,
				"If true, enables progressive recipes for Mekanism-based exchangers.");

		//Vanilla Tweaks
		cfg.addCustomCategoryComment(CATEGORY_TWEAKS_VANILLA, "Vanilla Exchanger Tweaks");
		woodMaxDmg = cfg.getInt("Wooden Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 256, 1, 2147483647,
				"Set the durability for Wooden Exchanger");
		stoneMaxDmg = cfg.getInt("Stone Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 384, 1, 2147483647,
				"Set the durability for Stone Exchanger");
		goldMaxDmg = cfg.getInt("Golden Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 512, 1, 2147483647,
				"Set the durability for Golden Exchanger");
		ironMaxDmg = cfg.getInt("Iron Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 1024, 1, 2147483647,
				"Set the durability for Iron Exchanger");
		diaMaxDmg = cfg.getInt("Diamond Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 4096, 1, 2147483647,
				"Set the durability for Diamond Exchanger");
		emeMaxDmg = cfg.getInt("Emerald Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 8192, 1, 2147483647,
				"Set the durability for Emerald Exchanger");
		obsMaxDmg = cfg.getInt("Obsidian Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 16384, 1, 2147483647,
				"Set the durability for Obsidian Exchanger");

		//Ender IO Tweaks
		cfg.addCustomCategoryComment(CATEGORY_TWEAKS_EIO, "[Not implemented!] Ender IO Exchanger Tweaks");
		conductiveMaxEnergy = cfg.getInt("Conductive Iron Exchanger Capacity", CATEGORY_TWEAKS_EIO, 80000,
				1000, 100000000, "Set the RF capacity for Conductive Iron Exchanger");
		conductivePerBlockUse = cfg.getInt("Conductive Iron Exchanger Power Consumption",
				CATEGORY_TWEAKS_EIO, 10, 1, 250, "Set the Rf consumption per block for Conductive Iron Exchanger");
		pulsatingMaxEnergy = cfg.getInt("Pulsating Iron Exchanger Capacity", CATEGORY_TWEAKS_EIO, 400000, 1000,
				100000000, "Set the RF capacity for Pulsating Iron Exchanger");
		pulsatingPerBlockUse = cfg.getInt("Pulsating Iron Exchanger Power Consumption", CATEGORY_TWEAKS_EIO,
				50, 1, 500, "Set the RF consumption per block for Pulsating Iron Exchanger");
		electricalSteelMaxEnergy = cfg.getInt("Electrical Steel Exchanger Capacity", CATEGORY_TWEAKS_EIO, 800000,
				1000, 100000000, "Set the RF capacity for Electrical Steel Exchanger");
		electricalSteelPerBlockUse = cfg.getInt("Electrical Steel Exchanger Power Consumption",
				CATEGORY_TWEAKS_EIO, 100, 1, 1000, "Set the RF consumption per block for Electrical Steel Exchanger");
		energeticMaxEnergy = cfg.getInt("Energetic Exchanger Capacity", CATEGORY_TWEAKS_EIO, 5000000, 1000,
				100000000, "Set the RF capacity for Energetic Exchanger");
		energeticPerBlockUse = cfg.getInt("Energetic Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 250, 1,
				2500, "Set the RF consumption per block for Energetic Exchanger");
		darkSteelMaxEnergy = cfg.getInt("Dark Steel Exchanger Capacity", CATEGORY_TWEAKS_EIO, 10000000, 1000,
				100000000, "Set the RF capacity for Dark Steel Exchanger");
		darkSteelPerBlockUse = cfg.getInt("Dark Steel Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 500, 1,
				5000, "Set the RF consumption per block for Dark Steel Exchanger");
		vibrantMaxEnergy = cfg.getInt("Vibrant Exchanger Capacity", CATEGORY_TWEAKS_EIO, 20000000, 1000, 100000000,
				"Set the RF capacity for Vibrant Exchanger");
		vibrantPerBlockUse = cfg.getInt("Vibrant Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 1000, 1,
				10000, "Set the RF consumption per block for Vibrant Exchanger");

		//Thermal Expansion Tweaks
		cfg.addCustomCategoryComment(CATEGORY_TWEAKS_TE, "[Not implemented!] Thermal Expansion Exchanger Tweaks");
		leadstoneMaxEnergy = cfg.getInt("Leadstone Exchanger Capacity", CATEGORY_TWEAKS_TE, 80000, 1000, 100000000,
				"Set the RF capacity for Leadstone Exchanger");
		leadstonePerBlockUse = cfg.getInt("Leadstone Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 10, 1,
				250, "Set the RF consumption per block for Leadstone Exchanger");
		hardenedMaxEnergy = cfg.getInt("Hardened Exchanger Capacity", CATEGORY_TWEAKS_TE, 500000, 1000, 100000000,
				"Set the RF capacity for Hardened Exchanger");
		hardenedPerBlockUse = cfg.getInt("Hardened Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 50, 1, 500,
				"Set the RF consumption per block for Hardened Exchanger");
		reinforcedMaxEnergy = cfg.getInt("Reinforced Exchanger Capacity", CATEGORY_TWEAKS_TE, 1000000, 1000,
				100000000, "Set the RF capacity for Reinforced Exchanger");
		reinforcedPerBlockUse = cfg.getInt("Reinforced Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 100, 1,
				1000, "Set the RF consumption per block for Reinforced Exchanger");
		signalumMaxEnergy = cfg.getInt("Signalum Exchanger Capacity", CATEGORY_TWEAKS_TE, 10000000, 1000,
				100000000, "Set the RF capacity for Signalum Exchanger");
		signalumPerBlockUse = cfg.getInt("Signalum Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 500, 1,
				5000, "Set the RF consumption per block for Signalum Exchanger");
		resonantMaxEnergy = cfg.getInt("Resonant Exchanger Capacity", CATEGORY_TWEAKS_TE, 20000000, 1000,
				100000000, "Set the RF capacity for Resonant Exchanger");
		resonantPerBlockUse = cfg.getInt("Resonant Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 1000, 1,
				10000, "Set the RF consumption per block for Resonant Exchanger");

		//Mekanism Tweaks
		cfg.addCustomCategoryComment(CATEGORY_TWEAKS_MEKANISM, "[Not implemented!] Mekanism Exchanger Tweaks");
		basicMaxEnergy = cfg.getInt("Basic Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 100000, 1000, 100000000,
				"Set the RF capacity for Basic Exchanger");
		basicPerBlockUse = cfg.getInt("Basic Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 50, 1, 500,
				"Set the RF consumption per block for Basic Exchanger");
		advancedMaxEnergy = cfg.getInt("Advanced Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 800000, 1000,
				100000000, "Set the RF capacity for Advanced Exchanger");
		advancedPerBlockUse = cfg.getInt("Advanced Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 100,
				1, 1000, "Set the RF consumption per block for Advanced Exchanger");
		eliteMaxEnergy = cfg.getInt("Elite Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 5000000, 1000, 100000000,
				"Set the RF capacity for Elite Exchanger");
		elitePerBlockUse = cfg.getInt("Elite Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 250, 1,
				2500, "Set the RF consumption per block for Elite Exchanger");
		ultimateMaxEnergy = cfg.getInt("Ultimate Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 10000000, 1000,
				100000000, "Set the RF capacity for Ultimate Exchanger");
		ultimatePerBlockUse = cfg.getInt("Ultimate Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 500,
				1, 5000, "Set the RF consumption per block for Ultimate Exchanger");

	}

}
