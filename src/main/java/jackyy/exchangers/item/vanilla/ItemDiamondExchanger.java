package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDiamondExchanger extends ItemExchangerBase {

    public ItemDiamondExchanger(){
        setRegistryName(Exchangers.MODID + ":diamond_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".diamond_exchanger");
        setMaxDamage(ModConfig.vanillaTweaks.diaMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public int getMaxRange() {
        return MODE_9X9;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
