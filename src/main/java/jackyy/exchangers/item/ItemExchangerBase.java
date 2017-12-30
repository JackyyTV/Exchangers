package jackyy.exchangers.item;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
        super.addInformation(stack, world, tooltip, bool);
        if (StringHelper.isShiftKeyDown()) {
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + StringHelper.localize("tooltip.durability"));
            }
        }
	}

}
