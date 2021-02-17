package jackyy.exchangers.item;

import jackyy.exchangers.client.keybind.Keys;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.handler.mode.ModeHorizontalCol;
import jackyy.exchangers.handler.mode.ModePlane;
import jackyy.exchangers.handler.mode.ModeVerticalCol;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.IExchanger;
import jackyy.exchangers.util.ILoadable;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemExchangerBase extends Item implements IExchanger, ILoadable {

    public ItemExchangerBase(Properties props) {
        super(props.group(Reference.TAB));
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return stack.isDamaged();
    }

    @Override
    public boolean isPowered() {
        return false;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getPos();
        Direction side = context.getFace();
        if (!world.isRemote && player != null) {
            if (player.isSneaking()) {
                ExchangerHandler.selectBlock(player.getHeldItemMainhand(), player, world, pos);
            } else {
                ExchangerHandler.placeBlock(player.getHeldItemMainhand(), player, world, pos, side, context);
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);

        ExchangerHandler.setDefaultTagCompound(stack);
        CompoundNBT compound = NBTHelper.getTag(stack);
        BlockState state = NBTUtil.readBlockState(compound.getCompound("blockstate"));
        Block block = state.getBlock();
        int mode = compound.getInt("mode");

        if (!KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText(Reference.MODID));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.selected_block", (block == Blocks.AIR ? StringHelper.localize(Reference.MODID, "tooltip.selected_block.none").mergeStyle(TextFormatting.RED) : ExchangerHandler.getBlockName(block).mergeStyle(TextFormatting.GREEN))).mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_range", TextFormatting.GREEN + ExchangerHandler.rangeList[compound.getInt("range")]).mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.max_range", new StringTextComponent(ExchangerHandler.rangeList[getMaxRange()]).mergeStyle(TextFormatting.GREEN)).mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.max_harvest_level", StringHelper.formatHarvestLevel(Reference.MODID, getHarvestLevel()).mergeStyle(TextFormatting.GREEN)).mergeStyle(TextFormatting.WHITE));
            switch (mode) {
                case 0:
                    tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModePlane.getDisplayName().mergeStyle(TextFormatting.GREEN)).mergeStyle(TextFormatting.WHITE));
                    break;
                case 1:
                    tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModeHorizontalCol.getDisplayName().mergeStyle(TextFormatting.GREEN)).mergeStyle(TextFormatting.WHITE));
                    break;
                case 2:
                    tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModeVerticalCol.getDisplayName().mergeStyle(TextFormatting.GREEN)).mergeStyle(TextFormatting.WHITE));
                    break;
            }
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.silk_touch", Reference.getStateString(ModConfigs.CONFIG.doExchangersSilkTouch.get())).mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.force_drop_items", Reference.getStateString(compound.getBoolean("forceDropItems"))).mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.directional_placement", Reference.getStateString(compound.getBoolean("directionalPlacement"))).mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement", Reference.getStateString(compound.getBoolean("fuzzyPlacement"))).mergeStyle(TextFormatting.WHITE));
        }
        if (!KeyHelper.isCtrlKeyDown()) {
            tooltip.add(StringHelper.getCtrlText(Reference.MODID));
        }
        if (KeyHelper.isCtrlKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.extra1").mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.extra2").mergeStyle(TextFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.extra3", new TranslationTextComponent(Keys.OPEN_GUI_KEY.getKey().toString()).mergeStyle(TextFormatting.GREEN)).mergeStyle(TextFormatting.WHITE));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getTierText(Reference.MODID, getTier()));
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getDamage()).appendString(" / ").append(StringHelper.formatNumber(stack.getMaxDamage())).appendString(" ").append(StringHelper.localize(Reference.MODID, "tooltip.durability")));
            }
        }
    }

    @Override @OnlyIn(Dist.CLIENT)
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (isInGroup(group)) {
            if (checkLoaded()) {
                items.add(new ItemStack(this));
            }
        }
    }

    @Override
    public boolean checkLoaded() {
        return true;
    }

    @Override @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemEnchantability() {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.FORTUNE || enchantment == Enchantments.SILK_TOUCH
                || enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }

}
