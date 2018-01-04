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

public class ItemObsidianExchanger extends ItemExchangerBase {

    public ItemObsidianExchanger(){
        setRegistryName(Exchangers.MODID + ":obsidian_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".obsidian_exchanger");
        setMaxDamage(Config.obsMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 7;
    }

    @Override
    public int getMaxRange() {
        return MODE_15X15;
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
