package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEIOExchangerCoreT2 extends ItemCoreBase {

    public ItemEIOExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOModule.get() && ModList.get().isLoaded(Reference.EIO);
    }

}
