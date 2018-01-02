package jackyy.exchangers.item;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.helper.StringHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemExchangerBase extends ExchangerHandler {

    public ItemExchangerBase(){
        setMaxStackSize(1);
        setCreativeTab(Exchangers.TAB);
    }

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

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (checkLoaded()) {
            list.add(new ItemStack(this));
        }
    }

    public boolean checkLoaded() {
        return this.checkLoaded();
    }

    @Override @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        return 20;
    }

}
