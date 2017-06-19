package me.jacky1356400.exchangers;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){
        if (Config.vanillaModule = true) {
            ShapedOreRecipe exchangerCoreT1Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT1), "WRW", "RPR", "WRW", 'R', "dyeRed", 'W', "logWood", 'P', "enderpearl");
            GameRegistry.addRecipe(exchangerCoreT1Recipe);
            ShapedOreRecipe exchangerCoreT2Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT2), "ILI", "CEC", "ILI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ExchangersItems.exchangerCoreT1);
            GameRegistry.addRecipe(exchangerCoreT2Recipe);
            ShapedOreRecipe exchangerCoreT3Recipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.exchangerCoreT3), "DCE", "CNC", "ECD", 'D', "gemDiamond", 'E', "gemEmerald", 'C', ExchangersItems.exchangerCoreT2, 'N', Items.NETHER_STAR);
            GameRegistry.addRecipe(exchangerCoreT3Recipe);
            ShapedOreRecipe tuberousExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.tuberousExchanger), "PGP", "PEP", "PGP", 'P', Items.POTATO, 'G', "nuggetGold", 'E', "enderpearl");
            GameRegistry.addRecipe(tuberousExchangerRecipe);
            ShapedOreRecipe woodenExchangerRecipe = new ShapedOreRecipe(new ItemStack(ExchangersItems.woodenExchanger), "WEW", "WCW", "WEW", 'W', "logWood", 'E', Items.ENDER_EYE, 'C', ExchangersItems.exchangerCoreT1);
            GameRegistry.addRecipe(woodenExchangerRecipe);
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
        if ((Config.enderIOModule = true) && (Loader.isModLoaded("EnderIO"))) {
            //TODO
        }
        if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded("thermalexpansion"))) {
            //TODO
        }
        if ((Config.mekanismModule = true) && (Loader.isModLoaded("Mekanism"))) {
            //TODO
        }
    }

}
