package jackyy.exchangers.item.enderio;

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

public class ItemVibrantExchanger extends ItemExchangerBasePowered {

    public ItemVibrantExchanger(){
        setRegistryName(Exchangers.MODID + ":exvibrant");
        setUnlocalizedName(Exchangers.MODID + ".exvibrant");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.vibrantMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.vibrantPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return Config.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public int getTier() {
        return 6;
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
