package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemUltimateExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.ultimateMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.ultimatePerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.ultimateMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.ultimateMaxRange.get();
            loaded = ModConfigs.CONFIG.mekanismModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.ultimateMaxEnergy;
            perBlockUse = DefaultValues.ultimatePerBlockUse;
            harvestLevel = DefaultValues.ultimateMaxHarvestLevel;
            range = DefaultValues.ultimateMaxRange;
            loaded = DefaultValues.mekanismModule;
        }
    }

    public ItemUltimateExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "ultimate_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.MEK);
    }

}
