package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemThermalExchangerCoreT3 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemThermalExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "thermal_exchanger_core_tier3");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
