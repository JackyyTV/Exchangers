package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemSignalumExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.signalumMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.signalumPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.signalumMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.signalumMaxRange.get();
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.signalumMaxEnergy;
            perBlockUse = DefaultValues.signalumPerBlockUse;
            harvestLevel = DefaultValues.signalumMaxHarvestLevel;
            range = DefaultValues.signalumMaxRange;
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemSignalumExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "signalum_exchanger");
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
        return 4;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
