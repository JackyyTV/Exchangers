package jackyy.exchangers.proxy;

import jackyy.exchangers.ExchangersItems;
import jackyy.exchangers.client.Keys;
import jackyy.exchangers.handler.ClientTickHandler;
import jackyy.exchangers.handler.GUIHandler;
import jackyy.exchangers.handler.KeyBindingsHandler;
import jackyy.exchangers.handler.RenderOverlayHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ExchangersItems.initModels();
        MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        MinecraftForge.EVENT_BUS.register(new KeyBindingsHandler());
        Keys.init();
        MinecraftForge.EVENT_BUS.register(new RenderOverlayHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        MinecraftForge.EVENT_BUS.register(new GUIHandler());
    }

}