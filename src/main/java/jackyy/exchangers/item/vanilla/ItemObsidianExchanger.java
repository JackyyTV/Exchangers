package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemObsidianExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.obsidianMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.obsidianMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.obsidianMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.obsidianMaxDmg;
            harvestLevel = DefaultValues.obsidianMaxHarvestLevel;
            range = DefaultValues.obsidianMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemObsidianExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "obsidian_exchanger");
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
        return 7;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.OBSIDIAN.contains(repair.getItem());
    }

}
