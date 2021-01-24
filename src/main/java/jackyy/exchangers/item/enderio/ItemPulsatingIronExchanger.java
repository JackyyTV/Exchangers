package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemPulsatingIronExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.pulsatingMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.pulsatingPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.pulsatingMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.pulsatingMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.pulsatingMaxEnergy;
            perBlockUse = DefaultValues.pulsatingPerBlockUse;
            harvestLevel = DefaultValues.pulsatingMaxHarvestLevel;
            range = DefaultValues.pulsatingMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemPulsatingIronExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "pulsating_iron_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
