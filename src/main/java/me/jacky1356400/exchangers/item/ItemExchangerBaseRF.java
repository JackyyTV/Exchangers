package me.jacky1356400.exchangers.item;

import java.util.List;

import me.jacky1356400.exchangers.handler.ExchangerHandler;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.helper.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemExchangerBaseRF extends ExchangerHandler {//TODO implement Forge Energy capabilities

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		if (stack.getTagCompound() == null) {
			EnergyHelper.setDefaultEnergyTag(stack, 0);
		}
		return 1D - ((double) stack.getTagCompound().getInteger("Energy") / (double) getMaxEnergyStored(stack));
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
		super.addInformation(stack, player, tooltip, bool);
		tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / "
				+ StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}

}
