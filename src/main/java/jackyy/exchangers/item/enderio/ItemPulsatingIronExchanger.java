package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraftforge.fml.ModList;

public class ItemPulsatingIronExchanger extends ItemExchangerBasePowered {

    public ItemPulsatingIronExchanger() {
        super(new Properties().rarity(Reference.RARITY_TIER1));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.pulsatingMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.pulsatingPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.pulsatingMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.pulsatingMaxRange.get();
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOModule.get() && ModList.get().isLoaded(Reference.EIO);
    }

}
