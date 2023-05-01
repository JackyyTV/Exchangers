package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEIOEndergyExchangerCoreT2 extends ItemCoreBase {

    public ItemEIOEndergyExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOEndergyModule.get() && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
