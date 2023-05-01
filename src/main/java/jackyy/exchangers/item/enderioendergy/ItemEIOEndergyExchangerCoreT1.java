package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemEIOEndergyExchangerCoreT1 extends ItemCoreBase {

    public ItemEIOEndergyExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOEndergyModule.get() && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
