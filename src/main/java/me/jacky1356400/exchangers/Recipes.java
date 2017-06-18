package me.jacky1356400.exchangers;

import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;

public class Recipes {
    private static RecipeList list = new RecipeList();

    private static int id = 0;

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

        if (Config.vanillaModule = true) {
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.exchangerCoreT1, 1, 0), 3, 3,
                            new Object[]{W, R, W, R, P, R, W, R, W}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.exchangerCoreT2, 1, 0), 3, 3,
                            new Object[]{I, L, I, EC1, EYE, EC1, I, L, I}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.exchangerCoreT3, 1, 0), 3, 3,
                            new Object[]{D, EC2, E, EC2, N, EC2, E, EC2, D}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.tuberousExchanger, 1, 0), 3, 3,
                            new Object[]{PO, GN, PO, PO, P, PO, PO, GN, PO}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.woodenExchanger, 1, 0), 3, 3,
                            new Object[]{W, EYE, W, W, EC1, W, W, EYE, W}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.stoneExchanger, 1, 0), 3, 3,
                            new Object[]{S, EYE, S, S, EC1, S, S, EYE, S}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.goldenExchanger, 1, 0), 3, 3,
                            new Object[]{G, EYE, G, G, EC2, G, G, EYE, G}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.ironExchanger, 1, 0), 3, 3,
                            new Object[]{I, EYE, I, I, EC2, I, I, EYE, I}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.diamondExchanger, 1, 0), 3, 3,
                            new Object[]{D, EYE, D, D, EC3, D, D, EYE, D}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.emeraldExchanger, 1, 0), 3, 3,
                            new Object[]{E, EYE, E, E, EC3, E, E, EYE, E}));
            CraftingManager.REGISTRY.register(id++, new ResourceLocation(Exchangers.MODID + ":recipe" + id),
                    RecipeHelper.getShaped(new ItemStack(ExchangersItems.obsidianExchanger, 1, 0), 3, 3,
                            new Object[]{O, EYE, O, O, EC3, O, O, EYE, O}));
        }
    }

}
