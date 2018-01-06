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

public class ItemConductiveIronExchanger extends ItemExchangerBasePowered {

    public ItemConductiveIronExchanger(){
        setRegistryName(Exchangers.MODID + ":exconductive");
        setUnlocalizedName(Exchangers.MODID + ".exconductive");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return Config.conductiveMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.conductivePerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return Config.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getMaxRange() {
        return MODE_3X3;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
