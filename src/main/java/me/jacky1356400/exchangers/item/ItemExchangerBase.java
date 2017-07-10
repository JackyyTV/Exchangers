package me.jacky1356400.exchangers.item;

import me.jacky1356400.exchangers.handler.ExchangerHandler;
import me.jacky1356400.exchangers.helper.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

import static me.jacky1356400.exchangers.helper.StringHelper.localize;

public class ItemExchangerBase extends ExchangerHandler {

	public boolean showDurabilityBar(ItemStack stack) {
		return stack.isItemDamaged();
	}

	public boolean isPowered() {
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
		super.addInformation(stack, player, tooltip, bool);
		if (!isPowered()){
			tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + localize("tooltip.durability"));
		}
	}

}
