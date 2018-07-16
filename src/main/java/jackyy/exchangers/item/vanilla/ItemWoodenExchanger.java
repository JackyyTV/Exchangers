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

import java.util.Arrays;

public class ItemWoodenExchanger extends ItemExchangerBase {

    public ItemWoodenExchanger() {
        setRegistryName(Exchangers.MODID + ":wooden_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".wooden_exchanger");
        setMaxDamage(ModConfig.vanillaTweaks.woodenMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.vanillaTweaks.woodenMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.vanillaTweaks.woodenMaxRange;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Exchangers.TIER_1;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return OreDictionary.containsMatch(false, Arrays.asList(
                        new ItemStack(Blocks.LOG, 1, 0), new ItemStack(Blocks.LOG, 1, 1), new ItemStack(Blocks.LOG, 1, 2), new ItemStack(Blocks.LOG, 1, 3),
                        new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(Blocks.LOG2, 1, 1)
                ), repair);
    }

}
