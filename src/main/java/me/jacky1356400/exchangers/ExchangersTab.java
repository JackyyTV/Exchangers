package me.jacky1356400.exchangers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExchangersTab extends CreativeTabs {

    public ExchangersTab() {
        super(Exchangers.MODID);
    }
    @Override
    public Item getTabIconItem(){
        return ExchangersItems.obsidianExchanger;
    }

}