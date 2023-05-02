package jackyy.exchangers.registry;

import jackyy.exchangers.util.DefaultValues;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;

public class ModConfigs {

    public static class CommonConfig {

        public final ForgeConfigSpec.BooleanValue vanillaModule;
        public final ForgeConfigSpec.BooleanValue enderIOModule;
        public final ForgeConfigSpec.BooleanValue enderIOEndergyModule;
        public final ForgeConfigSpec.BooleanValue thermalModule;
        public final ForgeConfigSpec.BooleanValue mekanismModule;
        public final ForgeConfigSpec.BooleanValue immersiveEngineeringModule;
        public final ForgeConfigSpec.BooleanValue specialModule;

        public final ForgeConfigSpec.IntValue woodenMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue woodenMaxRange;
        public final ForgeConfigSpec.IntValue stoneMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue stoneMaxRange;
        public final ForgeConfigSpec.IntValue goldenMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue goldenMaxRange;
        public final ForgeConfigSpec.IntValue ironMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue ironMaxRange;
        public final ForgeConfigSpec.IntValue diamondMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue diamondMaxRange;
        public final ForgeConfigSpec.IntValue emeraldMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue emeraldMaxRange;
        public final ForgeConfigSpec.IntValue obsidianMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue obsidianMaxRange;
        public final ForgeConfigSpec.IntValue endMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue endMaxRange;

        public final ForgeConfigSpec.IntValue conductiveMaxEnergy;
        public final ForgeConfigSpec.IntValue conductivePerBlockUse;
        public final ForgeConfigSpec.IntValue conductiveMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue conductiveMaxRange;
        public final ForgeConfigSpec.IntValue pulsatingMaxEnergy;
        public final ForgeConfigSpec.IntValue pulsatingPerBlockUse;
        public final ForgeConfigSpec.IntValue pulsatingMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue pulsatingMaxRange;
        public final ForgeConfigSpec.IntValue electricalSteelMaxEnergy;
        public final ForgeConfigSpec.IntValue electricalSteelPerBlockUse;
        public final ForgeConfigSpec.IntValue electricalSteelMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue electricalSteelMaxRange;
        public final ForgeConfigSpec.IntValue energeticMaxEnergy;
        public final ForgeConfigSpec.IntValue energeticPerBlockUse;
        public final ForgeConfigSpec.IntValue energeticMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue energeticMaxRange;
        public final ForgeConfigSpec.IntValue darkSteelMaxEnergy;
        public final ForgeConfigSpec.IntValue darkSteelPerBlockUse;
        public final ForgeConfigSpec.IntValue darkSteelMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue darkSteelMaxRange;
        public final ForgeConfigSpec.IntValue vibrantMaxEnergy;
        public final ForgeConfigSpec.IntValue vibrantPerBlockUse;
        public final ForgeConfigSpec.IntValue vibrantMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue vibrantMaxRange;
        public final ForgeConfigSpec.IntValue endSteelMaxEnergy;
        public final ForgeConfigSpec.IntValue endSteelPerBlockUse;
        public final ForgeConfigSpec.IntValue endSteelMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue endSteelMaxRange;

        public final ForgeConfigSpec.IntValue crudeSteelMaxEnergy;
        public final ForgeConfigSpec.IntValue crudeSteelPerBlockUse;
        public final ForgeConfigSpec.IntValue crudeSteelMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue crudeSteelMaxRange;
        public final ForgeConfigSpec.IntValue energeticSilverMaxEnergy;
        public final ForgeConfigSpec.IntValue energeticSilverPerBlockUse;
        public final ForgeConfigSpec.IntValue energeticSilverMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue energeticSilverMaxRange;
        public final ForgeConfigSpec.IntValue vividMaxEnergy;
        public final ForgeConfigSpec.IntValue vividPerBlockUse;
        public final ForgeConfigSpec.IntValue vividMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue vividMaxRange;
        public final ForgeConfigSpec.IntValue crystallineMaxEnergy;
        public final ForgeConfigSpec.IntValue crystallinePerBlockUse;
        public final ForgeConfigSpec.IntValue crystallineMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue crystallineMaxRange;
        public final ForgeConfigSpec.IntValue melodicMaxEnergy;
        public final ForgeConfigSpec.IntValue melodicPerBlockUse;
        public final ForgeConfigSpec.IntValue melodicMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue melodicMaxRange;
        public final ForgeConfigSpec.IntValue stellarMaxEnergy;
        public final ForgeConfigSpec.IntValue stellarPerBlockUse;
        public final ForgeConfigSpec.IntValue stellarMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue stellarMaxRange;

        public final ForgeConfigSpec.IntValue leadstoneMaxEnergy;
        public final ForgeConfigSpec.IntValue leadstonePerBlockUse;
        public final ForgeConfigSpec.IntValue leadstoneMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue leadstoneMaxRange;
        public final ForgeConfigSpec.IntValue hardenedMaxEnergy;
        public final ForgeConfigSpec.IntValue hardenedPerBlockUse;
        public final ForgeConfigSpec.IntValue hardenedMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue hardenedMaxRange;
        public final ForgeConfigSpec.IntValue reinforcedMaxEnergy;
        public final ForgeConfigSpec.IntValue reinforcedPerBlockUse;
        public final ForgeConfigSpec.IntValue reinforcedMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue reinforcedMaxRange;
        public final ForgeConfigSpec.IntValue signalumMaxEnergy;
        public final ForgeConfigSpec.IntValue signalumPerBlockUse;
        public final ForgeConfigSpec.IntValue signalumMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue signalumMaxRange;
        public final ForgeConfigSpec.IntValue resonantMaxEnergy;
        public final ForgeConfigSpec.IntValue resonantPerBlockUse;
        public final ForgeConfigSpec.IntValue resonantMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue resonantMaxRange;

