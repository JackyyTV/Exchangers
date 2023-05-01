package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemGoldenExchanger extends ItemExchangerBase {

    public ItemGoldenExchanger() {
        super(new Properties().defaultMaxDamage(DefaultValues.goldenMaxDmg).rarity(Rarity.RARE));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.goldenMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.goldenMaxRange.get();
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return Tags.Items.INGOTS_GOLD.contains(repair.getItem());
    }

}
