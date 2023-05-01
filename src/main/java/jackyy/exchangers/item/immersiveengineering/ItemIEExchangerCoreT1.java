package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemIEExchangerCoreT1 extends ItemCoreBase {

    public ItemIEExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.immersiveEngineeringModule.get() && ModList.get().isLoaded(Reference.IE);
    }

}
