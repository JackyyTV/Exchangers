package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEliteExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.eliteMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.elitePerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.eliteMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.eliteMaxRange.get();
            loaded = ModConfigs.CONFIG.mekanismModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.eliteMaxEnergy;
            perBlockUse = DefaultValues.elitePerBlockUse;
            harvestLevel = DefaultValues.eliteMaxHarvestLevel;
            range = DefaultValues.eliteMaxRange;
            loaded = DefaultValues.mekanismModule;
        }
    }

    public ItemEliteExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "elite_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.MEK);
    }

}
