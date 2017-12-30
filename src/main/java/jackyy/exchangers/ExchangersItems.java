package jackyy.exchangers;

import jackyy.exchangers.item.enderio.*;
import jackyy.exchangers.item.immersiveengineering.*;
import jackyy.exchangers.item.mekanism.*;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.exchangers.item.special.ItemTuberousExchanger;
import jackyy.exchangers.item.thermalexpansion.*;
import jackyy.exchangers.item.vanilla.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExchangersItems {

    public static ItemTuberousExchanger tuberousExchanger;
    public static ItemCreativeExchanger creativeExchanger;

    public static ItemWoodenExchanger woodenExchanger;
    public static ItemStoneExchanger stoneExchanger;
    public static ItemGoldenExchanger goldenExchanger;
    public static ItemIronExchanger ironExchanger;
    public static ItemDiamondExchanger diamondExchanger;
    public static ItemEmeraldExchanger emeraldExchanger;
    public static ItemObsidianExchanger obsidianExchanger;
    public static ItemExchangerCoreT1 exchangerCoreT1;
    public static ItemExchangerCoreT2 exchangerCoreT2;
    public static ItemExchangerCoreT3 exchangerCoreT3;

    public static ItemConductiveIronExchanger conductiveIronExchanger;
    public static ItemPulsatingIronExchanger pulsatingIronExchanger;
    public static ItemElectricalSteelExchanger electricalSteelExchanger;
    public static ItemEnergeticExchanger energeticExchanger;
    public static ItemDarkSteelExchanger darkSteelExchanger;
    public static ItemVibrantExchanger vibrantExchanger;
    public static ItemEIOExchangerCoreT1 eioExchangerCoreT1;
    public static ItemEIOExchangerCoreT2 eioExchangerCoreT2;
    public static ItemEIOExchangerCoreT3 eioExchangerCoreT3;

    public static ItemLeadstoneExchanger leadstoneExchanger;
    public static ItemHardenedExchanger hardenedExchanger;
    public static ItemReinforcedExchanger reinforcedExchanger;
    public static ItemSignalumExchanger signalumExchanger;
    public static ItemResonantExchanger resonantExchanger;
    public static ItemTEExchangerCoreT1 teExchangerCoreT1;
    public static ItemTEExchangerCoreT2 teExchangerCoreT2;
    public static ItemTEExchangerCoreT3 teExchangerCoreT3;

    public static ItemBasicExchanger basicExchanger;
    public static ItemAdvancedExchanger advancedExchanger;
    public static ItemEliteExchanger eliteExchanger;
    public static ItemUltimateExchanger ultimateExchanger;
    public static ItemMekanismExchangerCoreT1 mekanismExchangerCoreT1;
    public static ItemMekanismExchangerCoreT2 mekanismExchangerCoreT2;
    public static ItemMekanismExchangerCoreT3 mekanismExchangerCoreT3;

    public static ItemLVExchanger lvExchanger;
    public static ItemMVExchanger mvExchanger;
    public static ItemHVExchanger hvExchanger;
    public static ItemIEExchangerCoreT1 ieExchangerCoreT1;
    public static ItemIEExchangerCoreT2 ieExchangerCoreT2;
    public static ItemIEExchangerCoreT3 ieExchangerCoreT3;

    public static void init() {
        //Special Exchangers
        tuberousExchanger = GameRegistry.register(new ItemTuberousExchanger());
        creativeExchanger = GameRegistry.register(new ItemCreativeExchanger());
        //Vanilla Exchangers
        woodenExchanger = GameRegistry.register(new ItemWoodenExchanger());
        stoneExchanger = GameRegistry.register(new ItemStoneExchanger());
        goldenExchanger = GameRegistry.register(new ItemGoldenExchanger());
        ironExchanger = GameRegistry.register(new ItemIronExchanger());
        diamondExchanger = GameRegistry.register(new ItemDiamondExchanger());
        emeraldExchanger = GameRegistry.register(new ItemEmeraldExchanger());
        obsidianExchanger = GameRegistry.register(new ItemObsidianExchanger());
        exchangerCoreT1 = GameRegistry.register(new ItemExchangerCoreT1());
        exchangerCoreT2 = GameRegistry.register(new ItemExchangerCoreT2());
        exchangerCoreT3 = GameRegistry.register(new ItemExchangerCoreT3());
        //Ender IO Exchangers
        conductiveIronExchanger = GameRegistry.register(new ItemConductiveIronExchanger());
        pulsatingIronExchanger = GameRegistry.register(new ItemPulsatingIronExchanger());
        electricalSteelExchanger = GameRegistry.register(new ItemElectricalSteelExchanger());
        energeticExchanger = GameRegistry.register(new ItemEnergeticExchanger());
        darkSteelExchanger = GameRegistry.register(new ItemDarkSteelExchanger());
        vibrantExchanger = GameRegistry.register(new ItemVibrantExchanger());
        eioExchangerCoreT1 = GameRegistry.register(new ItemEIOExchangerCoreT1());
        eioExchangerCoreT2 = GameRegistry.register(new ItemEIOExchangerCoreT2());
        eioExchangerCoreT3 = GameRegistry.register(new ItemEIOExchangerCoreT3());
        //Thermal Expansion Exchangers
        leadstoneExchanger = GameRegistry.register(new ItemLeadstoneExchanger());
        hardenedExchanger = GameRegistry.register(new ItemHardenedExchanger());
        reinforcedExchanger = GameRegistry.register(new ItemReinforcedExchanger());
        signalumExchanger = GameRegistry.register(new ItemSignalumExchanger());
        resonantExchanger = GameRegistry.register(new ItemResonantExchanger());
        teExchangerCoreT1 = GameRegistry.register(new ItemTEExchangerCoreT1());
        teExchangerCoreT2 = GameRegistry.register(new ItemTEExchangerCoreT2());
        teExchangerCoreT3 = GameRegistry.register(new ItemTEExchangerCoreT3());
        //Mekanism Exchangers
        basicExchanger = GameRegistry.register(new ItemBasicExchanger());
        advancedExchanger = GameRegistry.register(new ItemAdvancedExchanger());
        eliteExchanger = GameRegistry.register(new ItemEliteExchanger());
        ultimateExchanger = GameRegistry.register(new ItemUltimateExchanger());
        mekanismExchangerCoreT1 = GameRegistry.register(new ItemMekanismExchangerCoreT1());
        mekanismExchangerCoreT2 = GameRegistry.register(new ItemMekanismExchangerCoreT2());
        mekanismExchangerCoreT3 = GameRegistry.register(new ItemMekanismExchangerCoreT3());
        //Immersive Engineering Exchangers
        lvExchanger = GameRegistry.register(new ItemLVExchanger());
        mvExchanger = GameRegistry.register(new ItemMVExchanger());
        hvExchanger = GameRegistry.register(new ItemHVExchanger());
        ieExchangerCoreT1 = GameRegistry.register(new ItemIEExchangerCoreT1());
        ieExchangerCoreT2 = GameRegistry.register(new ItemIEExchangerCoreT2());
        ieExchangerCoreT3 = GameRegistry.register(new ItemIEExchangerCoreT3());
    }

    public static void initModels() {
        //Special Exchangers
        tuberousExchanger.initModel();
        creativeExchanger.initModel();
        //Vanilla Exchangers
        woodenExchanger.initModel();
        stoneExchanger.initModel();
        goldenExchanger.initModel();
        ironExchanger.initModel();
        diamondExchanger.initModel();
        emeraldExchanger.initModel();
        obsidianExchanger.initModel();
        exchangerCoreT1.initModel();
        exchangerCoreT2.initModel();
        exchangerCoreT3.initModel();
        //Ender IO Exchangers
        conductiveIronExchanger.initModel();
        pulsatingIronExchanger.initModel();
        electricalSteelExchanger.initModel();
        energeticExchanger.initModel();
        darkSteelExchanger.initModel();
        vibrantExchanger.initModel();
        eioExchangerCoreT1.initModel();
        eioExchangerCoreT2.initModel();
        eioExchangerCoreT3.initModel();
        //Thermal Expansion Exchangers
        leadstoneExchanger.initModel();
        hardenedExchanger.initModel();
        reinforcedExchanger.initModel();
        signalumExchanger.initModel();
        resonantExchanger.initModel();
        teExchangerCoreT1.initModel();
        teExchangerCoreT2.initModel();
        teExchangerCoreT3.initModel();
        //Mekanism Exchangers
        basicExchanger.initModel();
        advancedExchanger.initModel();
        eliteExchanger.initModel();
        ultimateExchanger.initModel();
        mekanismExchangerCoreT1.initModel();
        mekanismExchangerCoreT2.initModel();
        mekanismExchangerCoreT3.initModel();
        //Immersive Engineering Exchangers
        lvExchanger.initModel();
        mvExchanger.initModel();
        hvExchanger.initModel();
        ieExchangerCoreT1.initModel();
        ieExchangerCoreT2.initModel();
        ieExchangerCoreT3.initModel();
    }

}
