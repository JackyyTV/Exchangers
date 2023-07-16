package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemNetheriteExchanger extends ItemExchangerBase {

    public ItemNetheriteExchanger() {
        super(new Properties().maxDamage(DefaultValues.netheriteMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.netheriteMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.netheriteMaxRange.get();
    }

    @Override
    public int getTier() {
        return 7;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.INGOTS_NETHERITE.contains(repair.getItem());
    }

}
