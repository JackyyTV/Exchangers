package jackyy.exchangers.item.enderioendergy;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemCrystallineExchanger extends ItemExchangerBasePowered {

    public ItemCrystallineExchanger() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.crystallineMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.crystallinePerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.crystallineMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.crystallineMaxRange.get();
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOEndergyModule.get() && ModList.get().isLoaded(Reference.EIO_ENDERGY);
    }

}
