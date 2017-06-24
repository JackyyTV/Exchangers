package jacky.exchangers.item;

import jacky.exchangers.util.Data;
import jacky.exchangers.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBasic extends Item implements IHasModel {

	public ItemBasic(String name) {
		setRegistryName(Data.MODID, name);
		setUnlocalizedName(Data.MODID + "." + name);
		setCreativeTab(Data.TAB);
		Data.ITEMS.add(this);
	}

}
