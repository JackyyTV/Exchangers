package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemLeadstoneExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.leadstoneMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.leadstonePerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.leadstoneMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.leadstoneMaxRange.get();
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.leadstoneMaxEnergy;
            perBlockUse = DefaultValues.leadstonePerBlockUse;
            harvestLevel = DefaultValues.leadstoneMaxHarvestLevel;
            range = DefaultValues.leadstoneMaxRange;
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemLeadstoneExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "leadstone_exchanger");
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
        return 1;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
