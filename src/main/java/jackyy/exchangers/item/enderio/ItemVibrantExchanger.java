package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemVibrantExchanger extends ItemExchangerBasePowered {

    public ItemVibrantExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.vibrantMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.vibrantPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.vibrantMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.vibrantMaxRange.get();
    }

    @Override
    public int getTier() {
        return 6;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOModule.get() && ModList.get().isLoaded(Reference.EIO);
    }

}
