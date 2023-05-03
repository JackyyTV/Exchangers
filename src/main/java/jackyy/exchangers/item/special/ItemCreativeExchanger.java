package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import net.minecraft.world.item.Rarity;

public class ItemCreativeExchanger extends ItemExchangerBase {

    public ItemCreativeExchanger() {
        super(new Properties().durability(9001).rarity(Rarity.EPIC));
    }

    @Override
    public boolean isCreative() {
        return true;
    }

    @Override
    public String getHarvestLevel() {
        return "minecraft:netherite";
    }

    @Override
    public String getDefaultHarvestLevel() {
        return "minecraft:netherite";
    }

    @Override
    public int getMaxRange() {
        return 12;
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
