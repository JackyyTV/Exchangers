package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemAdvancedExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.advancedMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.advancedPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.advancedMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.advancedMaxRange.get();
            loaded = ModConfigs.CONFIG.mekanismModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.advancedMaxEnergy;
            perBlockUse = DefaultValues.advancedPerBlockUse;
            harvestLevel = DefaultValues.advancedMaxHarvestLevel;
            range = DefaultValues.advancedMaxRange;
            loaded = DefaultValues.mekanismModule;
        }
    }

    public ItemAdvancedExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "advanced_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.MEK);
    }

}
