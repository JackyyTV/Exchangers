package jackyy.exchangers.proxy;

import jackyy.exchangers.handler.EventsHandler;
import jackyy.exchangers.handler.network.PacketHandler;
import jackyy.exchangers.integration.BetterWithModsIntegration;
import jackyy.exchangers.registry.ModItems;
import jackyy.exchangers.registry.ModRecipes;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        PacketHandler.registerMessages(Reference.MODID);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
        if (Loader.isModLoaded(Reference.BWM)) {
            MinecraftForge.EVENT_BUS.register(new BetterWithModsIntegration());
        }
    }

    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        ModItems.init(e);
    }

    @SubscribeEvent
    public void onRecipeRegistry(RegistryEvent.Register<IRecipe> e) {
        ModRecipes.init(e);
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}
