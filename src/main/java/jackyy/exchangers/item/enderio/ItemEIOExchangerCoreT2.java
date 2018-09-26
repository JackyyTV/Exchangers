package jackyy.exchangers.item.enderio;

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

public class ItemEIOExchangerCoreT2 extends ItemCoreBase {

    public ItemEIOExchangerCoreT2() {
        setRegistryName(Exchangers.MODID + ":eio_exchanger_core_tier2");
        setTranslationKey(Exchangers.MODID + ".eio_exchanger_core_tier2");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

}
