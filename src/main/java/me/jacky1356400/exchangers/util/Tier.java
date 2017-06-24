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
	CREATIVE(ExchangerHandler.MODE_25X25);

	final int size;

	Tier(int maxSize) {
		size = maxSize;
	}

	@SideOnly(Side.CLIENT)
	public String getFormattedText() {
		int k = this.ordinal();
		if(this == Tier.CREATIVE) k = 9001;
		return I18n.format(Data.MODID + ".tooltip.tier", k);
	}

	public int getMaxSize() {
		return size;
	}
}
