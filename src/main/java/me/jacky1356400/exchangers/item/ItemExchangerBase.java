package me.jacky1356400.exchangers.item;

import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.item.ItemStack;

public class ItemExchangerBase extends ExchangerHandler {

	public boolean showDurabilityBar(ItemStack stack) {
		return stack.isItemDamaged();
	}

}
