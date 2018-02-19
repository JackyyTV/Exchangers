package jackyy.exchangers.registry;

import jackyy.exchangers.Exchangers;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Exchangers.MODID, name = "Exchangers", category = Exchangers.MODID)
public class ModConfig {

    public static Modules modules = new Modules();
    public static VanillaTweaks vanillaTweaks = new VanillaTweaks();
    public static EnderIOTweaks enderIOTweaks = new EnderIOTweaks();
    public static ThermalExpansionTweaks thermalExpansionTweaks = new ThermalExpansionTweaks();
    public static MekanismTweaks mekanismTweaks = new MekanismTweaks();
    public static ImmersiveEngineeringTweaks immersiveEngineeringTweaks = new ImmersiveEngineeringTweaks();
    public static RecipeTweaks recipeTweaks = new RecipeTweaks();
    public static Misc misc = new Misc();

    public static class Modules {
        @Config.Comment("If true, enables Vanilla-based exchangers.")
        public boolean vanillaModule = true;
        @Config.Comment("If true, enables Ender IO-based exchangers (Requires Ender IO to be installed).")
        public boolean enderIOModule = true;
        @Config.Comment("If true, enables Thermal Expansion-based exchangers (Requires Thermal Expansion to be installed).")
        public boolean thermalExpansionModule = true;
        @Config.Comment("If true, enables Mekanism-based exchangers (Requires Mekanism to be installed).")
        public boolean mekanismModule = true;
        @Config.Comment("If true, enables Immersive Engineering-based exchangers (Requires Immersive Engineering to be installed).")
        public boolean immersiveEngineeringModule = true;
        @Config.Comment("If true, enables special exchangers (e.g. Tuberous Exchanger).")
        public boolean specialModule = true;
    }

    public static class VanillaTweaks {
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Wooden Exchanger")
        public int woodMaxDmg = 256;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Stone Exchanger")
        public int stoneMaxDmg = 384;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Golden Exchanger")
        public int goldMaxDmg = 512;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Iron Exchanger")
        public int ironMaxDmg = 1024;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Diamond Exchanger")
        public int diaMaxDmg = 4096;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Emerald Exchanger")
        public int emeMaxDmg = 8192;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Obsidian Exchanger")
        public int obsMaxDmg = 16384;
    }

