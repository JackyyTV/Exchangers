package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemEmeraldExchanger extends ItemExchangerBase {

    public ItemEmeraldExchanger() {
        super(new Properties().maxDamage(DefaultValues.emeraldMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.emeraldMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.emeraldMaxRange.get();
    }

    @Override
    public int getTier() {
        return 6;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.GEMS_EMERALD.contains(repair.getItem());
    }

}
