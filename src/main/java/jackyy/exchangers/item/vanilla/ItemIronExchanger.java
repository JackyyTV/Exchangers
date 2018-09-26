package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemIronExchanger extends ItemExchangerBase {

    public ItemIronExchanger() {
        setRegistryName(Exchangers.MODID + ":iron_exchanger");
        setTranslationKey(Exchangers.MODID + ".iron_exchanger");
        setMaxDamage(ModConfig.vanillaTweaks.ironMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.vanillaTweaks.ironMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.vanillaTweaks.ironMaxRange;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return OreDictionary.containsMatch(false, OreDictionary.getOres("ingotIron"), repair);
    }

}
