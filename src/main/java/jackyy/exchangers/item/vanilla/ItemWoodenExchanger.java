package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;

public class ItemWoodenExchanger extends ItemExchangerBase {

    public ItemWoodenExchanger() {
        super(new Properties().durability(DefaultValues.woodenMaxDmg).rarity(Reference.RARITY_TIER1));
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.woodenMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.woodenMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.woodenMaxRange.get();
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(ItemTags.LOGS);
    }

}
