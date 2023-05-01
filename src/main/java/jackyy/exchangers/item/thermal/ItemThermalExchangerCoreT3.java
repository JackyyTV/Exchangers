package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemThermalExchangerCoreT3 extends ItemCoreBase {

    public ItemThermalExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.thermalModule.get() && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
