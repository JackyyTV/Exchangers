package jackyy.exchangers.item;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.client.Keys;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.IExchanger;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemExchangerBase extends Item implements IExchanger {

    public ItemExchangerBase() {
        setMaxStackSize(1);
        setCreativeTab(Exchangers.TAB);
    }

    @Override
	public boolean showDurabilityBar(ItemStack stack) {
		return stack.isItemDamaged();
	}

	@Override
    public boolean isPowered() {
        return false;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (player.isSneaking()) {
                ExchangerHandler.selectBlock(player.getHeldItemMainhand(), player, world, pos);
            } else {
                ExchangerHandler.placeBlock(player.getHeldItemMainhand(), player, world, pos, side);
            }
        }
        return EnumActionResult.SUCCESS;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);

        ExchangerHandler.setDefaultTagCompound(stack);
        NBTTagCompound compound = stack.getTagCompound();
        IBlockState state = NBTUtil.readBlockState(compound.getCompoundTag("blockstate"));
        Block block = state.getBlock();
        int mode = stack.getTagCompound().getInteger("exmode");

        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText());
        }
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.selected_block") + " " + (block == Blocks.AIR ? TextFormatting.RED + StringHelper.localize("tooltip.selected_block.none") : TextFormatting.GREEN + ExchangerHandler.getBlockName(block, state.getBlock().getMetaFromState(state))));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.current_range") + " " + TextFormatting.GREEN + ExchangerHandler.modeSwitchList[compound.getInteger("range")]);
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.max_range") + " " + TextFormatting.GREEN + ExchangerHandler.modeSwitchList[getMaxRange()]);
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.max_harvest_level") + " " + TextFormatting.GREEN + StringHelper.formatHarvestLevel(getHarvestLevel()));
            switch (mode) {
                case 0:
                    tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.current_mode") + " " + TextFormatting.GREEN + StringHelper.localize("mode.plane"));
                    break;
                case 1:
                    tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.current_mode") + " " + TextFormatting.GREEN + StringHelper.localize("mode.horizontal"));
                    break;
                case 2:
                    tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.current_mode") + " " + TextFormatting.GREEN + StringHelper.localize("mode.vertical"));
                    break;
            }
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.silk_touch", ModConfig.misc.doExchangersSilkTouch ? TextFormatting.GREEN + StringHelper.localize("tooltip.state.enabled") + TextFormatting.WHITE : TextFormatting.RED + StringHelper.localize("tooltip.state.disabled") + TextFormatting.WHITE));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.force_drop_items", compound.getBoolean("forceDropItems") ? TextFormatting.GREEN + StringHelper.localize("tooltip.state.enabled") + TextFormatting.WHITE : TextFormatting.RED + StringHelper.localize("tooltip.state.disabled") + TextFormatting.WHITE));
        }
        if (!StringHelper.isCtrlKeyDown()) {
            tooltip.add(StringHelper.getCtrlText());
        }
        if (StringHelper.isCtrlKeyDown()) {
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.extra1"));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.extra2"));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.extra3", TextFormatting.GREEN + Keys.RANGE_SWITCH_KEY.getDisplayName() + TextFormatting.WHITE));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.extra4", TextFormatting.GREEN + Keys.MODE_SWITCH_KEY.getDisplayName() + TextFormatting.WHITE));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize("tooltip.extra5", TextFormatting.GREEN + Keys.FORCE_DROP_ITEMS_KEY.getDisplayName() + TextFormatting.WHITE));
        }
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getTierText(getTier()));
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + StringHelper.localize("tooltip.durability"));
            }
        }
    }

    @Override @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
        if (checkLoaded()) {
            list.add(new ItemStack(this));
        }
    }

    @Override @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.FORTUNE
                || enchantment == Enchantments.SILK_TOUCH
                || enchantment == Enchantments.UNBREAKING
                || enchantment == Enchantments.MENDING;
    }

}
