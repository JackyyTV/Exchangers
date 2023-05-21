package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.world.item.Rarity;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger() {
        super(new Properties().durability(DefaultValues.creativeMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public boolean isCreative() {
        return true;
    }

    @Override
    public String getHarvestLevel() {
        return DefaultValues.creativeMaxHarvestLevel;
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.creativeMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return DefaultValues.creativeMaxRange;
    }

    @Override
    public int getTier() {
        return 9001;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.specialModule.get();
    }

}
