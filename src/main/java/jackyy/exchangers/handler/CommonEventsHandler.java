package jackyy.exchangers.handler;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonEventsHandler {

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        ItemStack outputStack = event.getCrafting();
        Item outputItem = outputStack.getItem();
        CompoundNBT tags;
        if (outputItem instanceof ItemExchangerBase) {
            for (int i = 0; i < event.getInventory().getSizeInventory(); i++) {
                ItemStack input = event.getInventory().getStackInSlot(i);
                if (!(input.getItem() instanceof ItemExchangerBase)) {
                    continue;
                }
                if (input.getItem() instanceof ItemExchangerBase) {
                    tags = NBTHelper.getTag(input).copy();
                    outputStack.setTag(tags);
                    if (outputStack.isDamaged()) {
                        outputStack.setDamage(0);
                    }
                    break;
                }
            }
        }
    }

}
