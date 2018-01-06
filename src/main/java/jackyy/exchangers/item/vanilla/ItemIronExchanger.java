package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIronExchanger extends ItemExchangerBase {

    public ItemIronExchanger(){
        setRegistryName(Exchangers.MODID + ":exiron");
        setUnlocalizedName(Exchangers.MODID + ".exiron");
        setMaxDamage(Config.ironMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public int getMaxRange() {
        return MODE_7X7;
    }

    @Override
    public boolean checkLoaded() {
        return Config.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

}
