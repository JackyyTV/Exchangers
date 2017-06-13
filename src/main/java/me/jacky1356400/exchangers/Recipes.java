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
        Item EC = ExchangersItems.exchangerCore;
        String P = "enderpearl";
        String D = "gemDiamond";
        String E = "gemEmerald";
        String I = "ingotIron";
        String G = "IngotGold";
        String O = "obsidian";
        String S = "stone";
        String W = "logWood";

        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.exchangerCore, 3, 3,
                new Object[] {D, P, E, P, N, P, E, P, D}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.woodenExchanger, 3, 3,
                new Object[] {W, EYE, W, W, EC, W, W, EYE, W}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.stoneExchanger, 3, 3,
                new Object[] {S, EYE, S, S, EC, S, S, EYE, S}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.goldenExchanger, 3, 3,
                new Object[] {G, EYE, G, G, EC, G, G, EYE, G}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.ironExchanger, 3, 3,
                new Object[] {I, EYE, I, I, EC, I, I, EYE, I}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.diamondExchanger, 3, 3,
                new Object[] {D, EYE, D, D, EC, D, D, EYE, D}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.emeraldExchanger, 3, 3,
                new Object[] {E, EYE, E, E, EC, E, E, EYE, E}));
        list.func_192709_a(RecipeHelper.addShaped(ExchangersItems.obsidianExchanger, 3, 3,
                new Object[] {O, EYE, O, O, EC, O, O, EYE, O}));

        // Keep this last
        recipes.add(list);
    }

}
