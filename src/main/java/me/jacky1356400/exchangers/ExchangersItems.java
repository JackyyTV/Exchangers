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
    public static ItemExchangerCore exchangerCore;

    public static void init(){
        woodenExchanger = GameRegistry.register(new ItemWoodenExchanger());
        stoneExchanger = GameRegistry.register(new ItemStoneExchanger());
        goldenExchanger = GameRegistry.register(new ItemGoldenExchanger());
        ironExchanger = GameRegistry.register(new ItemIronExchanger());
        diamondExchanger = GameRegistry.register(new ItemDiamondExchanger());
        emeraldExchanger = GameRegistry.register(new ItemEmeraldExchanger());
        obsidianExchanger = GameRegistry.register(new ItemObsidianExchanger());
        exchangerCore = GameRegistry.register(new ItemExchangerCore());
    }

    public static void initModels(){
        woodenExchanger.initModel();
        stoneExchanger.initModel();
        goldenExchanger.initModel();
        ironExchanger.initModel();
        diamondExchanger.initModel();
        emeraldExchanger.initModel();
        obsidianExchanger.initModel();
        exchangerCore.initModel();
    }

}
