package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemIEExchangerCoreT3 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.immersiveEngineeringModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.immersiveEngineeringModule;
        }
    }

    public ItemIEExchangerCoreT3() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "ie_exchanger_core_tier3");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.IE);
    }

}
