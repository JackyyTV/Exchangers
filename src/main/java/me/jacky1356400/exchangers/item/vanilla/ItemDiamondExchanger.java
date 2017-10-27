package me.jacky1356400.exchangers.item.vanilla;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemDiamondExchanger extends ItemExchangerBase {

    public ItemDiamondExchanger(){
        setRegistryName(Exchangers.MODID + ":diamond_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".diamond_exchanger");
        setMaxStackSize(1);
        setMaxDamage(Config.diaMaxDmg);
        setCreativeTab(Exchangers.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);
        tooltip.add(StringHelper.getTierText(5));
    }

    @Override
    public int getMaxRange() {
        return MODE_9X9;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Config.vanillaModule) {
            list.add(new ItemStack(this));
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
