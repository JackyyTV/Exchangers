package jackyy.exchangers;

import jackyy.exchangers.proxy.CommonProxy;
import jackyy.exchangers.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Exchangers.MODID, version = Exchangers.VERSION, name = Exchangers.MODNAME, dependencies = Exchangers.DEPENDS, certificateFingerprint = "@FINGERPRINT@", acceptedMinecraftVersions = Exchangers.MCVERSION, useMetadata = true)
public class Exchangers {

    public static final String VERSION = "1.11.2-1.8.2";
    public static final String MCVERSION = "[1.11,1.12)";
    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";
    public static final String EIO = "enderio";
    public static final String TE = "thermalexpansion";
    public static final String MEK = "mekanism";
    public static final String IE = "immersiveengineering";
    public static final String DEPENDS
            = "after:" + EIO + ";"
            + "after:cofhcore;"
            + "after:thermalfoundation;"
            + "after:" + TE + ";"
            + "after:" + MEK + ";"
            + "after:" + IE + ";";
    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.obsidianExchanger);
        }
    };
    public static final EnumRarity TIER_1 = EnumHelper.addRarity("TIER_1", TextFormatting.GREEN, "Tier 1");

    public static Logger logger = LogManager.getLogger(MODNAME);

    @SidedProxy(serverSide = "jackyy.exchangers.proxy.CommonProxy", clientSide = "jackyy.exchangers.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        logger.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been modified. This will NOT be supported by the mod author!");
    }

}
