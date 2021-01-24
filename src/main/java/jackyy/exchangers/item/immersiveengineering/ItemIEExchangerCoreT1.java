package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemIEExchangerCoreT1 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.immersiveEngineeringModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.immersiveEngineeringModule;
        }
    }

    public ItemIEExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "ie_exchanger_core_tier1");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.IE);
    }

}
