package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemCrudeSteelExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.crudeSteelMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.crudeSteelPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.crudeSteelMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.crudeSteelMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOEndergyModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.crudeSteelMaxEnergy;
            perBlockUse = DefaultValues.crudeSteelPerBlockUse;
            harvestLevel = DefaultValues.crudeSteelMaxHarvestLevel;
            range = DefaultValues.crudeSteelMaxRange;
            loaded = DefaultValues.enderIOEndergyModule;
        }
    }

    public ItemCrudeSteelExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "crude_steel_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
