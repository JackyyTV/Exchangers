package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemVibrantExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.vibrantMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.vibrantPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.vibrantMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.vibrantMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.vibrantMaxEnergy;
            perBlockUse = DefaultValues.vibrantPerBlockUse;
            harvestLevel = DefaultValues.vibrantMaxHarvestLevel;
            range = DefaultValues.vibrantMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemVibrantExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "vibrant_exchanger");
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
        return 6;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
