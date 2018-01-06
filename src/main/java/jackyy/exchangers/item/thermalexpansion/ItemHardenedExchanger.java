package jackyy.exchangers.item.thermalexpansion;

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

public class ItemHardenedExchanger extends ItemExchangerBasePowered {

    public ItemHardenedExchanger(){
        setRegistryName(Exchangers.MODID + ":exhardened");
        setUnlocalizedName(Exchangers.MODID + ".exhardened");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.hardenedMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.hardenedPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return Config.thermalExpansionModule && Loader.isModLoaded(Exchangers.TE);
    }

    @Override
    public int getTier() {
        return 2;
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
