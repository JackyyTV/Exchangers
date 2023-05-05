package jackyy.exchangers.item;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.capability.FEItemStackCapability;
import jackyy.gunpowderlib.capability.FEStorageCapability;
import jackyy.gunpowderlib.capability.IFEContainer;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class ItemExchangerBasePowered extends ItemExchangerBase implements IFEContainer {

    public ItemExchangerBasePowered(Properties props) {
        super(props.durability(1));
    }

    @Override
    public int receiveEnergy(ItemStack container, int energy, boolean simulate) {
        return EnergyHelper.receiveEnergy(container, energy, simulate);
    }

    @Override
    public int extractEnergy(ItemStack container, int energy, boolean simulate) {
        return EnergyHelper.extractEnergy(container, energy, simulate);
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return EnergyHelper.getEnergyStored(container);
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        if (ModConfigs.CONFIG.holdingEnchantment.get() && ModList.get().isLoaded("cofh_core")) {
            int enchant = container.getEnchantmentLevel(Reference.holdingEnchant);
            return getMaxEnergy() + getMaxEnergy() * enchant / 2;
        }
        return getMaxEnergy();
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        if (stack.getTag() == null) {
            EnergyHelper.setDefaultEnergyTag(stack, 0);
        }
        return (int) Math.round(13.0D * getEnergyStored(stack) / (double) getMaxEnergyStored(stack));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(1 / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(
                    StringHelper.formatNumber(getEnergyStored(stack))
                            .append(" / ")
                            .append(StringHelper.formatNumber(getMaxEnergyStored(stack)))
                            .append(" " + ModConfigs.CONFIG.energyUnit.get())
            );
        }
    }

    @Override @OnlyIn(Dist.CLIENT)
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (allowedIn(tab)) {
            if (checkLoaded()) {
                ItemStack empty = new ItemStack(this);
                ExchangerHandler.setDefaultTagCompound(empty);
                items.add(empty);
                ItemStack full = new ItemStack(this);
                ExchangerHandler.setDefaultTagCompound(full);
                EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                items.add(full);
            }
        }
    }

    @Override
    public boolean isPowered() {
        return true;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
        return new FEItemStackCapability<>(new FEStorageCapability(this, stack));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.BLOCK_FORTUNE
                || enchantment == Enchantments.SILK_TOUCH
                || enchantment == Enchantments.UNBREAKING;
    }

}