        public final ForgeConfigSpec.IntValue basicMaxEnergy;
        public final ForgeConfigSpec.IntValue basicPerBlockUse;
        public final ForgeConfigSpec.IntValue basicMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue basicMaxRange;
        public final ForgeConfigSpec.IntValue advancedMaxEnergy;
        public final ForgeConfigSpec.IntValue advancedPerBlockUse;
        public final ForgeConfigSpec.IntValue advancedMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue advancedMaxRange;
        public final ForgeConfigSpec.IntValue eliteMaxEnergy;
        public final ForgeConfigSpec.IntValue elitePerBlockUse;
        public final ForgeConfigSpec.IntValue eliteMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue eliteMaxRange;
        public final ForgeConfigSpec.IntValue ultimateMaxEnergy;
        public final ForgeConfigSpec.IntValue ultimatePerBlockUse;
        public final ForgeConfigSpec.IntValue ultimateMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue ultimateMaxRange;

        public final ForgeConfigSpec.IntValue lvMaxEnergy;
        public final ForgeConfigSpec.IntValue lvPerBlockUse;
        public final ForgeConfigSpec.IntValue lvMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue lvMaxRange;
        public final ForgeConfigSpec.IntValue mvMaxEnergy;
        public final ForgeConfigSpec.IntValue mvPerBlockUse;
        public final ForgeConfigSpec.IntValue mvMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue mvMaxRange;
        public final ForgeConfigSpec.IntValue hvMaxEnergy;
        public final ForgeConfigSpec.IntValue hvPerBlockUse;
        public final ForgeConfigSpec.IntValue hvMaxHarvestLevel;
        public final ForgeConfigSpec.IntValue hvMaxRange;

        public final ForgeConfigSpec.ConfigValue<? extends String> vanillaRecipesType;
        public final ForgeConfigSpec.ConfigValue<? extends String> enderIORecipesType;
        public final ForgeConfigSpec.ConfigValue<? extends String> enderIOEndergyRecipesType;
        public final ForgeConfigSpec.ConfigValue<? extends String> thermalRecipesType;
        public final ForgeConfigSpec.ConfigValue<? extends String> mekanismRecipesType;
        public final ForgeConfigSpec.ConfigValue<? extends String> immersiveEngineeringRecipesType;

        public final ForgeConfigSpec.ConfigValue<? extends String> blocksWhitelist;
        public final ForgeConfigSpec.ConfigValue<? extends String> blocksBlacklist;
        public final ForgeConfigSpec.BooleanValue holdingEnchantment;
        public final ForgeConfigSpec.BooleanValue unbreakingPoweredExchangers;
        public final ForgeConfigSpec.BooleanValue doExchangersSilkTouch;
        public final ForgeConfigSpec.ConfigValue<? extends String> energyUnit;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Exchangers Config")
                    .push("modules");
            vanillaModule = builder
                    .comment("If true, enables Vanilla-based exchangers.")
                    .define("vanillaModule", DefaultValues.vanillaModule);
            enderIOModule = builder
                    .comment("If true, enables Ender IO-based exchangers (Requires Ender IO to be installed).")
                    .define("enderIOModule", DefaultValues.enderIOModule);
            enderIOEndergyModule = builder
                    .comment("If true, enables Ender IO Endergy-based exchangers (Requires Ender IO Endergy to be installed).")
                    .define("enderIOEndergyModule", DefaultValues.enderIOEndergyModule);
            thermalModule = builder
                    .comment("If true, enables Thermal Series-based exchangers (Requires Thermal Foundation and Thermal Innovation to be installed).")
                    .define("thermalModule", DefaultValues.thermalModule);
            mekanismModule = builder
                    .comment("If true, enables Mekanism-based exchangers (Requires Mekanism to be installed).")
                    .define("mekanismModule", DefaultValues.mekanismModule);
            immersiveEngineeringModule = builder
                    .comment("If true, enables Immersive Engineering-based exchangers (Requires Immersive Engineering to be installed).")
                    .define("immersiveEngineeringModule", DefaultValues.immersiveEngineeringModule);
            specialModule = builder
                    .comment("If true, enables special exchangers (e.g. Tuberous Exchanger).")
                    .define("specialModule", DefaultValues.specialModule);
            builder.pop();

            builder.push("vanilla_tweaks");

            woodenMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Wooden Exchanger")
                    .defineInRange("woodenExchangerMaxHarvestLevel", DefaultValues.woodenMaxHarvestLevel, 0, Integer.MAX_VALUE);

            woodenMaxRange = builder
                    .comment("Set the max range for Wooden Exchanger")
                    .defineInRange("woodenExchangerMaxRange", DefaultValues.woodenMaxRange, 0, 12);


            stoneMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Stone Exchanger")
                    .defineInRange("stoneExchangerMaxHarvestLevel", DefaultValues.stoneMaxHarvestLevel, 0, Integer.MAX_VALUE);

            stoneMaxRange = builder
                    .comment("Set the max range for Stone Exchanger")
                    .defineInRange("stoneExchangerMaxRange", DefaultValues.stoneMaxRange, 0, 12);


            goldenMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Golden Exchanger")
                    .defineInRange("goldenExchangerMaxHarvestLevel", DefaultValues.goldenMaxHarvestLevel, 0, Integer.MAX_VALUE);
            goldenMaxRange = builder
                    .comment("Set the max range for Golden Exchanger")
                    .defineInRange("goldenExchangerMaxRange", DefaultValues.goldenMaxRange, 0, 12);

            ironMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Iron Exchanger")
                    .defineInRange("ironExchangerMaxHarvestLevel", DefaultValues.ironMaxHarvestLevel, 0, Integer.MAX_VALUE);
            ironMaxRange = builder
                    .comment("Set the max range for Iron Exchanger")
                    .defineInRange("ironExchangerMaxRange", DefaultValues.ironMaxRange, 0, 12);

            diamondMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Diamond Exchanger")
                    .defineInRange("diamondExchangerMaxHarvestLevel", DefaultValues.diamondMaxHarvestLevel, 0, Integer.MAX_VALUE);
            diamondMaxRange = builder
                    .comment("Set the max range for Diamond Exchanger")
                    .defineInRange("diamondExchangerMaxRange", DefaultValues.diamondMaxRange, 0, 12);

            emeraldMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Emerald Exchanger")
                    .defineInRange("emeraldExchangerMaxHarvestLevel", DefaultValues.emeraldMaxHarvestLevel, 0, Integer.MAX_VALUE);
            emeraldMaxRange = builder
                    .comment("Set the max range for Emerald Exchanger")
                    .defineInRange("emeraldExchangerMaxRange", DefaultValues.emeraldMaxRange, 0, 12);

            obsidianMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Obsidian Exchanger")
                    .defineInRange("obsidianExchangerMaxHarvestLevel", DefaultValues.obsidianMaxHarvestLevel, 0, Integer.MAX_VALUE);
            obsidianMaxRange = builder
                    .comment("Set the max range for Obsidian Exchanger")
                    .defineInRange("obsidianExchangerMaxRange", DefaultValues.obsidianMaxRange, 0, 12);

            endMaxHarvestLevel = builder
                    .comment("Set the max harvest level for End Exchanger")
                    .defineInRange("endExchangerMaxHarvestLevel", DefaultValues.endMaxHarvestLevel, 0, Integer.MAX_VALUE);
            endMaxRange = builder
                    .comment("Set the max range for End Exchanger")
                    .defineInRange("endExchangerMaxRange", DefaultValues.endMaxRange, 0, 12);
            builder.pop();

            builder.push("ender_io_tweaks");
            conductiveMaxEnergy = builder
                    .comment("Set the energy capacity for Conductive Iron Exchanger")
                    .defineInRange("conductiveIronExchangerMaxEnergy", DefaultValues.conductiveMaxEnergy, 1000, Integer.MAX_VALUE);
            conductivePerBlockUse = builder
                    .comment("Set the energy consumption per block for Conductive Iron Exchanger")
                    .defineInRange("conductiveIronExchangerPerBlockUse", DefaultValues.conductivePerBlockUse, 1, Integer.MAX_VALUE);
            conductiveMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Conductive Iron Exchanger")
                    .defineInRange("conductiveIronExchangerMaxHarvestLevel", DefaultValues.conductiveMaxHarvestLevel, 0, Integer.MAX_VALUE);
            conductiveMaxRange = builder
                    .comment("Set the max range for Conductive Iron Exchanger")
                    .defineInRange("conductiveIronExchangerMaxRange", DefaultValues.conductiveMaxRange, 0, 12);

            pulsatingMaxEnergy = builder
                    .comment("Set the energy capacity for Pulsating Iron Exchanger")
                    .defineInRange("pulsatingIronExchangerMaxEnergy", DefaultValues.pulsatingMaxEnergy, 1000, Integer.MAX_VALUE);
            pulsatingPerBlockUse = builder
                    .comment("Set the energy consumption per block for Pulsating Iron Exchanger")
                    .defineInRange("pulsatingIronExchangerPerBlockUse", DefaultValues.pulsatingPerBlockUse, 1, Integer.MAX_VALUE);
            pulsatingMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Pulsating Iron Exchanger")
                    .defineInRange("pulsatingIronExchangerMaxHarvestLevel", DefaultValues.pulsatingMaxHarvestLevel, 0, Integer.MAX_VALUE);
            pulsatingMaxRange = builder
                    .comment("Set the max range for Pulsating Iron Exchanger")
                    .defineInRange("pulsatingIronExchangerMaxRange", DefaultValues.pulsatingMaxRange, 0, 12);

