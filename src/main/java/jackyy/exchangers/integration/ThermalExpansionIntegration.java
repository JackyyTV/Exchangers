package jackyy.exchangers.integration;

import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ObjectHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class ThermalExpansionIntegration {

    public static ItemStack fluxCapacitorBasic;
    public static ItemStack fluxCapacitorHardened;
    public static ItemStack fluxCapacitorReinforced;
    public static ItemStack fluxCapacitorSignalum;
    public static ItemStack fluxCapacitorResonant;
    public static ItemStack redstoneServo;
    public static ItemStack redstoneReceptionCoil;
    public static ItemStack redstoneTransmissionCoil;
    public static ItemStack redstoneConductanceCoil;
    public static ItemStack bucketResonantEnder;
    public static ItemStack bucketEnergizedGlowstone;
    public static ItemStack bucketGelidCryotheum;

    public static void init() {
        Reference.LOGGER.info("Fetching items for Thermal Expansion integration...");

        Item fluxCapacitorItem = ObjectHelper.getItemByName(Reference.TE, "capacitor");
        if (fluxCapacitorItem != null) {
            fluxCapacitorBasic = new ItemStack(fluxCapacitorItem, 1, 0);
            fluxCapacitorHardened = new ItemStack(fluxCapacitorItem, 1, 1);
            fluxCapacitorReinforced = new ItemStack(fluxCapacitorItem, 1, 2);
            fluxCapacitorSignalum = new ItemStack(fluxCapacitorItem, 1, 3);
            fluxCapacitorResonant = new ItemStack(fluxCapacitorItem, 1, 4);
        }

        Item teMaterialsItem = ObjectHelper.getItemByName("thermalfoundation", "material");
        if (teMaterialsItem != null) {
            redstoneServo = new ItemStack(teMaterialsItem, 1, 512);
            redstoneReceptionCoil = new ItemStack(teMaterialsItem, 1, 513);
            redstoneTransmissionCoil = new ItemStack(teMaterialsItem, 1, 514);
            redstoneConductanceCoil = new ItemStack(teMaterialsItem, 1, 515);
        }

        Fluid ender = FluidRegistry.getFluid("ender");
        bucketResonantEnder = FluidUtil.getFilledBucket(new FluidStack(ender, 1000));
        Fluid glowstone = FluidRegistry.getFluid("glowstone");
        bucketEnergizedGlowstone = FluidUtil.getFilledBucket(new FluidStack(glowstone, 1000));
        Fluid cryotheum = FluidRegistry.getFluid("cryotheum");
        bucketGelidCryotheum = FluidUtil.getFilledBucket(new FluidStack(cryotheum, 1000));
    }

}
