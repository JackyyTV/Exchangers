package me.jacky1356400.exchangers.item.special;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger(){
        setRegistryName(Exchangers.MODID + ":creative_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".creative_exchanger");
        setMaxStackSize(1);
        setCreativeTab(Exchangers.exchangersCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
