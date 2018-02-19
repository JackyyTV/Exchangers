package jackyy.exchangers.integration;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class MekanismIntegration {

    public static Object circuitBasic;
    public static Object circuitAdvanced;
    public static Object circuitElite;
    public static Object circuitUltimate;
    public static ItemStack teleportationCore;
    public static ItemStack energyTablet;
    public static ItemStack portableTeleporter;

    public static void init() {
        Exchangers.logger.info("Fetching items for Mekanism integration...");

        if (ModConfig.misc.useOreDictCircuits) {
            circuitBasic = "circuitBasic";
            circuitAdvanced = "circuitAdvanced";
            circuitElite = "circuitElite";
            circuitUltimate = "circuitUltimate";
        } else {
            Item circuitsItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.MEK, "ControlCircuit"));
            if (circuitsItem != null) {
                circuitBasic = new ItemStack(circuitsItem, 1, 0);
                circuitAdvanced = new ItemStack(circuitsItem, 1, 1);
                circuitElite = new ItemStack(circuitsItem, 1, 2);
                circuitUltimate = new ItemStack(circuitsItem, 1, 3);
            }
        }

        Item energyTabletItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.MEK, "EnergyTablet"));
        if (energyTabletItem != null) {
            energyTablet = new ItemStack(energyTabletItem, 1, 0);
        }

        Item teleportationCoreItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.MEK, "TeleportationCore"));
        if (teleportationCoreItem != null) {
            teleportationCore = new ItemStack(teleportationCoreItem, 1, 0);
        }

        Item portableTeleporterItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.MEK, "PortableTeleporter"));
        if (portableTeleporterItem != null) {
            portableTeleporter = new ItemStack(portableTeleporterItem, 1, 0);
        }
    }

}
