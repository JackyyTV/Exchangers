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

    //Modules
    public static boolean vanillaModule;
    public static boolean enderIOModule;
    public static boolean thermalExpansionModule;
    public static boolean mekanismModule;

    //Vanilla
    public static int woodenExchangerMaxDamage;
    public static int stoneExchangerMaxDamage;
    public static int goldenExchangerMaxDamage;
    public static int ironExchangerMaxDamage;
    public static int diamondExchangerMaxDamage;
    public static int emeraldExchangerMaxDamage;
    public static int obsidianExchangerMaxDamage;

    //Ender IO
    public static int conductiveIronExchangerMaxRF;
    public static int conductiveIronExchangerPerBlockRF;
    public static int pulsatingIronExchangerMaxRF;
    public static int pulsatingIronExchangerPerBlockRF;
    public static int electricalSteelExchangerMaxRF;
    public static int electricalSteelExchangerPerBlockRF;
    public static int energeticExchangerMaxRF;
    public static int energeticExchangerPerBlockRF;
    public static int darkSteelExchangerMaxRF;
    public static int darkSteelExchangerPerBlockRF;
    public static int vibrantExchangerMaxRF;
    public static int vibrantExchangerPerBlockRF;

    //Thermal Expansion
    public static int leadstoneExchangerMaxRF;
    public static int leadstoneExchangerPerBlockRF;
    public static int hardenedExchangerMaxRF;
    public static int hardenedExchangerPerBlockRF;
    public static int reinforcedExchangerMaxRF;
    public static int reinforcedExchangerPerBlockRF;
    public static int signalumExchangerMaxRF;
    public static int signalumExchangerPerBlockRF;
    public static int resonantExchangerMaxRF;
    public static int resonantExchangerPerBlockRF;

    //Mekanism
    public static int basicExchangerMaxRF;
    public static int basicExchangerPerBlockRF;
    public static int advancedExchangerMaxRF;
    public static int advancedExchangerPerBlockRF;
    public static int eliteExchangerMaxRF;
    public static int eliteExchangerPerBlockRF;
    public static int ultimateExchangerMaxRF;
    public static int ultimateExchangerPerBlockRF;

    public static void readConfig(){
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e) {
            Exchangers.logger.error("ERROR LOADING CONFIG", e);
        } finally {
            if(cfg.hasChanged()){
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg){

        //Modules
        vanillaModule = cfg.getBoolean("Vanilla Module", CATEGORY_MODULES, true, "If true, enables recipes for vanilla-based exchangers.");
        enderIOModule = cfg.getBoolean("Ender IO Module", CATEGORY_MODULES, false, "[Not yet implemented] If true, enables recipes for Ender IO-based exchangers (Requires Ender IO to be installed).");
        thermalExpansionModule = cfg.getBoolean("Thermal Expansion Module", CATEGORY_MODULES, false, "[Not yet implemented] If true, enables recipes for Thermal Expansion-based exchangers (Requires Thermal Expansion to be installed).");
        mekanismModule = cfg.getBoolean("Mekanism Module", CATEGORY_MODULES, false, "[Not yet implemented] If true, enables recipes for Mekanism-based exchangers (Requires Mekanism to be installed).");

        //Vanilla Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_VANILLA, "Vanilla Exchanger Tweaks");
        woodenExchangerMaxDamage = cfg.getInt("Wooden Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 256, 1, 2147483647, "Set the durability for Wooden Exchanger");
        stoneExchangerMaxDamage = cfg.getInt("Stone Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 384, 1, 2147483647, "Set the durability for Stone Exchanger");
        goldenExchangerMaxDamage = cfg.getInt("Golden Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 512, 1, 2147483647, "Set the durability for Golden Exchanger");
        ironExchangerMaxDamage = cfg.getInt("Iron Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 1024, 1, 2147483647, "Set the durability for Iron Exchanger");
        diamondExchangerMaxDamage = cfg.getInt("Diamond Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 4096, 1, 2147483647, "Set the durability for Diamond Exchanger");
        emeraldExchangerMaxDamage = cfg.getInt("Emerald Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 8192, 1, 2147483647, "Set the durability for Emerald Exchanger");
        obsidianExchangerMaxDamage = cfg.getInt("Obsidian Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 16384, 1, 2147483647, "Set the durability for Obsidian Exchanger");

        //Ender IO Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_EIO, "Ender IO Exchanger Tweaks");
        conductiveIronExchangerMaxRF = cfg.getInt("Conductive Iron Exchanger Capacity", CATEGORY_TWEAKS_EIO, 80000, 1000, 100000000, "Set the RF capacity for Conductive Iron Exchanger");
        conductiveIronExchangerPerBlockRF = cfg.getInt("Conductive Iron Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 10, 1, 250, "Set the Rf consumption per block for Conductive Iron Exchanger");
        pulsatingIronExchangerMaxRF = cfg.getInt("Pulsating Iron Exchanger Capacity", CATEGORY_TWEAKS_EIO, 400000, 1000, 100000000, "Set the RF capacity for Pulsating Iron Exchanger");
        pulsatingIronExchangerPerBlockRF = cfg.getInt("Pulsating Iron Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 50, 1, 500, "Set the RF consumption per block for Pulsating Iron Exchanger");
        electricalSteelExchangerMaxRF = cfg.getInt("Electrical Steel Exchanger Capacity", CATEGORY_TWEAKS_EIO, 800000, 1000, 100000000, "Set the RF capacity for Electrical Steel Exchanger");
        electricalSteelExchangerPerBlockRF = cfg.getInt("Electrical Steel Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 100, 1, 1000, "Set the RF consumption per block for Electrical Steel Exchanger");
        energeticExchangerMaxRF = cfg.getInt("Energetic Exchanger Capacity", CATEGORY_TWEAKS_EIO, 5000000, 1000, 100000000, "Set the RF capacity for Energetic Exchanger");
        energeticExchangerPerBlockRF = cfg.getInt("Energetic Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 250, 1, 2500, "Set the RF consumption per block for Energetic Exchanger");
        darkSteelExchangerMaxRF = cfg.getInt("Dark Steel Exchanger Capacity", CATEGORY_TWEAKS_EIO, 10000000, 1000, 100000000, "Set the RF capacity for Dark Steel Exchanger");
        darkSteelExchangerPerBlockRF = cfg.getInt("Dark Steel Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 500, 1, 5000, "Set the RF consumption per block for Dark Steel Exchanger");
        vibrantExchangerMaxRF = cfg.getInt("Vibrant Exchanger Capacity", CATEGORY_TWEAKS_EIO, 20000000, 1000, 100000000, "Set the RF capacity for Vibrant Exchanger");
        vibrantExchangerPerBlockRF = cfg.getInt("Vibrant Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 1000, 1, 10000, "Set the RF consumption per block for Vibrant Exchanger");

        //Thermal Expansion Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_TE, "Thermal Expansion Exchanger Tweaks");
        leadstoneExchangerMaxRF = cfg.getInt("Leadstone Exchanger Capacity", CATEGORY_TWEAKS_TE, 80000, 1000, 100000000, "Set the RF capacity for Leadstone Exchanger");
        leadstoneExchangerPerBlockRF = cfg.getInt("Leadstone Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 10, 1, 250, "Set the RF consumption per block for Leadstone Exchanger");
        hardenedExchangerMaxRF = cfg.getInt("Hardened Exchanger Capacity", CATEGORY_TWEAKS_TE, 500000, 1000, 100000000, "Set the RF capacity for Hardened Exchanger");
        hardenedExchangerPerBlockRF = cfg.getInt("Hardened Exchanger Capacity", CATEGORY_TWEAKS_TE, 50, 1, 500, "Set the RF consumption per block for Hardened Exchanger");
        reinforcedExchangerMaxRF = cfg.getInt("Reinforced Exchanger Capacity", CATEGORY_TWEAKS_TE, 1000000, 1000, 100000000, "Set the RF capacity for Reinforced Exchanger");
        reinforcedExchangerPerBlockRF = cfg.getInt("Reinforced Exchanger Capacity", CATEGORY_TWEAKS_TE, 100, 1, 1000, "Set the RF consumption per block for Reinforced Exchanger");
        signalumExchangerMaxRF = cfg.getInt("Signalum Exchanger Capacity", CATEGORY_TWEAKS_TE, 10000000, 1000, 100000000, "Set the RF capacity for Signalum Exchanger");
        signalumExchangerPerBlockRF = cfg.getInt("Signalum Exchanger Capacity", CATEGORY_TWEAKS_TE, 500, 1, 5000, "Set the RF consumption per block for Signalum Exchanger");
        resonantExchangerMaxRF = cfg.getInt("Resonant Exchanger Capacity", CATEGORY_TWEAKS_TE, 20000000, 1000, 100000000, "Set the RF capacity for Resonant Exchanger");
        resonantExchangerPerBlockRF = cfg.getInt("Resonant Exchanger Capacity", CATEGORY_TWEAKS_TE, 1000, 1, 10000, "Set the RF consumption per block for Resonant Exchanger");

        //Mekanism Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_MEKANISM, "Mekanism Exchanger Tweaks");
        basicExchangerMaxRF = cfg.getInt("Basic Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 100000, 1000, 100000000, "Set the RF capacity for Basic Exchanger");
        basicExchangerPerBlockRF = cfg.getInt("Basic Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 50, 1, 500, "Set the RF consumption per block for Basic Exchanger");
        advancedExchangerMaxRF = cfg.getInt("Advanced Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 800000, 1000, 100000000, "Set the RF capacity for Advanced Exchanger");
        advancedExchangerPerBlockRF = cfg.getInt("Advanced Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 100, 1, 1000, "Set the RF consumption per block for Advanced Exchanger");
        eliteExchangerMaxRF = cfg.getInt("Elite Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 5000000, 1000, 100000000, "Set the RF capacity for Elite Exchanger");
        eliteExchangerPerBlockRF = cfg.getInt("Elite Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 250, 1, 2500, "Set the RF consumption per block for Elite Exchanger");
        ultimateExchangerMaxRF = cfg.getInt("Ultimate Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 10000000, 1000, 100000000, "Set the RF capacity for Ultimate Exchanger");
        ultimateExchangerPerBlockRF = cfg.getInt("Ultimate Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 500, 1, 5000, "Set the RF consumption per block for Ultimate Exchanger");

    }

}
