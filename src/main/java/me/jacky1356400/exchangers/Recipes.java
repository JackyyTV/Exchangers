package me.jacky1356400.exchangers;

import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.client.util.RecipeBookClient;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Recipes {
    private static List<RecipeList> recipes = RecipeBookClient.field_194086_e.get(CreativeTabs.TOOLS);
    private static RecipeList list = new RecipeList();

    public static void init(){
        ItemStack N = new ItemStack(Items.NETHER_STAR);
        ItemStack EYE = new ItemStack(Items.ENDER_EYE);
        ItemStack PO = new ItemStack(Items.POTATO);
        Item EC1 = ExchangersItems.exchangerCoreT1;
        Item EC2 = ExchangersItems.exchangerCoreT2;
        Item EC3 = ExchangersItems.exchangerCoreT3;
        String P = "enderpearl";
        String R = "dyeRed";
        String L = "gemLapis";
        String D = "gemDiamond";
        String E = "gemEmerald";
        String I = "ingotIron";
        String G = "ingotGold";
        String GN = "nuggetGold";
        String O = "obsidian";
        String S = "stone";
        String W = "logWood";

        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.exchangerCoreT1, 3, 3,
                new Object[] {W, R, W, R, P, R, W, R, W}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.exchangerCoreT2, 3, 3,
                new Object[] {I, L, I, EC1, EYE, EC1, I, L, I}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.exchangerCoreT3, 3, 3,
                new Object[] {D, EC2, E, EC2, N, EC2, E, EC2, D}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.tuberousExchanger, 3, 3,
                new Object[] {PO, GN, PO, PO, P, PO, PO, GN, PO}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.woodenExchanger, 3, 3,
                new Object[] {W, EYE, W, W, EC1, W, W, EYE, W}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.stoneExchanger, 3, 3,
                new Object[] {S, EYE, S, S, EC1, S, S, EYE, S}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.goldenExchanger, 3, 3,
                new Object[] {G, EYE, G, G, EC2, G, G, EYE, G}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.ironExchanger, 3, 3,
                new Object[] {I, EYE, I, I, EC2, I, I, EYE, I}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.diamondExchanger, 3, 3,
                new Object[] {D, EYE, D, D, EC3, D, D, EYE, D}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.emeraldExchanger, 3, 3,
                new Object[] {E, EYE, E, E, EC3, E, E, EYE, E}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.obsidianExchanger, 3, 3,
                new Object[] {O, EYE, O, O, EC3, O, O, EYE, O}));

        // Keep this last
        recipes.add(list);
    }

}
