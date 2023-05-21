package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemEndExchanger extends ItemExchangerBase {

    public ItemEndExchanger() {
        super(new Properties().maxDamage(DefaultValues.endMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.endMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.endMaxRange.get();
    }

    @Override
    public int getTier() {
        return 8;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.END_STONES.contains(repair.getItem()) || repair.equals(new ItemStack(Blocks.PURPUR_BLOCK));
    }

}
