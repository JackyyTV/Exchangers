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

public class ItemEmeraldExchanger extends ItemExchangerBase {

    public ItemEmeraldExchanger(){
        setRegistryName(Exchangers.MODID + ":exemerald");
        setUnlocalizedName(Exchangers.MODID + ".exemerald");
        setMaxStackSize(1);
        setMaxDamage(Config.emeMaxDmg);
        setCreativeTab(Exchangers.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 6;
    }

    @Override
    public int getMaxRange() {
        return MODE_11X11;
    }

    @Override
    public boolean checkLoaded() {
        return Config.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}