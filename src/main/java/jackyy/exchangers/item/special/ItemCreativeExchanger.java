package jackyy.exchangers.item.special;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger(){
        setRegistryName(Exchangers.MODID + ":excreative");
        setUnlocalizedName(Exchangers.MODID + ".excreative");
        setMaxStackSize(1);
        setMaxDamage(9001);
        setCreativeTab(Exchangers.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 9001;
    }

    @Override
    public boolean isCreative() {
        return true;
    }

    @Override
    public int getMaxRange() {
        return MODE_25X25;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (Config.specialModule) {
            if (isInCreativeTab(tab)) {
                list.add(new ItemStack(this));
            }
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
