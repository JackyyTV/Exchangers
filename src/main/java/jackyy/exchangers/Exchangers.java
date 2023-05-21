package jackyy.exchangers;

import jackyy.exchangers.proxy.CommonProxy;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.MODNAME, dependencies = Reference.DEPENDS, certificateFingerprint = "@FINGERPRINT@", acceptedMinecraftVersions = Reference.MCVERSION, useMetadata = true)
public class Exchangers {

    @SidedProxy(serverSide = Reference.COMMON_PROXY, clientSide = Reference.CLIENT_PROXY)
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
        Reference.LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been modified or running in dev environment.");
    }

}
