package me.jacky1356400.exchangers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import me.jacky1356400.exchangers.item.*;

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

    public static void init(){
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

        conductiveIronExchanger = GameRegistry.register(new ItemConductiveIronExchanger());
    }

    public static void initModels(){
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

        conductiveIronExchanger.initModel();
    }

}
