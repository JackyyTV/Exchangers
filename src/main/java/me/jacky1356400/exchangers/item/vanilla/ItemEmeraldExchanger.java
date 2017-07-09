package me.jacky1356400.exchangers.item.vanilla;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemEmeraldExchanger extends ItemExchangerBase {

    public ItemEmeraldExchanger(){
        setRegistryName(Exchangers.MODID + ":emerald_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".emerald_exchanger");
        setMaxStackSize(1);
        setMaxDamage(Config.emeMaxDmg);
        setCreativeTab(Exchangers.exchangersCreativeTab);
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
        tooltip.add(StringHelper.getTierText(3));
    }

}