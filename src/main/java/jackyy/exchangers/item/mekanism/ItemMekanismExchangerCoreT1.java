package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemMekanismExchangerCoreT1 extends ItemCoreBase {

    public ItemMekanismExchangerCoreT1() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.mekanismModule.get() && ModList.get().isLoaded(Reference.MEK);
    }

}
