package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemMelodicExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.melodicMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.melodicPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.melodicMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.melodicMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOEndergyModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.melodicMaxEnergy;
            perBlockUse = DefaultValues.melodicPerBlockUse;
            harvestLevel = DefaultValues.melodicMaxHarvestLevel;
            range = DefaultValues.melodicMaxRange;
            loaded = DefaultValues.enderIOEndergyModule;
        }
    }

    public ItemMelodicExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "melodic_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
