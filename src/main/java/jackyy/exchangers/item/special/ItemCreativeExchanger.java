package jackyy.exchangers.item.special;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger(){
        setRegistryName(Exchangers.MODID + ":creative_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".creative_exchanger");
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
    public boolean isCreative() {
        return true;
    }

    @Override
    public int getMaxRange() {
        return MODE_25X25;
    }

    @Override
    public boolean checkLoaded() {
        return Config.specialModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
