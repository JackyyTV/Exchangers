package jacky.exchangers.item;

import jacky.exchangers.init.Data;
import jacky.exchangers.init.IHasModel;
import net.minecraft.item.Item;

public class ItemBasicBase extends Item implements IHasModel{

	public ItemBasicBase(String name) {
		setRegistryName(Data.MODID, name);
		setUnlocalizedName(Data.MODID + "." + name);
		setCreativeTab(Data.TAB);
		Data.ITEMS.add(this);
	}

}
