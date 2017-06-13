package me.jacky1356400.exchangers;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){
        ShapedOreRecipe exchangerCoreRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCore), "DPE", "PNP", "EPD", 'D', "gemDiamond", 'E', "gemEmerald", 'P', "enderpearl", 'N', Items.NETHER_STAR);
        GameRegistry.addRecipe(exchangerCoreRecipe);
        ShapedOreRecipe woodenExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.woodenExchanger), "WEW", "WCW", "WEW", 'W', "logWood", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(woodenExchangerRecipe);
        ShapedOreRecipe stoneExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.stoneExchanger), "SES", "SCS", "SES", 'S', "stone", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(stoneExchangerRecipe);
        ShapedOreRecipe goldenExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.goldenExchanger), "GEG", "GCG", "GEG", 'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(goldenExchangerRecipe);
        ShapedOreRecipe ironExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.ironExchanger), "IEI", "ICI", "IEI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(ironExchangerRecipe);
        ShapedOreRecipe diamondExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.diamondExchanger), "DED", "DCD", "DED", 'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(diamondExchangerRecipe);
        ShapedOreRecipe emeraldExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.emeraldExchanger), "MEM", "MCM", "MEM", 'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(emeraldExchangerRecipe);
        ShapedOreRecipe obsidianExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.obsidianExchanger), "OEO", "OCO", "OEO", 'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCore);
        GameRegistry.addRecipe(obsidianExchangerRecipe);
    }

}
