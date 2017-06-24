package me.jacky1356400.exchangers.item;

import java.util.List;

import me.jacky1356400.exchangers.util.Tier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPoweredExchanger extends ItemExchanger {

	private final int maxEnergy;
	private final int perBlockUse;

	public ItemPoweredExchanger(String name, Tier tier, int maxStorage, int perBlock) {
		super(name, true, tier, 0);
		maxEnergy = maxStorage;
		perBlockUse = perBlock;
	}

	//TODO implement Forge Energy

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return false; //TODO implement Forge Energy
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		/*
		if (!stack.hasTagCompound()) {
		EnergyHelper.setDefaultEnergyTag(stack, 0);
		}
		return 1D - ((double) stack.getTagCompound().getInteger("Energy") / (double) getMaxEnergyStored(stack));
		*/
		return 0; //TODO implement Forge Energy
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		ItemStack empty = new ItemStack(this);
		list.add(empty);
		ItemStack full = new ItemStack(this);
		//EnergyHelper.setDefaultEnergyTag(full, Config.darkSteelExchangerMaxRF);
		list.add(full);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		//tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / " + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public int getPerBlockCost() {
		return perBlockUse;
	}

	@Override
	public boolean isPowered() {
		return true;
	}

}
