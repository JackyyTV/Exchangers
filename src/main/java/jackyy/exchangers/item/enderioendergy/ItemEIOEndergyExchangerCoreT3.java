package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEIOEndergyExchangerCoreT3 extends ItemCoreBase {

    public ItemEIOEndergyExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOEndergyModule.get() && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
