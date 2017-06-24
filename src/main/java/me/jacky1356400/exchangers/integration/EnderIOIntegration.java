package me.jacky1356400.exchangers.integration;

import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;

public class EnderIOIntegration {

	public static ItemStack capacitorBankBasic;
	public static ItemStack capacitorBank;
	public static ItemStack capacitorBankVibrant;
	public static ItemStack basicCapacitor;
	public static ItemStack doubleLayerCapacitor;
	public static ItemStack octadicCapacitor;
	public static ItemStack pulsatingCrystal;
	public static ItemStack vibrantCrystal;
	public static ItemStack enderCrystal;
	public static ItemStack bucketNutrientDistillation;
	public static ItemStack bucketDewOfTheVoid;
	public static ItemStack bucketVaporOfLevity;

	public static void init() {
		Exchangers.logger.info("Fetching items for Ender IO integration...");

		Block capBankBlock = Block.REGISTRY.getObject(new ResourceLocation("enderio", "blockCapBank"));
		capacitorBankBasic = new ItemStack(capBankBlock, 1, 1);
		capacitorBank = new ItemStack(capBankBlock, 1, 2);
		capacitorBankVibrant = new ItemStack(capBankBlock, 1, 3);

		Item capacitorItem = Item.REGISTRY.getObject(new ResourceLocation("enderio", "itemBasicCapacitor"));
		if (capacitorItem != null) {
			basicCapacitor = new ItemStack(capacitorItem, 1, 0);
			doubleLayerCapacitor = new ItemStack(capacitorItem, 1, 1);
			octadicCapacitor = new ItemStack(capacitorItem, 1, 2);
		}

		Item eioMaterialsItem = Item.REGISTRY.getObject(new ResourceLocation("enderio", "itemMaterial"));
		if (eioMaterialsItem != null) {
			pulsatingCrystal = new ItemStack(eioMaterialsItem, 1, 5);
			vibrantCrystal = new ItemStack(eioMaterialsItem, 1, 6);
			enderCrystal = new ItemStack(eioMaterialsItem, 1, 8);
		}

		Fluid nutrientDistillation = FluidRegistry.getFluid("nutrient_distillation");
		bucketNutrientDistillation = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket,
				nutrientDistillation);
		Fluid dewOfTheVoid = FluidRegistry.getFluid("ender_distillation");
		bucketDewOfTheVoid = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket,
				dewOfTheVoid);
		Fluid vaporOfLevity = FluidRegistry.getFluid("vapor_of_levity");
		bucketVaporOfLevity = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket,
				vaporOfLevity);
	}

}
