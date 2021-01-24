package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemIronExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.ironMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.ironMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.ironMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.ironMaxHarvestLevel;
            harvestLevel = DefaultValues.ironMaxHarvestLevel;
            range = DefaultValues.ironMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemIronExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "iron_exchanger");
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
        return 4;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.INGOTS_IRON.contains(repair.getItem());
    }

}
