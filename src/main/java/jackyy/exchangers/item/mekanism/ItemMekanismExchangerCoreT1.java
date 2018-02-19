package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMekanismExchangerCoreT1 extends ItemCoreBase {

    public ItemMekanismExchangerCoreT1(){
        setRegistryName(Exchangers.MODID + ":mekanism_exchanger_core_tier1");
        setUnlocalizedName(Exchangers.MODID + ".mekanism_exchanger_core_tier1");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.mekanismModule && Loader.isModLoaded(Exchangers.MEK);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
