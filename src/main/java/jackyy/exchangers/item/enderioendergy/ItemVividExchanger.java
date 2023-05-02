package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemVividExchanger extends ItemExchangerBasePowered {

    public ItemVividExchanger() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.vividMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.vividPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.vividMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.vividMaxRange.get();
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOEndergyModule.get() && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
