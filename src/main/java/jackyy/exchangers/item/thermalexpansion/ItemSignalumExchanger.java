package jackyy.exchangers.item.thermalexpansion;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.helper.EnergyHelper;
import jackyy.exchangers.item.ItemExchangerBasePowered;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSignalumExchanger extends ItemExchangerBasePowered {

    public ItemSignalumExchanger(){
        setRegistryName(Exchangers.MODID + ":exsignalum");
        setUnlocalizedName(Exchangers.MODID + ".exsignalum");
        setMaxStackSize(1);
        setCreativeTab(Exchangers.TAB);
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.signalumMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.signalumPerBlockUse;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                if (isInCreativeTab(tab)) {
                    ItemStack empty = new ItemStack(this);
                    list.add(empty);
                    ItemStack full = new ItemStack(this);
                    EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                    list.add(full);
                }
            }
        }
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public int getMaxRange() {
        return MODE_13X13;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
