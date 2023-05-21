package jackyy.exchangers.util;

import jackyy.exchangers.registry.ModItems;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ObjectHolder;

public final class Reference {

    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";

    public static final String EIO = "enderio";
    public static final String EIO_ENDERGY = "enderioendergy";
    public static final String THERMAL = "thermal";
    public static final String THERMAL_INNOVATION = "thermal_innovation";
    public static final String MEK = "mekanism";
    public static final String IE = "immersiveengineering";
    public static final String BWM = "betterwithmods";

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OBSIDIAN_EXCHANGER.get());
        }
    };

    public static final Rarity RARITY_TIER1 = Rarity.create(MODID + "_rarity_tier1", ChatFormatting.GREEN);
    public static final Rarity RARITY_BEE = Rarity.create(MODID + "_rarity_bee", ChatFormatting.GOLD);

    public static final String KEY_PREFIX = "key.exchangers.";
    public static final String KEY_CATEGORY = "key.categories.exchangers";

    public static MutableComponent getStateString(boolean condition) {
        return condition
                ? StringHelper.localize(Reference.MODID, "tooltip.state.enabled").withStyle(ChatFormatting.GREEN)
                : StringHelper.localize(Reference.MODID, "tooltip.state.disabled").withStyle(ChatFormatting.RED);
    }

    @ObjectHolder(registryName="enchantment", value="cofh_core:holding")
    public static final Enchantment holdingEnchant = null;

}
