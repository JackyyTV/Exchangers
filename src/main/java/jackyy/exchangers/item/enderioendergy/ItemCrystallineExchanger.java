package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemCrystallineExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.crystallineMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.crystallinePerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.crystallineMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.crystallineMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOEndergyModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.crystallineMaxEnergy;
            perBlockUse = DefaultValues.crystallinePerBlockUse;
            harvestLevel = DefaultValues.crystallineMaxHarvestLevel;
            range = DefaultValues.crystallineMaxRange;
            loaded = DefaultValues.enderIOEndergyModule;
        }
    }

    public ItemCrystallineExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "crystalline_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
