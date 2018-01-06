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

public class ItemHVExchanger extends ItemExchangerBasePowered {

    public ItemHVExchanger(){
        setRegistryName(Exchangers.MODID + ":exhv");
        setUnlocalizedName(Exchangers.MODID + ".exhv");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.hvMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.hvPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return Config.immersiveEngineeringModule && Loader.isModLoaded(Exchangers.IE);
    }

    @Override
    public int getTier() {
        return 3;
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
