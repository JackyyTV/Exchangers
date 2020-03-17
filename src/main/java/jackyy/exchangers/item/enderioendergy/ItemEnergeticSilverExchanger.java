package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnergeticSilverExchanger extends ItemExchangerBasePowered {

    public ItemEnergeticSilverExchanger() {
        setRegistryName(Reference.MODID + ":energetic_silver_exchanger");
        setTranslationKey(Reference.MODID + ".energetic_silver_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.enderIOEndergyTweaks.energeticSilverMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.enderIOEndergyTweaks.energeticSilverPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOEndergyModule && Loader.isModLoaded(Reference.EIO_ENDERGY);
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.enderIOEndergyTweaks.energeticSilverMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.enderIOEndergyTweaks.energeticSilverMaxRange;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return Reference.TIER_1;
    }

}