            electricalSteelMaxEnergy = builder
                    .comment("Set the energy capacity for Electrical Steel Exchanger")
                    .defineInRange("electricalSteelExchangerMaxEnergy", DefaultValues.electricalSteelMaxEnergy, 1000, Integer.MAX_VALUE);
            electricalSteelPerBlockUse = builder
                    .comment("Set the energy consumption per block for Electrical Steel Exchanger")
                    .defineInRange("electricalSteelExchangerPerBlockUse", DefaultValues.electricalSteelPerBlockUse, 1, Integer.MAX_VALUE);
            electricalSteelMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Electrical Steel Exchanger")
                    .defineInRange("electricalSteelExchangerMaxHarvestLevel", DefaultValues.electricalSteelMaxHarvestLevel, 0, Integer.MAX_VALUE);
            electricalSteelMaxRange = builder
                    .comment("Set the max range for Electrical Steel Exchanger")
                    .defineInRange("electricalSteelExchangerMaxRange", DefaultValues.electricalSteelMaxRange, 0, 12);

            energeticMaxEnergy = builder
                    .comment("Set the energy capacity for Energetic Exchanger")
                    .defineInRange("energeticExchangerMaxEnergy", DefaultValues.energeticMaxEnergy, 1000, Integer.MAX_VALUE);
            energeticPerBlockUse = builder
                    .comment("Set the energy consumption per block for Energetic Exchanger")
                    .defineInRange("energeticExchangerPerBlockUse", DefaultValues.energeticPerBlockUse, 1, Integer.MAX_VALUE);
            energeticMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Energetic Exchanger")
                    .defineInRange("energeticExchangerMaxHarvestLevel", DefaultValues.energeticMaxHarvestLevel, 0, Integer.MAX_VALUE);
            energeticMaxRange = builder
                    .comment("Set the max range for Energetic Exchanger")
                    .defineInRange("energeticExchangerMaxRange", DefaultValues.energeticMaxRange, 0, 12);

            darkSteelMaxEnergy = builder
                    .comment("Set the energy capacity for Dark Steel Exchanger")
                    .defineInRange("darkSteelExchangerMaxEnergy", DefaultValues.darkSteelMaxEnergy, 1000, Integer.MAX_VALUE);
            darkSteelPerBlockUse = builder
                    .comment("Set the energy consumption per block for Dark Steel Exchanger")
                    .defineInRange("darkSteelExchangerPerBlockUse", DefaultValues.darkSteelPerBlockUse, 1, Integer.MAX_VALUE);
            darkSteelMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Dark Steel Exchanger")
                    .defineInRange("darkSteelExchangerMaxHarvestLevel", DefaultValues.darkSteelMaxHarvestLevel, 0, Integer.MAX_VALUE);
            darkSteelMaxRange = builder
                    .comment("Set the max range for Dark Steel Exchanger")
                    .defineInRange("darkSteelExchangerMaxRange", DefaultValues.darkSteelMaxRange, 0, 12);

            vibrantMaxEnergy = builder
                    .comment("Set the energy capacity for Vibrant Exchanger")
                    .defineInRange("vibrantExchangerMaxEnergy", DefaultValues.vibrantMaxEnergy, 1000, Integer.MAX_VALUE);
            vibrantPerBlockUse = builder
                    .comment("Set the energy consumption per block for Vibrant Exchanger")
                    .defineInRange("vibrantExchangerPerBlockUse", DefaultValues.vibrantPerBlockUse, 1, Integer.MAX_VALUE);
            vibrantMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Vibrant Exchanger")
                    .defineInRange("vibrantExchangerMaxHarvestLevel", DefaultValues.vibrantMaxHarvestLevel, 0, Integer.MAX_VALUE);
            vibrantMaxRange = builder
                    .comment("Set the max range for Vibrant Exchanger")
                    .defineInRange("vibrantExchangerMaxRange", DefaultValues.vibrantMaxRange, 0, 12);

            endSteelMaxEnergy = builder
                    .comment("Set the energy capacity for End Steel Exchanger")
                    .defineInRange("endSteelExchangerMaxEnergy", DefaultValues.endSteelMaxEnergy, 1000, Integer.MAX_VALUE);
            endSteelPerBlockUse = builder
                    .comment("Set the energy consumption per block for End Steel Exchanger")
                    .defineInRange("endSteelExchangerPerBlockUse", DefaultValues.endSteelPerBlockUse, 1, Integer.MAX_VALUE);
            endSteelMaxHarvestLevel = builder
                    .comment("Set the max harvest level for End Steel Exchanger")
                    .defineInRange("endSteelExchangerMaxHarvestLevel", DefaultValues.endSteelMaxHarvestLevel, 0, Integer.MAX_VALUE);
            endSteelMaxRange = builder
                    .comment("Set the max range for End Steel Exchanger")
                    .defineInRange("endSteelExchangerMaxRange", DefaultValues.endSteelMaxRange, 0, 12);
            builder.pop();

            builder.push("ender_io_endergy_tweaks");
            crudeSteelMaxEnergy = builder
                    .comment("Set the energy capacity for Crude Steel Exchanger")
                    .defineInRange("crudeSteelExchangerMaxEnergy", DefaultValues.crudeSteelMaxEnergy, 1000, Integer.MAX_VALUE);
            crudeSteelPerBlockUse = builder
                    .comment("Set the energy consumption per block for Crude Steel Exchanger")
                    .defineInRange("crudeSteelExchangerPerBlockUse", DefaultValues.crudeSteelPerBlockUse, 1, Integer.MAX_VALUE);
            crudeSteelMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Crude Steel Exchanger")
                    .defineInRange("crudeSteelExchangerMaxHarvestLevel", DefaultValues.crudeSteelMaxHarvestLevel, 0, Integer.MAX_VALUE);
            crudeSteelMaxRange = builder
                    .comment("Set the max range for Crude Steel Exchanger")
                    .defineInRange("crudeSteelExchangerMaxRange", DefaultValues.crudeSteelMaxRange, 0, 12);

