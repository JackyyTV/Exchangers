package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.integration.EnderIOIntegration;
import me.jacky1356400.exchangers.integration.ImmersiveEngineeringIntegration;
import me.jacky1356400.exchangers.integration.MekanismIntegration;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init() {

        if (Config.vanillaModule) {
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(ExchangersItems.woodenExchanger),
                            "WEW", "WCW", "WEW", 'W', "logWood",
                            'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1)
            );
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT1),
                            "WRW", "RPR", "WRW",
                            'R', "dyeRed", 'W', "logWood", 'P', "enderpearl")
            );
            switch (Config.vanillaRecipesType) {
                case "easy": {
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.stoneExchanger),
                                    "SES", "SCS", "SES",
                                    'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.goldenExchanger),
                                    "GEG", "GCG", "GEG",
                                    'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.ironExchanger),
                                    "IEI", "ICI", "IEI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.diamondExchanger),
                                    "DED", "DCD", "DED",
                                    'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.emeraldExchanger),
                                    "MEM", "MCM", "MEM",
                                    'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.obsidianExchanger),
                                    "OEO", "OCO", "OEO",
                                    'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT2),
                                    "ILI", "LEL", "ILI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT3),
                                    "DED", "EBE", "DED",
                                    'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'B', "blockDiamond")
                    );
                    break;
                }
                case "normal": {
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.stoneExchanger),
                                    "SCS", "EXE", "SSS",
                                    'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1, 'X', ExchangersItems.woodenExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.goldenExchanger),
                                    "GCG", "EXE", "GCG",
                                    'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.stoneExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.ironExchanger),
                                    "ICI", "EXE", "III",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.goldenExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.diamondExchanger),
                                    "DCD", "EXE", "DDD",
                                    'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.ironExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.emeraldExchanger),
                                    "MCM", "EXE", "MMM",
                                    'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.diamondExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.obsidianExchanger),
                                    "OCO", "EXE", "OOO",
                                    'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.emeraldExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT2),
                                    "ILI", "ECE", "ILI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT3),
                                    "DED", "BCB", "DED",
                                    'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'B', "blockDiamond")
                    );
                    break;
                }
                case "hard": {
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.stoneExchanger),
                                    "SES", "CXC", "SES",
                                    'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1, 'X', ExchangersItems.woodenExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.goldenExchanger),
                                    "GEG", "CXC", "GEG",
                                    'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.stoneExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.ironExchanger),
                                    "IEI", "CXC", "IEI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.goldenExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.diamondExchanger),
                                    "DED", "CXC", "DED",
                                    'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.ironExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.emeraldExchanger),
                                    "MEM", "CXC", "MEM",
                                    'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.diamondExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.obsidianExchanger),
                                    "OEO", "CXC", "OEO",
                                    'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.emeraldExchanger)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT2),
                                    "ILI", "CEC", "ILI",
                                    'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1)
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT3),
                                    "DCE", "CBC", "ECD",
                                    'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'B', "blockDiamond")
                    );
                    break;
                }
            }
        }

        if (Config.enderIOModule) {
            if (Loader.isModLoaded("enderio")) {
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.conductiveIronExchanger),
                                "IBI", "ICI", "IBI",
                                'I', "ingotConductiveIron", 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1)
                );
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT1),
                                "PCP", "CNC", "PCP",
                                'P', "nuggetPulsatingIron", 'C', "ingotConductiveIron", 'N', EnderIOIntegration.bucketNutrientDistillation)
                );
                switch (Config.enderIORecipesType) {
                    case "easy": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.pulsatingIronExchanger),
                                        "IPI", "ICI", "IBI",
                                        'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.electricalSteelExchanger),
                                        "SDS", "SCS", "SBS",
                                        'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.energeticExchanger),
                                        "ADA", "ACA", "ABA",
                                        'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.darkSteelExchanger),
                                        "SVS", "SCS", "SOS",
                                        'S', "ingotDarkSteel", 'B', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.vibrantExchanger),
                                        "AEA", "ACA", "ABA",
                                        'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT2),
                                        "PSP", "SDS", "PSP",
                                        'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ExchangersItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT3),
                                        "DBD", "BVB", "DBD",
                                        'C', ExchangersItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity)
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.pulsatingIronExchanger),
                                        "ICI", "PXP", "IBI",
                                        'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1, 'X', ExchangersItems.conductiveIronExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.electricalSteelExchanger),
                                        "SCS", "DXD", "SBS",
                                        'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.pulsatingIronExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.energeticExchanger),
                                        "ACA", "DXD", "ABA",
                                        'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.electricalSteelExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.darkSteelExchanger),
                                        "SCS", "VXV", "SOS",
                                        'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.energeticExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.vibrantExchanger),
                                        "ACA", "EXE", "ABA",
                                        'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.darkSteelExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT2),
                                        "PSP", "DCD", "PSP",
                                        'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ExchangersItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT3),
                                        "DBD", "VCV", "DBD",
                                        'C', ExchangersItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity)
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.pulsatingIronExchanger),
                                        "IPI", "CXC", "IBI",
                                        'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1, 'X', ExchangersItems.conductiveIronExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.electricalSteelExchanger),
                                        "SDS", "CXC", "SBS",
                                        'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.pulsatingIronExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.energeticExchanger),
                                        "ADA", "CXC", "ABA",
                                        'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.electricalSteelExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.darkSteelExchanger),
                                        "SVS", "CXC", "SOS",
                                        'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.energeticExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.vibrantExchanger),
                                        "AEA", "CXC", "ABA",
                                        'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.darkSteelExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT2),
                                        "PSP", "CDC", "PSP",
                                        'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ExchangersItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT3),
                                        "DCD", "CVC", "DCD",
                                        'C', ExchangersItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'V', EnderIOIntegration.bucketVaporOfLevity)
                        );
                        break;
                    }
                }
            }
        }

        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded("thermalexpansion")) {
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.leadstoneExchanger),
                                "LSL", "LCL", "LFL",
                                'L', "ingotLead", 'S', ThermalExpansionIntegration.redstoneServo, 'F', ThermalExpansionIntegration.fluxCapacitorBasic, 'C', ExchangersItems.teExchangerCoreT1)
                );
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT1),
                                "CLC", "LRL", "CLC",
                                'C', "gearCopper", 'L', "ingotLead", 'R', ThermalExpansionIntegration.bucketResonantEnder)
                );
                switch (Config.thermalExpansionRecipesType) {
                    case "easy": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.hardenedExchanger),
                                        "IRI", "ICI", "IFI",
                                        'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.reinforcedExchanger),
                                        "ERE", "ECE", "EFE",
                                        'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.signalumExchanger),
                                        "SRS", "SCS", "SFS",
                                        'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.resonantExchanger),
                                        "IRI", "ICI", "IFI",
                                        'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT2),
                                        "BIB", "IGI", "BIB",
                                        'B', "gearBronze", 'I', "gearInvar", 'C', ExchangersItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT3),
                                        "LSL", "SGS", "LSL",
                                        'C', ExchangersItems.teExchangerCoreT2, 'S', "gearSignalum", 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum)
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.hardenedExchanger),
                                        "ICI", "RXR", "IFI",
                                        'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1, 'X', ExchangersItems.leadstoneExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.reinforcedExchanger),
                                        "ECE", "RXR", "EFE",
                                        'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2, 'X', ExchangersItems.hardenedExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.signalumExchanger),
                                        "SCS", "RXR", "SFS",
                                        'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.reinforcedExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.resonantExchanger),
                                        "ICI", "RXR", "IFI",
                                        'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.signalumExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT2),
                                        "BIB", "GCG", "BIB",
                                        'B', "gearBronze", 'I', "gearInvar", 'C', ExchangersItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT3),
                                        "LSL", "GCG", "LSL",
                                        'C', ExchangersItems.teExchangerCoreT2, 'L', "gearLumium", 'S', "gearSignalum", 'G', ThermalExpansionIntegration.bucketGelidCryotheum)
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.hardenedExchanger),
                                        "IRI", "CXC", "IFI",
                                        'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1, 'X', ExchangersItems.leadstoneExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.reinforcedExchanger),
                                        "ERE", "CXC", "EFE",
                                        'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2, 'X', ExchangersItems.hardenedExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.signalumExchanger),
                                        "SRS", "CXC", "SFS",
                                        'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.reinforcedExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.resonantExchanger),
                                        "IRI", "CXC", "IFI",
                                        'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.signalumExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT2),
                                        "BIB", "CGC", "BIB",
                                        'B', "gearBronze", 'I', "gearInvar", 'C', ExchangersItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT3),
                                        "LCL", "CGC", "LCL",
                                        'C', ExchangersItems.teExchangerCoreT2, 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum)
                        );
                        break;
                    }
                }
            }
        }

        if (Config.mekanismModule) {
            if (Loader.isModLoaded("mekanism")) {
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.basicExchanger),
                                "BTB", "BCB", "BTB",
                                'B', MekanismIntegration.circuitBasic, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT1)
                );
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT1),
                                "OSO", "SAS", "OSO",
                                'O', "ingotOsmium", 'S', "ingotSteel", 'A', "alloyAdvanced")
                );
                switch (Config.mekanismRecipesType) {
                    case "easy": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.advancedExchanger),
                                        "ATA", "ACA", "ATA",
                                        'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eliteExchanger),
                                        "EPE", "ECE", "ETE",
                                        'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ultimateExchanger),
                                        "UTU", "UCU", "UTU",
                                        'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT2),
                                        "DGD", "GAG", "DGD",
                                        'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'A', "alloyElite")
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT3),
                                        "OIO", "IAI", "OIO",
                                        'O', "dustRefinedObsidian", 'I', "ingotRefinedObsidian", 'A', "alloyUltimate")
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.advancedExchanger),
                                        "ACA", "TXT", "AAA",
                                        'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2, 'X', ExchangersItems.basicExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eliteExchanger),
                                        "ECE", "TXT", "EPE",
                                        'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.advancedExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ultimateExchanger),
                                        "UCU", "TXT", "UUU",
                                        'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.eliteExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT2),
                                        "DGD", "ACA", "DGD",
                                        'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ExchangersItems.mekanismExchangerCoreT1, 'A', "alloyElite")
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT3),
                                        "OAO", "ACA", "OAO",
                                        'C', ExchangersItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate")
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.advancedExchanger),
                                        "ATA", "CXC", "ATA",
                                        'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2, 'X', ExchangersItems.basicExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.eliteExchanger),
                                        "EPE", "CXC", "ETE",
                                        'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.advancedExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ultimateExchanger),
                                        "UTU", "CXC", "UTU",
                                        'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.eliteExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT2),
                                        "DGD", "CAC", "DGD",
                                        'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ExchangersItems.mekanismExchangerCoreT1, 'A', "alloyElite")
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT3),
                                        "OCO", "CAC", "OCO",
                                        'C', ExchangersItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate")
                        );
                        break;
                    }
                }
            }
        }

        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded("immersiveengineering")) {
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.lvExchanger),
                                "SLS", "SCS", "SLS",
                                'S', "blockSheetmetalCopper", 'L', ImmersiveEngineeringIntegration.lvCapacitor, 'C', ExchangersItems.ieExchangerCoreT1)
                );
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT1),
                                "CIC", "IBI", "CIC",
                                'C', ImmersiveEngineeringIntegration.lvWireCoil, 'I', ImmersiveEngineeringIntegration.ironMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketCreosote)
                );
                switch (Config.immersiveEngineeringRecipesType) {
                    case "easy": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mvExchanger),
                                        "SMS", "SCS", "SMS",
                                        'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ExchangersItems.ieExchangerCoreT2)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.hvExchanger),
                                        "SHS", "SCS", "SHS",
                                        'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT2),
                                        "ESE", "SBS", "ESE",
                                        'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT3),
                                        "SHS", "HBH", "SHS",
                                        'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel)
                        );
                        break;
                    }
                    case "normal": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mvExchanger),
                                        "SCS", "MXM", "SSS",
                                        'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ExchangersItems.ieExchangerCoreT2, 'X', ExchangersItems.lvExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.hvExchanger),
                                        "SCS", "HXH", "SSS",
                                        'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3, 'X', ExchangersItems.mvExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT2),
                                        "ESE", "BCB", "ESE",
                                        'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', ExchangersItems.ieExchangerCoreT1)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT3),
                                        "SHS", "BCB", "SHS",
                                        'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', ExchangersItems.ieExchangerCoreT2)
                        );
                        break;
                    }
                    case "hard": {
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.mvExchanger),
                                        "SMS", "CXC", "SMS",
                                        'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ExchangersItems.ieExchangerCoreT2, 'X', ExchangersItems.lvExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.hvExchanger),
                                        "SHS", "CXC", "SHS",
                                        'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3, 'X', ExchangersItems.mvExchanger)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT2),
                                        "ESE", "CBC", "ESE",
                                        'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', ExchangersItems.ieExchangerCoreT1)
                        );
                        GameRegistry.addRecipe(
                                new ShapedOreRecipe(new ItemStack(ExchangersItems.ieExchangerCoreT3),
                                        "HCS", "CBC", "SCH",
                                        'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', ExchangersItems.ieExchangerCoreT2)
                        );
                        break;
                    }
                }
            }
        }

        if (Config.specialModule) {
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(ExchangersItems.tuberousExchanger),
                            "PGP", "PEP", "PGP",
                            'P', Items.POTATO, 'G', "nuggetGold", 'E', "enderpearl")
            );
        }

    }

}
