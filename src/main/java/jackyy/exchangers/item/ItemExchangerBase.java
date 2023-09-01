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
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemExchangerBase extends Item implements IExchanger, ILoadable {

    public ItemExchangerBase(Properties props) {
        super(props.tab(Reference.TAB));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.isDamaged();
    }

    @Override
    public boolean isPowered() {
        return false;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        Direction side = context.getClickedFace();
        if (!world.isClientSide() && player != null) {
            ItemStack mainHandStack = player.getMainHandItem();
            ExchangerHandler.setDefaultTagCompound(mainHandStack);
            if (player.isShiftKeyDown()) {
                ExchangerHandler.selectBlock(mainHandStack, player, world, pos);
            } else {
                ExchangerHandler.placeBlock(mainHandStack, player, world, pos, side, context);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, world, tooltip, advanced);

        ExchangerHandler.setDefaultTagCompound(stack);
        CompoundTag compound = NBTHelper.getTag(stack);
        BlockState state = NbtUtils.readBlockState(compound.getCompound("blockstate"));
        Block block = state.getBlock();
        int mode = compound.getInt("mode");

        if (!KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText(Reference.MODID));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.selected_block", (block == Blocks.AIR ? StringHelper.localize(Reference.MODID, "tooltip.selected_block.none").withStyle(ChatFormatting.RED) : ExchangerHandler.getBlockName(block).withStyle(ChatFormatting.GREEN))).withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_range", ChatFormatting.GREEN + ExchangerHandler.rangeList[compound.getInt("range")]).withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.max_range", new TextComponent(ExchangerHandler.rangeList[getMaxRange()]).withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.max_harvest_level", StringHelper.formatHarvestLevel(getHarvestLevel()).withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.WHITE));
            switch (mode) {
                case 0 ->
                        tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModePlane.getDisplayName().withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.WHITE));
                case 1 ->
                        tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModeHorizontalCol.getDisplayName().withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.WHITE));
                case 2 ->
                        tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.current_mode", ModeVerticalCol.getDisplayName().withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.WHITE));
            }
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.silk_touch", Reference.getStateString(ModConfigs.CONFIG.doExchangersSilkTouch.get())).withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.force_drop_items", Reference.getStateString(compound.getBoolean("forceDropItems"))).withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.directional_placement", Reference.getStateString(compound.getBoolean("directionalPlacement"))).withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.fuzzy_placement", Reference.getStateString(compound.getBoolean("fuzzyPlacement"))).withStyle(ChatFormatting.WHITE));
        }
        if (!KeyHelper.isCtrlKeyDown()) {
            tooltip.add(StringHelper.getCtrlText(Reference.MODID));
        }
        if (KeyHelper.isCtrlKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.extra1").withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.extra2").withStyle(ChatFormatting.WHITE));
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.extra3", new TranslatableComponent(Keys.OPEN_GUI_KEY.getKey().toString()).withStyle(ChatFormatting.GREEN)).withStyle(ChatFormatting.WHITE));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getTierText(Reference.MODID, getTier()));
            if (!isPowered()) {
                tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getDamageValue()).append(" / ").append(StringHelper.formatNumber(stack.getMaxDamage())).append(" ").append(StringHelper.localize(Reference.MODID, "tooltip.durability")));
            }
        }
    }

    @Override @OnlyIn(Dist.CLIENT)
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (allowdedIn(group)) {
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
    public boolean isFoil(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.BLOCK_FORTUNE || enchantment == Enchantments.SILK_TOUCH
                || enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }

}
