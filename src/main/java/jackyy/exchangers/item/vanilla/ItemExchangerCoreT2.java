package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraft.item.Rarity;

public class ItemExchangerCoreT2 extends ItemCoreBase {

    public ItemExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

}
