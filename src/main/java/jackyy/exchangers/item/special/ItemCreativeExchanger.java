package jackyy.exchangers.item.special;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger(){
        setRegistryName(Exchangers.MODID + ":creative_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".creative_exchanger");
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
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Config.specialModule) {
            list.add(new ItemStack(this));
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
