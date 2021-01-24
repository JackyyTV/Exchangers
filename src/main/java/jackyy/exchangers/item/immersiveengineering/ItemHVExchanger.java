package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemHVExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.hvMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.hvPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.hvMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.hvMaxRange.get();
            loaded = ModConfigs.CONFIG.immersiveEngineeringModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.hvMaxEnergy;
            perBlockUse = DefaultValues.hvPerBlockUse;
            harvestLevel = DefaultValues.hvMaxHarvestLevel;
            range = DefaultValues.hvMaxRange;
            loaded = DefaultValues.immersiveEngineeringModule;
        }
    }

    public ItemHVExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "hv_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.IE);
    }

}
