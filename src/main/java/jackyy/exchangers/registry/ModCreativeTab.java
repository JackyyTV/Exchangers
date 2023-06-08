package jackyy.exchangers.registry;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.EnergyHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {

    public static CreativeModeTab tab = CreativeModeTab.builder()
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
                            if (((ItemExchangerBase) itemToAdd).isPowered()) {
                                ItemStack full = new ItemStack(itemToAdd);
                                ExchangerHandler.setDefaultTagCompound(full);
                                EnergyHelper.setDefaultEnergyTag(full, EnergyHelper.getMaxEnergyStored(full));
                                output.accept(full);
                            }
                        }
                    } else if (itemToAdd instanceof ItemCoreBase) {
                        if (((ItemCoreBase) itemToAdd).checkLoaded()) {
                            output.accept(itemToAdd);
                        }
                    }
                }
            })
            .build();

    @SubscribeEvent
    public static void registerCreativeModeTab(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB,
                helper -> helper.register(new ResourceLocation(Reference.MODID, "main_creative_tab"), tab)
        );
    }

}
