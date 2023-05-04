package jackyy.exchangers.registry;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.util.Reference;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {

    public static CreativeModeTab tab;
    @SubscribeEvent
    public static void registerCreativeTab(CreativeModeTabEvent.Register event) {
        tab = event.registerCreativeModeTab(
                new ResourceLocation(Reference.MODID, "main_creative_tab"), builder -> builder
                        .title(Component.translatable("item_group." + Reference.MODID + ".main_creative_tab"))
                        .icon(() -> new ItemStack(ModItems.OBSIDIAN_EXCHANGER.get()))
                        .displayItems((params, output) -> {
                            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                                Item itemToAdd = item.get();
                                if (itemToAdd instanceof ItemExchangerBase) {
                                    if (((ItemExchangerBase) itemToAdd).checkLoaded()) {
                                        ItemStack stack = new ItemStack(itemToAdd);
                                        ExchangerHandler.setDefaultTagCompound(stack);
                                        output.accept(stack);
                                    }
                                } else if (itemToAdd instanceof ItemCoreBase) {
                                    if (((ItemCoreBase) itemToAdd).checkLoaded()) {
                                        output.accept(itemToAdd);
                                    }
                                }
                            }
                        })
        );
    }

}
