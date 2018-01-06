package jackyy.exchangers.item.enderio;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemCoreBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEIOExchangerCoreT1 extends ItemCoreBase {

    public ItemEIOExchangerCoreT1(){
        setRegistryName(Exchangers.MODID + ":eioexcore_t1");
        setUnlocalizedName(Exchangers.MODID + ".eioexcore_t1");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean checkLoaded() {
        return Config.enderIOModule && Loader.isModLoaded(Exchangers.EIO);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

}
