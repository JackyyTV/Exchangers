package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.helper.EnergyHelper;
import jackyy.exchangers.item.ItemExchangerBasePowered;
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

public class ItemLVExchanger extends ItemExchangerBasePowered {

    public ItemLVExchanger(){
        setRegistryName(Exchangers.MODID + ":lv_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".lv_exchanger");
        setMaxStackSize(1);
        setCreativeTab(Exchangers.TAB);
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.lvMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.lvPerBlockUse;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Config.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                ItemStack empty = new ItemStack(this);
                list.add(empty);
                ItemStack full = new ItemStack(this);
                EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                list.add(full);
            }
        }
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getMaxRange() {
        return MODE_5X5;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
