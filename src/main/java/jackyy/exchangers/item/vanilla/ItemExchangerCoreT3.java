package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;

public class ItemExchangerCoreT3 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "exchanger_core_tier3");
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

}
