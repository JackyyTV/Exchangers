package jackyy.exchangers.item.enderioendergy;

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

public class ItemStellarExchanger extends ItemExchangerBasePowered {

    public ItemStellarExchanger() {
        setRegistryName(Reference.MODID + ":stellar_exchanger");
        setTranslationKey(Reference.MODID + ".stellar_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.enderIOEndergyTweaks.stellarMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.enderIOEndergyTweaks.stellarPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOEndergyModule && Loader.isModLoaded(Reference.EIO_ENDERGY);
    }

    @Override
    public int getTier() {
        return 6;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.enderIOEndergyTweaks.stellarMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.enderIOEndergyTweaks.stellarMaxRange;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
