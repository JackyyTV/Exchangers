package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemBasicExchanger extends ItemExchangerBasePowered {

    public ItemBasicExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.basicMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.basicPerBlockUse.get();
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.basicMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.basicMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.basicMaxRange.get();
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.mekanismModule.get()  && ModList.get().isLoaded(Reference.MEK);
    }

}
