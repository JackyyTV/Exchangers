package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;

public class ItemWoodenExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.woodenMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.woodenMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.woodenMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.woodenMaxDmg;
            harvestLevel = DefaultValues.woodenMaxHarvestLevel;
            range = DefaultValues.woodenMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemWoodenExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "wooden_exchanger");
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxRange() {
        return range;
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return ItemTags.LOGS.contains(repair.getItem());
    }

}
