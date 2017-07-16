package me.jacky1356400.exchangers.integration;

import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class MekanismIntegration {

	public static ItemStack circuitBasic;
	public static ItemStack circuitAdvanced;
	public static ItemStack circuitElite;
	public static ItemStack circuitUltimate;
	public static ItemStack teleportationCore;
	public static ItemStack energyTablet;
	public static ItemStack portableTeleporter;

	public static void init() {
		Exchangers.logger.info("Fetching items for Mekanism integration...");

		Item circuitsItem = Item.REGISTRY.getObject(new ResourceLocation("mekanism", "ControlCircuit"));
		if (circuitsItem != null) {
			circuitBasic = new ItemStack(circuitsItem, 1, 0);
			circuitAdvanced = new ItemStack(circuitsItem, 1, 1);
			circuitElite = new ItemStack(circuitsItem, 1, 2);
			circuitUltimate = new ItemStack(circuitsItem, 1, 3);
		}

		Item energyTabletItem = Item.REGISTRY.getObject(new ResourceLocation("mekanism", "EnergyTablet"));
		if (energyTabletItem != null) {
			energyTablet = new ItemStack(energyTabletItem, 1, 0);
		}

		Item teleportationCoreItem = Item.REGISTRY.getObject(new ResourceLocation("mekanism", "TeleportationCore"));
		if (teleportationCoreItem != null) {
			teleportationCore = new ItemStack(teleportationCoreItem, 1, 0);
		}

		Item portableTeleporterItem = Item.REGISTRY.getObject(new ResourceLocation("mekanism", "PortableTeleporter"));
		if (portableTeleporterItem != null) {
			portableTeleporter = new ItemStack(portableTeleporterItem, 1, 0);
		}
	}

}
