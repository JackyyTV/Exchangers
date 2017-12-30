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

public class ItemBasicExchanger extends ItemExchangerBasePowered {

    public ItemBasicExchanger(){
        setRegistryName(Exchangers.MODID + ":basic_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".basic_exchanger");
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
        return Config.basicMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.basicPerBlockUse;
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
        return 1;
    }

    @Override
    public int getMaxRange() {
        return MODE_7X7;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
