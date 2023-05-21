package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemDiamondExchanger extends ItemExchangerBase {

    public ItemDiamondExchanger() {
        super(new Properties().maxDamage(DefaultValues.diamondMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.diamondMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.diamondMaxRange.get();
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.GEMS_DIAMOND.contains(repair.getItem());
    }

}