    public static class EnderIOTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Conductive Iron Exchanger")
        public final int conductiveMaxEnergy = 80000;
        @Config.RangeInt(min = 1, max = conductiveMaxEnergy / 10)
        @Config.Comment("Set the Rf consumption per block for Conductive Iron Exchanger")
        public final int conductivePerBlockUse = 10;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Pulsating Iron Exchanger")
        public final int pulsatingMaxEnergy = 400000;
        @Config.RangeInt(min = 1, max = pulsatingMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Pulsating Iron Exchanger")
        public final int pulsatingPerBlockUse = 50;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Electrical Steel Exchanger")
        public final int electricalSteelMaxEnergy = 800000;
        @Config.RangeInt(min = 1, max = electricalSteelMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Electrical Steel Exchanger")
        public final int electricalSteelPerBlockUse = 100;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Energetic Exchanger")
        public final int energeticMaxEnergy = 5000000;
        @Config.RangeInt(min = 1, max = energeticMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Energetic Exchanger")
        public final int energeticPerBlockUse = 250;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Dark Steel Exchanger")
        public final int darkSteelMaxEnergy = 10000000;
        @Config.RangeInt(min = 1, max = darkSteelMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Dark Steel Exchanger")
        public final int darkSteelPerBlockUse = 500;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Vibrant Exchanger")
        public final int vibrantMaxEnergy = 20000000;
        @Config.RangeInt(min = 1, max = vibrantMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Vibrant Exchanger")
        public final int vibrantPerBlockUse = 1000;
    }

    public static class ThermalExpansionTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Leadstone Exchanger")
        public final int leadstoneMaxEnergy = 80000;
        @Config.RangeInt(min = 1, max = leadstoneMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Leadstone Exchanger")
        public final int leadstonePerBlockUse = 10;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Hardened Exchanger")
        public final int hardenedMaxEnergy = 500000;
        @Config.RangeInt(min = 1, max = hardenedMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Hardened Exchanger")
        public final int hardenedPerBlockUse = 50;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Reinforced Exchanger")
        public final int reinforcedMaxEnergy = 1000000;
        @Config.RangeInt(min = 1, max = reinforcedMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Reinforced Exchanger")
        public final int reinforcedPerBlockUse = 100;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Signalum Exchanger")
        public final int signalumMaxEnergy = 10000000;
        @Config.RangeInt(min = 1, max = signalumMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Signalum Exchanger")
        public final int signalumPerBlockUse = 500;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Resonant Exchanger")
        public final int resonantMaxEnergy = 20000000;
        @Config.RangeInt(min = 1, max = resonantMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Resonant Exchanger")
        public final int resonantPerBlockUse = 1000;
    }

    public static class MekanismTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Basic Exchanger")
        public final int basicMaxEnergy = 100000;
        @Config.RangeInt(min = 1, max = basicMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Basic Exchanger")
        public final int basicPerBlockUse = 50;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Advanced Exchanger")
        public final int advancedMaxEnergy = 800000;
        @Config.RangeInt(min = 1, max = advancedMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Advanced Exchanger")
        public final int advancedPerBlockUse = 100;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Elite Exchanger")
        public final int eliteMaxEnergy = 5000000;
        @Config.RangeInt(min = 1, max = eliteMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Elite Exchanger")
        public final int elitePerBlockUse = 250;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Ultimate Exchanger")
        public final int ultimateMaxEnergy = 10000000;
        @Config.RangeInt(min = 1, max = ultimateMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for Ultimate Exchanger")
        public final int ultimatePerBlockUse = 500;
    }

    public static class ImmersiveEngineeringTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for LV Exchanger")
        public final int lvMaxEnergy = 100000;
        @Config.RangeInt(min = 1, max = lvMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for LV Exchanger")
        public final int lvPerBlockUse = 100;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for MV Exchanger")
        public final int mvMaxEnergy = 500000;
        @Config.RangeInt(min = 1, max = mvMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for MV Exchanger")
        public final int mvPerBlockUse = 250;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for HV Exchanger")
        public final int hvMaxEnergy = 2500000;
        @Config.RangeInt(min = 1, max = hvMaxEnergy / 10)
        @Config.Comment("Set the RF consumption per block for HV Exchanger")
        public final int hvPerBlockUse = 500;
    }

    public static class RecipeTweaks {
        @Config.Comment({
                "Set the recipes type for Vanilla-based exchangers:",
                "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                "'normal'   Normal recipes, progressive, moderate recipe costs.",
                "'hard'     Hard recipes, progressive, expensive recipe costs."
        })
        public String vanillaRecipesType = "normal";
        @Config.Comment({
                "Set the recipes type for Ender IO-based exchangers:",
                "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                "'normal'   Normal recipes, progressive, moderate recipe costs.",
                "'hard'     Hard recipes, progressive, expensive recipe costs."
        })
        public String enderIORecipesType = "normal";
        @Config.Comment({
                "Set the recipes type for Thermal Expansion-based exchangers:",
                "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                "'normal'   Normal recipes, progressive, moderate recipe costs.",
                "'hard'     Hard recipes, progressive, expensive recipe costs."
        })
        public String thermalExpansionRecipesType = "normal";
        @Config.Comment({
                "Set the recipes type for Mekanism-based exchangers:",
                "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                "'normal'   Normal recipes, progressive, moderate recipe costs.",
                "'hard'     Hard recipes, progressive, expensive recipe costs."
        })
        public String mekanismRecipesType = "normal";
        @Config.Comment({
                "Set the recipes type for Immersive Engineering-based exchangers:",
                "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                "'normal'   Normal recipes, progressive, moderate recipe costs.",
                "'hard'     Hard recipes, progressive, expensive recipe costs."
        })
        public String immersiveEngineeringRecipesType = "normal";
    }

    public static class Misc {
        @Config.Comment({
                "Certain blocks might be blacklisted by Exchangers if they're Tile Entities.",
                "Put a list of block registry names that you wish to be whitelisted from Exchangers.",
                "(e.g. thermalexpansion:cell)"
        })
        public String[] blocksWhitelist = new String[0];
        @Config.Comment({
                "If true, allows the Holding Enchantment from CoFHCore to be used in Powered Exchangers",
                "Calculation formula: Base Energy + (Base Energy * Enchantment Level / 2)"
        })
        public boolean holdingEnchantment = true;
        @Config.Comment("If true, allows Unbreaking Enchantment to affect Powered Exchangers")
        public boolean unbreakingPoweredExchangers = true;
        @Config.Comment("If true, allows Circuits in Mekanism Exchanger recipes to use OreDict")
        public boolean useOreDictCircuits = false;
        @Config.Comment("If true, enables Silk Touch (gets the blocks itself rather than drops) in all Exchangers")
        public boolean doExchangersSilkTouch = true;
    }

    @Mod.EventBusSubscriber
    public static class ConfigHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Exchangers.MODID)) {
                ConfigManager.sync(Exchangers.MODID, Config.Type.INSTANCE);
            }
        }
    }

}