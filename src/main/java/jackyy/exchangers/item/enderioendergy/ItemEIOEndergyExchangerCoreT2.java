package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEIOEndergyExchangerCoreT2 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.enderIOEndergyModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.enderIOEndergyModule;
        }
    }

    public ItemEIOEndergyExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "eio_endergy_exchanger_core_tier2");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
