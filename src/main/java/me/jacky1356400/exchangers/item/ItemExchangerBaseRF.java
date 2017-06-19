package me.jacky1356400.exchangers.item;

import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.ItemEnergyContainer;
import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class ItemExchangerBaseRF extends ExchangerHandler implements IEnergyContainerItem {

	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;

	public ItemExchangerBaseRF() {
		super();
	}

	public ItemExchangerBaseRF setMaxTransfer(int maxTransfer) {

		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
		return this;
	}

	public ItemExchangerBaseRF setMaxReceive(int maxReceive) {

		this.maxReceive = maxReceive;
		return this;
	}

	public ItemExchangerBaseRF setMaxExtract(int maxExtract) {

		this.maxExtract = maxExtract;
		return this;
	}

	/* IEnergyContainerItem */
	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

		if (!container.hasTagCompound()) {
			container.setTagCompound(new NBTTagCompound());
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

		if (!simulate) {
			energy += energyReceived;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyReceived;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

		if (!simulate) {
			energy -= energyExtracted;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyExtracted;
	}

	@Override
	public int getEnergyStored(ItemStack container) {

		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		return container.getTagCompound().getInteger("Energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return capacity;
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 1D-(getEnergyStored(stack)/getMaxEnergyStored(stack));
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
		super.addInformation(stack, player, tooltip, bool);
		tooltip.add(getEnergyStored(stack) + " / " + getMaxEnergyStored(stack) + " RF");
	}

}
