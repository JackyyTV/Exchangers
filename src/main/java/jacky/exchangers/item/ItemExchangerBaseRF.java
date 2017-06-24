package jacky.exchangers.item;

import java.util.List;

import jacky.exchangers.handler.ExchangerHandler;
import jacky.exchangers.helper.EnergyHelper;
import jacky.exchangers.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ItemExchangerBaseRF extends ItemExchangerBase {
	
	public ItemExchangerBaseRF(String name) {
		super(name, true);
	}

//TODO implement Forge Energy capabilities

	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		if (!stack.hasTagCompound()) {
			EnergyHelper.setDefaultEnergyTag(stack, 0);
		}
		return 1D - ((double) stack.getTagCompound().getInteger("Energy") / (double) getMaxEnergyStored(stack));
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / "
				+ StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}

}
