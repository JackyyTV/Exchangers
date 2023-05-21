package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Tags;

public class ItemStoneExchanger extends ItemExchangerBase {

    public ItemStoneExchanger() {
        super(new Properties().maxDamage(DefaultValues.stoneMaxDmg).rarity(Reference.RARITY_TIER1));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.stoneMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.stoneMaxRange.get();
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.STONE.contains(repair.getItem());
    }

}
