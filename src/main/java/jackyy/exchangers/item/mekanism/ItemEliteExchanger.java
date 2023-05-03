package jackyy.exchangers.item.mekanism;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemEliteExchanger extends ItemExchangerBasePowered {

    public ItemEliteExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.eliteMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.elitePerBlockUse.get();
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.eliteMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.eliteMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.eliteMaxRange.get();
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.mekanismModule.get()  && ModList.get().isLoaded(Reference.MEK);
    }

}
