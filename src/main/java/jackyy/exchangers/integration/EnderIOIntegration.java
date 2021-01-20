package jackyy.exchangers.integration;

import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ObjectHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class EnderIOIntegration {

    public static ItemStack capacitorBankBasic;
    public static ItemStack capacitorBank;
    public static ItemStack capacitorBankVibrant;
    public static ItemStack enhancedWirelessChargingAntenna;
    public static ItemStack enderResonator;
    public static ItemStack dimensionalTransceiver;
    public static ItemStack basicCapacitor;
    public static ItemStack doubleLayerCapacitor;
    public static ItemStack octadicCapacitor;
    public static Object pulsatingCrystal;
    public static Object vibrantCrystal;
    public static Object enderCrystal;
    public static Object precientCrystal;
    public static ItemStack bucketNutrientDistillation;
    public static ItemStack bucketDewOfTheVoid;
    public static ItemStack bucketVaporOfLevity;
    public static ItemStack bucketLiquidSunshine;
    public static ItemStack bucketConcentratedCloudSeed;

    public static void init() {
        Reference.LOGGER.info("Fetching items for Ender IO integration...");

        Block capBankBlock = ObjectHelper.getBlockByName(Reference.EIO, "block_cap_bank");
        capacitorBankBasic = new ItemStack(capBankBlock, 1, 1);
        capacitorBank = new ItemStack(capBankBlock, 1, 2);
        capacitorBankVibrant = new ItemStack(capBankBlock, 1, 3);

        Item capacitorItem = ObjectHelper.getItemByName(Reference.EIO, "item_basic_capacitor");
        if (capacitorItem != null) {
            basicCapacitor = new ItemStack(capacitorItem, 1, 0);
            doubleLayerCapacitor = new ItemStack(capacitorItem, 1, 1);
            octadicCapacitor = new ItemStack(capacitorItem, 1, 2);
        }

        enderResonator = ObjectHelper.getItemStackByName(Reference.EIO, "item_material", 1, 43);

        enhancedWirelessChargingAntenna = ObjectHelper.getBlockStackByName(Reference.EIO, "block_enhanced_wireless_charger", 1, 0);
        dimensionalTransceiver = ObjectHelper.getBlockStackByName(Reference.EIO, "block_transceiver", 1, 0);

        pulsatingCrystal = "itemPulsatingCrystal";
        vibrantCrystal = "itemVibrantCrystal";
        enderCrystal = "itemEnderCrystal";
        precientCrystal = "itemPrecientCrystal";

        Fluid nutrientDistillation = FluidRegistry.getFluid("nutrient_distillation");
        bucketNutrientDistillation = FluidUtil.getFilledBucket(new FluidStack(nutrientDistillation, 1000));
        Fluid dewOfTheVoid = FluidRegistry.getFluid("ender_distillation");
        bucketDewOfTheVoid = FluidUtil.getFilledBucket(new FluidStack(dewOfTheVoid, 1000));
        Fluid vaporOfLevity = FluidRegistry.getFluid("vapor_of_levity");
        bucketVaporOfLevity = FluidUtil.getFilledBucket(new FluidStack(vaporOfLevity, 1000));
        Fluid liquidSunshine = FluidRegistry.getFluid("liquid_sunshine");
        bucketLiquidSunshine = FluidUtil.getFilledBucket(new FluidStack(liquidSunshine, 1000));
        Fluid concentratedCloudSeed = FluidRegistry.getFluid("cloud_seed_concentrated");
        bucketConcentratedCloudSeed = FluidUtil.getFilledBucket(new FluidStack(concentratedCloudSeed, 1000));
    }

}
