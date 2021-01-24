package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemConductiveIronExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.conductiveMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.conductivePerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.conductiveMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.conductiveMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.conductiveMaxEnergy;
            perBlockUse = DefaultValues.conductivePerBlockUse;
            harvestLevel = DefaultValues.conductiveMaxHarvestLevel;
            range = DefaultValues.conductiveMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemConductiveIronExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "conductive_iron_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
