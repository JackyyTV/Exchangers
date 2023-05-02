package jackyy.exchangers.item.enderio;

import jackyy.exchangers.item.ItemExchangerBasePowered;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.ModList;

public class ItemElectricalSteelExchanger extends ItemExchangerBasePowered {

    public ItemElectricalSteelExchanger() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public int getMaxEnergy() {
        return ModConfigs.CONFIG.electricalSteelMaxEnergy.get();
    }

    @Override
    public int getPerBlockUse() {
        return ModConfigs.CONFIG.electricalSteelPerBlockUse.get();
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.electricalSteelMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.electricalSteelMaxRange.get();
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.enderIOModule.get() && ModList.get().isLoaded(Reference.EIO);
    }

}
