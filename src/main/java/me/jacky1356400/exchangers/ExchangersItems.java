package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.item.enderio.*;
import me.jacky1356400.exchangers.item.mekanism.ItemAdvancedExchanger;
import me.jacky1356400.exchangers.item.mekanism.ItemBasicExchanger;
import me.jacky1356400.exchangers.item.mekanism.ItemEliteExchanger;
import me.jacky1356400.exchangers.item.mekanism.ItemUltimateExchanger;
import me.jacky1356400.exchangers.item.thermalexpansion.*;
import me.jacky1356400.exchangers.item.vanilla.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExchangersItems {
    public static ItemWoodenExchanger woodenExchanger;
    public static ItemStoneExchanger stoneExchanger;
    public static ItemGoldenExchanger goldenExchanger;
    public static ItemIronExchanger ironExchanger;
    public static ItemDiamondExchanger diamondExchanger;
    public static ItemEmeraldExchanger emeraldExchanger;
    public static ItemObsidianExchanger obsidianExchanger;
    public static ItemTuberousExchanger tuberousExchanger;
    public static ItemExchangerCoreT1 exchangerCoreT1;
    public static ItemExchangerCoreT2 exchangerCoreT2;
    public static ItemExchangerCoreT3 exchangerCoreT3;

    public static ItemConductiveIronExchanger conductiveIronExchanger;
    public static ItemPulsatingIronExchanger pulsatingIronExchanger;
    public static ItemElectricalSteelExchanger electricalSteelExchanger;
    public static ItemEnergeticExchanger energeticExchanger;
    public static ItemDarkSteelExchanger darkSteelExchanger;
    public static ItemVibrantExchanger vibrantExchanger;

    public static ItemLeadstoneExchanger leadstoneExchanger;
    public static ItemHardenedExchanger hardenedExchanger;
    public static ItemReinforcedExchanger reinforcedExchanger;
    public static ItemSignalumExchanger signalumExchanger;
    public static ItemResonantExchanger resonantExchanger;

    public static ItemBasicExchanger basicExchanger;
    public static ItemAdvancedExchanger advancedExchanger;
    public static ItemEliteExchanger eliteExchanger;
    public static ItemUltimateExchanger ultimateExchanger;

    public static void init(){
        //Vanilla Exchangers
        woodenExchanger = GameRegistry.register(new ItemWoodenExchanger());
        stoneExchanger = GameRegistry.register(new ItemStoneExchanger());
        goldenExchanger = GameRegistry.register(new ItemGoldenExchanger());
        ironExchanger = GameRegistry.register(new ItemIronExchanger());
        diamondExchanger = GameRegistry.register(new ItemDiamondExchanger());
        emeraldExchanger = GameRegistry.register(new ItemEmeraldExchanger());
        obsidianExchanger = GameRegistry.register(new ItemObsidianExchanger());
        tuberousExchanger = GameRegistry.register(new ItemTuberousExchanger());
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
        //Thermal Expansion Exchangers
        leadstoneExchanger = GameRegistry.register(new ItemLeadstoneExchanger());
        hardenedExchanger = GameRegistry.register(new ItemHardenedExchanger());
        reinforcedExchanger = GameRegistry.register(new ItemReinforcedExchanger());
        signalumExchanger = GameRegistry.register(new ItemSignalumExchanger());
        resonantExchanger = GameRegistry.register(new ItemResonantExchanger());
        //Mekanism Exchangers
        basicExchanger = GameRegistry.register(new ItemBasicExchanger());
        advancedExchanger = GameRegistry.register(new ItemAdvancedExchanger());
        eliteExchanger = GameRegistry.register(new ItemEliteExchanger());
        ultimateExchanger = GameRegistry.register(new ItemUltimateExchanger());
    }

    public static void initModels(){
        //Vanilla Exchangers
        woodenExchanger.initModel();
        stoneExchanger.initModel();
        goldenExchanger.initModel();
        ironExchanger.initModel();
        diamondExchanger.initModel();
        emeraldExchanger.initModel();
        obsidianExchanger.initModel();
        tuberousExchanger.initModel();
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
        //Thermal Expansion Exchangers
        leadstoneExchanger.initModel();
        hardenedExchanger.initModel();
        reinforcedExchanger.initModel();
        signalumExchanger.initModel();
        resonantExchanger.initModel();
        //Mekanism Exchangers
        basicExchanger.initModel();
        advancedExchanger.initModel();
        eliteExchanger.initModel();
        ultimateExchanger.initModel();
    }

}
