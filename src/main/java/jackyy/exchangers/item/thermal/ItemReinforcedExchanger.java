package jackyy.exchangers.item.thermal;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemReinforcedExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.reinforcedMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.reinforcedPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.reinforcedMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.reinforcedMaxRange.get();
            loaded = ModConfigs.CONFIG.thermalModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.reinforcedMaxEnergy;
            perBlockUse = DefaultValues.reinforcedPerBlockUse;
            harvestLevel = DefaultValues.reinforcedMaxHarvestLevel;
            range = DefaultValues.reinforcedMaxRange;
            loaded = DefaultValues.thermalModule;
        }
    }

    public ItemReinforcedExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "reinforced_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.THERMAL) && ModList.get().isLoaded(Reference.THERMAL_INNOVATION);
    }

}
