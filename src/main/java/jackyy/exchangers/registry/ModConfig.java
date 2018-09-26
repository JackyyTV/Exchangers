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
        public int woodenMaxDmg = 256;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Wooden Exchanger")
        public int woodenMaxHarvestLevel = 0;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Wooden Exchanger")
        public int woodenMaxRange = 0;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Stone Exchanger")
        public int stoneMaxDmg = 384;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Stone Exchanger")
        public int stoneMaxHarvestLevel = 1;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Stone Exchanger")
        public int stoneMaxRange = 1;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Golden Exchanger")
        public int goldenMaxDmg = 512;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Golden Exchanger")
        public int goldenMaxHarvestLevel = 1;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Golden Exchanger")
        public int goldenMaxRange = 2;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Iron Exchanger")
        public int ironMaxDmg = 1024;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Iron Exchanger")
        public int ironMaxHarvestLevel = 2;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Iron Exchanger")
        public int ironMaxRange = 3;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Diamond Exchanger")
        public int diamondMaxDmg = 4096;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Diamond Exchanger")
        public int diamondMaxHarvestLevel = 3;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Diamond Exchanger")
        public int diamondMaxRange = 4;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Emerald Exchanger")
        public int emeraldMaxDmg = 8192;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Emerald Exchanger")
        public int emeraldMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Emerald Exchanger")
        public int emeraldMaxRange = 5;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for Obsidian Exchanger")
        public int obsidianMaxDmg = 16384;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Obsidian Exchanger")
        public int obsidianMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Obsidian Exchanger")
        public int obsidianMaxRange = 6;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for End Exchanger")
        public int endMaxDmg = 32768;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for End Exchanger")
        public int endMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for End Exchanger")
        public int endMaxRange = 7;
    }

    public static class EnderIOTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Conductive Iron Exchanger")
        public int conductiveMaxEnergy = 80000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the Rf consumption per block for Conductive Iron Exchanger")
        public int conductivePerBlockUse = 10;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Conductive Iron Exchanger")
        public int conductiveMaxHarvestLevel = 1;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Conductive Iron Exchanger")
        public int conductiveMaxRange = 1;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Pulsating Iron Exchanger")
        public int pulsatingMaxEnergy = 400000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Pulsating Iron Exchanger")
        public int pulsatingPerBlockUse = 50;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Pulsating Iron Exchanger")
        public int pulsatingMaxHarvestLevel = 2;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Pulsating Iron Exchanger")
        public int pulsatingMaxRange = 2;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Electrical Steel Exchanger")
        public int electricalSteelMaxEnergy = 800000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Electrical Steel Exchanger")
        public int electricalSteelPerBlockUse = 100;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Electrical Steel Exchanger")
        public int electricalSteelMaxHarvestLevel = 3;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Electrical Steel Exchanger")
        public int electricalSteelMaxRange = 4;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Energetic Exchanger")
        public int energeticMaxEnergy = 5000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Energetic Exchanger")
        public int energeticPerBlockUse = 250;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Energetic Exchanger")
        public int energeticMaxHarvestLevel = 3;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Energetic Exchanger")
        public int energeticMaxRange = 5;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Dark Steel Exchanger")
        public int darkSteelMaxEnergy = 10000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Dark Steel Exchanger")
        public int darkSteelPerBlockUse = 500;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Dark Steel Exchanger")
        public int darkSteelMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Dark Steel Exchanger")
        public int darkSteelMaxRange = 6;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Vibrant Exchanger")
        public int vibrantMaxEnergy = 20000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Vibrant Exchanger")
        public int vibrantPerBlockUse = 1000;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Vibrant Exchanger")
        public int vibrantMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Vibrant Exchanger")
        public int vibrantMaxRange = 7;
    }

    public static class ThermalExpansionTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Leadstone Exchanger")
        public int leadstoneMaxEnergy = 80000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Leadstone Exchanger")
        public int leadstonePerBlockUse = 10;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Leadstone Exchanger")
        public int leadstoneMaxHarvestLevel = 1;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Leadstone Exchanger")
        public int leadstoneMaxRange = 1;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Hardened Exchanger")
        public int hardenedMaxEnergy = 500000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Hardened Exchanger")
        public int hardenedPerBlockUse = 50;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Hardened Exchanger")
        public int hardenedMaxHarvestLevel = 2;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Hardened Exchanger")
        public int hardenedMaxRange = 3;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Reinforced Exchanger")
        public int reinforcedMaxEnergy = 1000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Reinforced Exchanger")
        public int reinforcedPerBlockUse = 100;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Reinforced Exchanger")
        public int reinforcedMaxHarvestLevel = 3;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Reinforced Exchanger")
        public int reinforcedMaxRange = 5;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Signalum Exchanger")
        public int signalumMaxEnergy = 10000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Signalum Exchanger")
        public int signalumPerBlockUse = 500;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Signalum Exchanger")
        public int signalumMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Signalum Exchanger")
        public int signalumMaxRange = 6;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Resonant Exchanger")
        public int resonantMaxEnergy = 20000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Resonant Exchanger")
        public int resonantPerBlockUse = 1000;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Resonant Exchanger")
        public int resonantMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Resonant Exchanger")
        public int resonantMaxRange = 7;
    }

    public static class MekanismTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Basic Exchanger")
        public int basicMaxEnergy = 100000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Basic Exchanger")
        public int basicPerBlockUse = 50;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Basic Exchanger")
        public int basicMaxHarvestLevel = 1;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Basic Exchanger")
        public int basicMaxRange = 3;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Advanced Exchanger")
        public int advancedMaxEnergy = 800000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Advanced Exchanger")
        public int advancedPerBlockUse = 100;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Advanced Exchanger")
        public int advancedMaxHarvestLevel = 2;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Advanced Exchanger")
        public int advancedMaxRange = 5;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Elite Exchanger")
        public int eliteMaxEnergy = 5000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Elite Exchanger")
        public int elitePerBlockUse = 250;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Elite Exchanger")
        public int eliteMaxHarvestLevel = 3;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Elite Exchanger")
        public int eliteMaxRange = 6;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for Ultimate Exchanger")
        public int ultimateMaxEnergy = 10000000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for Ultimate Exchanger")
        public int ultimatePerBlockUse = 500;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for Ultimate Exchanger")
        public int ultimateMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for Ultimate Exchanger")
        public int ultimateMaxRange = 7;
    }

    public static class ImmersiveEngineeringTweaks {
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for LV Exchanger")
        public int lvMaxEnergy = 100000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for LV Exchanger")
        public int lvPerBlockUse = 100;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for LV Exchanger")
        public int lvMaxHarvestLevel = 2;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for LV Exchanger")
        public int lvMaxRange = 3;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for MV Exchanger")
        public int mvMaxEnergy = 500000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for MV Exchanger")
        public int mvPerBlockUse = 250;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for MV Exchanger")
        public int mvMaxHarvestLevel = 3;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for MV Exchanger")
        public int mvMaxRange = 5;
        @Config.RangeInt(min = 1000)
        @Config.Comment("Set the RF capacity for HV Exchanger")
        public int hvMaxEnergy = 2500000;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the RF consumption per block for HV Exchanger")
        public int hvPerBlockUse = 500;
        @Config.RangeInt(min = 0)
        @Config.Comment("Set the max harvest level for HV Exchanger")
        public int hvMaxHarvestLevel = 4;
        @Config.RangeInt(min = 0, max = 12)
        @Config.Comment("Set the max range for HV Exchanger")
        public int hvMaxRange = 7;
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
        public String[] blocksWhitelist = new String[] {
                "tconstruct:seared"
        };
        @Config.Comment({
                "Put a list of block registry names that you wish to be blacklisted from Exchangers.",
                "Note: Blacklisting a block will prevent it from being selected or being exchanged.",
                "(e.g. minecraft:grass)"
        })
        public String[] blocksBlacklist = new String[0];
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