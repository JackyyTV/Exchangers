package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemThermalExchangerCoreT2 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemThermalExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "thermal_exchanger_core_tier2");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
