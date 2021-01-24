package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemCoreBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemMekanismExchangerCoreT2 extends ItemCoreBase {

    private static boolean loaded;
    static {
        try {
            loaded = ModConfigs.CONFIG.mekanismModule.get();
        } catch (NullPointerException exception) {
            loaded = DefaultValues.mekanismModule;
        }
    }

    public ItemMekanismExchangerCoreT2() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "mekanism_exchanger_core_tier2");
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.MEK);
    }

}
