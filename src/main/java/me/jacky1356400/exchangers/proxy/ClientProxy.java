package me.jacky1356400.exchangers.proxy;

import me.jacky1356400.exchangers.client.Keys;
import me.jacky1356400.exchangers.handler.KeyBindingsHandler;
import net.minecraft.client.Minecraft;
import me.jacky1356400.exchangers.ExchangersItems;
import me.jacky1356400.exchangers.handler.GUIHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e){
        super.preInit(e);
        ExchangersItems.initModels();
    }

    @Override
    public void init(FMLInitializationEvent e){
        super.init(e);
        MinecraftForge.EVENT_BUS.register(new KeyBindingsHandler());
        Keys.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e){
        super.postInit(e);
        MinecraftForge.EVENT_BUS.register(new GUIHandler((Minecraft.getMinecraft())));
    }

}