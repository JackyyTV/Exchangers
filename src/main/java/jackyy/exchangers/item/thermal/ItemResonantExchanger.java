package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemResonantExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.resonantMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.resonantPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.resonantMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.resonantMaxRange.get();
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.resonantMaxEnergy;
            perBlockUse = DefaultValues.resonantPerBlockUse;
            harvestLevel = DefaultValues.resonantMaxHarvestLevel;
            range = DefaultValues.resonantMaxRange;
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemResonantExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "resonant_exchanger");
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
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
