package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBasePowered;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMVExchanger extends ItemExchangerBasePowered {

    public ItemMVExchanger(){
        setRegistryName(Exchangers.MODID + ":exmv");
        setUnlocalizedName(Exchangers.MODID + ".exmv");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.mvMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.mvPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return Config.immersiveEngineeringModule && Loader.isModLoaded(Exchangers.IE);
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public int getMaxRange() {
        return MODE_11X11;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

}
