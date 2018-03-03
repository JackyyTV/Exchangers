package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHVExchanger extends ItemExchangerBasePowered {

    public ItemHVExchanger() {
        setRegistryName(Exchangers.MODID + ":hv_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".hv_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.immersiveEngineeringTweaks.hvMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.immersiveEngineeringTweaks.hvPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.immersiveEngineeringModule && Loader.isModLoaded(Exchangers.IE);
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public int getHarvestLevel() {
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
