package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraft.item.Rarity;

public class ItemExchangerCoreT3 extends ItemCoreBase {

    public ItemExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

}
