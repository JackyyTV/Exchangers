package me.jacky1356400.exchangers.init;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.integration.ThermalExpansionIntegration;
import me.jacky1356400.exchangers.item.ItemBasic;
import me.jacky1356400.exchangers.item.ItemExchanger;
import me.jacky1356400.exchangers.item.ItemPoweredExchanger;
import me.jacky1356400.exchangers.item.special.ItemTuberousExchanger;
import me.jacky1356400.exchangers.util.Data;
import me.jacky1356400.exchangers.util.RecipeHelper;
import me.jacky1356400.exchangers.util.Tier;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
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
    public static final Item LEADSTONE = new ItemPoweredExchanger("exleadstone", Tier.TE_ONE, Config.leadstoneMaxEnergy, Config.leadstonePerBlockUse);
    public static final Item HARDENED = new ItemPoweredExchanger("exhardened", Tier.TE_TWO, Config.hardenedMaxEnergy, Config.hardenedPerBlockUse);
    public static final Item REINFORCED = new ItemPoweredExchanger("exreinforced", Tier.TE_THREE, Config.reinforcedMaxEnergy, Config.reinforcedPerBlockUse);
    public static final Item SIGNALUM = new ItemPoweredExchanger("exsignalum", Tier.TE_FOUR, Config.signalumMaxEnergy, Config.signalumPerBlockUse);
    public static final Item RESONANT = new ItemPoweredExchanger("exresonant", Tier.TE_FIVE, Config.resonantMaxEnergy, Config.resonantPerBlockUse);
	public static final Item CREATIVE = new ItemExchanger("excreative", Tier.CREATIVE, 9001);
	public static final Item POTATO = new ItemTuberousExchanger();
	public static final Item CORE_1 = new ItemBasic("excore_t1");
	public static final Item CORE_2 = new ItemBasic("excore_t2");
	public static final Item CORE_3 = new ItemBasic("excore_t3");
    public static final Item TECORE_1 = new ItemBasic("teexcore_t1");
    public static final Item TECORE_2 = new ItemBasic("teexcore_t2");
    public static final Item TECORE_3 = new ItemBasic("teexcore_t3");

    public static ItemStack bucketResonantEnder;
    public static ItemStack bucketEnergizedGlowstone;
    public static ItemStack bucketGelidCryotheum;

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
        if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded(Data.THERMAL))) {
            RecipeHelper.addOldShaped(LEADSTONE, "LSL", "LCL", "LFL", 'L', "ingotLead", 'S', ThermalExpansionIntegration.redstoneServo, 'F', ThermalExpansionIntegration.fluxCapacitorBasic, 'C', TECORE_1);

            if (Config.thermalExpansionProgressiveRecipes = true) {
                RecipeHelper.addOldShaped(HARDENED, "IRI", "CXC", "IFI", 'I', "ingotInvar", 'R',
                        ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened,
                        'C', TECORE_1, 'X', LEADSTONE);
                RecipeHelper.addOldShaped(REINFORCED, "ERE", "CXC", "EFE", 'E', "ingotElectrum", 'R',
                        ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced,
                        'C', TECORE_2, 'X', HARDENED);
                RecipeHelper.addOldShaped(SIGNALUM, "SRS", "CXC", "SFS", 'S', "ingotSignalum", 'R',
                        ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum,
                        'C', TECORE_3, 'X', REINFORCED);
                RecipeHelper.addOldShaped(RESONANT, "IRI", "CXC", "IFI", 'I', "ingotEnderium", 'R',
                        ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant,
                        'C', TECORE_3, 'X', SIGNALUM);
            } else {
                RecipeHelper.addOldShaped(HARDENED, "IRI", "ICI", "IFI", 'I', "ingotInvar",
                        'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened,
                        'C', TECORE_1);
                RecipeHelper.addOldShaped(REINFORCED, "ERE", "ECE", "EFE", 'E', "ingotElectrum",
                        'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced,
                        'C', TECORE_2);
                RecipeHelper.addOldShaped(SIGNALUM, "SRS", "SCS", "SFS", 'S', "ingotSignalum",
                        'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum,
                        'C', TECORE_3);
                RecipeHelper.addOldShaped(RESONANT, "IRI", "ICI", "IFI", 'I', "ingotEnderium",
                        'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant,
                        'C', TECORE_3);
            }

            Fluid ender = FluidRegistry.getFluid("ender");
            bucketResonantEnder = FluidUtil.getFilledBucket(new FluidStack(ender, 1000));
            Fluid glowstone = FluidRegistry.getFluid("glowstone");
            bucketEnergizedGlowstone = FluidUtil.getFilledBucket(new FluidStack(glowstone, 1000));
            Fluid cryotheum = FluidRegistry.getFluid("cryotheum");
            bucketGelidCryotheum = FluidUtil.getFilledBucket(new FluidStack(cryotheum, 1000));

            RecipeHelper.addOldShaped(TECORE_1, "CLC", "LRL", "CLC", 'C', "gearCopper", 'L', "ingotLead",
                    'R', bucketResonantEnder);
            RecipeHelper.addOldShaped(TECORE_2, "BIB", "CGC", "BIB", 'B', "gearBronze", 'I', "gearInvar",'C',
                    TECORE_1, 'G', bucketEnergizedGlowstone);
            RecipeHelper.addOldShaped(TECORE_3, "LCL", "CGC", "LCL", 'C', TECORE_2,
                    'L', "gearLumium", 'G', bucketGelidCryotheum);
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
		/*
		if ((Config.enderIOModule = true) && (Loader.isModLoaded(Data.EIO))) {
			EnderIOIntegration.init();
		}
		*/
		if ((Config.thermalExpansionModule = true) && (Loader.isModLoaded(Data.THERMAL))) {
			ThermalExpansionIntegration.init();
		}
		/*
		if ((Config.mekanismModule = true) && (Loader.isModLoaded(Data.MEK))) {
			MekanismIntegration.init();
		}
		*/
		initRecipes();
		e.getRegistry().registerAll(Data.RECIPES.toArray(new IRecipe[0]));
	}

}
