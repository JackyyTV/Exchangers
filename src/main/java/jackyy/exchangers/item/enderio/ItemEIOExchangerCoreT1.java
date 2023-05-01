package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemEIOExchangerCoreT1 extends ItemCoreBase {

    public ItemEIOExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOModule.get() && ModList.get().isLoaded(Reference.EIO);
    }

}