            energeticSilverMaxEnergy = builder
                    .comment("Set the energy capacity for Energetic Silver Exchanger")
                    .defineInRange("energeticSilverExchangerMaxEnergy", DefaultValues.energeticSilverMaxEnergy, 1000, Integer.MAX_VALUE);
            energeticSilverPerBlockUse = builder
                    .comment("Set the energy consumption per block for Energetic Silver Exchanger")
                    .defineInRange("energeticSilverExchangerPerBlockUse", DefaultValues.energeticSilverPerBlockUse, 1, Integer.MAX_VALUE);
            energeticSilverMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Energetic Silver Exchanger")
                    .defineInRange("energeticSilverExchangerMaxHarvestLevel", DefaultValues.energeticSilverMaxHarvestLevel, 0, Integer.MAX_VALUE);
            energeticSilverMaxRange = builder
                    .comment("Set the max range for Energetic Silver Exchanger")
                    .defineInRange("energeticSilverExchangerMaxRange", DefaultValues.energeticSilverMaxRange, 0, 12);

            vividMaxEnergy = builder
                    .comment("Set the energy capacity for Vivid Exchanger")
                    .defineInRange("vividExchangerMaxEnergy", DefaultValues.vividMaxEnergy, 1000, Integer.MAX_VALUE);
            vividPerBlockUse = builder
                    .comment("Set the energy consumption per block for Vivid Exchanger")
                    .defineInRange("vividExchangerPerBlockUse", DefaultValues.vividPerBlockUse, 1, Integer.MAX_VALUE);
            vividMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Vivid Exchanger")
                    .defineInRange("vividExchangerMaxHarvestLevel", DefaultValues.vividMaxHarvestLevel, 0, Integer.MAX_VALUE);
            vividMaxRange = builder
                    .comment("Set the max range for Vivid Exchanger")
                    .defineInRange("vividExchangerMaxRange", DefaultValues.vividMaxRange, 0, 12);

            crystallineMaxEnergy = builder
                    .comment("Set the energy capacity for Crystalline Exchanger")
                    .defineInRange("crystallineExchangerMaxEnergy", DefaultValues.crystallineMaxEnergy, 1000, Integer.MAX_VALUE);
            crystallinePerBlockUse = builder
                    .comment("Set the energy consumption per block for Crystalline Exchanger")
                    .defineInRange("crystallineExchangerPerBlockUse", DefaultValues.crystallinePerBlockUse, 1, Integer.MAX_VALUE);
            crystallineMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Crystalline Exchanger")
                    .defineInRange("crystallineExchangerMaxHarvestLevel", DefaultValues.crystallineMaxHarvestLevel, 0, Integer.MAX_VALUE);
            crystallineMaxRange = builder
                    .comment("Set the max range for Crystalline Exchanger")
                    .defineInRange("crystallineExchangerMaxRange", DefaultValues.crystallineMaxRange, 0, 12);

            melodicMaxEnergy = builder
                    .comment("Set the energy capacity for Melodic Exchanger")
                    .defineInRange("melodicExchangerMaxEnergy", DefaultValues.melodicMaxEnergy, 1000, Integer.MAX_VALUE);
            melodicPerBlockUse = builder
                    .comment("Set the energy consumption per block for Melodic Exchanger")
                    .defineInRange("melodicExchangerPerBlockUse", DefaultValues.melodicPerBlockUse, 1, Integer.MAX_VALUE);
            melodicMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Melodic Exchanger")
                    .defineInRange("melodicExchangerMaxHarvestLevel", DefaultValues.melodicMaxHarvestLevel, 0, Integer.MAX_VALUE);
            melodicMaxRange = builder
                    .comment("Set the max range for Melodic Exchanger")
                    .defineInRange("melodicExchangerMaxRange", DefaultValues.melodicMaxRange, 0, 12);

            stellarMaxEnergy = builder
                    .comment("Set the energy capacity for Stellar Exchanger")
                    .defineInRange("stellarExchangerMaxEnergy", DefaultValues.stellarMaxEnergy, 1000, Integer.MAX_VALUE);
            stellarPerBlockUse = builder
                    .comment("Set the energy consumption per block for Stellar Exchanger")
                    .defineInRange("stellarExchangerPerBlockUse", DefaultValues.stellarPerBlockUse, 1, Integer.MAX_VALUE);
            stellarMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Stellar Exchanger")
                    .defineInRange("stellarExchangerMaxHarvestLevel", DefaultValues.stellarMaxHarvestLevel, 0, Integer.MAX_VALUE);
            stellarMaxRange = builder
                    .comment("Set the max range for Stellar Exchanger")
                    .defineInRange("stellarExchangerMaxRange", DefaultValues.stellarMaxRange, 0, 12);
            builder.pop();

