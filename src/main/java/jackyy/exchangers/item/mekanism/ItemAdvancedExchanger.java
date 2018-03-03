package jackyy.exchangers.item.mekanism;

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

public class ItemAdvancedExchanger extends ItemExchangerBasePowered {

    public ItemAdvancedExchanger(){
        setRegistryName(Exchangers.MODID + ":advanced_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".advanced_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.mekanismTweaks.advancedMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.mekanismTweaks.advancedPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.mekanismModule && Loader.isModLoaded(Exchangers.MEK);
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public int getHarvestLevel() {
        return 3;
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
