package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemEndExchanger extends ItemExchangerBase {

    private static int dmg;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            dmg = ModConfigs.CONFIG.endMaxDmg.get();
            harvestLevel = ModConfigs.CONFIG.endMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.endMaxRange.get();
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            dmg = DefaultValues.endMaxDmg;
            harvestLevel = DefaultValues.endMaxHarvestLevel;
            range = DefaultValues.endMaxRange;
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemEndExchanger() {
        super(new Properties().defaultMaxDamage(dmg).rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "end_exchanger");
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
        return 8;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.END_STONES.contains(repair.getItem()) || repair.equals(new ItemStack(Blocks.PURPUR_BLOCK));
    }

}
