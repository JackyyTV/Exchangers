package jacky.exchangers.init;

import jacky.exchangers.Config;
import jacky.exchangers.item.ItemBasic;
import jacky.exchangers.item.ItemExchanger;
import jacky.exchangers.item.special.ItemTuberousExchanger;
import jacky.exchangers.util.Data;
import jacky.exchangers.util.RecipeHelper;
import jacky.exchangers.util.Tier;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModRegistry {

	public static final Item WOODEN = new ItemExchanger("wooden", Tier.ONE, Config.woodMaxDmg);
	public static final Item STONE = new ItemExchanger("stone", Tier.TWO, Config.stoneMaxDmg);
	public static final Item IRON = new ItemExchanger("iron", Tier.THREE, Config.ironMaxDmg);
	public static final Item GOLD = new ItemExchanger("golden", Tier.THREE, Config.goldMaxDmg);
	public static final Item DIAMOND = new ItemExchanger("diamond", Tier.FOUR, Config.diaMaxDmg);
	public static final Item EMERALD = new ItemExchanger("emerald", Tier.FOUR, Config.emeMaxDmg);
	public static final Item OBSIDIAN = new ItemExchanger("obsidian", Tier.FOUR, Config.obsMaxDmg);
	public static final Item CREATIVE = new ItemExchanger("creative", Tier.CREATIVE, 0);
	public static final Item POTATO = new ItemTuberousExchanger();
	public static final Item CORE_1 = new ItemBasic("core_t1");
	public static final Item CORE_2 = new ItemBasic("core_t2");
	public static final Item CORE_3 = new ItemBasic("core_t3");

	@SuppressWarnings("deprecation")
	private static void initRecipes() {
		if (Config.vanillaModule = true) {
			String L = "logWood";
			String R = "dyeRed";
			String I = "ingotIron";
			String D = "gemDiamond";
			String E = "gemEmerald";

			RecipeHelper.addShaped(WOODEN, 3, 3, L, Items.ENDER_EYE, L, L, CORE_1, L, L, Items.ENDER_EYE, L);

			if (Config.specialModule = true)
				RecipeHelper.addOldShaped(POTATO, "PGP", "PEP", "PGP", 'P', Items.POTATO, 'G', "nuggetGold", 'E',
						"enderpearl");

			if (Config.vanillaProgressiveRecipes = true) {
				RecipeHelper.addOldShaped(STONE, "SES", "CXC", "SES", 'S', "stone", 'E', Items.ENDER_EYE, 'C', CORE_1,
						'X', WOODEN);
				RecipeHelper.addOldShaped(GOLD, "GEG", "CXC", "GEG", 'G', "ingotGold", 'E', Items.ENDER_EYE, 'C',
						CORE_2, 'X', STONE);
				RecipeHelper.addOldShaped(IRON, "IEI", "CXC", "IEI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'C',
						CORE_2, 'X', GOLD);
				RecipeHelper.addOldShaped(DIAMOND, "DED", "CXC", "DED", 'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C',
						CORE_3, 'X', IRON);
				RecipeHelper.addOldShaped(EMERALD, "MEM", "CXC", "MEM", 'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C',
						CORE_3, 'X', DIAMOND);
				RecipeHelper.addOldShaped(OBSIDIAN, "OEO", "CXC", "OEO", 'O', "obsidian", 'E', Items.ENDER_EYE, 'C',
						CORE_3, 'X', EMERALD);
			} else {
				RecipeHelper.addOldShaped(STONE, "SES", "SCS", "SES", 'S', "stone", 'E', Items.ENDER_EYE, 'C', CORE_1);
				RecipeHelper.addOldShaped(GOLD, "GEG", "GCG", "GEG", 'G', "ingotGold", 'E', Items.ENDER_EYE, 'C',
						CORE_2);
				RecipeHelper.addOldShaped(IRON, "IEI", "ICI", "IEI", 'I', "ingotIron", 'E', Items.ENDER_EYE, 'C',
						CORE_2);
				RecipeHelper.addOldShaped(DIAMOND, "DED", "DCD", "DED", 'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C',
						CORE_3);
				RecipeHelper.addOldShaped(EMERALD, "MEM", "MCM", "MEM", 'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C',
						CORE_3);
				RecipeHelper.addOldShaped(OBSIDIAN, "OEO", "OCO", "OEO", 'O', "obsidian", 'E', Items.ENDER_EYE, 'C',
						CORE_3);
			}

			RecipeHelper.addShaped(CORE_1, 3, 3, L, R, L, R, "enderpearl", R, L, R, L);
			RecipeHelper.addShaped(CORE_2, 3, 3, I, "gemLapis", I, CORE_1, Items.ENDER_EYE, CORE_1, I, "gemLapis", I);
			RecipeHelper.addShaped(CORE_3, 3, 3, D, CORE_2, E, CORE_2, "blockDiamond", CORE_2, E, CORE_2, D);
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
		initRecipes();
		e.getRegistry().registerAll(Data.RECIPES.toArray(new IRecipe[0]));
	}

}
