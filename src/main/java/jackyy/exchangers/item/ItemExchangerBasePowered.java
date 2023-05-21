package jackyy.exchangers.item;

import cofh.core.item.IEnchantableItem;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.registry.ModConfig;
import jackyy.gunpowderlib.capability.FEItemStackCapability;
import jackyy.gunpowderlib.capability.FEStorageCapability;
import jackyy.gunpowderlib.capability.IFEContainer;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@Optional.Interface(iface = "cofh.core.item.IEnchantableItem", modid = "cofhcore")
public class ItemExchangerBasePowered extends ItemExchangerBase implements IFEContainer, IEnchantableItem {

    @GameRegistry.ObjectHolder("cofhcore:holding")
    public static final Enchantment holding = null;

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
        if (container.getTagCompound() == null || !container.getTagCompound().hasKey(EnergyHelper.ENERGY_NBT)) {
            return 0;
        }
        return Math.min(NBTHelper.getInt(container, EnergyHelper.ENERGY_NBT), getMaxEnergyStored(container));
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        if (ModConfig.misc.holdingEnchantment && Loader.isModLoaded("cofhcore")) {
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
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / " + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " " + ModConfig.misc.energyUnit);
        }
    }

    @Override @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (checkLoaded()) {
                ItemStack empty = new ItemStack(this);
                ExchangerHandler.setDefaultTagCompound(empty);
                list.add(empty);
                ItemStack full = new ItemStack(this);
                ExchangerHandler.setDefaultTagCompound(full);
                EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                list.add(full);
            }
        }
    }

    @Override
    public boolean isPowered() {
        return true;
    }

    /* CAPABILITIES */
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new FEItemStackCapability(new FEStorageCapability(this, stack));
    }

    /* HOLDING ENCHANT */
    @Override @Optional.Method(modid = "cofhcore")
    public boolean canEnchant(ItemStack stack, Enchantment enchantment) {
        return ModConfig.misc.holdingEnchantment && Loader.isModLoaded("cofhcore") && enchantment == holding;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.FORTUNE
                || enchantment == Enchantments.SILK_TOUCH
                || enchantment == Enchantments.UNBREAKING;
    }

}
