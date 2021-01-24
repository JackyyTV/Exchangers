package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemElectricalSteelExchanger extends ItemExchangerBasePowered {

    private static int energy;
    private static int perBlockUse;
    private static int harvestLevel;
    private static int range;
    private static boolean loaded;
    static {
        try {
            energy = ModConfigs.CONFIG.electricalSteelMaxEnergy.get();
            perBlockUse = ModConfigs.CONFIG.electricalSteelPerBlockUse.get();
            harvestLevel = ModConfigs.CONFIG.electricalSteelMaxHarvestLevel.get();
            range = ModConfigs.CONFIG.electricalSteelMaxRange.get();
            loaded = ModConfigs.CONFIG.enderIOModule.get();
        } catch (NullPointerException exception) {
            energy = DefaultValues.electricalSteelMaxEnergy;
            perBlockUse = DefaultValues.electricalSteelPerBlockUse;
            harvestLevel = DefaultValues.electricalSteelMaxHarvestLevel;
            range = DefaultValues.electricalSteelMaxRange;
            loaded = DefaultValues.enderIOModule;
        }
    }

    public ItemElectricalSteelExchanger() {
        super(new Properties().rarity(Rarity.RARE));
        setRegistryName(Reference.MODID, "electrical_steel_exchanger");
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
        return loaded && ModList.get().isLoaded(Reference.EIO);
    }

}
