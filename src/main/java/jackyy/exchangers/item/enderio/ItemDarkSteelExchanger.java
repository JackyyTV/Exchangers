package jackyy.exchangers.item.enderio;

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

public class ItemDarkSteelExchanger extends ItemExchangerBasePowered {

    public ItemDarkSteelExchanger() {
        setRegistryName(Exchangers.MODID + ":dark_steel_exchanger");
        setTranslationKey(Exchangers.MODID + ".dark_steel_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.enderIOTweaks.darkSteelMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.enderIOTweaks.darkSteelPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.enderIOTweaks.darkSteelMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.enderIOTweaks.darkSteelMaxRange;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
