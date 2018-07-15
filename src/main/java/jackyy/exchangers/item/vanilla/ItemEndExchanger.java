package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Collections;

public class ItemEndExchanger extends ItemExchangerBase {

    public ItemEndExchanger() {
        setRegistryName(Exchangers.MODID + ":end_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".end_exchanger");
        setMaxDamage(ModConfig.vanillaTweaks.endMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 8;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.vanillaTweaks.endMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.vanillaTweaks.endMaxRange;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return OreDictionary.containsMatch(false, OreDictionary.getOres("endstone"), repair)
                || OreDictionary.containsMatch(false, Collections.singletonList(new ItemStack(Blocks.PURPUR_BLOCK)), repair);
    }

}
