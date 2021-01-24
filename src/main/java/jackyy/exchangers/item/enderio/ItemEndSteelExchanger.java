package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEndSteelExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.endSteelMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.endSteelPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.endSteelMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.endSteelMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.endSteelMaxEnergy;
            perBlockUse = DefaultValues.endSteelPerBlockUse;
            harvestLevel = DefaultValues.endSteelMaxHarvestLevel;
            range = DefaultValues.endSteelMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemEndSteelExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
        setRegistryName(Reference.MODID, "end_steel_exchanger");
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
        return 7;
    }

    @Override
    public boolean checkLoaded() {
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
