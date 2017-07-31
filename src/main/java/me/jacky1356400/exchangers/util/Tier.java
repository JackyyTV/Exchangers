package me.jacky1356400.exchangers.util;

import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum Tier {
    ZERO(-1),
    ONE(ExchangerHandler.MODE_1X1),
    TWO(ExchangerHandler.MODE_3X3),
    THREE(ExchangerHandler.MODE_5X5),
    FOUR(ExchangerHandler.MODE_7X7),
    FIVE(ExchangerHandler.MODE_9X9),
    SIX(ExchangerHandler.MODE_11X11),
    SEVEN(ExchangerHandler.MODE_15X15),
    TE_ONE(ExchangerHandler.MODE_3X3),
    TE_TWO(ExchangerHandler.MODE_7X7),
    TE_THREE(ExchangerHandler.MODE_11X11),
    TE_FOUR(ExchangerHandler.MODE_13X13),
    TE_FIVE(ExchangerHandler.MODE_15X15),
    MEK_ONE(ExchangerHandler.MODE_7X7),
    MEK_TWO(ExchangerHandler.MODE_11X11),
    MEK_THREE(ExchangerHandler.MODE_13X13),
    MEK_FOUR(ExchangerHandler.MODE_15X15),
    CREATIVE(ExchangerHandler.MODE_25X25);

    final int size;

    Tier(int maxSize) {
        size = maxSize;
    }

    @SideOnly(Side.CLIENT)
    public String getFormattedText() {
        int k = this.ordinal();
        if (this == Tier.TE_ONE) k = 1;
        if (this == Tier.TE_TWO) k = 2;
        if (this == Tier.TE_THREE) k = 3;
        if (this == Tier.TE_FOUR) k = 4;
        if (this == Tier.TE_FIVE) k = 5;
        if (this == Tier.MEK_ONE) k = 1;
        if (this == Tier.MEK_TWO) k = 2;
        if (this == Tier.MEK_THREE) k = 3;
        if (this == Tier.MEK_FOUR) k = 4;
        if (this == Tier.CREATIVE) k = 9001;
        return I18n.format(Data.MODID + ".tooltip.tier", k);
    }

    public int getMaxSize() {
        return size;
    }
}
