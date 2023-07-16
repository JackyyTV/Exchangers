package jackyy.exchangers.util;

import jackyy.exchangers.registry.ModItems;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.registries.ObjectHolder;

public final class Reference {

    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";

    public static final String THERMAL = "thermal";
    public static final String THERMAL_INNOVATION = "thermal_innovation";
    public static final String MEK = "mekanism";
    public static final String IE = "immersiveengineering";

    public static final ItemGroup TAB = new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.OBSIDIAN_EXCHANGER.get());
        }
    };

    public static final Rarity RARITY_TIER1 = Rarity.create(MODID + "_rarity_tier1", TextFormatting.GREEN);
    public static final Rarity RARITY_BEE = Rarity.create(MODID + "_rarity_bee", TextFormatting.GOLD);

    public static final String KEY_PREFIX = "key.exchangers.";
    public static final String KEY_CATEGORY = "key.categories.exchangers";

    public static IFormattableTextComponent getStateString(boolean condition) {
        return condition
                ? StringHelper.localize(Reference.MODID, "tooltip.state.enabled").mergeStyle(TextFormatting.GREEN)
                : StringHelper.localize(Reference.MODID, "tooltip.state.disabled").mergeStyle(TextFormatting.RED);
    }

    @ObjectHolder("cofh_core:holding")
    public static final Enchantment holdingEnchant = null;

}
