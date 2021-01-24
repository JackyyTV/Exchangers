package jackyy.exchangers.registry;

import jackyy.exchangers.item.enderio.*;
import jackyy.exchangers.item.enderioendergy.*;
import jackyy.exchangers.item.immersiveengineering.*;
import jackyy.exchangers.item.mekanism.*;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.exchangers.item.special.ItemTuberousExchanger;
import jackyy.exchangers.item.thermal.*;
import jackyy.exchangers.item.vanilla.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

    public static ItemTuberousExchanger tuberousExchanger = new ItemTuberousExchanger();
    public static ItemCreativeExchanger creativeExchanger = new ItemCreativeExchanger();

    public static ItemWoodenExchanger woodenExchanger = new ItemWoodenExchanger();
    public static ItemStoneExchanger stoneExchanger = new ItemStoneExchanger();
    public static ItemGoldenExchanger goldenExchanger = new ItemGoldenExchanger();
    public static ItemIronExchanger ironExchanger = new ItemIronExchanger();
    public static ItemDiamondExchanger diamondExchanger = new ItemDiamondExchanger();
    public static ItemEmeraldExchanger emeraldExchanger = new ItemEmeraldExchanger();
    public static ItemObsidianExchanger obsidianExchanger = new ItemObsidianExchanger();
    public static ItemEndExchanger endExchanger = new ItemEndExchanger();
    public static ItemExchangerCoreT1 exchangerCoreT1 = new ItemExchangerCoreT1();
    public static ItemExchangerCoreT2 exchangerCoreT2 = new ItemExchangerCoreT2();
    public static ItemExchangerCoreT3 exchangerCoreT3 = new ItemExchangerCoreT3();

    public static ItemConductiveIronExchanger conductiveIronExchanger = new ItemConductiveIronExchanger();
    public static ItemPulsatingIronExchanger pulsatingIronExchanger = new ItemPulsatingIronExchanger();
    public static ItemElectricalSteelExchanger electricalSteelExchanger = new ItemElectricalSteelExchanger();
    public static ItemEnergeticExchanger energeticExchanger = new ItemEnergeticExchanger();
    public static ItemDarkSteelExchanger darkSteelExchanger = new ItemDarkSteelExchanger();
    public static ItemVibrantExchanger vibrantExchanger = new ItemVibrantExchanger();
    public static ItemEndSteelExchanger endSteelExchanger = new ItemEndSteelExchanger();
    public static ItemEIOExchangerCoreT1 eioExchangerCoreT1 = new ItemEIOExchangerCoreT1();
    public static ItemEIOExchangerCoreT2 eioExchangerCoreT2 = new ItemEIOExchangerCoreT2();
    public static ItemEIOExchangerCoreT3 eioExchangerCoreT3 = new ItemEIOExchangerCoreT3();

    public static ItemCrudeSteelExchanger crudeSteelExchanger = new ItemCrudeSteelExchanger();
    public static ItemEnergeticSilverExchanger energeticSilverExchanger = new ItemEnergeticSilverExchanger();
    public static ItemVividExchanger vividExchanger = new ItemVividExchanger();
    public static ItemCrystallineExchanger crystallineExchanger = new ItemCrystallineExchanger();
    public static ItemMelodicExchanger melodicExchanger = new ItemMelodicExchanger();
    public static ItemStellarExchanger stellarExchanger = new ItemStellarExchanger();
    public static ItemEIOEndergyExchangerCoreT1 eioEndergyExchangerCoreT1 = new ItemEIOEndergyExchangerCoreT1();
    public static ItemEIOEndergyExchangerCoreT2 eioEndergyExchangerCoreT2 = new ItemEIOEndergyExchangerCoreT2();
    public static ItemEIOEndergyExchangerCoreT3 eioEndergyExchangerCoreT3 = new ItemEIOEndergyExchangerCoreT3();

    public static ItemLeadstoneExchanger leadstoneExchanger = new ItemLeadstoneExchanger();
    public static ItemHardenedExchanger hardenedExchanger = new ItemHardenedExchanger();
    public static ItemReinforcedExchanger reinforcedExchanger = new ItemReinforcedExchanger();
    public static ItemSignalumExchanger signalumExchanger = new ItemSignalumExchanger();
    public static ItemResonantExchanger resonantExchanger = new ItemResonantExchanger();
    public static ItemThermalExchangerCoreT1 teExchangerCoreT1 = new ItemThermalExchangerCoreT1();
    public static ItemThermalExchangerCoreT2 teExchangerCoreT2 = new ItemThermalExchangerCoreT2();
    public static ItemThermalExchangerCoreT3 teExchangerCoreT3 = new ItemThermalExchangerCoreT3();

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
                endExchanger,
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
                endSteelExchanger,
                eioExchangerCoreT1,
                eioExchangerCoreT2,
                eioExchangerCoreT3,
                //Ender IO Endergy Exchangers
                crudeSteelExchanger,
                energeticSilverExchanger,
                vividExchanger,
                crystallineExchanger,
                melodicExchanger,
                stellarExchanger,
                eioEndergyExchangerCoreT1,
                eioEndergyExchangerCoreT2,
                eioEndergyExchangerCoreT3,
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

}
