package jackyy.exchangers.integration;

import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ObjectHelper;
import net.minecraft.item.ItemStack;

public class EnderIOEndergyIntegration {

    public static ItemStack grainyCapacitor;
    public static ItemStack silverCapacitor;
    public static ItemStack endergeticSilverCapacitor;
    public static ItemStack endergisedCapacitor;
    public static ItemStack crystallineCapacitor;
    public static ItemStack totemicCapacitor;
    public static ItemStack melodicCapacitor;
    public static ItemStack stellarCapacitor;
    public static ItemStack infinityDust;
    public static ItemStack glowstoneNanoParticles;

    public static void init() {
        Reference.LOGGER.info("Fetching items for Ender IO Endergy integration...");

        grainyCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_grainy", 1, 0);
        silverCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_silver", 1, 0);
        endergeticSilverCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_energetic_silver", 1, 0);
        endergisedCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_vivid", 1, 0);
        crystallineCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_crystalline", 1, 0);
        totemicCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_totemic", 1, 0);
        melodicCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_melodic", 1, 0);
        stellarCapacitor = ObjectHelper.getItemStackByName(Reference.EIO, "item_capacitor_stellar", 1, 0);

        infinityDust = ObjectHelper.getItemStackByName(Reference.EIO, "block_infinity_fog", 1, 0);
        glowstoneNanoParticles = ObjectHelper.getItemStackByName(Reference.EIO, "block_holy_fog", 1, 0);
    }

}
