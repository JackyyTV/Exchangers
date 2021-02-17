package jackyy.exchangers.handler;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class CommonEventsHandler {

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        ItemStack output = event.getCrafting();
        if (output.getItem() instanceof ItemExchangerBase) {
            for (int i = 0; i < event.getInventory().getSizeInventory(); i++) {
                ItemStack input = event.getInventory().getStackInSlot(i);
                if (!(input.getItem() instanceof ItemExchangerBase)) {
                    continue;
                }
                if (input.getItem() instanceof ItemExchangerBase) {
                    CompoundNBT tags = NBTHelper.getTag(input).copy();
                    ItemStack crafted = output.copy();
                    crafted.setTag(tags);
                    if (crafted.isDamaged()) {
                        crafted.setDamage(0);
                    }
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        if (ModConfigs.CONFIG.holdingEnchantment.get() && ModList.get().isLoaded("cofh_core")) {
            ItemStack left = event.getLeft();
            ItemStack right = event.getRight();
            int holdingLevel = EnchantmentHelper.getEnchantmentLevel(Reference.holdingEnchant, left);
            if (left.getItem() instanceof ItemExchangerBasePowered && right.getItem() instanceof EnchantedBookItem && holdingLevel == 0) {
                ListNBT enchantments = EnchantedBookItem.getEnchantments(right);
                for (int j = 0; j < enchantments.size(); ++j) {
                    CompoundNBT nbtRight = enchantments.getCompound(j);
                    ResourceLocation idRight = ResourceLocation.tryCreate(nbtRight.getString("id"));
                    if (idRight != null && idRight.equals(new ResourceLocation("cofh_core", "holding"))) {
                        ItemStack enchanted = left.copy();
                        int lvl = nbtRight.getInt("lvl");
                        enchanted.addEnchantment(Reference.holdingEnchant, lvl);
                        event.setOutput(enchanted);
                        event.setCost(lvl);
                    }
                }
            }
        }
    }



}
