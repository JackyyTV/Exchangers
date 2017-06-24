package jacky.exchangers.item.enderio;

import java.util.List;

import javax.annotation.Nonnull;

import jacky.exchangers.Config;
import jacky.exchangers.Exchangers;
import jacky.exchangers.helper.EnergyHelper;
import jacky.exchangers.helper.StringHelper;
import jacky.exchangers.init.Data;
import jacky.exchangers.item.ItemExchangerBaseRF;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemElectricalSteelExchanger extends ItemExchangerBaseRF {

	public ItemElectricalSteelExchanger() {
		setRegistryName(Data.MODID + ":electrical_steel_exchanger");
		setUnlocalizedName(Data.MODID + ".electrical_steel_exchanger");
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
		return Config.electricalSteelExchangerMaxRF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		ItemStack empty = new ItemStack(this);
		list.add(empty);
		ItemStack full = new ItemStack(this);
		EnergyHelper.setDefaultEnergyTag(full, Config.electricalSteelExchangerMaxRF);
		list.add(full);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		tooltip.add(StringHelper.getTierText(2));
	}

}
