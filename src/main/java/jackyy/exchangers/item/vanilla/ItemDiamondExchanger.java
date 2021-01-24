package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemDiamondExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.diamondMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.diamondMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.diamondMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.diamondMaxDmg;
            harvestLevel = DefaultValues.diamondMaxHarvestLevel;
            range = DefaultValues.diamondMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemDiamondExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "diamond_exchanger");
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
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.GEMS_DIAMOND.contains(repair.getItem());
    }

}
