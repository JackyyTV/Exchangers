package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Tags;

public class ItemStoneExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.stoneMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.stoneMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.stoneMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.stoneMaxDmg;
            harvestLevel = DefaultValues.stoneMaxHarvestLevel;
            range = DefaultValues.stoneMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemStoneExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "stone_exchanger");
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
        return 2;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.STONE.contains(repair.getItem());
    }

}
