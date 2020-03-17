package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemEndExchanger extends ItemExchangerBase {

    public ItemEndExchanger() {
        setRegistryName(Reference.MODID + ":end_exchanger");
        setTranslationKey(Reference.MODID + ".end_exchanger");
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
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        NonNullList<ItemStack> list = NonNullList.create();
        list.add(new ItemStack(Blocks.PURPUR_BLOCK));
        return OreDictionary.containsMatch(false, OreDictionary.getOres("endstone"), repair)
                || OreDictionary.containsMatch(false, list, repair);
    }

}
