package jacky.exchangers.util;

import jacky.exchangers.handler.ExchangerHandler;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum Tier {
	ZERO(-1),
	ONE(ExchangerHandler.MODE_1X1),
	TWO(ExchangerHandler.MODE_5X5),
	THREE(ExchangerHandler.MODE_9X9),
	FOUR(ExchangerHandler.MODE_15X15),
	CREATIVE(ExchangerHandler.MODE_25X25);

	final int size;

	Tier(int maxSize) {
		size = maxSize;
	}

	@SideOnly(Side.CLIENT)
	public String getFormattedText() {
		return I18n.format(Data.MODID + ".tooltip.tier", this.ordinal());
	}

	public int getMaxSize() {
		return size;
	}
}
