package jackyy.exchangers.item;

import jackyy.exchangers.client.keybind.Keys;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.handler.mode.ModeHorizontalCol;
import jackyy.exchangers.handler.mode.ModePlane;
import jackyy.exchangers.handler.mode.ModeVerticalCol;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.IExchanger;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
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

import java.util.List;

public class ItemExchangerBase extends Item implements IExchanger {

    public ItemExchangerBase() {
        setMaxStackSize(1);
        setCreativeTab(Reference.TAB);
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
        ItemStack mainHandStack = player.getHeldItemMainhand();
        ExchangerHandler.setDefaultTagCompound(mainHandStack);
        if (!world.isRemote) {
            if (player.isSneaking()) {
                ExchangerHandler.selectBlock(mainHandStack, player, world, pos);
            } else {
                ExchangerHandler.placeBlock(mainHandStack, player, world, pos, side);
            }
        }
        return EnumActionResult.SUCCESS;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);

        ExchangerHandler.setDefaultTagCompound(stack);
        NBTTagCompound compound = NBTHelper.getTag(stack);
        IBlockState state = NBTUtil.readBlockState(compound.getCompoundTag("blockstate"));
        Block block = state.getBlock();
        int mode = compound.getInteger("mode");

        if (!KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText(Reference.MODID));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.selected_block", (block == Blocks.AIR ? TextFormatting.RED + StringHelper.localize(Reference.MODID, "tooltip.selected_block.none") + TextFormatting.WHITE : TextFormatting.GREEN + ExchangerHandler.getBlockName(block, state.getBlock().getMetaFromState(state)) + TextFormatting.WHITE)));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.current_range", TextFormatting.GREEN + ExchangerHandler.rangeList[compound.getInteger("range")] + TextFormatting.WHITE));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.max_range", TextFormatting.GREEN + ExchangerHandler.rangeList[getMaxRange()] + TextFormatting.WHITE));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.max_harvest_level", TextFormatting.GREEN + StringHelper.formatHarvestLevel(Reference.MODID, getHarvestLevel()) + TextFormatting.WHITE));
            switch (mode) {
                case 0:
                    tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.current_mode", TextFormatting.GREEN + ModePlane.getDisplayName()) );
                    break;
                case 1:
                    tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.current_mode", TextFormatting.GREEN + ModeHorizontalCol.getDisplayName()));
                    break;
                case 2:
                    tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.current_mode", TextFormatting.GREEN + ModeVerticalCol.getDisplayName()));
                    break;
            }
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.silk_touch", Reference.getStateString(ModConfig.misc.doExchangersSilkTouch)));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.force_drop_items", Reference.getStateString(compound.getBoolean("forceDropItems"))));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.directional_placement", Reference.getStateString(compound.getBoolean("directionalPlacement"))));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement", Reference.getStateString(compound.getBoolean("fuzzyPlacement"))));
        }
        if (!KeyHelper.isCtrlKeyDown()) {
            tooltip.add(StringHelper.getCtrlText(Reference.MODID));
        }
        if (KeyHelper.isCtrlKeyDown()) {
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.extra1"));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.extra2"));
            tooltip.add(TextFormatting.WHITE + StringHelper.localize(Reference.MODID, "tooltip.extra3", TextFormatting.GREEN + Keys.OPEN_GUI_KEY.getDisplayName() + TextFormatting.WHITE));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getTierText(Reference.MODID, getTier()));
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + StringHelper.localize(Reference.MODID, "tooltip.durability"));
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
