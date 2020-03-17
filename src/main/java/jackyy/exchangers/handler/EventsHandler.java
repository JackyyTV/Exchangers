package jackyy.exchangers.handler;

import jackyy.exchangers.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsHandler {

    /**
     * This exists to remap all the item IDs so they match with 1.10 and 1.11
     * Will be removed on 1.13
     */
    @SubscribeEvent
    public void onMissingMappings(RegistryEvent.MissingMappings<Item> event) {
        for (RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
            if (mapping.key.getNamespace().equals("exchangers")) {
                switch (mapping.key.getPath()) {
                    case ("expotato") :
                        mapping.remap(ModItems.tuberousExchanger);
                        break;
                    case ("excreative") :
                        mapping.remap(ModItems.creativeExchanger);
                        break;

                    case ("exwooden") :
                        mapping.remap(ModItems.woodenExchanger);
                        break;
                    case ("exstone") :
                        mapping.remap(ModItems.stoneExchanger);
                        break;
                    case ("exgolden") :
                        mapping.remap(ModItems.goldenExchanger);
                        break;
                    case ("exiron") :
                        mapping.remap(ModItems.ironExchanger);
                        break;
                    case ("exdiamond") :
                        mapping.remap(ModItems.diamondExchanger);
                        break;
                    case ("exemerald") :
                        mapping.remap(ModItems.emeraldExchanger);
                        break;
                    case ("exobsidian") :
                        mapping.remap(ModItems.obsidianExchanger);
                        break;
                    case ("excore_t1") :
                        mapping.remap(ModItems.exchangerCoreT1);
                        break;
                    case ("excore_t2") :
                        mapping.remap(ModItems.exchangerCoreT2);
                        break;
                    case ("excore_t3") :
                        mapping.remap(ModItems.exchangerCoreT3);
                        break;

                    case ("exconductive") :
                        mapping.remap(ModItems.conductiveIronExchanger);
                        break;
                    case ("expulsating") :
                        mapping.remap(ModItems.pulsatingIronExchanger);
                        break;
                    case ("exelectricalsteel") :
                        mapping.remap(ModItems.electricalSteelExchanger);
                        break;
                    case ("exenergetic") :
                        mapping.remap(ModItems.energeticExchanger);
                        break;
                    case ("exdarksteel") :
                        mapping.remap(ModItems.darkSteelExchanger);
                        break;
                    case ("exvibrant") :
                        mapping.remap(ModItems.vibrantExchanger);
                        break;
                    case ("eioexcore_t1") :
                        mapping.remap(ModItems.eioExchangerCoreT1);
                        break;
                    case ("eioexcore_t2") :
                        mapping.remap(ModItems.eioExchangerCoreT2);
                        break;
                    case ("eioexcore_t3") :
                        mapping.remap(ModItems.eioExchangerCoreT3);
                        break;

                    case ("exleadstone") :
                        mapping.remap(ModItems.leadstoneExchanger);
                        break;
                    case ("exhardened") :
                        mapping.remap(ModItems.hardenedExchanger);
                        break;
                    case ("exreinforced") :
                        mapping.remap(ModItems.reinforcedExchanger);
                        break;
                    case ("exsignalum") :
                        mapping.remap(ModItems.signalumExchanger);
                        break;
                    case ("exresonant") :
                        mapping.remap(ModItems.resonantExchanger);
                        break;
                    case ("teexcore_t1") :
                        mapping.remap(ModItems.teExchangerCoreT1);
                        break;
                    case ("teexcore_t2") :
                        mapping.remap(ModItems.teExchangerCoreT2);
                        break;
                    case ("teexcore_t3") :
                        mapping.remap(ModItems.teExchangerCoreT3);
                        break;

                    case ("exbasic") :
                        mapping.remap(ModItems.basicExchanger);
                        break;
                    case ("exadvanced") :
                        mapping.remap(ModItems.advancedExchanger);
                        break;
                    case ("exelite") :
                        mapping.remap(ModItems.eliteExchanger);
                        break;
                    case ("exultimate") :
                        mapping.remap(ModItems.ultimateExchanger);
                        break;
                    case ("mekexcore_t1") :
                        mapping.remap(ModItems.mekanismExchangerCoreT1);
                        break;
                    case ("mekexcore_t2") :
                        mapping.remap(ModItems.mekanismExchangerCoreT2);
                        break;
                    case ("mekexcore_t3") :
                        mapping.remap(ModItems.mekanismExchangerCoreT3);
                        break;

                    case ("exlv") :
                        mapping.remap(ModItems.lvExchanger);
                        break;
                    case ("exmv") :
                        mapping.remap(ModItems.mvExchanger);
                        break;
                    case ("exhv") :
                        mapping.remap(ModItems.hvExchanger);
                        break;
                    case ("ieexcore_t1") :
                        mapping.remap(ModItems.ieExchangerCoreT1);
                        break;
                    case ("ieexcore_t2") :
                        mapping.remap(ModItems.ieExchangerCoreT2);
                        break;
                    case ("ieexcore_t3") :
                        mapping.remap(ModItems.ieExchangerCoreT3);
                        break;
                }
            }
        }
    }

}
