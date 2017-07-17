package me.jacky1356400.exchangers.init;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import me.jacky1356400.exchangers.item.ItemBasic;
import me.jacky1356400.exchangers.item.ItemExchanger;
import me.jacky1356400.exchangers.item.ItemPoweredExchanger;
import me.jacky1356400.exchangers.item.special.ItemTuberousExchanger;
import me.jacky1356400.exchangers.util.Data;
import me.jacky1356400.exchangers.helper.RecipeHelper;
import me.jacky1356400.exchangers.util.Tier;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModRegistry {

    public static final Item WOODEN = new ItemExchanger("exwooden", Tier.ONE, Config.woodMaxDmg);
    public static final Item STONE = new ItemExchanger("exstone", Tier.TWO, Config.stoneMaxDmg);
    public static final Item GOLD = new ItemExchanger("exgolden", Tier.THREE, Config.goldMaxDmg);
    public static final Item IRON = new ItemExchanger("exiron", Tier.FOUR, Config.ironMaxDmg);
    public static final Item DIAMOND = new ItemExchanger("exdiamond", Tier.FIVE, Config.diaMaxDmg);
    public static final Item EMERALD = new ItemExchanger("exemerald", Tier.SIX, Config.emeMaxDmg);
    public static final Item OBSIDIAN = new ItemExchanger("exobsidian", Tier.SEVEN, Config.obsMaxDmg);
    public static final Item LEADSTONE = new ItemPoweredExchanger("exleadstone", Tier.TE_ONE, Config.leadstoneMaxEnergy,
	    Config.leadstonePerBlockUse);
    public static final Item HARDENED = new ItemPoweredExchanger("exhardened", Tier.TE_TWO, Config.hardenedMaxEnergy,
	    Config.hardenedPerBlockUse);
    public static final Item REINFORCED = new ItemPoweredExchanger("exreinforced", Tier.TE_THREE,
	    Config.reinforcedMaxEnergy, Config.reinforcedPerBlockUse);
    public static final Item SIGNALUM = new ItemPoweredExchanger("exsignalum", Tier.TE_FOUR, Config.signalumMaxEnergy,
	    Config.signalumPerBlockUse);
    public static final Item RESONANT = new ItemPoweredExchanger("exresonant", Tier.TE_FIVE, Config.resonantMaxEnergy,
	    Config.resonantPerBlockUse);
    public static final Item CREATIVE = new ItemExchanger("excreative", Tier.CREATIVE, 9001);
    public static final Item POTATO = new ItemTuberousExchanger();
    public static final Item CORE_1 = new ItemBasic("excore_t1");
    public static final Item CORE_2 = new ItemBasic("excore_t2");
    public static final Item CORE_3 = new ItemBasic("excore_t3");
    public static final Item TECORE_1 = new ItemBasic("teexcore_t1");
    public static final Item TECORE_2 = new ItemBasic("teexcore_t2");
    public static final Item TECORE_3 = new ItemBasic("teexcore_t3");

    private static void initRecipes() {
	if (Config.vanillaModule) {
	    String W = "logWood";
	    String R = "dyeRed";
	    String S = "stone";
	    String G = "ingotGold";
	    String I = "ingotIron";
	    String D = "gemDiamond";
	    String Db = "blockDiamond";
	    String E = "gemEmerald";
	    String L = "gemLapis";
	    String O = "obsidian";
	    String Pe = "enderpearl";
	    Item EYE = Items.ENDER_EYE;

	    RecipeHelper.addShaped(WOODEN, 3, 3, W, EYE, W, W, CORE_1, W, W, EYE, W);

	    if (Config.vanillaProgressiveRecipes) {
		RecipeHelper.addShaped(STONE, 3, 3, S, EYE, S, CORE_1, WOODEN, CORE_1, S, EYE, S);
		RecipeHelper.addShaped(GOLD, 3, 3, G, EYE, G, CORE_2, STONE, CORE_2, G, EYE, G);
		RecipeHelper.addShaped(IRON, 3, 3, I, EYE, I, CORE_2, GOLD, CORE_2, I, EYE, I);
		RecipeHelper.addShaped(DIAMOND, 3, 3, D, EYE, D, CORE_3, IRON, CORE_3, D, EYE, D);
		RecipeHelper.addShaped(EMERALD, 3, 3, E, EYE, E, CORE_3, DIAMOND, CORE_3, E, EYE, E);
		RecipeHelper.addShaped(OBSIDIAN, 3, 3, O, EYE, O, CORE_3, EMERALD, CORE_3, O, EYE, O);
	    } else {
		RecipeHelper.addShaped(STONE, 3, 3, S, EYE, S, S, CORE_1, S, S, EYE, S);
		RecipeHelper.addShaped(GOLD, 3, 3, G, EYE, G, G, CORE_2, G, G, EYE, G);
		RecipeHelper.addShaped(IRON, 3, 3, I, EYE, I, I, CORE_2, I, I, EYE, I);
		RecipeHelper.addShaped(DIAMOND, 3, 3, D, EYE, D, D, CORE_3, D, D, EYE, D);
		RecipeHelper.addShaped(EMERALD, 3, 3, E, EYE, E, E, CORE_3, E, E, EYE, E);
		RecipeHelper.addShaped(OBSIDIAN, 3, 3, O, EYE, O, O, CORE_3, O, O, EYE, O);
	    }

	    RecipeHelper.addShaped(CORE_1, 3, 3, W, R, W, R, Pe, R, W, R, W);
	    RecipeHelper.addShaped(CORE_2, 3, 3, I, L, I, CORE_1, EYE, CORE_1, I, L, I);
	    RecipeHelper.addShaped(CORE_3, 3, 3, D, CORE_2, E, CORE_2, Db, CORE_2, E, CORE_2, D);
	}
	if (Config.specialModule) {
	    String Pe = "enderpearl";
	    String nG = "nuggetGold";
	    Item Po = Items.POTATO;

	    RecipeHelper.addShaped(POTATO, 3, 3, Po, nG, Po, Po, Pe, Po, Po, nG, Po);
	}
	if (Config.thermalExpansionModule) {
	    if (Loader.isModLoaded(Data.THERMAL)) {
		String iLe = "ingotLead";
		String iI = "ingotInvar";
		String iEle = "ingotElectrum";
		String iS = "ingotSignalum";
		String iEn = "ingotEnderium";
		String gC = "gearCopper";
		String gB = "gearBronze";
		String gI = "gearInvar";
		String gLu = "gearLumium";
		ItemStack S = ThermalExpansionIntegration.redstoneServo;
		ItemStack C1 = ThermalExpansionIntegration.redstoneReceptionCoil;
		ItemStack C2 = ThermalExpansionIntegration.redstoneTransmissionCoil;
		ItemStack C3 = ThermalExpansionIntegration.redstoneConductanceCoil;
		ItemStack F1 = ThermalExpansionIntegration.fluxCapacitorBasic;
		ItemStack F2 = ThermalExpansionIntegration.fluxCapacitorHardened;
		ItemStack F3 = ThermalExpansionIntegration.fluxCapacitorReinforced;
		ItemStack F4 = ThermalExpansionIntegration.fluxCapacitorSignalum;
		ItemStack F5 = ThermalExpansionIntegration.fluxCapacitorResonant;
		ItemStack B1 = ThermalExpansionIntegration.bucketResonantEnder;
		ItemStack B2 = ThermalExpansionIntegration.bucketEnergizedGlowstone;
		ItemStack B3 = ThermalExpansionIntegration.bucketGelidCryotheum;

		RecipeHelper.addShaped(LEADSTONE, 3, 3, iLe, S, iLe, iLe, TECORE_1, iLe, iLe, F1, iLe);

		if (Config.thermalExpansionProgressiveRecipes) {
		    RecipeHelper.addShaped(HARDENED, 3, 3, iI, C1, iI, TECORE_1, LEADSTONE, TECORE_1, iI, F2, iI);
		    RecipeHelper.addShaped(REINFORCED, 3, 3, iEle, C2, iEle, TECORE_2, HARDENED, TECORE_2, iEle, F3,
			    iEle);
		    RecipeHelper.addShaped(SIGNALUM, 3, 3, iS, C3, iS, TECORE_3, REINFORCED, TECORE_3, iS, F4, iS);
		    RecipeHelper.addShaped(RESONANT, 3, 3, iEn, C3, iEn, TECORE_3, SIGNALUM, TECORE_3, iEn, F5, iEn);
		} else {
		    RecipeHelper.addShaped(HARDENED, 3, 3, iI, C1, iI, iI, TECORE_1, iI, iI, F2, iI);
		    RecipeHelper.addShaped(REINFORCED, 3, 3, iEle, C2, iEle, iEle, TECORE_2, iEle, iEle, F3, iEle);
		    RecipeHelper.addShaped(SIGNALUM, 3, 3, iS, C3, iS, iS, TECORE_3, iS, iS, F4, iS);
		    RecipeHelper.addShaped(RESONANT, 3, 3, iEn, C3, iEn, iEn, TECORE_3, iEn, iEn, F5, iEn);
		}

		RecipeHelper.addShaped(TECORE_1, 3, 3, gC, iLe, gC, iLe, B1, iLe, gC, iLe, gC);
		RecipeHelper.addShaped(TECORE_2, 3, 3, gB, gI, gB, TECORE_1, B2, TECORE_1, gB, gI, gB);
		RecipeHelper.addShaped(TECORE_3, 3, 3, gLu, TECORE_2, gLu, TECORE_2, B3, TECORE_2, gLu, TECORE_2, gLu);
	    }
	}
    }

    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> e) {
	e.getRegistry().registerAll(Data.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
	e.getRegistry().registerAll(Data.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public void onRecipeRegistry(RegistryEvent.Register<IRecipe> e) {
	if (Config.enderIOModule = true) {
	    if (Loader.isModLoaded(Data.EIO)) {
		// EnderIOIntegration.init();
	    }
	}
	if (Config.thermalExpansionModule = true) {
	    if (Loader.isModLoaded(Data.THERMAL)) {
		ThermalExpansionIntegration.init();
	    }
	}
	if (Config.mekanismModule = true) {
	    if (Loader.isModLoaded(Data.MEK)) {
		// MekanismIntegration.init();
	    }
	}
	initRecipes();
	e.getRegistry().registerAll(Data.RECIPES.toArray(new IRecipe[0]));
    }

}
