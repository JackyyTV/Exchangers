package jackyy.exchangers;

import jackyy.exchangers.integration.EnderIOIntegration;
import jackyy.exchangers.integration.ImmersiveEngineeringIntegration;
import jackyy.exchangers.integration.MekanismIntegration;
import jackyy.exchangers.integration.ThermalExpansionIntegration;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import javax.annotation.Nonnull;

public class Recipes {

    public static void init(RegistryEvent.Register<IRecipe> e) {

        if (Config.enderIOModule) {
            if (Loader.isModLoaded(Exchangers.EIO)) {
                EnderIOIntegration.init();
            }
        }
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                ThermalExpansionIntegration.init();
            }
        }
        if (Config.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
                MekanismIntegration.init();
            }
        }
        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                ImmersiveEngineeringIntegration.init();
            }
        }

        if (Config.vanillaModule) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Exchangers.MODID + ":wooden_exchanger"), null, new ItemStack(ExchangersItems.woodenExchanger),
                    "WEW", "WCW", "WEW", 'W', "logWood",
                    'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1
            );
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier1"), null, new ItemStack(ExchangersItems.exchangerCoreT1),
                    "WRW", "RPR", "WRW",
                    'R', "dyeRed", 'W', "logWood", 'P', "enderpearl"
            );
            switch (Config.vanillaRecipesType) {
                case "easy": {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":stone_exchanger_easy"), null, new ItemStack(ExchangersItems.stoneExchanger),
                            "SES", "SCS", "SES",
                            'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":golden_exchanger_easy"), null, new ItemStack(ExchangersItems.goldenExchanger),
                            "GEG", "GCG", "GEG",
                            'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":iron_exchanger_easy"), null, new ItemStack(ExchangersItems.ironExchanger),
                            "IEI", "ICI", "IEI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":diamond_exchanger_easy"), null, new ItemStack(ExchangersItems.diamondExchanger),
                            "DED", "DCD", "DED",
                            'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":emerald_exchanger_easy"), null, new ItemStack(ExchangersItems.emeraldExchanger),
                            "MEM", "MCM", "MEM",
                            'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":obsidian_exchanger_easy"), null, new ItemStack(ExchangersItems.obsidianExchanger),
                            "OEO", "OCO", "OEO",
                            'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier2_easy"), null, new ItemStack(ExchangersItems.exchangerCoreT2),
                            "ILI", "LEL", "ILI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis"
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier3_easy"), null, new ItemStack(ExchangersItems.exchangerCoreT3),
                            "DED", "EBE", "DED",
                            'D', "gemDiamond", 'E', "gemEmerald", 'B', "blockDiamond"
                    );
                    break;
                }
                case "normal": {
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":stone_exchanger_normal"), new ItemStack(ExchangersItems.stoneExchanger), new ItemStack(ExchangersItems.woodenExchanger),
                            "SCS", "EXE", "SSS",
                            'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1, 'X', ExchangersItems.woodenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":golden_exchanger_normal"), new ItemStack(ExchangersItems.goldenExchanger), new ItemStack(ExchangersItems.stoneExchanger),
                            "GCG", "EXE", "GGG",
                            'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.stoneExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":iron_exchanger_normal"), new ItemStack(ExchangersItems.ironExchanger), new ItemStack(ExchangersItems.goldenExchanger),
                            "ICI", "EXE", "III",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.goldenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":diamond_exchanger_normal"), new ItemStack(ExchangersItems.diamondExchanger), new ItemStack(ExchangersItems.ironExchanger),
                            "DCD", "EXE", "DDD",
                            'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.ironExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":emerald_exchanger_normal"), new ItemStack(ExchangersItems.emeraldExchanger), new ItemStack(ExchangersItems.diamondExchanger),
                            "MCM", "EXE", "MMM",
                            'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.diamondExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":obsidian_exchanger_normal"), new ItemStack(ExchangersItems.obsidianExchanger), new ItemStack(ExchangersItems.emeraldExchanger),
                            "OCO", "EXE", "OOO",
                            'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.emeraldExchanger
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier2_normal"), null, new ItemStack(ExchangersItems.exchangerCoreT2),
                            "ILI", "ECE", "ILI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier3_normal"), null, new ItemStack(ExchangersItems.exchangerCoreT3),
                            "DED", "BCB", "DED",
                            'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'B', "blockDiamond"
                    );
                    break;
                }
                case "hard": {
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":stone_exchanger_hard"), new ItemStack(ExchangersItems.stoneExchanger), new ItemStack(ExchangersItems.woodenExchanger),
                            "SES", "CXC", "SES",
                            'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1, 'X', ExchangersItems.woodenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":golden_exchanger_hard"), new ItemStack(ExchangersItems.goldenExchanger), new ItemStack(ExchangersItems.stoneExchanger),
                            "GEG", "CXC", "GEG",
                            'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.stoneExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":iron_exchanger_hard"), new ItemStack(ExchangersItems.ironExchanger), new ItemStack(ExchangersItems.goldenExchanger),
                            "IEI", "CXC", "IEI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT2, 'X', ExchangersItems.goldenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":diamond_exchanger_hard"), new ItemStack(ExchangersItems.diamondExchanger), new ItemStack(ExchangersItems.ironExchanger),
                            "DED", "CXC", "DED",
                            'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.ironExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":emerald_exchanger_hard"), new ItemStack(ExchangersItems.emeraldExchanger), new ItemStack(ExchangersItems.diamondExchanger),
                            "MEM", "CXC", "MEM",
                            'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.diamondExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":obsidian_exchanger_hard"), new ItemStack(ExchangersItems.obsidianExchanger), new ItemStack(ExchangersItems.emeraldExchanger),
                            "OEO", "CXC", "OEO",
                            'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT3, 'X', ExchangersItems.emeraldExchanger
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier2_hard"), null, new ItemStack(ExchangersItems.exchangerCoreT2),
                            "ILI", "CEC", "ILI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier3_hard"), null, new ItemStack(ExchangersItems.exchangerCoreT3),
                            "DCE", "CBC", "ECD",
                            'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'B', "blockDiamond"
                    );
                    break;
                }
            }
        }

        if (Config.enderIOModule) {
            if (Loader.isModLoaded(Exchangers.EIO)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":conductive_exchanger"), null, new ItemStack(ExchangersItems.conductiveIronExchanger),
                        "IBI", "ICI", "IBI",
                        'I', "ingotConductiveIron", 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":eio_core_tier1"), null, new ItemStack(ExchangersItems.eioExchangerCoreT1),
                        "PCP", "CNC", "PCP",
                        'P', "nuggetPulsatingIron", 'C', "ingotConductiveIron", 'N', EnderIOIntegration.bucketNutrientDistillation
                );
                switch (Config.enderIORecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":pulsating_exchanger_easy"), null, new ItemStack(ExchangersItems.pulsatingIronExchanger),
                                "IPI", "ICI", "IBI",
                                'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":electricalsteel_exchanger_easy"), null, new ItemStack(ExchangersItems.electricalSteelExchanger),
                                "SDS", "SCS", "SBS",
                                'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":energetic_exchanger_easy"), null, new ItemStack(ExchangersItems.energeticExchanger),
                                "ADA", "ACA", "ABA",
                                'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":darksteel_exchanger_easy"), null, new ItemStack(ExchangersItems.darkSteelExchanger),
                                "SVS", "SCS", "SOS",
                                'S', "ingotDarkSteel", 'B', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":vibrant_exchanger_easy"), null, new ItemStack(ExchangersItems.vibrantExchanger),
                                "AEA", "ACA", "ABA",
                                'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier2_easy"), null, new ItemStack(ExchangersItems.eioExchangerCoreT2),
                                "PSP", "SDS", "PSP",
                                'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier3_easy"), null, new ItemStack(ExchangersItems.eioExchangerCoreT3),
                                "DBD", "BVB", "DBD",
                                'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":pulsating_exchanger_normal"), new ItemStack(ExchangersItems.pulsatingIronExchanger), new ItemStack(ExchangersItems.conductiveIronExchanger),
                                "ICI", "PXP", "IBI",
                                'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1, 'X', ExchangersItems.conductiveIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":electricalsteel_exchanger_normal"), new ItemStack(ExchangersItems.electricalSteelExchanger), new ItemStack(ExchangersItems.pulsatingIronExchanger),
                                "SCS", "DXD", "SBS",
                                'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.pulsatingIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":energetic_exchanger_normal"), new ItemStack(ExchangersItems.energeticExchanger), new ItemStack(ExchangersItems.electricalSteelExchanger),
                                "ACA", "DXD", "ABA",
                                'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.electricalSteelExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":darksteel_exchanger_normal"), new ItemStack(ExchangersItems.darkSteelExchanger), new ItemStack(ExchangersItems.energeticExchanger),
                                "SCS", "VXV", "SOS",
                                'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.energeticExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":vibrant_exchanger_normal"), new ItemStack(ExchangersItems.vibrantExchanger), new ItemStack(ExchangersItems.darkSteelExchanger),
                                "ACA", "EXE", "ABA",
                                'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.darkSteelExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier2_normal"), null, new ItemStack(ExchangersItems.eioExchangerCoreT2),
                                "PSP", "DCD", "PSP",
                                'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ExchangersItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier3_normal"), null, new ItemStack(ExchangersItems.eioExchangerCoreT3),
                                "DBD", "VCV", "DBD",
                                'C', ExchangersItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":pulsating_exchanger_hard"), new ItemStack(ExchangersItems.pulsatingIronExchanger), new ItemStack(ExchangersItems.conductiveIronExchanger),
                                "IPI", "CXC", "IBI",
                                'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ExchangersItems.eioExchangerCoreT1, 'X', ExchangersItems.conductiveIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":electricalsteel_exchanger_hard"), new ItemStack(ExchangersItems.electricalSteelExchanger), new ItemStack(ExchangersItems.pulsatingIronExchanger),
                                "SDS", "CXC", "SBS",
                                'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.pulsatingIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":energetic_exchanger_hard"), new ItemStack(ExchangersItems.energeticExchanger), new ItemStack(ExchangersItems.electricalSteelExchanger),
                                "ADA", "CXC", "ABA",
                                'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ExchangersItems.eioExchangerCoreT2, 'X', ExchangersItems.electricalSteelExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":darksteel_exchanger_hard"), new ItemStack(ExchangersItems.darkSteelExchanger), new ItemStack(ExchangersItems.energeticExchanger),
                                "SVS", "CXC", "SOS",
                                'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.energeticExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":vibrant_exchanger_hard"), new ItemStack(ExchangersItems.vibrantExchanger), new ItemStack(ExchangersItems.darkSteelExchanger),
                                "AEA", "CXC", "ABA",
                                'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ExchangersItems.eioExchangerCoreT3, 'X', ExchangersItems.darkSteelExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier2_hard"), null, new ItemStack(ExchangersItems.eioExchangerCoreT2),
                                "PSP", "CDC", "PSP",
                                'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ExchangersItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier3_hard"), null, new ItemStack(ExchangersItems.eioExchangerCoreT3),
                                "DCD", "CVC", "DCD",
                                'C', ExchangersItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                }
            }
        }

        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":leadstone_exchanger"), null, new ItemStack(ExchangersItems.leadstoneExchanger),
                        "LSL", "LCL", "LFL",
                        'L', "ingotLead", 'S', ThermalExpansionIntegration.redstoneServo, 'F', ThermalExpansionIntegration.fluxCapacitorBasic, 'C', ExchangersItems.teExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":te_core_tier1"), null, new ItemStack(ExchangersItems.teExchangerCoreT1),
                        "CLC", "LRL", "CLC",
                        'C', "gearCopper", 'L', "ingotLead", 'R', ThermalExpansionIntegration.bucketResonantEnder
                );
                switch (Config.thermalExpansionRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":hardened_exchanger_easy"), null, new ItemStack(ExchangersItems.hardenedExchanger),
                                "IRI", "ICI", "IFI",
                                'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":reinforced_exchanger_easy"), null, new ItemStack(ExchangersItems.reinforcedExchanger),
                                "ERE", "ECE", "EFE",
                                'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":signalum_exchanger_easy"), null, new ItemStack(ExchangersItems.signalumExchanger),
                                "SRS", "SCS", "SFS",
                                'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":resonant_exchanger_easy"), null, new ItemStack(ExchangersItems.resonantExchanger),
                                "IRI", "ICI", "IFI",
                                'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier2_easy"), null, new ItemStack(ExchangersItems.teExchangerCoreT2),
                                "BIB", "IGI", "BIB",
                                'B', "gearBronze", 'I', "gearInvar", 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier3_easy"), null, new ItemStack(ExchangersItems.teExchangerCoreT3),
                                "LSL", "SGS", "LSL",
                                'S', "gearSignalum", 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hardened_exchanger_normal"), new ItemStack(ExchangersItems.hardenedExchanger), new ItemStack(ExchangersItems.leadstoneExchanger),
                                "ICI", "RXR", "IFI",
                                'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1, 'X', ExchangersItems.leadstoneExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":reinforced_exchanger_normal"), new ItemStack(ExchangersItems.reinforcedExchanger), new ItemStack(ExchangersItems.hardenedExchanger),
                                "ECE", "RXR", "EFE",
                                'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2, 'X', ExchangersItems.hardenedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":signalum_exchanger_normal"), new ItemStack(ExchangersItems.signalumExchanger), new ItemStack(ExchangersItems.reinforcedExchanger),
                                "SCS", "RXR", "SFS",
                                'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.reinforcedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":resonant_exchanger_normal"), new ItemStack(ExchangersItems.resonantExchanger), new ItemStack(ExchangersItems.signalumExchanger),
                                "ICI", "RXR", "IFI",
                                'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.signalumExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier2_normal"), null, new ItemStack(ExchangersItems.teExchangerCoreT2),
                                "BIB", "GCG", "BIB",
                                'B', "gearBronze", 'I', "gearInvar", 'C', ExchangersItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier3_normal"), null, new ItemStack(ExchangersItems.teExchangerCoreT3),
                                "LSL", "GCG", "LSL",
                                'C', ExchangersItems.teExchangerCoreT2, 'L', "gearLumium", 'S', "gearSignalum", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hardened_exchanger_hard"), new ItemStack(ExchangersItems.hardenedExchanger), new ItemStack(ExchangersItems.leadstoneExchanger),
                                "IRI", "CXC", "IFI",
                                'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ExchangersItems.teExchangerCoreT1, 'X', ExchangersItems.leadstoneExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":reinforced_exchanger_hard"), new ItemStack(ExchangersItems.reinforcedExchanger), new ItemStack(ExchangersItems.hardenedExchanger),
                                "ERE", "CXC", "EFE",
                                'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ExchangersItems.teExchangerCoreT2, 'X', ExchangersItems.hardenedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":signalum_exchanger_hard"), new ItemStack(ExchangersItems.signalumExchanger), new ItemStack(ExchangersItems.reinforcedExchanger),
                                "SRS", "CXC", "SFS",
                                'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.reinforcedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":resonant_exchanger_hard"), new ItemStack(ExchangersItems.resonantExchanger), new ItemStack(ExchangersItems.signalumExchanger),
                                "IRI", "CXC", "IFI",
                                'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ExchangersItems.teExchangerCoreT3, 'X', ExchangersItems.signalumExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier2_hard"), null, new ItemStack(ExchangersItems.teExchangerCoreT2),
                                "BIB", "CGC", "BIB",
                                'B', "gearBronze", 'I', "gearInvar", 'C', ExchangersItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier3_hard"), null, new ItemStack(ExchangersItems.teExchangerCoreT3),
                                "LCL", "CGC", "LCL",
                                'C', ExchangersItems.teExchangerCoreT2, 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                }
            }
        }

        if (Config.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":basic_exchanger"), null, new ItemStack(ExchangersItems.basicExchanger),
                        "BTB", "BCB", "BTB",
                        'B', MekanismIntegration.circuitBasic, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":mek_core_tier1"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT1),
                        "OSO", "SAS", "OSO",
                        'O', "ingotOsmium", 'S', "ingotSteel", 'A', "alloyAdvanced"
                );
                switch (Config.mekanismRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":advanced_exchanger_easy"), null, new ItemStack(ExchangersItems.advancedExchanger),
                                "ATA", "ACA", "ATA",
                                'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":elite_exchanger_easy"), null, new ItemStack(ExchangersItems.eliteExchanger),
                                "EPE", "ECE", "ETE",
                                'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ultimate_exchanger_easy"), null, new ItemStack(ExchangersItems.ultimateExchanger),
                                "UTU", "UCU", "UTU",
                                'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier2_easy"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT2),
                                "DGD", "GAG", "DGD",
                                'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier3_easy"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT3),
                                "OIO", "IAI", "OIO",
                                'O', "dustRefinedObsidian", 'I', "ingotRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":advanced_exchanger_normal"), new ItemStack(ExchangersItems.advancedExchanger), new ItemStack(ExchangersItems.basicExchanger),
                                "ACA", "TXT", "AAA",
                                'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2, 'X', ExchangersItems.basicExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":elite_exchanger_normal"), new ItemStack(ExchangersItems.eliteExchanger), new ItemStack(ExchangersItems.advancedExchanger),
                                "ECE", "TXT", "EPE",
                                'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.advancedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":ultimate_exchanger_normal"), new ItemStack(ExchangersItems.ultimateExchanger), new ItemStack(ExchangersItems.eliteExchanger),
                                "UCU", "TXT", "UUU",
                                'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.eliteExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier2_normal"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT2),
                                "DGD", "ACA", "DGD",
                                'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ExchangersItems.mekanismExchangerCoreT1, 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier3_normal"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT3),
                                "OAO", "ACA", "OAO",
                                'C', ExchangersItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":advanced_exchanger_hard"), new ItemStack(ExchangersItems.advancedExchanger), new ItemStack(ExchangersItems.basicExchanger),
                                "ATA", "CXC", "ATA",
                                'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT2, 'X', ExchangersItems.basicExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":elite_exchanger_hard"), new ItemStack(ExchangersItems.eliteExchanger), new ItemStack(ExchangersItems.advancedExchanger),
                                "EPE", "CXC", "ETE",
                                'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.advancedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":ultimate_exchanger_hard"), new ItemStack(ExchangersItems.ultimateExchanger), new ItemStack(ExchangersItems.eliteExchanger),
                                "UTU", "CXC", "UTU",
                                'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ExchangersItems.mekanismExchangerCoreT3, 'X', ExchangersItems.eliteExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier2_hard"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT2),
                                "DGD", "CAC", "DGD",
                                'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ExchangersItems.mekanismExchangerCoreT1, 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier3_hard"), null, new ItemStack(ExchangersItems.mekanismExchangerCoreT3),
                                "OCO", "CAC", "OCO",
                                'C', ExchangersItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                }
            }
        }

        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":lv_exchanger"), null, new ItemStack(ExchangersItems.lvExchanger),
                        "SLS", "SCS", "SLS",
                        'S', "blockSheetmetalCopper", 'L', ImmersiveEngineeringIntegration.lvCapacitor, 'C', ExchangersItems.ieExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":ie_core_tier1"), null, new ItemStack(ExchangersItems.ieExchangerCoreT1),
                        "CIC", "IBI", "CIC",
                        'C', ImmersiveEngineeringIntegration.lvWireCoil, 'I', ImmersiveEngineeringIntegration.ironMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketCreosote
                );
                switch (Config.immersiveEngineeringRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mv_exchanger_easy"), null, new ItemStack(ExchangersItems.mvExchanger),
                                "SMS", "SCS", "SMS",
                                'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ExchangersItems.ieExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":hv_exchanger_easy"), null, new ItemStack(ExchangersItems.hvExchanger),
                                "SHS", "SCS", "SHS",
                                'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier2_easy"), null, new ItemStack(ExchangersItems.ieExchangerCoreT2),
                                "ESE", "SBS", "ESE",
                                'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier3_easy"), null, new ItemStack(ExchangersItems.ieExchangerCoreT3),
                                "SHS", "HBH", "SHS",
                                'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":mv_exchanger_normal"), new ItemStack(ExchangersItems.mvExchanger), new ItemStack(ExchangersItems.lvExchanger),
                                "SCS", "MXM", "SSS",
                                'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ExchangersItems.ieExchangerCoreT2, 'X', ExchangersItems.lvExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hv_exchanger_normal"), new ItemStack(ExchangersItems.hvExchanger), new ItemStack(ExchangersItems.mvExchanger),
                                "SCS", "HXH", "SSS",
                                'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3, 'X', ExchangersItems.mvExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier2_normal"), null, new ItemStack(ExchangersItems.ieExchangerCoreT2),
                                "ESE", "BCB", "ESE",
                                'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', ExchangersItems.ieExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier3_normal"), null, new ItemStack(ExchangersItems.ieExchangerCoreT3),
                                "SHS", "BCB", "SHS",
                                'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', ExchangersItems.ieExchangerCoreT2
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":mv_exchanger_hard"), new ItemStack(ExchangersItems.mvExchanger), new ItemStack(ExchangersItems.lvExchanger),
                                "SMS", "CXC", "SMS",
                                'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3, 'X', ExchangersItems.lvExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hv_exchanger_hard"), new ItemStack(ExchangersItems.hvExchanger), new ItemStack(ExchangersItems.mvExchanger),
                                "SHS", "CXC", "SHS",
                                'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ExchangersItems.ieExchangerCoreT3, 'X', ExchangersItems.mvExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier2_hard"), null, new ItemStack(ExchangersItems.ieExchangerCoreT2),
                                "ESE", "CBC", "ESE",
                                'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', ExchangersItems.ieExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier3_hard"), null, new ItemStack(ExchangersItems.ieExchangerCoreT3),
                                "HCS", "CBC", "SCH",
                                'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', ExchangersItems.ieExchangerCoreT2
                        );
                        break;
                    }
                }
            }
        }

        if (Config.specialModule) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Exchangers.MODID + ":tuberous_exchanger"), null, new ItemStack(ExchangersItems.tuberousExchanger),
                    "PGP", "PEP", "PGP",
                    'P', Items.POTATO, 'G', "nuggetGold", 'E', "enderpearl"
            );
        }

    }

    private static class ShapedCopyNBTRecipe extends ShapedOreRecipe {

        private final ItemStack nbtCopyStack;

        private ShapedCopyNBTRecipe(RegistryEvent.Register<IRecipe> e, ResourceLocation group, @Nonnull ItemStack result, ItemStack nbtCopyStack, Object... recipe) {
            super(group, result, recipe);
            this.nbtCopyStack = nbtCopyStack;

            e.getRegistry().register(this.setRegistryName(group));
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventory) {
            ItemStack stack = super.getCraftingResult(inventory);
            if (stack != ItemStack.EMPTY) {
                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack input = inventory.getStackInSlot(i);
                    if (this.nbtCopyStack.isItemEqual(input)) {
                        stack.setTagCompound(input.getTagCompound());
                        break;
                    }
                }
            }
            return stack;
        }

    }

}