            builder.push("thermal_tweaks");
            leadstoneMaxEnergy = builder
                    .comment("Set the energy capacity for Leadstone Exchanger")
                    .defineInRange("leadstoneExchangerMaxEnergy", DefaultValues.leadstoneMaxEnergy, 1000, Integer.MAX_VALUE);
            leadstonePerBlockUse = builder
                    .comment("Set the energy consumption per block for Leadstone Exchanger")
                    .defineInRange("leadstoneExchangerPerBlockUse", DefaultValues.leadstonePerBlockUse, 1, Integer.MAX_VALUE);
            leadstoneMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Leadstone Exchanger")
                    .defineInRange("leadstoneExchangerMaxHarvestLevel", DefaultValues.leadstoneMaxHarvestLevel, 0, Integer.MAX_VALUE);
            leadstoneMaxRange = builder
                    .comment("Set the max range for Leadstone Exchanger")
                    .defineInRange("leadstoneExchangerMaxRange", DefaultValues.leadstoneMaxRange, 0, 12);

            hardenedMaxEnergy = builder
                    .comment("Set the energy capacity for Hardened Exchanger")
                    .defineInRange("hardenedExchangerMaxEnergy", DefaultValues.hardenedMaxEnergy, 1000, Integer.MAX_VALUE);
            hardenedPerBlockUse = builder
                    .comment("Set the energy consumption per block for Hardened Exchanger")
                    .defineInRange("hardenedExchangerPerBlockUse", DefaultValues.hardenedPerBlockUse, 1, Integer.MAX_VALUE);
            hardenedMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Hardened Exchanger")
                    .defineInRange("hardenedExchangerMaxHarvestLevel", DefaultValues.hardenedMaxHarvestLevel, 0, Integer.MAX_VALUE);
            hardenedMaxRange = builder
                    .comment("Set the max range for Hardened Exchanger")
                    .defineInRange("hardenedExchangerMaxRange", DefaultValues.hardenedMaxRange, 0, 12);

            reinforcedMaxEnergy = builder
                    .comment("Set the energy capacity for Reinforced Exchanger")
                    .defineInRange("reinforcedExchangerMaxEnergy", DefaultValues.reinforcedMaxEnergy, 1000, Integer.MAX_VALUE);
            reinforcedPerBlockUse = builder
                    .comment("Set the energy consumption per block for Reinforced Exchanger")
                    .defineInRange("reinforcedExchangerPerBlockUse", DefaultValues.reinforcedPerBlockUse, 1, Integer.MAX_VALUE);
            reinforcedMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Reinforced Exchanger")
                    .defineInRange("reinforcedExchangerMaxHarvestLevel", DefaultValues.reinforcedMaxHarvestLevel, 0, Integer.MAX_VALUE);
            reinforcedMaxRange = builder
                    .comment("Set the max range for Reinforced Exchanger")
                    .defineInRange("reinforcedExchangerMaxRange", DefaultValues.reinforcedMaxRange, 0, 12);

            signalumMaxEnergy = builder
                    .comment("Set the energy capacity for Signalum Exchanger")
                    .defineInRange("signalumExchangerMaxEnergy", DefaultValues.signalumMaxEnergy, 1000, Integer.MAX_VALUE);
            signalumPerBlockUse = builder
                    .comment("Set the energy consumption per block for Signalum Exchanger")
                    .defineInRange("signalumExchangerPerBlockUse", DefaultValues.signalumPerBlockUse, 1, Integer.MAX_VALUE);
            signalumMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Signalum Exchanger")
                    .defineInRange("signalumExchangerMaxHarvestLevel", DefaultValues.signalumMaxHarvestLevel, 0, Integer.MAX_VALUE);
            signalumMaxRange = builder
                    .comment("Set the max range for Signalum Exchanger")
                    .defineInRange("signalumExchangerMaxRange", DefaultValues.signalumMaxRange, 0, 12);

            resonantMaxEnergy = builder
                    .comment("Set the energy capacity for Resonant Exchanger")
                    .defineInRange("resonantExchangerMaxEnergy", DefaultValues.resonantMaxEnergy, 1000, Integer.MAX_VALUE);
            resonantPerBlockUse = builder
                    .comment("Set the energy consumption per block for Resonant Exchanger")
                    .defineInRange("resonantExchangerPerBlockUse", DefaultValues.resonantPerBlockUse, 1, Integer.MAX_VALUE);
            resonantMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Resonant Exchanger")
                    .defineInRange("resonantExchangerMaxHarvestLevel", DefaultValues.resonantMaxHarvestLevel, 0, Integer.MAX_VALUE);
            resonantMaxRange = builder
                    .comment("Set the max range for Resonant Exchanger")
                    .defineInRange("resonantExchangerMaxRange", DefaultValues.resonantMaxRange, 0, 12);
            builder.pop();

            builder.push("mekanism_tweaks");
            basicMaxEnergy = builder
                    .comment("Set the energy capacity for Basic Exchanger")
                    .defineInRange("basicExchangerMaxEnergy", DefaultValues.basicMaxEnergy, 1000, Integer.MAX_VALUE);
            basicPerBlockUse = builder
                    .comment("Set the energy consumption per block for Basic Exchanger")
                    .defineInRange("basicExchangerPerBlockUse", DefaultValues.basicPerBlockUse, 1, Integer.MAX_VALUE);
            basicMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Basic Exchanger")
                    .defineInRange("basicExchangerMaxHarvestLevel", DefaultValues.basicMaxHarvestLevel, 0, Integer.MAX_VALUE);
            basicMaxRange = builder
                    .comment("Set the max range for Basic Exchanger")
                    .defineInRange("basicExchangerMaxRange", DefaultValues.basicMaxRange, 0, 12);

