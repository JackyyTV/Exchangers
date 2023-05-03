package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

public class ItemEndExchanger extends ItemExchangerBase {

    public ItemEndExchanger() {
        super(new Properties().durability(DefaultValues.endMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.endMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.endMaxHarvestLevel;
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
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Tags.Items.END_STONES) || repair.equals(new ItemStack(Blocks.PURPUR_BLOCK));
    }

}
