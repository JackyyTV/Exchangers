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

public class ItemPulsatingIronExchanger extends ItemExchangerBasePowered {

    public ItemPulsatingIronExchanger(){
        setRegistryName(Exchangers.MODID + ":expulsating");
        setUnlocalizedName(Exchangers.MODID + ".expulsating");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.pulsatingMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.pulsatingPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return Config.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public int getTier() {
        return 2;
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
