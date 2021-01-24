package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemVividExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.vividMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.vividPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.vividMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.vividMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOEndergyModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.vividMaxEnergy;
            perBlockUse = DefaultValues.vividPerBlockUse;
            harvestLevel = DefaultValues.vividMaxHarvestLevel;
            range = DefaultValues.vividMaxRange;
            loaded = DefaultValues.enderIOEndergyModule;
        }
    }

    public ItemVividExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "vivid_exchanger");
    }

    @Override
    public int getMaxEnergy() {
        return energy;
    }

    @Override
    public int getPerBlockUse() {
        return perBlockUse;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxRange() {
        return range;
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
