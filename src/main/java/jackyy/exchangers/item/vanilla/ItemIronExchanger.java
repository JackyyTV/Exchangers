package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemIronExchanger extends ItemExchangerBase {

    public ItemIronExchanger() {
        super(new Properties().durability(DefaultValues.ironMaxDmg).rarity(Rarity.RARE));
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
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Tags.Items.INGOTS_IRON);
    }

}
