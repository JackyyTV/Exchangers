package jackyy.exchangers.item;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.helper.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemExchangerBase extends ExchangerHandler {

	public boolean showDurabilityBar(ItemStack stack) {
		return stack.isItemDamaged();
	}

	@Override
    public boolean isPowered() {
        return false;
    }

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
		super.addInformation(stack, player, tooltip, bool);
        if (StringHelper.isShiftKeyDown()) {
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + StringHelper.localize("tooltip.durability"));
            }
        }
	}

}
