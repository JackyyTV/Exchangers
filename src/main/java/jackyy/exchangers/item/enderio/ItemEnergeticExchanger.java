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

public class ItemEnergeticExchanger extends ItemExchangerBasePowered {

    public ItemEnergeticExchanger() {
        setRegistryName(Exchangers.MODID + ":energetic_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".energetic_exchanger");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfig.enderIOTweaks.energeticMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.enderIOTweaks.energeticPerBlockUse;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.enderIOTweaks.energeticMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.enderIOTweaks.energeticMaxRange;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

}
