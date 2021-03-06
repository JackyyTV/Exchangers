package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemEmeraldExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.emeraldMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.emeraldMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.emeraldMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.emeraldMaxDmg;
            harvestLevel = DefaultValues.emeraldMaxHarvestLevel;
            range = DefaultValues.emeraldMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemEmeraldExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "emerald_exchanger");
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
        return 6;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.GEMS_EMERALD.contains(repair.getItem());
    }

}