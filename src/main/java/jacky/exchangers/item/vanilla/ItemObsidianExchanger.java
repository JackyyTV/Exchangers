package jacky.exchangers.item.vanilla;

import java.util.List;

import jacky.exchangers.Config;
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

public class ItemObsidianExchanger extends ItemExchangerBase {

	public ItemObsidianExchanger() {
		setRegistryName(Data.MODID + ":obsidian_exchanger");
		setUnlocalizedName(Data.MODID + ".obsidian_exchanger");
		setMaxStackSize(1);
		setMaxDamage(Config.obsidianExchangerMaxDamage);
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
		tooltip.add(StringHelper.getTierText(3));
	}

}
