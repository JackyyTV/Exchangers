package jackyy.exchangers.item;

import cofh.api.energy.IEnergyContainerItem;
import cofh.core.item.IEnchantableItem;
import jackyy.exchangers.Config;
import jackyy.exchangers.helper.EnergyHelper;
import jackyy.exchangers.helper.NBTHelper;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.util.EnergyContainerItemWrapper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;

import java.util.List;

@Optional.Interface(iface = "cofh.core.item.IEnchantableItem", modid = "cofhcore")
public class ItemExchangerBasePowered extends ItemExchangerBase implements IEnergyContainerItem, IEnchantableItem {

    private Enchantment holding = Enchantment.getEnchantmentByLocation("cofhcore:holding");

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
	    if (Config.holdingEnchantment && Loader.isModLoaded("cofhcore")) {
            int enchant = EnchantmentHelper.getEnchantmentLevel(holding, container);
            return getMaxEnergy() + getMaxEnergy() * enchant / 2;
        }
        return getMaxEnergy();
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
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / " + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
        }
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isPowered() {
		return true;
	}

    /* CAPABILITIES */
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new EnergyContainerItemWrapper(stack, this);
    }

    /* HOLDING ENCHANT */
    @Override
    public boolean canEnchant(ItemStack stack, Enchantment enchantment) {
        return Config.holdingEnchantment && Loader.isModLoaded("cofhcore") && enchantment == holding;
    }

}
