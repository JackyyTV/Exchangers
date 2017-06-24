package me.jacky1356400.exchangers.integration;

import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;

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
		Exchangers.logger.info("Fetching items for Thermal Expansion integration...");

		Item fluxCapacitorItem = Item.REGISTRY.getObject(new ResourceLocation("thermalexpansion", "capacitor"));
		if (fluxCapacitorItem != null) {
			fluxCapacitorBasic = new ItemStack(fluxCapacitorItem, 1, 0);
			fluxCapacitorHardened = new ItemStack(fluxCapacitorItem, 1, 1);
			fluxCapacitorReinforced = new ItemStack(fluxCapacitorItem, 1, 2);
			fluxCapacitorSignalum = new ItemStack(fluxCapacitorItem, 1, 3);
			fluxCapacitorResonant = new ItemStack(fluxCapacitorItem, 1, 4);
		}

		Item teMaterialsItem = Item.REGISTRY.getObject(new ResourceLocation("thermalfoundation", "material"));
		if (teMaterialsItem != null) {
			redstoneServo = new ItemStack(teMaterialsItem, 1, 512);
			redstoneReceptionCoil = new ItemStack(teMaterialsItem, 1, 513);
			redstoneTransmissionCoil = new ItemStack(teMaterialsItem, 1, 514);
			redstoneConductanceCoil = new ItemStack(teMaterialsItem, 1, 515);
		}

		Fluid ender = FluidRegistry.getFluid("ender");
		bucketResonantEnder = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ender);
		Fluid glowstone = FluidRegistry.getFluid("glowstone");
		bucketEnergizedGlowstone = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket,
				glowstone);
		Fluid cryotheum = FluidRegistry.getFluid("cryotheum");
		bucketGelidCryotheum = UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket,
				cryotheum);
	}
}
