package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEnergeticExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.energeticMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.energeticPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.energeticMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.energeticMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.energeticMaxEnergy;
            perBlockUse = DefaultValues.energeticPerBlockUse;
            harvestLevel = DefaultValues.energeticMaxHarvestLevel;
            range = DefaultValues.energeticMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemEnergeticExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "energetic_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
