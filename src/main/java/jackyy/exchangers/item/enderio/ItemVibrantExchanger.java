package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVibrantExchanger extends ItemExchangerBasePowered {

    public ItemVibrantExchanger() {
        setRegistryName(Reference.MODID + ":vibrant_exchanger");
        setTranslationKey(Reference.MODID + ".vibrant_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.enderIOTweaks.vibrantMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.enderIOTweaks.vibrantPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOModule && Loader.isModLoaded(Reference.EIO);
    }

    @Override
    public int getTier() {
        return 6;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.enderIOTweaks.vibrantMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.enderIOTweaks.vibrantMaxRange;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
