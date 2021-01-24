package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemEnergeticSilverExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.energeticSilverMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.energeticSilverPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.energeticSilverMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.energeticSilverMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOEndergyModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.energeticSilverMaxEnergy;
            perBlockUse = DefaultValues.energeticSilverPerBlockUse;
            harvestLevel = DefaultValues.energeticSilverMaxHarvestLevel;
            range = DefaultValues.energeticSilverMaxRange;
            loaded = DefaultValues.enderIOEndergyModule;
        }
    }

    public ItemEnergeticSilverExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "energetic_silver_exchanger");
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
        return 2;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
