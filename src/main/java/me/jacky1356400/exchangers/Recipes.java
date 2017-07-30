package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.integration.EnderIOIntegration;
import me.jacky1356400.exchangers.integration.MekanismIntegration;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){

        if (Config.vanillaModule) {
            ShapedOreRecipe woodenExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.woodenExchanger), "WEW", "WCW", "WEW", 'W', "logWood", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1);
            GameRegistry.addRecipe(woodenExchangerRecipe);
            if (Config.vanillaProgressiveRecipes) {
                ShapedOreRecipe stoneExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.stoneExchanger), "SES", "CXC", "SES", 'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1, 'X', ExchangersItems.woodenExchanger);
                GameRegistry.addRecipe(stoneExchangerRecipe);
                ShapedOreRecipe goldenExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.goldenExchanger), "GEG", "CXC", "GEG", 'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.stoneExchanger);
                GameRegistry.addRecipe(goldenExchangerRecipe);
                ShapedOreRecipe ironExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.ironExchanger), "IEI", "CXC", "IEI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.goldenExchanger);
                GameRegistry.addRecipe(ironExchangerRecipe);
                ShapedOreRecipe diamondExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.diamondExchanger), "DED", "CXC", "DED", 'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.ironExchanger);
                GameRegistry.addRecipe(diamondExchangerRecipe);
                ShapedOreRecipe emeraldExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.emeraldExchanger), "MEM", "CXC", "MEM", 'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.diamondExchanger);
                GameRegistry.addRecipe(emeraldExchangerRecipe);
                ShapedOreRecipe obsidianExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.obsidianExchanger), "OEO", "CXC", "OEO", 'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.emeraldExchanger);
                GameRegistry.addRecipe(obsidianExchangerRecipe);
            }
            else {
                ShapedOreRecipe stoneExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.stoneExchanger), "SES", "SCS", "SES", 'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1);
                GameRegistry.addRecipe(stoneExchangerRecipe);
                ShapedOreRecipe goldenExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.goldenExchanger), "GEG", "GCG", "GEG", 'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2);
                GameRegistry.addRecipe(goldenExchangerRecipe);
                ShapedOreRecipe ironExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.ironExchanger), "IEI", "ICI", "IEI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2);
                GameRegistry.addRecipe(ironExchangerRecipe);
                ShapedOreRecipe diamondExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.diamondExchanger), "DED", "DCD", "DED", 'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3);
                GameRegistry.addRecipe(diamondExchangerRecipe);
                ShapedOreRecipe emeraldExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.emeraldExchanger), "MEM", "MCM", "MEM", 'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3);
                GameRegistry.addRecipe(emeraldExchangerRecipe);
                ShapedOreRecipe obsidianExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.obsidianExchanger), "OEO", "OCO", "OEO", 'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3);
                GameRegistry.addRecipe(obsidianExchangerRecipe);
            }
            ShapedOreRecipe exchangerCoreT1Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT1), "WRW", "RPR", "WRW", 'R', "dyeRed", 'W', "logWood", 'P', "enderpearl");
            GameRegistry.addRecipe(exchangerCoreT1Recipe);
            ShapedOreRecipe exchangerCoreT2Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT2), "ILI", "CEC", "ILI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1);
            GameRegistry.addRecipe(exchangerCoreT2Recipe);
            ShapedOreRecipe exchangerCoreT3Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT3), "DCE", "CBC", "ECD", 'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'B', "blockDiamond");
            GameRegistry.addRecipe(exchangerCoreT3Recipe);
        }

        if (Config.specialModule) {
            ShapedOreRecipe tuberousExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.tuberousExchanger), "PGP", "PEP", "PGP", 'P', Items.POTATO, 'G', "nuggetGold", 'E', "enderpearl");
            GameRegistry.addRecipe(tuberousExchangerRecipe);
        }

        if (Config.enderIOModule) {
            if (Loader.isModLoaded("EnderIO")) {
                ShapedOreRecipe conductiveIronExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.conductiveIronExchanger), "IBI", "ICI", "IBI", 'I', "ingotConductiveIron", 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1);
                GameRegistry.addRecipe(conductiveIronExchangerRecipe);
                if (Config.enderIOProgressiveRecipes) {
                    ShapedOreRecipe pulsatingIronExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.pulsatingIronExchanger), "IPI", "CXC", "IBI", 'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1, 'X', ExchangersItems.conductiveIronExchanger);
                    GameRegistry.addRecipe(pulsatingIronExchangerRecipe);
                    ShapedOreRecipe electricalSteelExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.electricalSteelExchanger), "SDS", "CXC", "SBS", 'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.pulsatingIronExchanger);
                    GameRegistry.addRecipe(electricalSteelExchangerRecipe);
                    ShapedOreRecipe energeticExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.energeticExchanger), "ADA", "CXC", "ABA", 'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.electricalSteelExchanger);
                    GameRegistry.addRecipe(energeticExchangerRecipe);
                    ShapedOreRecipe darkSteelExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.darkSteelExchanger), "SVS", "CXC", "SOS", 'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.energeticExchanger);
                    GameRegistry.addRecipe(darkSteelExchangerRecipe);
                    ShapedOreRecipe vibrantExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.vibrantExchanger), "AEA", "CXC", "ABA", 'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.darkSteelExchanger);
                    GameRegistry.addRecipe(vibrantExchangerRecipe);
                } else {
                    ShapedOreRecipe pulsatingIronExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.pulsatingIronExchanger), "IPI", "ICI", "IBI", 'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1);
                    GameRegistry.addRecipe(pulsatingIronExchangerRecipe);
                    ShapedOreRecipe electricalSteelExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.electricalSteelExchanger), "SDS", "SCS", "SBS", 'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2);
                    GameRegistry.addRecipe(electricalSteelExchangerRecipe);
                    ShapedOreRecipe energeticExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.energeticExchanger), "ADA", "ACA", "ABA", 'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2);
                    GameRegistry.addRecipe(energeticExchangerRecipe);
                    ShapedOreRecipe darkSteelExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.darkSteelExchanger), "SVS", "SCS", "SOS", 'S', "ingotDarkSteel", 'B', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3);
                    GameRegistry.addRecipe(darkSteelExchangerRecipe);
                    ShapedOreRecipe vibrantExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.vibrantExchanger), "AEA", "ACA", "ABA", 'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3);
                    GameRegistry.addRecipe(vibrantExchangerRecipe);
                }
                ShapedOreRecipe eioExchangerCoreT1Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT1), "PCP", "CNC", "PCP", 'P', "nuggetPulsatingIron", 'C', "ingotConductiveIron", 'N', EnderIOIntegration.bucketNutrientDistillation);
                GameRegistry.addRecipe(eioExchangerCoreT1Recipe);
                ShapedOreRecipe eioExchangerCoreT2Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT2), "PSP", "CDC", "PSP", 'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ExchangersItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid);
                GameRegistry.addRecipe(eioExchangerCoreT2Recipe);
                ShapedOreRecipe eioExchangerCoreT3Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.eioExchangerCoreT3), "DCD", "CVC", "DCD", 'C', ExchangersItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'V', EnderIOIntegration.bucketVaporOfLevity);
                GameRegistry.addRecipe(eioExchangerCoreT3Recipe);
            }
        }

        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded("thermalexpansion")) {
                ShapedOreRecipe leadstoneExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.leadstoneExchanger), "LSL", "LCL", "LFL", 'L', "ingotLead", 'S', ThermalExpansionIntegration.redstoneServo, 'F', ThermalExpansionIntegration.fluxCapacitorBasic, 'C', ExchangersItems.teExchangerCoreT1);
                GameRegistry.addRecipe(leadstoneExchangerRecipe);
                if (Config.thermalExpansionProgressiveRecipes) {
                    ShapedOreRecipe hardenedExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.hardenedExchanger), "IRI", "CXC", "IFI", 'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1, 'X', ExchangersItems.leadstoneExchanger);
                    GameRegistry.addRecipe(hardenedExchangerRecipe);
                    ShapedOreRecipe reinforcedExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.reinforcedExchanger), "ERE", "CXC", "EFE", 'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2, 'X', ExchangersItems.hardenedExchanger);
                    GameRegistry.addRecipe(reinforcedExchangerRecipe);
                    ShapedOreRecipe signalumExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.signalumExchanger), "SRS", "CXC", "SFS", 'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.reinforcedExchanger);
                    GameRegistry.addRecipe(signalumExchangerRecipe);
                    ShapedOreRecipe resonantExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.resonantExchanger), "IRI", "CXC", "IFI", 'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.signalumExchanger);
                    GameRegistry.addRecipe(resonantExchangerRecipe);
                } else {
                    ShapedOreRecipe hardenedExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.hardenedExchanger), "IRI", "ICI", "IFI", 'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1);
                    GameRegistry.addRecipe(hardenedExchangerRecipe);
                    ShapedOreRecipe reinforcedExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.reinforcedExchanger), "ERE", "ECE", "EFE", 'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2);
                    GameRegistry.addRecipe(reinforcedExchangerRecipe);
                    ShapedOreRecipe signalumExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.signalumExchanger), "SRS", "SCS", "SFS", 'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3);
                    GameRegistry.addRecipe(signalumExchangerRecipe);
                    ShapedOreRecipe resonantExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.resonantExchanger), "IRI", "ICI", "IFI", 'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3);
                    GameRegistry.addRecipe(resonantExchangerRecipe);
                }
                ShapedOreRecipe teExchangerCoreT1Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT1), "CLC", "LRL", "CLC", 'C', "gearCopper", 'L', "ingotLead", 'R', ThermalExpansionIntegration.bucketResonantEnder);
                GameRegistry.addRecipe(teExchangerCoreT1Recipe);
                ShapedOreRecipe teExchangerCoreT2Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT2), "BIB", "CGC", "BIB", 'B', "gearBronze", 'I', "gearInvar", 'C', ExchangersItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone);
                GameRegistry.addRecipe(teExchangerCoreT2Recipe);
                ShapedOreRecipe teExchangerCoreT3Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.teExchangerCoreT3), "LCL", "CGC", "LCL", 'C', ExchangersItems.teExchangerCoreT2, 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum);
                GameRegistry.addRecipe(teExchangerCoreT3Recipe);
            }
        }

        if (Config.mekanismModule) {
            if (Loader.isModLoaded("Mekanism")) {
                ShapedOreRecipe basicExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.basicExchanger), "BTB", "BCB", "BTB", 'B', MekanismIntegration.circuitBasic, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT1);
                GameRegistry.addRecipe(basicExchangerRecipe);
                if (Config.mekanismProgressiveRecipes) {
                    ShapedOreRecipe advancedExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.advancedExchanger), "ATA", "CXC", "ATA", 'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2, 'X', ExchangersItems.basicExchanger);
                    GameRegistry.addRecipe(advancedExchangerRecipe);
                    ShapedOreRecipe eliteExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.eliteExchanger), "EPE", "CXC", "ETE", 'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.advancedExchanger);
                    GameRegistry.addRecipe(eliteExchangerRecipe);
                    ShapedOreRecipe ultimateExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.ultimateExchanger), "UTU", "CXC", "UTU", 'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.eliteExchanger);
                    GameRegistry.addRecipe(ultimateExchangerRecipe);
                } else {
                    ShapedOreRecipe advancedExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.advancedExchanger), "ATA", "ACA", "ATA", 'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2);
                    GameRegistry.addRecipe(advancedExchangerRecipe);
                    ShapedOreRecipe eliteExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.eliteExchanger), "EPE", "ECE", "ETE", 'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3);
                    GameRegistry.addRecipe(eliteExchangerRecipe);
                    ShapedOreRecipe ultimateExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.ultimateExchanger), "UTU", "UCU", "UTU", 'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3);
                    GameRegistry.addRecipe(ultimateExchangerRecipe);
                }
                ShapedOreRecipe mekanismExchangerCoreT1Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT1), "OSO", "SAS", "OSO", 'O', "ingotOsmium", 'S', "ingotSteel", 'A', "alloyAdvanced");
                GameRegistry.addRecipe(mekanismExchangerCoreT1Recipe);
                ShapedOreRecipe mekanismExchangerCoreT2Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT2), "DGD", "CAC", "DGD", 'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ExchangersItems.mekanismExchangerCoreT1, 'A', "alloyElite");
                GameRegistry.addRecipe(mekanismExchangerCoreT2Recipe);
                ShapedOreRecipe mekanismExchangerCoreT3Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.mekanismExchangerCoreT3), "OCO", "CAC", "OCO", 'C', ExchangersItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate");
                GameRegistry.addRecipe(mekanismExchangerCoreT3Recipe);
            }
        }

    }

}
