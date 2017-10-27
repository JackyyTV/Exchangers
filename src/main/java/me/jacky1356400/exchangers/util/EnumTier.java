package me.jacky1356400.exchangers.util;

import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum EnumTier {
    ZERO(-1),
    ONE(ExchangerHandler.MODE_1X1),
    TWO(ExchangerHandler.MODE_3X3),
    THREE(ExchangerHandler.MODE_5X5),
    FOUR(ExchangerHandler.MODE_7X7),
    FIVE(ExchangerHandler.MODE_9X9),
    SIX(ExchangerHandler.MODE_11X11),
    SEVEN(ExchangerHandler.MODE_15X15),
    EIO_ONE(ExchangerHandler.MODE_3X3),
    EIO_TWO(ExchangerHandler.MODE_5X5),
    EIO_THREE(ExchangerHandler.MODE_9X9),
    EIO_FOUR(ExchangerHandler.MODE_11X11),
    EIO_FIVE(ExchangerHandler.MODE_13X13),
    EIO_SIX(ExchangerHandler.MODE_15X15),
    TE_ONE(ExchangerHandler.MODE_3X3),
    TE_TWO(ExchangerHandler.MODE_7X7),
    TE_THREE(ExchangerHandler.MODE_11X11),
    TE_FOUR(ExchangerHandler.MODE_13X13),
    TE_FIVE(ExchangerHandler.MODE_15X15),
    MEK_ONE(ExchangerHandler.MODE_7X7),
    MEK_TWO(ExchangerHandler.MODE_11X11),
    MEK_THREE(ExchangerHandler.MODE_13X13),
    MEK_FOUR(ExchangerHandler.MODE_15X15),
    IE_ONE(ExchangerHandler.MODE_5X5),
    IE_TWO(ExchangerHandler.MODE_11X11),
    IE_THREE(ExchangerHandler.MODE_15X15),
    CREATIVE(ExchangerHandler.MODE_25X25);

    final int size;

    EnumTier(int maxSize) {
        size = maxSize;
    }

    @SideOnly(Side.CLIENT)
    public String getFormattedText() {
        int k = this.ordinal();
        if (this == EnumTier.EIO_ONE) k = 1;
        if (this == EnumTier.EIO_TWO) k = 2;
        if (this == EnumTier.EIO_THREE) k = 3;
        if (this == EnumTier.EIO_FOUR) k = 4;
        if (this == EnumTier.EIO_FIVE) k = 5;
        if (this == EnumTier.EIO_SIX) k = 6;
        if (this == EnumTier.TE_ONE) k = 1;
        if (this == EnumTier.TE_TWO) k = 2;
        if (this == EnumTier.TE_THREE) k = 3;
        if (this == EnumTier.TE_FOUR) k = 4;
        if (this == EnumTier.TE_FIVE) k = 5;
        if (this == EnumTier.MEK_ONE) k = 1;
        if (this == EnumTier.MEK_TWO) k = 2;
        if (this == EnumTier.MEK_THREE) k = 3;
        if (this == EnumTier.MEK_FOUR) k = 4;
        if (this == EnumTier.IE_ONE) k = 1;
        if (this == EnumTier.IE_TWO) k = 2;
        if (this == EnumTier.IE_THREE) k = 3;
        if (this == EnumTier.CREATIVE) k = 9001;
        return I18n.format(Data.MODID + ".tooltip.tier", k);
    }

    public int getMaxSize() {
        return size;
    }
}
