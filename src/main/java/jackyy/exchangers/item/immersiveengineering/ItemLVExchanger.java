package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemLVExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.lvMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.lvPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.lvMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.lvMaxRange.get();
            loaded = ModConfigs.CONFIG.immersiveEngineeringModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.lvMaxEnergy;
            perBlockUse = DefaultValues.lvPerBlockUse;
            harvestLevel = DefaultValues.lvMaxHarvestLevel;
            range = DefaultValues.lvMaxRange;
            loaded = DefaultValues.immersiveEngineeringModule;
        }
    }

    public ItemLVExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
        setRegistryName(Reference.MODID, "lv_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.IE);
    }

}
