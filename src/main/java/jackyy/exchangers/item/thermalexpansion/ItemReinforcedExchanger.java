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

public class ItemReinforcedExchanger extends ItemExchangerBasePowered {

    public ItemReinforcedExchanger(){
        setRegistryName(Exchangers.MODID + ":reinforced_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".reinforced_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.thermalExpansionTweaks.reinforcedMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.thermalExpansionTweaks.reinforcedPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.thermalExpansionModule && Loader.isModLoaded(Exchangers.TE);
    }

    @Override
    public int getTier() {
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
