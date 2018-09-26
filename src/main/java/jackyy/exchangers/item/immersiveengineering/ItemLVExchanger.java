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

public class ItemLVExchanger extends ItemExchangerBasePowered {

    public ItemLVExchanger() {
        setRegistryName(Exchangers.MODID + ":lv_exchanger");
        setTranslationKey(Exchangers.MODID + ".lv_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.immersiveEngineeringTweaks.lvMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.immersiveEngineeringTweaks.lvPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.immersiveEngineeringModule && Loader.isModLoaded(Exchangers.IE);
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.immersiveEngineeringTweaks.lvMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.immersiveEngineeringTweaks.lvMaxRange;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
