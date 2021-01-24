package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemBasicExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.basicMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.basicPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.basicMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.basicMaxRange.get();
            loaded = ModConfigs.CONFIG.mekanismModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.basicMaxEnergy;
            perBlockUse = DefaultValues.basicPerBlockUse;
            harvestLevel = DefaultValues.basicMaxHarvestLevel;
            range = DefaultValues.basicMaxRange;
            loaded = DefaultValues.mekanismModule;
        }
    }

    public ItemBasicExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "basic_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.MEK);
    }

}
