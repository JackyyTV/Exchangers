package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEIOExchangerCoreT3 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemEIOExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "eio_exchanger_core_tier3");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
