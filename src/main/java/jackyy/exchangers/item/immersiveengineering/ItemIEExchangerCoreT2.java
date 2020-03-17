package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemCoreBase;
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

public class ItemIEExchangerCoreT2 extends ItemCoreBase {

    public ItemIEExchangerCoreT2() {
        setRegistryName(Reference.MODID + ":ie_exchanger_core_tier2");
        setTranslationKey(Reference.MODID + ".ie_exchanger_core_tier2");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.immersiveEngineeringModule && Loader.isModLoaded(Reference.IE);
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

}
