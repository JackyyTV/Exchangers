package me.jacky1356400.exchangers.item;

import cofh.api.energy.IEnergyContainerItem;
import me.jacky1356400.exchangers.handler.ExchangerHandler;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.helper.NBTHelper;
import me.jacky1356400.exchangers.helper.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.text.NumberFormat;
import java.util.List;

public class ItemExchangerBaseRF extends ExchangerHandler implements IEnergyContainerItem {

	@Override
	public int receiveEnergy(ItemStack container, int energy, boolean simulate) {
		return NBTHelper.receiveEnergy(container, energy, getMaxEnergyStored(container), simulate);
	}

	@Override
	public int extractEnergy(ItemStack container, int energy, boolean simulate) {
		return NBTHelper.extractEnergy(container, energy, simulate);
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		return NBTHelper.getEnergyStored(container);
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return 0;
	}

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
		tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / " + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}

}
