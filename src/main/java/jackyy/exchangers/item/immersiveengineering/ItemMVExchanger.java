package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemMVExchanger extends ItemExchangerBasePowered {

    public ItemMVExchanger() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.mvMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.mvPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.mvMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.mvMaxRange.get();
    }

    @Override
    public int getTier() {
        return 2;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.immersiveEngineeringModule.get() && ModList.get().isLoaded(Reference.IE);
    }


}
