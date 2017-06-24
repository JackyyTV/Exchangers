package jacky.exchangers.item;

import jacky.exchangers.handler.ExchangerHandler;
import jacky.exchangers.init.Data;
import jacky.exchangers.init.IHasModel;
import net.minecraft.item.ItemStack;

public abstract class ItemExchangerBase extends ExchangerHandler implements IHasModel{
	
	public ItemExchangerBase(String name, boolean noRepair){
		setRegistryName(Data.MODID, name);
		setUnlocalizedName(Data.MODID + "." + name);
		setCreativeTab(Data.TAB);
		if(noRepair) setNoRepair();
		setMaxStackSize(1);
		Data.ITEMS.add(this);
	}

	public boolean showDurabilityBar(ItemStack stack) {
		return stack.isItemDamaged();
	}

}
