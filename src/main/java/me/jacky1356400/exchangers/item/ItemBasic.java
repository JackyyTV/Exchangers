package me.jacky1356400.exchangers.item;

import me.jacky1356400.exchangers.util.Data;
import me.jacky1356400.exchangers.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBasic extends Item implements IHasModel {

    public ItemBasic(String name) {
        setRegistryName(Data.MODID, name);
        setUnlocalizedName(Data.MODID + "." + name);
        setCreativeTab(Data.TAB);
        Data.ITEMS.add(this);
    }

}
