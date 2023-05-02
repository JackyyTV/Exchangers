package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemHVExchanger extends ItemExchangerBasePowered {

    public ItemHVExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.hvMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.hvPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.hvMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.hvMaxRange.get();
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.immersiveEngineeringModule.get() && ModList.get().isLoaded(Reference.IE);
    }

}
