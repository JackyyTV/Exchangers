package jackyy.exchangers;

import jackyy.exchangers.handler.ClientEventsHandler;
import jackyy.exchangers.handler.CommonEventsHandler;
import jackyy.exchangers.handler.network.NetworkHandler;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.registry.ModItems;
import jackyy.exchangers.registry.crafting.ModCrafting;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class Exchangers {

    public Exchangers() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        ModCrafting.registerConditions();
        ModItems.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        /*
        TODO add Better With Mods integration back when possible
        if (ModList.get().isLoaded(Reference.BWM)) {
            MinecraftForge.EVENT_BUS.register(new BetterWithModsIntegration());
        }
        */
        MinecraftForge.EVENT_BUS.register(new CommonEventsHandler());
        NetworkHandler.registerMessages();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new ClientEventsHandler());
    }

}
