package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;

public class ItemExchangerCoreT1 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "exchanger_core_tier1");
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

}
