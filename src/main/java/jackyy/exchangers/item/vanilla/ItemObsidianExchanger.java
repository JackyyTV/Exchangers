package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemObsidianExchanger extends ItemExchangerBase {

    public ItemObsidianExchanger() {
        super(new Properties().maxDamage(DefaultValues.obsidianMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.obsidianMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.obsidianMaxRange.get();
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
        return Tags.Items.OBSIDIAN.contains(repair.getItem());
    }

}
