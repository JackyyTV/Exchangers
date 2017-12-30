package jackyy.exchangers;

import jackyy.exchangers.item.enderio.*;
import jackyy.exchangers.item.immersiveengineering.*;
import jackyy.exchangers.item.mekanism.*;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.exchangers.item.special.ItemTuberousExchanger;
import jackyy.exchangers.item.thermalexpansion.*;
import jackyy.exchangers.item.vanilla.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class ExchangersItems {

    public static ItemTuberousExchanger tuberousExchanger = new ItemTuberousExchanger();
    public static ItemCreativeExchanger creativeExchanger = new ItemCreativeExchanger();

    public static ItemWoodenExchanger woodenExchanger = new ItemWoodenExchanger();
    public static ItemStoneExchanger stoneExchanger = new ItemStoneExchanger();
    public static ItemGoldenExchanger goldenExchanger = new ItemGoldenExchanger();
    public static ItemIronExchanger ironExchanger = new ItemIronExchanger();
    public static ItemDiamondExchanger diamondExchanger = new ItemDiamondExchanger();
    public static ItemEmeraldExchanger emeraldExchanger = new ItemEmeraldExchanger();
    public static ItemObsidianExchanger obsidianExchanger = new ItemObsidianExchanger();
    public static ItemExchangerCoreT1 exchangerCoreT1 = new ItemExchangerCoreT1();
    public static ItemExchangerCoreT2 exchangerCoreT2 = new ItemExchangerCoreT2();
    public static ItemExchangerCoreT3 exchangerCoreT3 = new ItemExchangerCoreT3();

    public static ItemConductiveIronExchanger conductiveIronExchanger = new ItemConductiveIronExchanger();
    public static ItemPulsatingIronExchanger pulsatingIronExchanger = new ItemPulsatingIronExchanger();
    public static ItemElectricalSteelExchanger electricalSteelExchanger = new ItemElectricalSteelExchanger();
    public static ItemEnergeticExchanger energeticExchanger = new ItemEnergeticExchanger();
    public static ItemDarkSteelExchanger darkSteelExchanger = new ItemDarkSteelExchanger();
    public static ItemVibrantExchanger vibrantExchanger = new ItemVibrantExchanger();
    public static ItemEIOExchangerCoreT1 eioExchangerCoreT1 = new ItemEIOExchangerCoreT1();
    public static ItemEIOExchangerCoreT2 eioExchangerCoreT2 = new ItemEIOExchangerCoreT2();
    public static ItemEIOExchangerCoreT3 eioExchangerCoreT3 = new ItemEIOExchangerCoreT3();

    public static ItemLeadstoneExchanger leadstoneExchanger = new ItemLeadstoneExchanger();
    public static ItemHardenedExchanger hardenedExchanger = new ItemHardenedExchanger();
    public static ItemReinforcedExchanger reinforcedExchanger = new ItemReinforcedExchanger();
    public static ItemSignalumExchanger signalumExchanger = new ItemSignalumExchanger();
    public static ItemResonantExchanger resonantExchanger = new ItemResonantExchanger();
    public static ItemTEExchangerCoreT1 teExchangerCoreT1 = new ItemTEExchangerCoreT1();
    public static ItemTEExchangerCoreT2 teExchangerCoreT2 = new ItemTEExchangerCoreT2();
    public static ItemTEExchangerCoreT3 teExchangerCoreT3 = new ItemTEExchangerCoreT3();

    public static ItemBasicExchanger basicExchanger = new ItemBasicExchanger();
    public static ItemAdvancedExchanger advancedExchanger = new ItemAdvancedExchanger();
    public static ItemEliteExchanger eliteExchanger = new ItemEliteExchanger();
    public static ItemUltimateExchanger ultimateExchanger = new ItemUltimateExchanger();
    public static ItemMekanismExchangerCoreT1 mekanismExchangerCoreT1 = new ItemMekanismExchangerCoreT1();
    public static ItemMekanismExchangerCoreT2 mekanismExchangerCoreT2 = new ItemMekanismExchangerCoreT2();
    public static ItemMekanismExchangerCoreT3 mekanismExchangerCoreT3 = new ItemMekanismExchangerCoreT3();

    public static ItemLVExchanger lvExchanger = new ItemLVExchanger();
    public static ItemMVExchanger mvExchanger = new ItemMVExchanger();
    public static ItemHVExchanger hvExchanger = new ItemHVExchanger();
    public static ItemIEExchangerCoreT1 ieExchangerCoreT1 = new ItemIEExchangerCoreT1();
    public static ItemIEExchangerCoreT2 ieExchangerCoreT2 = new ItemIEExchangerCoreT2();
    public static ItemIEExchangerCoreT3 ieExchangerCoreT3 = new ItemIEExchangerCoreT3();

    public static void init(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(
                //Special Exchangers
                tuberousExchanger,
                creativeExchanger,
                //Vanilla Exchangers
                woodenExchanger,
                stoneExchanger,
                goldenExchanger,
                ironExchanger,
                diamondExchanger,
                emeraldExchanger,
                obsidianExchanger,
                exchangerCoreT1,
                exchangerCoreT2,
                exchangerCoreT3,
                //Ender IO Exchangers
                conductiveIronExchanger,
                pulsatingIronExchanger,
                electricalSteelExchanger,
                energeticExchanger,
                darkSteelExchanger,
                vibrantExchanger,
                eioExchangerCoreT1,
                eioExchangerCoreT2,
                eioExchangerCoreT3,
                //Thermal Expansion Exchangers
                leadstoneExchanger,
                hardenedExchanger,
                reinforcedExchanger,
                signalumExchanger,
                resonantExchanger,
                teExchangerCoreT1,
                teExchangerCoreT2,
                teExchangerCoreT3,
                //Mekanism Exchangers
                basicExchanger,
                advancedExchanger,
                eliteExchanger,
                ultimateExchanger,
                mekanismExchangerCoreT1,
                mekanismExchangerCoreT2,
                mekanismExchangerCoreT3,
                //Immersive Engineering Exchangers
                lvExchanger,
                mvExchanger,
                hvExchanger,
                ieExchangerCoreT1,
                ieExchangerCoreT2,
                ieExchangerCoreT3
        );
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
