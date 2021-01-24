package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;

public class ItemExchangerCoreT2 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.vanillaModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.vanillaModule;
        }
    }

    public ItemExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "exchanger_core_tier2");
    }

    @Override
    public boolean checkLoaded() {
        return loaded;
    }

}
