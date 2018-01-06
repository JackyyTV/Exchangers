package jackyy.exchangers;

import jackyy.exchangers.proxy.CommonProxy;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class Config {

    //Categories
    private static final String CATEGORY_MODULES = "modules";
    private static final String CATEGORY_TWEAKS_VANILLA = "vanilla tweaks";
    private static final String CATEGORY_TWEAKS_EIO = "ender io tweaks";
    private static final String CATEGORY_TWEAKS_TE = "thermal expansion tweaks";
    private static final String CATEGORY_TWEAKS_MEKANISM = "mekanism tweaks";
    private static final String CATEGORY_TWEAKS_IE = "immersive engineering tweaks";
    private static final String CATEGORY_RECIPES = "recipe tweaks";
    private static final String CATEGORY_MISC = "misc";

    //Modules
    public static boolean vanillaModule;
    public static boolean enderIOModule;
    public static boolean thermalExpansionModule;
    public static boolean mekanismModule;
    public static boolean immersiveEngineeringModule;
    public static boolean specialModule;

    //Recipes
    public static String vanillaRecipesType;
    public static String enderIORecipesType;
    public static String thermalExpansionRecipesType;
    public static String mekanismRecipesType;
    public static String immersiveEngineeringRecipesType;

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

    //Immersive Engineering
    public static int lvMaxEnergy;
    public static int lvPerBlockUse;
    public static int mvMaxEnergy;
    public static int mvPerBlockUse;
    public static int hvMaxEnergy;
    public static int hvPerBlockUse;

    //Misc
    public static String[] blocksWhitelist;
    public static boolean holdingEnchantment;
    public static boolean unbreakingPoweredExchangers;
    public static boolean useOreDictCircuits;
    public static boolean doExchangersSilkTouch;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e) {
            Exchangers.logger.error("Error caught while loading config!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    public static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        Configuration cfg = CommonProxy.config;

        list.add(new ConfigElement(cfg.getCategory(CATEGORY_MODULES)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_TWEAKS_VANILLA)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_TWEAKS_EIO)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_TWEAKS_TE)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_TWEAKS_MEKANISM)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_TWEAKS_IE)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_RECIPES)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_MISC)));

        return list;
    }

    private static void initConfig(Configuration cfg) {

        //Modules
        vanillaModule = cfg.getBoolean("Vanilla Module", CATEGORY_MODULES, true,
                "If true, enables recipes for Vanilla-based exchangers.");
        enderIOModule = cfg.getBoolean("Ender IO Module", CATEGORY_MODULES, true,
                "If true, enables recipes for Ender IO-based exchangers (Requires Ender IO to be installed).");
        thermalExpansionModule = cfg.getBoolean("Thermal Expansion Module", CATEGORY_MODULES, true,
                "If true, enables recipes for Thermal Expansion-based exchangers (Requires Thermal Expansion to be installed).");
        mekanismModule = cfg.getBoolean("Mekanism Module", CATEGORY_MODULES, true,
                "If true, enables recipes for Mekanism-based exchangers (Requires Mekanism to be installed).");
        immersiveEngineeringModule = cfg.getBoolean("Immersive Engineering Module", CATEGORY_MODULES, true,
                "If true, enables recipes for Immersive Engineering-based exchangers (Requires Immersive Engineering to be installed).");
        specialModule = cfg.getBoolean("Special Module", CATEGORY_MODULES, true,
                "If true, enables recipes for special exchangers (e.g. Tuberous Exchanger).");

        //Recipes
        cfg.addCustomCategoryComment(CATEGORY_RECIPES, "Tweak how difficult recipes are");
        vanillaRecipesType = cfg.getString(
                "Vanilla Recipes Type", CATEGORY_RECIPES, "normal",
                "Set the recipes type for Vanilla-based exchangers:\n" +
                "'easy'     Easy recipes, non-progressive, lowest recipe costs.\n" +
                "'normal'   Normal recipes, progressive, moderate recipe costs.\n" +
                "'hard'     Hard recipes, progressive, expensive recipe costs.\n"
        );
        enderIORecipesType = cfg.getString(
                "Ender IO Recipes Type", CATEGORY_RECIPES, "normal",
                "Set the recipes type for Ender IO-based exchangers:\n" +
                        "'easy'     Easy recipes, non-progressive, lowest recipe costs.\n" +
                        "'normal'   Normal recipes, progressive, moderate recipe costs.\n" +
                        "'hard'     Hard recipes, progressive, expensive recipe costs.\n"
        );
        thermalExpansionRecipesType = cfg.getString(
                "Thermal Expansion Recipes Type", CATEGORY_RECIPES, "normal",
                "Set the recipes type for Thermal Expansion-based exchangers:\n" +
                        "'easy'     Easy recipes, non-progressive, lowest recipe costs.\n" +
                        "'normal'   Normal recipes, progressive, moderate recipe costs.\n" +
                        "'hard'     Hard recipes, progressive, expensive recipe costs.\n"
        );
        mekanismRecipesType = cfg.getString(
                "Mekanism Recipes Type", CATEGORY_RECIPES, "normal",
                "Set the recipes type for Mekanism-based exchangers:\n" +
                        "'easy'     Easy recipes, non-progressive, lowest recipe costs.\n" +
                        "'normal'   Normal recipes, progressive, moderate recipe costs.\n" +
                        "'hard'     Hard recipes, progressive, expensive recipe costs.\n"
        );
        immersiveEngineeringRecipesType = cfg.getString(
                "Immersive Engineering Recipes Type", CATEGORY_RECIPES, "normal",
                "Set the recipes type for Immersive Engineering-based exchangers:\n" +
                        "'easy'     Easy recipes, non-progressive, lowest recipe costs.\n" +
                        "'normal'   Normal recipes, progressive, moderate recipe costs.\n" +
                        "'hard'     Hard recipes, progressive, expensive recipe costs.\n"
        );

        //Vanilla Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_VANILLA, "Vanilla Exchanger Tweaks");
        woodMaxDmg = cfg.getInt("Wooden Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 256, 1, Integer.MAX_VALUE,
                "Set the durability for Wooden Exchanger");
        stoneMaxDmg = cfg.getInt("Stone Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 384, 1, Integer.MAX_VALUE,
                "Set the durability for Stone Exchanger");
        goldMaxDmg = cfg.getInt("Golden Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 512, 1, Integer.MAX_VALUE,
                "Set the durability for Golden Exchanger");
        ironMaxDmg = cfg.getInt("Iron Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 1024, 1, Integer.MAX_VALUE,
                "Set the durability for Iron Exchanger");
        diaMaxDmg = cfg.getInt("Diamond Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 4096, 1, Integer.MAX_VALUE,
                "Set the durability for Diamond Exchanger");
        emeMaxDmg = cfg.getInt("Emerald Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 8192, 1, Integer.MAX_VALUE,
                "Set the durability for Emerald Exchanger");
        obsMaxDmg = cfg.getInt("Obsidian Exchanger Max Durability", CATEGORY_TWEAKS_VANILLA, 16384, 1, Integer.MAX_VALUE,
                "Set the durability for Obsidian Exchanger");

        //Ender IO Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_EIO, "Ender IO Exchanger Tweaks");
        conductiveMaxEnergy = cfg.getInt("Conductive Iron Exchanger Capacity", CATEGORY_TWEAKS_EIO, 80000,
                1000, Integer.MAX_VALUE, "Set the RF capacity for Conductive Iron Exchanger");
        conductivePerBlockUse = cfg.getInt("Conductive Iron Exchanger Power Consumption",
                CATEGORY_TWEAKS_EIO, 10, 1, conductiveMaxEnergy / 10, "Set the Rf consumption per block for Conductive Iron Exchanger");
        pulsatingMaxEnergy = cfg.getInt("Pulsating Iron Exchanger Capacity", CATEGORY_TWEAKS_EIO, 400000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Pulsating Iron Exchanger");
        pulsatingPerBlockUse = cfg.getInt("Pulsating Iron Exchanger Power Consumption", CATEGORY_TWEAKS_EIO,
                50, 1, pulsatingMaxEnergy / 10, "Set the RF consumption per block for Pulsating Iron Exchanger");
        electricalSteelMaxEnergy = cfg.getInt("Electrical Steel Exchanger Capacity", CATEGORY_TWEAKS_EIO, 800000,
                1000, Integer.MAX_VALUE, "Set the RF capacity for Electrical Steel Exchanger");
        electricalSteelPerBlockUse = cfg.getInt("Electrical Steel Exchanger Power Consumption",
                CATEGORY_TWEAKS_EIO, 100, 1, electricalSteelMaxEnergy / 10, "Set the RF consumption per block for Electrical Steel Exchanger");
        energeticMaxEnergy = cfg.getInt("Energetic Exchanger Capacity", CATEGORY_TWEAKS_EIO, 5000000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Energetic Exchanger");
        energeticPerBlockUse = cfg.getInt("Energetic Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 250, 1,
                energeticMaxEnergy / 10, "Set the RF consumption per block for Energetic Exchanger");
        darkSteelMaxEnergy = cfg.getInt("Dark Steel Exchanger Capacity", CATEGORY_TWEAKS_EIO, 10000000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Dark Steel Exchanger");
        darkSteelPerBlockUse = cfg.getInt("Dark Steel Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 500, 1,
                darkSteelMaxEnergy / 10, "Set the RF consumption per block for Dark Steel Exchanger");
        vibrantMaxEnergy = cfg.getInt("Vibrant Exchanger Capacity", CATEGORY_TWEAKS_EIO, 20000000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for Vibrant Exchanger");
        vibrantPerBlockUse = cfg.getInt("Vibrant Exchanger Power Consumption", CATEGORY_TWEAKS_EIO, 1000, 1,
                vibrantMaxEnergy / 10, "Set the RF consumption per block for Vibrant Exchanger");

        //Thermal Expansion Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_TE, "Thermal Expansion Exchanger Tweaks");
        leadstoneMaxEnergy = cfg.getInt("Leadstone Exchanger Capacity", CATEGORY_TWEAKS_TE, 80000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for Leadstone Exchanger");
        leadstonePerBlockUse = cfg.getInt("Leadstone Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 10, 1,
                leadstoneMaxEnergy / 10, "Set the RF consumption per block for Leadstone Exchanger");
        hardenedMaxEnergy = cfg.getInt("Hardened Exchanger Capacity", CATEGORY_TWEAKS_TE, 500000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for Hardened Exchanger");
        hardenedPerBlockUse = cfg.getInt("Hardened Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 50, 1, hardenedMaxEnergy / 10,
                "Set the RF consumption per block for Hardened Exchanger");
        reinforcedMaxEnergy = cfg.getInt("Reinforced Exchanger Capacity", CATEGORY_TWEAKS_TE, 1000000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Reinforced Exchanger");
        reinforcedPerBlockUse = cfg.getInt("Reinforced Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 100, 1,
                reinforcedMaxEnergy / 10, "Set the RF consumption per block for Reinforced Exchanger");
        signalumMaxEnergy = cfg.getInt("Signalum Exchanger Capacity", CATEGORY_TWEAKS_TE, 10000000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Signalum Exchanger");
        signalumPerBlockUse = cfg.getInt("Signalum Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 500, 1,
                signalumMaxEnergy / 10, "Set the RF consumption per block for Signalum Exchanger");
        resonantMaxEnergy = cfg.getInt("Resonant Exchanger Capacity", CATEGORY_TWEAKS_TE, 20000000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Resonant Exchanger");
        resonantPerBlockUse = cfg.getInt("Resonant Exchanger Power Consumption", CATEGORY_TWEAKS_TE, 1000, 1,
                resonantMaxEnergy / 10, "Set the RF consumption per block for Resonant Exchanger");

        //Mekanism Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_MEKANISM, "Mekanism Exchanger Tweaks");
        basicMaxEnergy = cfg.getInt("Basic Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 100000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for Basic Exchanger");
        basicPerBlockUse = cfg.getInt("Basic Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 50, 1, basicMaxEnergy / 10,
                "Set the RF consumption per block for Basic Exchanger");
        advancedMaxEnergy = cfg.getInt("Advanced Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 800000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Advanced Exchanger");
        advancedPerBlockUse = cfg.getInt("Advanced Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 100,
                1, advancedMaxEnergy / 10, "Set the RF consumption per block for Advanced Exchanger");
        eliteMaxEnergy = cfg.getInt("Elite Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 5000000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for Elite Exchanger");
        elitePerBlockUse = cfg.getInt("Elite Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 250, 1,
                eliteMaxEnergy / 10, "Set the RF consumption per block for Elite Exchanger");
        ultimateMaxEnergy = cfg.getInt("Ultimate Exchanger Capacity", CATEGORY_TWEAKS_MEKANISM, 10000000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for Ultimate Exchanger");
        ultimatePerBlockUse = cfg.getInt("Ultimate Exchanger Power Consumption", CATEGORY_TWEAKS_MEKANISM, 500,
                1, ultimateMaxEnergy / 10, "Set the RF consumption per block for Ultimate Exchanger");

        //Immersive Engineering Tweaks
        cfg.addCustomCategoryComment(CATEGORY_TWEAKS_IE, "Immersive Engineering Exchanger Tweaks");
        lvMaxEnergy = cfg.getInt("LV Exchanger Capacity", CATEGORY_TWEAKS_IE, 100000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for LV Exchanger");
        lvPerBlockUse = cfg.getInt("LV Exchanger Power Consumption", CATEGORY_TWEAKS_IE, 100, 1, lvMaxEnergy / 10,
                "Set the RF consumption per block for LV Exchanger");
        mvMaxEnergy = cfg.getInt("MV Exchanger Capacity", CATEGORY_TWEAKS_IE, 500000, 1000,
                Integer.MAX_VALUE, "Set the RF capacity for MV Exchanger");
        mvPerBlockUse = cfg.getInt("MV Exchanger Power Consumption", CATEGORY_TWEAKS_IE, 250,
                1, mvMaxEnergy / 10, "Set the RF consumption per block for MV Exchanger");
        hvMaxEnergy = cfg.getInt("HV Exchanger Capacity", CATEGORY_TWEAKS_IE, 2500000, 1000, Integer.MAX_VALUE,
                "Set the RF capacity for HV Exchanger");
        hvPerBlockUse = cfg.getInt("HV Exchanger Power Consumption", CATEGORY_TWEAKS_IE, 500, 1,
                hvMaxEnergy / 10, "Set the RF consumption per block for HV Exchanger");

        //Misc
        blocksWhitelist = cfg.getStringList("Exchanger Blocks Whitelist", CATEGORY_MISC, new String[0],
                "Certain blocks might be blacklisted by Exchangers if they're Tile Entities.\n"
                        + "Put a list of block registry names that you wish to be whitelisted from Exchangers.\n"
                        + "(e.g. thermalexpansion:cell)\n");
        holdingEnchantment = cfg.getBoolean("Holding Enchantment", CATEGORY_MISC, true,
                "If true, allows the Holding Enchantment from CoFHCore to be used in Powered Exchangers\n"
                        + "Calculation formula: Base Energy + (Base Energy * Enchantment Level / 2)\n");
        unbreakingPoweredExchangers = cfg.getBoolean("Unbreaking Enchantment Affects Powered Exchangers", CATEGORY_MISC, true,
                "If true, allows Unbreaking Enchantment to affect Powered Exchangers");
        useOreDictCircuits = cfg.getBoolean("Use OreDict Circuits", CATEGORY_MISC, false,
                "If true, allows Circuits in Mekanism Exchanger recipes to use OreDict");
        doExchangersSilkTouch = cfg.getBoolean("Exchangers Silk Touch", CATEGORY_MISC, true,
                "If true, enables Silk Touch (gets the blocks itself rather than drops) in all Exchangers");

    }

}