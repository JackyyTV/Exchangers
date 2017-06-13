package me.jacky1356400.exchangers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ExchangersTab extends CreativeTabs {

    public ExchangersTab() {
        super(Exchangers.MODID);
    }
    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(ExchangersItems.obsidianExchanger);
    }

}