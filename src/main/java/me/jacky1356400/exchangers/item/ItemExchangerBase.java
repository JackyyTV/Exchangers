package me.jacky1356400.exchangers.item;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.List;

import static me.jacky1356400.exchangers.helper.ChatHelper.msgPlayer;

public class ItemExchangerBase extends Item {

    public static final int MODE_INITIAL = 0;
    public static final int MODE_1X1 = 0;
    public static final int MODE_3X3 = 1;
    public static final int MODE_5X5 = 2;
    public static final int MODE_7X7 = 3;
    public static final int MODE_9X9 = 4;
    public static final int MODE_11X11 = 5;
    public static final int MODE_13X13 = 6;
    public static final int MODE_15X15 = 7;

    public static final String[] modeSwitchList = new String[] {"1x1", "3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15"};
    public static final Integer[] modeSwitchRange = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7};

    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    public static void setDefaultTagCompound(ItemStack stack) {
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setString("BlockName", "");
        stack.getTagCompound().setInteger("BlockData", 0);
        stack.getTagCompound().setInteger("ExchangeMode", 0);
    }

    public static boolean stackTagCompoundNull(ItemStack stack) {
        return stack.getTagCompound() == null;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);

        if (stackTagCompoundNull(stack)) setDefaultTagCompound(stack);
        NBTTagCompound compound = stack.getTagCompound();

        if (compound == null || Block.getBlockFromName(compound.getString("BlockName")) == null) {
            tooltip.add(ChatFormatting.RED + "No Selected Block");
        } else {
            String name = compound.getString("BlockName");
            Block block = Block.getBlockFromName(name);

            int meta = compound.getByte("BlockData");

            tooltip.add(ChatFormatting.GREEN + "Selected Block: " + ExchangerHandler.getBlockName(block, meta));
            tooltip.add(ChatFormatting.GREEN + "Selected Mode: " + modeSwitchList[compound.getInteger("ExchangeMode")]);
        }

        tooltip.add("Sneak right click on block to select.");
        tooltip.add("Right click on a block to exchange.");
        tooltip.add("Use the mode key (default 'COMMA') to switch modes.");
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return EnumActionResult.PASS;
        }

        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        int meta = block.getMetaFromState(state);

        if (player.isSneaking()) {

            if (ExchangerHandler.blockSuitableForSelection(player, world, pos)) {
                ExchangerHandler.setSelectedBlock(stack, block, state);
                return EnumActionResult.SUCCESS;
            } else {
                msgPlayer(player, "Error: Invalid block!");
                return EnumActionResult.FAIL;
            }
        } else {
            if (ExchangerHandler.blockSuitableForExchange(stack, player, world, pos)) {

                boolean success = ExchangerHandler.exchangeBlocks(stack, player, world, pos, facing);

                if (success) {
                    return EnumActionResult.SUCCESS;

                }

            } else {
                return EnumActionResult.FAIL;
            }
        }

        return EnumActionResult.SUCCESS;
    }

    public void switchMode(EntityPlayer player, ItemStack stack, EnumHand hand, MessageContext context) {
        if (stackTagCompoundNull(stack)) setDefaultTagCompound(stack);

        int modeSwitch = stack.getTagCompound().getInteger("ExchangeMode");
        modeSwitch++;

        EntityPlayerMP playerMP = context.getServerHandler().playerEntity;
        ItemStack heldItem = playerMP.getHeldItemMainhand();

        if (heldItem != null) {
            if (heldItem.getItem() instanceof ItemObsidianExchanger) {
                if (modeSwitch > MODE_15X15) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemEmeraldExchanger) {
                if (modeSwitch > MODE_13X13) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemEmeraldExchanger) {
                if (modeSwitch > MODE_11X11) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemDiamondExchanger) {
                if (modeSwitch > MODE_9X9) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemIronExchanger) {
                if (modeSwitch > MODE_7X7) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemGoldenExchanger) {
                if (modeSwitch > MODE_5X5) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemStoneExchanger) {
                if (modeSwitch > MODE_3X3) modeSwitch = MODE_INITIAL;
            }
            if (heldItem.getItem() instanceof ItemWoodenExchanger) {
                if (modeSwitch > MODE_1X1) modeSwitch = MODE_INITIAL;
            }
        }

        stack.getTagCompound().setInteger("ExchangeMode", modeSwitch);
        msgPlayer(player, "Exchanger mode set to " + modeSwitchList[modeSwitch]);
    }

}
