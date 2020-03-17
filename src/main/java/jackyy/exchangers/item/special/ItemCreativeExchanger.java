package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger() {
        setRegistryName(Reference.MODID + ":creative_exchanger");
        setTranslationKey(Reference.MODID + ".creative_exchanger");
        setMaxDamage(9001);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 9001;
    }

    @Override
    public int getHarvestLevel() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isCreative() {
        return true;
    }

    @Override
    public int getMaxRange() {
        return 12;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.specialModule;
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
