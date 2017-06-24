package jacky.exchangers.item.vanilla;

import jacky.exchangers.Exchangers;
import jacky.exchangers.init.Data;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemExchangerCoreT1 extends Item {

	public ItemExchangerCoreT1() {
		setRegistryName(Data.MODID + ":exchanger_core_tier1");
		setUnlocalizedName(Data.MODID + ".exchanger_core_tier1");
		setMaxStackSize(16);
		setCreativeTab(Exchangers.exchangersCreativeTab);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
