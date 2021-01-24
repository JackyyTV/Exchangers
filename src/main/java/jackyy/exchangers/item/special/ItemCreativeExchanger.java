package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;

public class ItemCreativeExchanger extends ItemExchangerBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.specialModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.specialModule;
        }
    }

    public ItemCreativeExchanger() {
        super(new Properties().defaultMaxDamage(9001).rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "creative_exchanger");
    }

    @Override
    public boolean isCreative() {
        return true;
    }

    @Override
    public int getHarvestLevel() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getMaxRange() {
        return 12;
    }

    @Override
    public int getTier() {
        return 9001;
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

}
