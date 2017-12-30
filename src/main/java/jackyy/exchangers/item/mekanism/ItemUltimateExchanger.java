package jackyy.exchangers.item.mekanism;

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

public class ItemUltimateExchanger extends ItemExchangerBasePowered {

    public ItemUltimateExchanger(){
        setRegistryName(Exchangers.MODID + ":ultimate_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".ultimate_exchanger");
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
        return Config.ultimateMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.ultimatePerBlockUse;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Config.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
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
        return 4;
    }

    @Override
    public int getMaxRange() {
        return MODE_15X15;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
