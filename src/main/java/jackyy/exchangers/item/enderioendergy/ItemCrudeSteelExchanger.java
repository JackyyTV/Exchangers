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

public class ItemCrudeSteelExchanger extends ItemExchangerBasePowered {

    public ItemCrudeSteelExchanger() {
        setRegistryName(Reference.MODID + ":crude_steel_exchanger");
        setTranslationKey(Reference.MODID + ".crude_steel_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.enderIOEndergyTweaks.crudeSteelMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.enderIOEndergyTweaks.crudeSteelPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOEndergyModule && Loader.isModLoaded(Reference.EIO_ENDERGY);
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.enderIOEndergyTweaks.crudeSteelMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.enderIOEndergyTweaks.crudeSteelMaxRange;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return Reference.TIER_1;
    }

}
