package jackyy.exchangers.item;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.gunpowderlib.capability.FEItemStackCapability;
import jackyy.gunpowderlib.capability.FEStorageCapability;
import jackyy.gunpowderlib.capability.IFEContainer;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.ModList;

import java.util.List;
import java.util.Map;

public class ItemExchangerBasePowered extends ItemExchangerBase implements IFEContainer {

    public ItemExchangerBasePowered(Properties props) {
        super(props.defaultMaxDamage(1));
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
            Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(container);
            for (Map.Entry<Enchantment, Integer> entry : enchants.entrySet()) {
                if (entry.getKey().getName().equals("enchantment.cofh_core.holding")) {
                    return getMaxEnergy() + getMaxEnergy() * entry.getValue() / 2;
                }
            }
        }
        return getMaxEnergy();
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if (stack.getTag() == null) {
            EnergyHelper.setDefaultEnergyTag(stack, 0);
        }
        return 1D - ((double) stack.getTag().getInt(EnergyHelper.ENERGY_NBT) / (double) getMaxEnergyStored(stack));
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(
                    StringHelper.formatNumber(getEnergyStored(stack))
                            .appendString(" / ")
                            .append(StringHelper.formatNumber(getMaxEnergyStored(stack)))
                            .appendString(" " + ModConfigs.CONFIG.energyUnit.get())
            );
        }
    }

    @Override @OnlyIn(Dist.CLIENT)
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (isInGroup(group)) {
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
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new FEItemStackCapability(new FEStorageCapability(this, stack));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        /*
        TODO add back fortune enchant support
        return enchantment == Enchantments.FORTUNE || enchantment == Enchantments.SILK_TOUCH || enchantment == Enchantments.UNBREAKING;
        */
        return enchantment == Enchantments.SILK_TOUCH || enchantment == Enchantments.UNBREAKING;
    }

}
