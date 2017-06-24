package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.integration.EnderIOIntegration;
import me.jacky1356400.exchangers.integration.MekanismIntegration;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import me.jacky1356400.exchangers.helper.RecipeHelper;
import net.minecraftforge.fml.common.Loader;

public class Recipes {

    private static int id = 0;

    public static void init(){
        Item ExT1 = ExchangersItems.woodenExchanger;
        Item ExT2 = ExchangersItems.stoneExchanger;
        Item ExT3 = ExchangersItems.goldenExchanger;
        Item ExT4 = ExchangersItems.ironExchanger;
        Item ExT5 = ExchangersItems.diamondExchanger;
        Item ExT6 = ExchangersItems.emeraldExchanger;
        Item EIOExT1 = ExchangersItems.conductiveIronExchanger;
        Item EIOExT2 = ExchangersItems.pulsatingIronExchanger;
        Item EIOExT3 = ExchangersItems.electricalSteelExchanger;
        Item EIOExT4 = ExchangersItems.energeticExchanger;
        Item EIOExT5 = ExchangersItems.darkSteelExchanger;
        Item TEExT1 = ExchangersItems.leadstoneExchanger;
        Item TEExT2 = ExchangersItems.hardenedExchanger;
        Item TEExT3 = ExchangersItems.reinforcedExchanger;
        Item TEExT4 = ExchangersItems.signalumExchanger;
        Item MekExT1 = ExchangersItems.basicExchanger;
        Item MekExT2 = ExchangersItems.advancedExchanger;
        Item MekExT3 = ExchangersItems.eliteExchanger;
        Item EC1 = ExchangersItems.exchangerCoreT1;
        Item EC2 = ExchangersItems.exchangerCoreT2;
        Item EC3 = ExchangersItems.exchangerCoreT3;
        Item EIOEC1 = ExchangersItems.eioExchangerCoreT1;
        Item EIOEC2 = ExchangersItems.eioExchangerCoreT2;
        Item EIOEC3 = ExchangersItems.eioExchangerCoreT3;
        Item TEEC1 = ExchangersItems.teExchangerCoreT1;
        Item TEEC2 = ExchangersItems.teExchangerCoreT2;
        Item TEEC3 = ExchangersItems.teExchangerCoreT3;
        Item MekEC1 = ExchangersItems.mekanismExchangerCoreT1;
        Item MekEC2 = ExchangersItems.mekanismExchangerCoreT2;
        Item MekEC3 = ExchangersItems.mekanismExchangerCoreT3;
        ItemStack crystal1 = EnderIOIntegration.pulsatingCrystal;
        ItemStack crystal2 = EnderIOIntegration.vibrantCrystal;
        ItemStack crystal3 = EnderIOIntegration.enderCrystal;
        ItemStack cap1 = EnderIOIntegration.basicCapacitor;
        ItemStack cap2 = EnderIOIntegration.doubleLayerCapacitor;
        ItemStack cap3 = EnderIOIntegration.octadicCapacitor;
        ItemStack capBank1 = EnderIOIntegration.capacitorBankBasic;
        ItemStack capBank2 = EnderIOIntegration.capacitorBank;
        ItemStack capBank3 = EnderIOIntegration.capacitorBankVibrant;
        ItemStack servo = ThermalExpansionIntegration.redstoneServo;
        ItemStack coil1 = ThermalExpansionIntegration.redstoneReceptionCoil;
        ItemStack coil2 = ThermalExpansionIntegration.redstoneTransmissionCoil;
        ItemStack coil3 = ThermalExpansionIntegration.redstoneConductanceCoil;
        ItemStack fluxcap1 = ThermalExpansionIntegration.fluxCapacitorBasic;
        ItemStack fluxcap2 = ThermalExpansionIntegration.fluxCapacitorHardened;
        ItemStack fluxcap3 = ThermalExpansionIntegration.fluxCapacitorReinforced;
        ItemStack fluxcap4 = ThermalExpansionIntegration.fluxCapacitorSignalum;
        ItemStack fluxcap5 = ThermalExpansionIntegration.fluxCapacitorResonant;
        ItemStack circuit1 = MekanismIntegration.circuitBasic;
        ItemStack circuit2 = MekanismIntegration.circuitAdvanced;
        ItemStack circuit3 = MekanismIntegration.circuitElite;
        ItemStack circuit4 = MekanismIntegration.circuitUltimate;
        ItemStack tablet = MekanismIntegration.energyTablet;
        ItemStack teleCore = MekanismIntegration.teleportationCore;
        ItemStack teleporter = MekanismIntegration.portableTeleporter;
        ItemStack bucketNutrientDistillation = EnderIOIntegration.bucketNutrientDistillation;
        ItemStack bucketDewOfTheVoid = EnderIOIntegration.bucketDewOfTheVoid;
        ItemStack bucketVaporOfLevity = EnderIOIntegration.bucketVaporOfLevity;
        ItemStack bucketResonantEnder = ThermalExpansionIntegration.bucketResonantEnder;
        ItemStack bucketEnergizedGlowstone = ThermalExpansionIntegration.bucketEnergizedGlowstone;
        ItemStack bucketGelidCryotheum = ThermalExpansionIntegration.bucketGelidCryotheum;
        ItemStack eye = new ItemStack(Items.ENDER_EYE);
        ItemStack potato = new ItemStack(Items.POTATO);
        String pearl = "enderpearl";
        String red = "dyeRed";
        String lapis = "gemLapis";
        String diamond = "gemDiamond";
        String diamondBlock = "blockDiamond";
        String emerald = "gemEmerald";
        String iron = "ingotIron";
        String gold = "ingotGold";
        String goldNug = "nuggetGold";
        String obsidian = "obsidian";
        String stone = "stone";
        String wood = "logWood";
        String conductiveIron = "ingotConductiveIron";
        String pulsatingIron = "ingotPulsatingIron";
        String pulsatingIronNug = "nuggetPulsatingIron";
        String electricalSteel = "ingotElectricalSteel";
        String darkSteel = "ingotDarkSteel";
        String energeticAlloy = "ingotEnergeticAlloy";
        String vibrantAlloy = "ingotVibrantAlloy";
        String pulsatingPowder = "itemPulsatingPowder";
        String gearCopper = "gearCopper";
        String gearBronze = "gearBronze";
        String gearInvar = "gearInvar";
        String gearLumium = "gearLumium";
        String lead = "ingotLead";
        String invar = "ingotInvar";
        String electrum = "ingotElectrum";
        String signalum = "ingotSignalum";
        String enderium = "ingotEnderium";
        String alloy1 = "alloyAdvanced";
        String alloy2 = "alloyElite";
        String alloy3 = "alloyUltimate";
        String osmium = "ingotOsmium";
        String steel = "ingotSteel";
        String diamondDust = "dustDiamond";
        String refinedGlowstone = "ingotRefinedGlowstone";
        String refinedObsidianDust = "dustRefinedObsidian";

        if (Config.vanillaModule = true) {
            if (Config.vanillaProgressiveRecipes = true) {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.woodenExchanger, 1, 0), 3, 3,
                                new Object[]{wood, eye, wood, wood, EC1, wood, wood, eye, wood}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.stoneExchanger, 1, 0), 3, 3,
                                new Object[]{stone, eye, stone, EC1, ExT1, EC1, stone, eye, stone}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.goldenExchanger, 1, 0), 3, 3,
                                new Object[]{gold, eye, gold, EC2, ExT2, EC2, gold, eye, gold}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.ironExchanger, 1, 0), 3, 3,
                                new Object[]{iron, eye, iron, EC2, ExT3, EC2, iron, eye, iron}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.diamondExchanger, 1, 0), 3, 3,
                                new Object[]{diamond, eye, diamond, EC3, ExT4, EC3, diamond, eye, diamond}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.emeraldExchanger, 1, 0), 3, 3,
                                new Object[]{emerald, eye, emerald, EC3, ExT5, EC3, emerald, eye, emerald}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.obsidianExchanger, 1, 0), 3, 3,
                                new Object[]{obsidian, eye, obsidian, EC3, ExT6, EC3, obsidian, eye, obsidian}));
            }
            else {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.woodenExchanger, 1, 0), 3, 3,
                                new Object[]{wood, eye, wood, wood, EC1, wood, wood, eye, wood}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.stoneExchanger, 1, 0), 3, 3,
                                new Object[]{stone, eye, stone, stone, EC1, stone, stone, eye, stone}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.goldenExchanger, 1, 0), 3, 3,
                                new Object[]{gold, eye, gold, gold, EC2, gold, gold, eye, gold}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.ironExchanger, 1, 0), 3, 3,
                                new Object[]{iron, eye, iron, iron, EC2, iron, iron, eye, iron}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.diamondExchanger, 1, 0), 3, 3,
                                new Object[]{diamond, eye, diamond, diamond, EC3, diamond, diamond, eye, diamond}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.emeraldExchanger, 1, 0), 3, 3,
                                new Object[]{emerald, eye, emerald, emerald, EC3, emerald, emerald, eye, emerald}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.obsidianExchanger, 1, 0), 3, 3,
                                new Object[]{obsidian, eye, obsidian, obsidian, EC3, obsidian, obsidian, eye, obsidian}));
            }
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.exchangerCoreT1, 1, 0), 3, 3,
                            new Object[]{wood, red, wood, red, pearl, red, wood, red, wood}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.exchangerCoreT2, 1, 0), 3, 3,
                            new Object[]{iron, lapis, iron, EC1, eye, EC1, iron, lapis, iron}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.exchangerCoreT3, 1, 0), 3, 3,
                            new Object[]{diamond, EC2, emerald, EC2, diamondBlock, EC2, emerald, EC2, diamond}));
        }
        if (Config.specialModule = true) {
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.tuberousExchanger, 1, 0), 3, 3,
                            new Object[]{potato, goldNug, potato, potato, pearl, potato, potato, goldNug, potato}));
        }
        if ((Config.enderIOModule = true) && (Loader.isModLoaded("enderio"))) {
            if (Config.enderIOProgressiveRecipes = true) {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.conductiveIronExchanger, 1, 0), 3, 3,
                                new Object[]{conductiveIron, cap1, conductiveIron, conductiveIron, EIOEC1, conductiveIron, conductiveIron, cap1, conductiveIron}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.pulsatingIronExchanger, 1, 0), 3, 3,
                                new Object[]{pulsatingIron, crystal1, pulsatingIron, EIOEC1, EIOExT1, EIOEC1, pulsatingIron, cap1, pulsatingIron}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.electricalSteelExchanger, 1, 0), 3, 3,
                                new Object[]{electricalSteel, cap2, electricalSteel, EIOEC2, EIOExT2, EIOEC2, electricalSteel, capBank1, electricalSteel}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.energeticExchanger, 1, 0), 3, 3,
                                new Object[]{energeticAlloy, cap2, energeticAlloy, EIOEC2, EIOExT3, EIOEC2, energeticAlloy, capBank2, energeticAlloy}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.darkSteelExchanger, 1, 0), 3, 3,
                                new Object[]{darkSteel, crystal2, darkSteel, EIOEC3, EIOExT4, EIOEC3, darkSteel, cap3, darkSteel}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.vibrantExchanger, 1, 0), 3, 3,
                                new Object[]{vibrantAlloy, crystal3, vibrantAlloy, EIOEC3, EIOExT5, EIOEC3, vibrantAlloy, capBank3, vibrantAlloy}));
            }
            else {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.conductiveIronExchanger, 1, 0), 3, 3,
                                new Object[]{conductiveIron, cap1, conductiveIron, conductiveIron, EIOEC1, conductiveIron, conductiveIron, cap1, conductiveIron}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.pulsatingIronExchanger, 1, 0), 3, 3,
                                new Object[]{pulsatingIron, crystal1, pulsatingIron, pulsatingIron, EIOEC1, pulsatingIron, pulsatingIron, cap1, pulsatingIron}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.electricalSteelExchanger, 1, 0), 3, 3,
                                new Object[]{electricalSteel, cap2, electricalSteel, electricalSteel, EIOEC2, electricalSteel, electricalSteel, capBank1, electricalSteel}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.energeticExchanger, 1, 0), 3, 3,
                                new Object[]{energeticAlloy, cap2, energeticAlloy, energeticAlloy, EIOEC2, energeticAlloy, energeticAlloy, capBank2, energeticAlloy}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.darkSteelExchanger, 1, 0), 3, 3,
                                new Object[]{darkSteel, crystal2, darkSteel, darkSteel, EIOEC3, darkSteel, darkSteel, cap3, darkSteel}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.vibrantExchanger, 1, 0), 3, 3,
                                new Object[]{vibrantAlloy, crystal3, vibrantAlloy, vibrantAlloy, EIOEC3, vibrantAlloy, vibrantAlloy, capBank3, vibrantAlloy}));
            }
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.eioExchangerCoreT1, 1, 0), 3, 3,
                            new Object[]{pulsatingIronNug, conductiveIron, pulsatingIronNug, conductiveIron, bucketNutrientDistillation, conductiveIron, pulsatingIronNug, conductiveIron, pulsatingIronNug}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.eioExchangerCoreT2, 1, 0), 3, 3,
                            new Object[]{pulsatingPowder, electricalSteel, pulsatingPowder, EIOEC1, bucketDewOfTheVoid, EIOEC1, pulsatingPowder, electricalSteel, pulsatingPowder}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.eioExchangerCoreT3, 1, 0), 3, 3,
                            new Object[]{darkSteel, EIOEC2, darkSteel, EIOEC2, bucketVaporOfLevity, EIOEC2, darkSteel, EIOEC2, darkSteel}));
        }
        if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded("thermalexpansion"))) {
            if (Config.thermalExpansionProgressiveRecipes = true) {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.leadstoneExchanger, 1, 0), 3, 3,
                                new Object[]{lead, servo, lead, lead, TEEC1, lead, lead, fluxcap1, lead}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.hardenedExchanger, 1, 0), 3, 3,
                                new Object[]{invar, coil1, invar, TEEC1, TEExT1, TEEC1, invar, fluxcap2, invar}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.reinforcedExchanger, 1, 0), 3, 3,
                                new Object[]{electrum, coil2, electrum, TEEC2, TEExT2, TEEC2, electrum, fluxcap3, electrum}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.signalumExchanger, 1, 0), 3, 3,
                                new Object[]{signalum, coil3, signalum, TEEC3, TEExT3, TEEC3, signalum, fluxcap4, signalum}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.resonantExchanger, 1, 0), 3, 3,
                                new Object[]{enderium, coil3, enderium, TEEC3, TEExT4, TEEC3, enderium, fluxcap5, enderium}));
            }
            else {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.leadstoneExchanger, 1, 0), 3, 3,
                                new Object[]{lead, servo, lead, lead, TEEC1, lead, lead, fluxcap1, lead}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.hardenedExchanger, 1, 0), 3, 3,
                                new Object[]{invar, coil1, invar, invar, TEEC1, invar, invar, fluxcap2, invar}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.reinforcedExchanger, 1, 0), 3, 3,
                                new Object[]{electrum, coil2, electrum, electrum, TEEC2, electrum, electrum, fluxcap3, electrum}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.signalumExchanger, 1, 0), 3, 3,
                                new Object[]{signalum, coil3, signalum, signalum, TEEC3, signalum, signalum, fluxcap4, signalum}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.resonantExchanger, 1, 0), 3, 3,
                                new Object[]{enderium, coil3, enderium, enderium, TEEC3, enderium, enderium, fluxcap5, enderium}));
            }
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.teExchangerCoreT1, 1, 0), 3, 3,
                            new Object[]{gearCopper, lead, gearCopper, lead, bucketResonantEnder, lead, gearCopper, lead, gearCopper}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.teExchangerCoreT2, 1, 0), 3, 3,
                            new Object[]{gearBronze, gearInvar, gearBronze, TEEC1, bucketEnergizedGlowstone, TEEC1, gearBronze, gearInvar, gearBronze}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.teExchangerCoreT3, 1, 0), 3, 3,
                            new Object[]{gearLumium, TEEC2, gearLumium, TEEC2, bucketGelidCryotheum, TEEC2, gearLumium, TEEC2, gearLumium}));
        }
        if ((Config.mekanismModule = true) && (Loader.isModLoaded("mekanism"))) {
            if (Config.mekanismProgressiveRecipes = true) {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.basicExchanger, 1, 0), 3, 3,
                                new Object[]{circuit1, tablet, circuit1, circuit1, MekEC1, circuit1, circuit1, tablet, circuit1}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.advancedExchanger, 1, 0), 3, 3,
                                new Object[]{circuit2, tablet, circuit2, MekEC2, MekExT1, MekEC2, circuit2, tablet, circuit2}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.eliteExchanger, 1, 0), 3, 3,
                                new Object[]{circuit3, teleCore, circuit3, MekEC3, MekExT2, MekEC3, circuit3, tablet, circuit3}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.ultimateExchanger, 1, 0), 3, 3,
                                new Object[]{circuit4, teleporter, circuit4, MekEC3, MekExT3, MekEC3, circuit4, teleporter, circuit4}));
            }
            else {
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.basicExchanger, 1, 0), 3, 3,
                                new Object[]{circuit1, tablet, circuit1, circuit1, MekEC1, circuit1, circuit1, tablet, circuit1}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.advancedExchanger, 1, 0), 3, 3,
                                new Object[]{circuit2, tablet, circuit2, circuit2, MekEC2, circuit2, circuit2, tablet, circuit2}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.eliteExchanger, 1, 0), 3, 3,
                                new Object[]{circuit3, teleCore, circuit3, circuit3, MekEC3, circuit3, circuit3, tablet, circuit3}));
                CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                        RecipeHelper.getShaped(new ItemStack(ExchangersItems.ultimateExchanger, 1, 0), 3, 3,
                                new Object[]{circuit4, teleporter, circuit4, circuit4, MekEC3, circuit4, circuit4, teleporter, circuit4}));
            }
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.mekanismExchangerCoreT1, 1, 0), 3, 3,
                            new Object[]{osmium, steel, osmium, steel, alloy1, steel, osmium, steel, osmium}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.mekanismExchangerCoreT2, 1, 0), 3, 3,
                            new Object[]{diamondDust, refinedGlowstone, diamondDust, MekEC1, alloy2, MekEC1, diamondDust, refinedGlowstone, diamondDust}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.mekanismExchangerCoreT3, 1, 0), 3, 3,
                            new Object[]{refinedObsidianDust, MekEC2, refinedObsidianDust, MekEC2, alloy3, MekEC2, refinedObsidianDust, MekEC2, refinedObsidianDust}));
        }
    }

}
