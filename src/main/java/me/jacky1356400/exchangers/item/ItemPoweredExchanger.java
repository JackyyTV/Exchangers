package me.jacky1356400.exchangers.item;

import cofh.redstoneflux.api.IEnergyContainerItem;
import cofh.redstoneflux.util.EnergyContainerItemWrapper;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.helper.NBTHelper;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.util.Tier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.List;

public class ItemPoweredExchanger extends ItemExchanger implements IEnergyContainerItem {

    private final int maxEnergy;
    private final int perBlockUse;

    public ItemPoweredExchanger(String name, Tier tier, int maxStorage, int perBlock) {
        super(name, true, tier, 0);
        maxEnergy = maxStorage;
        perBlockUse = perBlock;
    }

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
        return maxEnergy;
    }

    public int getPerBlockCost() {
        return perBlockUse;
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
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / "
                + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
        tooltip.add(getTier().getFormattedText());
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isPowered() {
        return true;
    }

    @Override
    public boolean isCreative() {
        return false;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            ItemStack empty = new ItemStack(this);
            list.add(empty);
            ItemStack full = new ItemStack(this);
            EnergyHelper.setDefaultEnergyTag(full, maxEnergy);
            list.add(full);
        }
    }

    /* CAPABILITIES */
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {

        return new EnergyContainerItemWrapper(stack, this);
    }
}
