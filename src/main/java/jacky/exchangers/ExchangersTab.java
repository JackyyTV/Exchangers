package jacky.exchangers;

import jacky.exchangers.init.Data;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ExchangersTab extends CreativeTabs {

	public ExchangersTab() {
		super(Data.MODID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ExchangersItems.obsidianExchanger);
	}

}