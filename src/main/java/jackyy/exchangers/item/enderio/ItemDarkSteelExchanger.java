package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemDarkSteelExchanger extends ItemExchangerBasePowered {

    public ItemDarkSteelExchanger() {
        super(new Properties().rarity(Rarity.EPIC));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.darkSteelMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.darkSteelPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.darkSteelMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.darkSteelMaxRange.get();
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOModule.get() && ModList.get().isLoaded(Reference.EIO);
    }

}
