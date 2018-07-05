package jackyy.exchangers.item;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.client.Keys;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.IExchanger;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
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
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText());
        }

        ExchangerHandler.setDefaultTagCompound(stack);

        NBTTagCompound compound = stack.getTagCompound();
        String id = compound.getString("block");
        IBlockState state = NBTUtil.readBlockState(compound.getCompoundTag("blockstate"));

        if (StringHelper.isShiftKeyDown()) {
            if (id.equals("minecraft:air")) {
                tooltip.add(StringHelper.localize("tooltip.no_selected_block"));
            } else {
                Block block = Block.getBlockFromName(id);
                tooltip.add(StringHelper.localize("tooltip.selected_block") + " " + ExchangerHandler.getBlockName(block, state.getBlock().getMetaFromState(state)));
            }
            tooltip.add(StringHelper.localize("tooltip.current_range") + " " + ExchangerHandler.modeSwitchList[compound.getInteger("mode")]);
            tooltip.add(StringHelper.localize("tooltip.max_range") + " " + ExchangerHandler.modeSwitchList[getMaxRange()]);
            tooltip.add(StringHelper.localize("tooltip.max_harvest_level") + " " + StringHelper.formatHarvestLevel(getHarvestLevel()));
            if (ModConfig.misc.doExchangersSilkTouch) {
                tooltip.add(StringHelper.localize("tooltip.silk_touch.on"));
            } else {
                tooltip.add(StringHelper.localize("tooltip.silk_touch.off"));
            }
            if (compound.getBoolean("forceDropItems")) {
                tooltip.add(StringHelper.localize("tooltip.force_drop_items.on") + " " + TextFormatting.GRAY + "(" + TextFormatting.GREEN + Keys.FORCE_DROP_ITEMS_KEY.getDisplayName() + TextFormatting.GRAY + ")");
            } else {
                tooltip.add(StringHelper.localize("tooltip.force_drop_items.off") + " " + TextFormatting.GRAY + "(" + TextFormatting.GREEN + Keys.FORCE_DROP_ITEMS_KEY.getDisplayName() + TextFormatting.GRAY + ")");
            }
            tooltip.add(StringHelper.localize("tooltip.shift1"));
            tooltip.add(StringHelper.localize("tooltip.shift2"));
            tooltip.add(StringHelper.localize("tooltip.shift3") + " " + "(" + TextFormatting.GREEN + Keys.MODE_KEY.getDisplayName() + TextFormatting.GRAY + ")");
            tooltip.add(StringHelper.getTierText(getTier()));
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + StringHelper.localize("tooltip.durability"));
            }
        }
    }

    @Override @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (checkLoaded()) {
                list.add(new ItemStack(this));
            }
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
