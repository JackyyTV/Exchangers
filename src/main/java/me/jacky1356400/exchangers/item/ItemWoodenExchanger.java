package me.jacky1356400.exchangers.item;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.Config;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWoodenExchanger extends ItemExchangerBase {

    public ItemWoodenExchanger(){
        setRegistryName(Exchangers.MODID + ":wooden_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".wooden_exchanger");
        setMaxStackSize(1);
        setMaxDamage(Config.woodenExchangerMaxDamage);
        setCreativeTab(Exchangers.exchangersCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
