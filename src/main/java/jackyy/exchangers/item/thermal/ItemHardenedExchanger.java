package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemHardenedExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.hardenedMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.hardenedPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.hardenedMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.hardenedMaxRange.get();
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.hardenedMaxEnergy;
            perBlockUse = DefaultValues.hardenedPerBlockUse;
            harvestLevel = DefaultValues.hardenedMaxHarvestLevel;
            range = DefaultValues.hardenedMaxRange;
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemHardenedExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "hardened_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
