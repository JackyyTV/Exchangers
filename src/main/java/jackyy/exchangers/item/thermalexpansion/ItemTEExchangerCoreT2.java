package jackyy.exchangers.item.thermalexpansion;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTEExchangerCoreT2 extends Item {

    public ItemTEExchangerCoreT2(){
        setRegistryName(Exchangers.MODID + ":teexcore_t2");
        setUnlocalizedName(Exchangers.MODID + ".teexcore_t2");
        setMaxStackSize(16);
        setCreativeTab(Exchangers.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (Config.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                if (isInCreativeTab(tab)) {
                    list.add(new ItemStack(this));
                }
            }
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

}
