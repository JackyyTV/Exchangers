package me.jacky1356400.exchangers;

import me.jacky1356400.exchangers.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Exchangers.MODID, version = Exchangers.VERSION, name = Exchangers.MODNAME, useMetadata = true)
public class Exchangers {

    public static final String VERSION = "1.12-1.0";
    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";
    public static final ExchangersTab exchangersCreativeTab = new ExchangersTab();

    public static Logger logger = LogManager.getLogger("Exchangers");

    @SidedProxy(serverSide = "me.jacky1356400.exchangers.proxy.CommonProxy", clientSide = "me.jacky1356400.exchangers.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit(e);
    }

}