            advancedMaxEnergy = builder
                    .comment("Set the energy capacity for Advanced Exchanger")
                    .defineInRange("advancedExchangerMaxEnergy", DefaultValues.advancedMaxEnergy, 1000, Integer.MAX_VALUE);
            advancedPerBlockUse = builder
                    .comment("Set the energy consumption per block for Advanced Exchanger")
                    .defineInRange("advancedExchangerPerBlockUse", DefaultValues.advancedPerBlockUse, 1, Integer.MAX_VALUE);
            advancedMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Advanced Exchanger")
                    .defineInRange("advancedExchangerMaxHarvestLevel", DefaultValues.advancedMaxHarvestLevel, 0, Integer.MAX_VALUE);
            advancedMaxRange = builder
                    .comment("Set the max range for Advanced Exchanger")
                    .defineInRange("advancedExchangerMaxRange", DefaultValues.advancedMaxRange, 0, 12);

            eliteMaxEnergy = builder
                    .comment("Set the energy capacity for Elite Exchanger")
                    .defineInRange("eliteExchangerMaxEnergy", DefaultValues.eliteMaxEnergy, 1000, Integer.MAX_VALUE);
            elitePerBlockUse = builder
                    .comment("Set the energy consumption per block for Elite Exchanger")
                    .defineInRange("eliteExchangerPerBlockUse", DefaultValues.elitePerBlockUse, 1, Integer.MAX_VALUE);
            eliteMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Elite Exchanger")
                    .defineInRange("eliteExchangerMaxHarvestLevel", DefaultValues.eliteMaxHarvestLevel, 0, Integer.MAX_VALUE);
            eliteMaxRange = builder
                    .comment("Set the max range for Elite Exchanger")
                    .defineInRange("eliteExchangerMaxRange", DefaultValues.eliteMaxRange, 0, 12);

            ultimateMaxEnergy = builder
                    .comment("Set the energy capacity for Ultimate Exchanger")
                    .defineInRange("ultimateExchangerMaxEnergy", DefaultValues.ultimateMaxEnergy, 1000, Integer.MAX_VALUE);
            ultimatePerBlockUse = builder
                    .comment("Set the energy consumption per block for Ultimate Exchanger")
                    .defineInRange("ultimateExchangerPerBlockUse", DefaultValues.ultimatePerBlockUse, 1, Integer.MAX_VALUE);
            ultimateMaxHarvestLevel = builder
                    .comment("Set the max harvest level for Ultimate Exchanger")
                    .defineInRange("ultimateExchangerMaxHarvestLevel", DefaultValues.ultimateMaxHarvestLevel, 0, Integer.MAX_VALUE);
            ultimateMaxRange = builder
                    .comment("Set the max range for Ultimate Exchanger")
                    .defineInRange("ultimateExchangerMaxRange", DefaultValues.ultimateMaxRange, 0, 12);
            builder.pop();

            builder.push("immersive_engineering_tweaks");
            lvMaxEnergy = builder
                    .comment("Set the energy capacity for LV Exchanger")
                    .defineInRange("lvExchangerMaxEnergy", DefaultValues.lvMaxEnergy, 1000, Integer.MAX_VALUE);
            lvPerBlockUse = builder
                    .comment("Set the energy consumption per block for LV Exchanger")
                    .defineInRange("lvExchangerPerBlockUse", DefaultValues.lvPerBlockUse, 1, Integer.MAX_VALUE);
            lvMaxHarvestLevel = builder
                    .comment("Set the max harvest level for LV Exchanger")
                    .defineInRange("lvExchangerMaxHarvestLevel", DefaultValues.lvMaxHarvestLevel, 0, Integer.MAX_VALUE);
            lvMaxRange = builder
                    .comment("Set the max range for LV Exchanger")
                    .defineInRange("lvExchangerMaxRange", DefaultValues.lvMaxRange, 0, 12);

            mvMaxEnergy = builder
                    .comment("Set the energy capacity for MV Exchanger")
                    .defineInRange("mvExchangerMaxEnergy", DefaultValues.mvMaxEnergy, 1000, Integer.MAX_VALUE);
            mvPerBlockUse = builder
                    .comment("Set the energy consumption per block for MV Exchanger")
                    .defineInRange("mvExchangerPerBlockUse", DefaultValues.mvPerBlockUse, 1, Integer.MAX_VALUE);
            mvMaxHarvestLevel = builder
                    .comment("Set the max harvest level for MV Exchanger")
                    .defineInRange("mvExchangerMaxHarvestLevel", DefaultValues.mvMaxHarvestLevel, 0, Integer.MAX_VALUE);
            mvMaxRange = builder
                    .comment("Set the max range for MV Exchanger")
                    .defineInRange("mvExchangerMaxRange", DefaultValues.mvMaxRange, 0, 12);

