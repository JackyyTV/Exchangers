package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemObsidianExchanger extends ItemExchangerBase {

    public ItemObsidianExchanger() {
        super(new Properties().durability(DefaultValues.obsidianMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.obsidianMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.obsidianMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.obsidianMaxRange.get();
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
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Tags.Items.OBSIDIAN);
    }

}
