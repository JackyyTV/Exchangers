package me.jacky1356400.exchangers.item.thermalexpansion;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemTEExchangerCoreT2 extends Item {

    public ItemTEExchangerCoreT2(){
        setRegistryName(Exchangers.MODID + ":te_exchanger_core_tier2");
        setUnlocalizedName(Exchangers.MODID + ".te_exchanger_core_tier2");
        setMaxStackSize(16);
        setCreativeTab(Exchangers.exchangersCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded("thermalexpansion")) {
                list.add(new ItemStack(this));
            }
        }
    }

}