            hvMaxEnergy = builder
                    .comment("Set the energy capacity for HV Exchanger")
                    .defineInRange("hvExchangerMaxEnergy", DefaultValues.hvMaxEnergy, 1000, Integer.MAX_VALUE);
            hvPerBlockUse = builder
                    .comment("Set the energy consumption per block for HV Exchanger")
                    .defineInRange("hvExchangerPerBlockUse", DefaultValues.hvPerBlockUse, 1, Integer.MAX_VALUE);
            hvMaxHarvestLevel = builder
                    .comment("Set the max harvest level for HV Exchanger")
                    .defineInRange("hvExchangerMaxHarvestLevel", DefaultValues.hvMaxHarvestLevel, 0, Integer.MAX_VALUE);
            hvMaxRange = builder
                    .comment("Set the max range for HV Exchanger")
                    .defineInRange("hvExchangerMaxRange", DefaultValues.hvMaxRange, 0, 12);
            builder.pop();

            builder.push("recipe_tweaks");
            vanillaRecipesType = builder
                    .comment(
                            "Set the recipes type for Vanilla-based exchangers:",
                            "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                            "'normal'   Normal recipes, progressive, moderate recipe costs.",
                            "'hard'     Hard recipes, progressive, expensive recipe costs."
                    )
                    .defineInList("vanillaRecipesType", "normal", Arrays.asList("easy", "normal", "hard"));
            enderIORecipesType = builder
                    .comment(
                            "Set the recipes type for Ender IO-based exchangers:",
                            "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                            "'normal'   Normal recipes, progressive, moderate recipe costs.",
                            "'hard'     Hard recipes, progressive, expensive recipe costs."
                    )
                    .defineInList("enderIORecipesType", "normal", Arrays.asList("easy", "normal", "hard"));
            enderIOEndergyRecipesType = builder
                    .comment(
                            "Set the recipes type for Ender IO Endergy-based exchangers:",
                            "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                            "'normal'   Normal recipes, progressive, moderate recipe costs.",
                            "'hard'     Hard recipes, progressive, expensive recipe costs."
                    )
                    .defineInList("enderIOEndergyRecipesType", "normal", Arrays.asList("easy", "normal", "hard"));
            thermalRecipesType = builder
                    .comment(
                            "Set the recipes type for Thermal Series-based exchangers:",
                            "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                            "'normal'   Normal recipes, progressive, moderate recipe costs.",
                            "'hard'     Hard recipes, progressive, expensive recipe costs."
                    )
                    .defineInList("thermalRecipesType", "normal", Arrays.asList("easy", "normal", "hard"));
            mekanismRecipesType = builder
                    .comment(
                            "Set the recipes type for Mekanism-based exchangers:",
                            "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                            "'normal'   Normal recipes, progressive, moderate recipe costs.",
                            "'hard'     Hard recipes, progressive, expensive recipe costs."
                    )
                    .defineInList("mekanismRecipesType", "normal", Arrays.asList("easy", "normal", "hard"));
            immersiveEngineeringRecipesType = builder
                    .comment(
                            "Set the recipes type for Immersive Engineering-based exchangers:",
                            "'easy'     Easy recipes, non-progressive, lowest recipe costs.",
                            "'normal'   Normal recipes, progressive, moderate recipe costs.",
                            "'hard'     Hard recipes, progressive, expensive recipe costs."
                    )
                    .defineInList("immersiveEngineeringRecipesType", "normal", Arrays.asList("easy", "normal", "hard"));
            builder.pop();

            builder.push("misc");
            blocksWhitelist = builder
                    .comment(
                            "Certain blocks might be blacklisted by Exchangers if they're Tile Entities.",
                            "Put a list of block registry names that you wish to be whitelisted from Exchangers.",
                            "Separate each entry with semicolon.",
                            "(e.g. \"tconstruct:seared;thermal:energy_cell;minecraft:conduit\")"
                    )
                    .define("blocksWhitelist", "tconstruct:seared");
            blocksBlacklist = builder
                    .comment(
                            "Put a list of block registry names that you wish to be blacklisted from Exchangers.",
                            "Note: Blacklisting a block will prevent it from being selected or being exchanged.",
                            "Separate each entry with semicolon.",
                            "(e.g. \"minecraft:grass;minecraft:cake;minecraft:dragon_egg\")"
                    )
                    .define("blocksBlacklist", "");
            holdingEnchantment = builder
                    .comment(
                            "If true, allows the Holding Enchantment from CoFH Core to be used on Powered Exchangers",
                            "Calculation formula: Base Energy + (Base Energy * Enchantment Level / 2)"
                    )
                    .define("holdingEnchantment", true);
            unbreakingPoweredExchangers = builder
                    .comment("If true, allows Unbreaking Enchantment to affect Powered Exchangers")
                    .define("unbreakingPoweredExchangers", true);
            doExchangersSilkTouch = builder
                    .comment("If true, enables Silk Touch (gets the blocks itself rather than drops) on all Exchangers")
                    .define("doExchangersSilkTouch", true);
            energyUnit = builder
                    .comment(
                            "Set the energy unit shown on Powered Exchangers:",
                            "'FE'     Forge Energy",
                            "'RF'     Redstone Flux"
                    )
                    .defineInList("energyUnit", "FE", Arrays.asList("FE", "RF"));
            builder.pop();
        }

    }

    public static final ForgeConfigSpec SPEC;
    public static final CommonConfig CONFIG;
    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

}