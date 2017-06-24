package me.jacky1356400.exchangers.item.powered.enderio;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.util.Data;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEIOExchangerCoreT3 extends Item {

	public ItemEIOExchangerCoreT3() {
		setRegistryName(Data.MODID + ":eio_exchanger_core_tier3");
		setUnlocalizedName(Data.MODID + ".eio_exchanger_core_tier3");
		setMaxStackSize(16);
		setCreativeTab(Exchangers.exchangersCreativeTab);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
