package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemEmeraldExchanger extends ItemExchangerBase {

    public ItemEmeraldExchanger() {
        super(new Properties().durability(DefaultValues.emeraldMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.emeraldMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.emeraldMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.emeraldMaxRange.get();
    }

    @Override
    public int getTier() {
        return 5;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Tags.Items.GEMS_EMERALD);
    }

}
