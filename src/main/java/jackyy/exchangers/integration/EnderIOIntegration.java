package jackyy.exchangers.integration;

import jackyy.exchangers.Exchangers;
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
    public static Object pulsatingCrystal;
    public static Object vibrantCrystal;
    public static Object enderCrystal;
    public static ItemStack bucketNutrientDistillation;
    public static ItemStack bucketDewOfTheVoid;
    public static ItemStack bucketVaporOfLevity;

    public static void init() {
        Exchangers.logger.info("Fetching items for Ender IO integration...");

        Block capBankBlock = Block.REGISTRY.getObject(new ResourceLocation(Exchangers.EIO.toLowerCase(), "blockCapBank"));
        capacitorBankBasic = new ItemStack(capBankBlock, 1, 1);
        capacitorBank = new ItemStack(capBankBlock, 1, 2);
        capacitorBankVibrant = new ItemStack(capBankBlock, 1, 3);

        Item capacitorItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.EIO.toLowerCase(), "itemBasicCapacitor"));
        if (capacitorItem != null) {
            basicCapacitor = new ItemStack(capacitorItem, 1, 0);
            doubleLayerCapacitor = new ItemStack(capacitorItem, 1, 1);
            octadicCapacitor = new ItemStack(capacitorItem, 1, 2);
        }

        pulsatingCrystal = "itemPulsatingCrystal";
        vibrantCrystal = "itemVibrantCrystal";
        enderCrystal = "itemEnderCrystal";

        Fluid nutrientDistillation = FluidRegistry.getFluid("nutrient_distillation");
        bucketNutrientDistillation = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, nutrientDistillation);
        Fluid dewOfTheVoid = FluidRegistry.getFluid("ender_distillation");
        bucketDewOfTheVoid = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, dewOfTheVoid);
        Fluid vaporOfLevity = FluidRegistry.getFluid("vapor_of_levity");
        bucketVaporOfLevity = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, vaporOfLevity);
    }

}
