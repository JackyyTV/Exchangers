package jackyy.exchangers.util;

import jackyy.exchangers.registry.ModItems;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.IRarity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Reference {

    public static final String MODID = "exchangers";
    public static final String MODNAME = "Exchangers";
    public static final String VERSION = "1.12.2-2.10.2";
    public static final String MCVERSION = "[1.12,1.13)";

    public static final String EIO = "enderio";
    public static final String EIO_ENDERGY = "enderioendergy";
    public static final String TE = "thermalexpansion";
    public static final String MEK = "mekanism";
    public static final String IE = "immersiveengineering";
    public static final String BWM = "betterwithmods";

    public static final String DEPENDS
            = "required-after:gunpowderlib@[1.12.2-1.1,);"
            + "required-after:forge@[14.23.5.2816,);"
            + "after:cofhcore;"
            + "after:thermalfoundation;"
            + "after:" + EIO + ";"
            + "after:" + EIO_ENDERGY + ";"
            + "after:" + TE + ";"
            + "after:" + MEK + ";"
            + "after:" + IE + ";"
            + "after:" + BWM + ";";

    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.obsidianExchanger);
        }
    };
    public static final IRarity TIER_1 = new IRarity() {
        @Override
        public TextFormatting getColor() {
            return TextFormatting.GREEN;
        }

        @Override
        public String getName() {
            return "Tier 1";
        }
    };

    public static final Logger LOGGER = LogManager.getLogger(MODNAME);

    public static final String COMMON_PROXY = "jackyy.exchangers.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "jackyy.exchangers.proxy.ClientProxy";

    public static final String KEY_PREFIX = "key.exchangers.";
    public static final String KEY_CATEGORY = "key.categories.exchangers";

    public static String getStateString(boolean condition) {
        return condition
                ? TextFormatting.GREEN + StringHelper.localize(Reference.MODID, "tooltip.state.enabled") + TextFormatting.WHITE
                : TextFormatting.RED + StringHelper.localize(Reference.MODID, "tooltip.state.disabled") + TextFormatting.WHITE;
    }

}
