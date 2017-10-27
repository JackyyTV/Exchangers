package me.jacky1356400.exchangers.item.mekanism;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemMekanismExchangerCoreT1 extends Item {

    public ItemMekanismExchangerCoreT1(){
        setRegistryName(Exchangers.MODID + ":mekanism_exchanger_core_tier1");
        setUnlocalizedName(Exchangers.MODID + ".mekanism_exchanger_core_tier1");
        setMaxStackSize(16);
        setCreativeTab(Exchangers.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Config.mekanismModule) {
            if (Loader.isModLoaded("Mekanism")) {
                list.add(new ItemStack(this));
            }
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
