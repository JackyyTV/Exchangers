package jackyy.exchangers.item.thermalexpansion;

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

public class ItemTEExchangerCoreT1 extends ItemCoreBase {

    public ItemTEExchangerCoreT1(){
        setRegistryName(Exchangers.MODID + ":te_exchanger_core_tier1");
        setUnlocalizedName(Exchangers.MODID + ".te_exchanger_core_tier1");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.thermalExpansionModule && Loader.isModLoaded(Exchangers.TE);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
