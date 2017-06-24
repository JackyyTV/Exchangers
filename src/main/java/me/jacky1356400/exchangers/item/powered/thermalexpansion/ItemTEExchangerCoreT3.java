package me.jacky1356400.exchangers.item.powered.thermalexpansion;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.util.Data;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTEExchangerCoreT3 extends Item {

	public ItemTEExchangerCoreT3() {
		setRegistryName(Data.MODID + ":te_exchanger_core_tier3");
		setUnlocalizedName(Data.MODID + ".te_exchanger_core_tier3");
		setMaxStackSize(16);
		setCreativeTab(Exchangers.exchangersCreativeTab);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}