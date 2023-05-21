package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemIronExchanger extends ItemExchangerBase {

    public ItemIronExchanger() {
        super(new Properties().maxDamage(DefaultValues.ironMaxDmg).rarity(Rarity.RARE));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.ironMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.ironMaxRange.get();
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.INGOTS_IRON.contains(repair.getItem());
    }

}
