package me.jacky1356400.exchangers.item.powered.mekanism;

import java.util.List;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import jacky.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemPoweredExchanger;
import me.jacky1356400.exchangers.util.Data;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAdvancedExchanger extends ItemPoweredExchanger {

	public ItemAdvancedExchanger() {
		setRegistryName(Data.MODID + ":advanced_exchanger");
		setUnlocalizedName(Data.MODID + ".advanced_exchanger");
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
		return Config.advancedExchangerMaxRF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		ItemStack empty = new ItemStack(this);
		list.add(empty);
		ItemStack full = new ItemStack(this);
		EnergyHelper.setDefaultEnergyTag(full, Config.advancedExchangerMaxRF);
		list.add(full);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		tooltip.add(StringHelper.getTierText(2));
	}

}
