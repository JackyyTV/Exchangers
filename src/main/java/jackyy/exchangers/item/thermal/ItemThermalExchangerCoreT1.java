package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemThermalExchangerCoreT1 extends ItemCoreBase {

    public ItemThermalExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.thermalModule.get() && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
