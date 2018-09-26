package jackyy.exchangers.item.thermalexpansion;

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

public class ItemLeadstoneExchanger extends ItemExchangerBasePowered {

    public ItemLeadstoneExchanger() {
        setRegistryName(Exchangers.MODID + ":leadstone_exchanger");
        setTranslationKey(Exchangers.MODID + ".leadstone_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.thermalExpansionTweaks.leadstoneMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.thermalExpansionTweaks.leadstonePerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.thermalExpansionModule && Loader.isModLoaded(Exchangers.TE);
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.thermalExpansionTweaks.leadstoneMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.thermalExpansionTweaks.leadstoneMaxRange;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
