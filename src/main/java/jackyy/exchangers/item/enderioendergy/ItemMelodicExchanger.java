package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemMelodicExchanger extends ItemExchangerBasePowered {

    public ItemMelodicExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.melodicMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.melodicPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.melodicMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.melodicMaxRange.get();
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOEndergyModule.get() && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
