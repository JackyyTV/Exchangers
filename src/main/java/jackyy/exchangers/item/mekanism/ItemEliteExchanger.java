package jackyy.exchangers.item.mekanism;

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

public class ItemEliteExchanger extends ItemExchangerBasePowered {

    public ItemEliteExchanger() {
        setRegistryName(Reference.MODID + ":elite_exchanger");
        setTranslationKey(Reference.MODID + ".elite_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.mekanismTweaks.eliteMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.mekanismTweaks.elitePerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.mekanismModule && Loader.isModLoaded(Reference.MEK);
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.mekanismTweaks.eliteMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.mekanismTweaks.eliteMaxRange;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
