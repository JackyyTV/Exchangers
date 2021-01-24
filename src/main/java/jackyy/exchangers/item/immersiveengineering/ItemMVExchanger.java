package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemMVExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.mvMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.mvPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.mvMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.mvMaxRange.get();
            loaded = ModConfigs.CONFIG.immersiveEngineeringModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.mvMaxEnergy;
            perBlockUse = DefaultValues.mvPerBlockUse;
            harvestLevel = DefaultValues.mvMaxHarvestLevel;
            range = DefaultValues.mvMaxRange;
            loaded = DefaultValues.immersiveEngineeringModule;
        }
    }

    public ItemMVExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "mv_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.IE);
    }


}
