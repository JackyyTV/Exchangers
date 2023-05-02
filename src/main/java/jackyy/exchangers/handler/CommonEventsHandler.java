package jackyy.exchangers.handler;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class CommonEventsHandler {

    @SubscribeEvent
    public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        ItemStack output = event.getCrafting();
        if (output.getItem() instanceof ItemExchangerBase) {
            for (int i = 0; i < event.getInventory().getContainerSize(); i++) {
                ItemStack input = event.getInventory().getItem(i);
                if (!(input.getItem() instanceof ItemExchangerBase)) {
                    continue;
                }
                if (input.getItem() instanceof ItemExchangerBase) {
                    CompoundTag tags = NBTHelper.getTag(input).copy();
                    output.setTag(tags);
                    if (output.isDamaged()) {
                        output.setDamageValue(0);
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
            int holdingLevel = EnchantmentHelper.getItemEnchantmentLevel(Reference.holdingEnchant, left);
            if (left.getItem() instanceof ItemExchangerBasePowered && right.getItem() instanceof EnchantedBookItem && holdingLevel == 0) {
                ListTag enchantments = EnchantedBookItem.getEnchantments(right);
                for (int i = 0; i < enchantments.size(); ++i) {
                    CompoundTag nbt = enchantments.getCompound(i);
                    ResourceLocation id = ResourceLocation.tryParse(nbt.getString("id"));
                    if (id != null && id.equals(new ResourceLocation("cofh_core", "holding"))) {
                        ItemStack enchanted = left.copy();
                        int lvl = nbt.getInt("lvl");
                        enchanted.enchant(Reference.holdingEnchant, lvl);
                        event.setOutput(enchanted);
                        event.setCost(lvl);
                    }
                }
            }
        }
    }



}
