package me.jacky1356400.exchangers.item.thermalexpansion;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchangerBaseRF;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemHardenedExchanger extends ItemExchangerBaseRF {

    public ItemHardenedExchanger(){
        setRegistryName(Exchangers.MODID + ":hardened_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".hardened_exchanger");
        setMaxStackSize(1);
        setCreativeTab(Exchangers.exchangersCreativeTab);
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return Config.hardenedMaxEnergy;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        ItemStack empty = new ItemStack(this);
        list.add(empty);
        ItemStack full = new ItemStack(this);
        EnergyHelper.setDefaultEnergyTag(full, Config.hardenedMaxEnergy);
        list.add(full);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);
        tooltip.add(StringHelper.getTierText(2));
    }

}
