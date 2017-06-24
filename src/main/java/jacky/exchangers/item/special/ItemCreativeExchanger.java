package jacky.exchangers.item.special;

import java.util.List;

import jacky.exchangers.Exchangers;
import jacky.exchangers.helper.StringHelper;
import jacky.exchangers.init.Data;
import jacky.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeExchanger extends ItemExchangerBase {

	public ItemCreativeExchanger() {
		setRegistryName(Data.MODID + ":creative_exchanger");
		setUnlocalizedName(Data.MODID + ".creative_exchanger");
		setMaxStackSize(1);
		setCreativeTab(Exchangers.exchangersCreativeTab);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		tooltip.add(StringHelper.getTierText(9001));
	}

}
