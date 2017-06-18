package me.jacky1356400.exchangers.item;

import static me.jacky1356400.exchangers.handler.WorldEventHandler.queueExchanges;
import static me.jacky1356400.exchangers.helper.ChatHelper.msgPlayer;
import static me.jacky1356400.exchangers.helper.DirectionHelper.getFacings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fluids.BlockFluidBase;

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

            tooltip.add(ChatFormatting.GREEN + "Selected Block: " + getBlockName(block, meta));
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

            if (blockSuitableForSelection(player, world, pos)) {
                setSelectedBlock(stack, block, state);
                return EnumActionResult.SUCCESS;
            } else {
                msgPlayer(player, "Error: Invalid block!");
                return EnumActionResult.FAIL;
            }
        } else {
            if (blockSuitableForExchange(stack, player, world, pos)) {

                boolean success = exchangeBlocks(stack, player, world, pos, facing);

                if (success) {
                    return EnumActionResult.SUCCESS;

                }

            } else {
                return EnumActionResult.FAIL;
            }
        }

        return EnumActionResult.SUCCESS;
    }

    public void switchMode(EntityPlayer player, ItemStack stack) {
        if (stackTagCompoundNull(stack)) setDefaultTagCompound(stack);

        int modeSwitch = stack.getTagCompound().getInteger("ExchangeMode");
        modeSwitch++;

        ItemStack heldItem = player.getHeldItemMainhand();

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

    public static List<BlockPos> getBlocksToExchange(ItemStack stack, BlockPos pos, World world, EnumFacing side) {

        int modeSwitch = stack.getTagCompound().getInteger("ExchangeMode");
        int range = modeSwitchRange[modeSwitch];
        IBlockState state = world.getBlockState(pos);

        List<BlockPos> exchangeList = new ArrayList<BlockPos>();
        List<BlockPos> checkedList = new ArrayList<BlockPos>();

        exchangeList.add(pos);
        checkedList.add(pos);

        buildExchangeList(world, pos, pos, state, side, range, exchangeList, checkedList);

        if (!exchangeList.isEmpty()) {
            Collections.sort(exchangeList, new Comparator<BlockPos>() {
                @Override
                public int compare(BlockPos o1, BlockPos o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        return exchangeList;
    }

    private static final Set<Block> softBlocks = new HashSet<Block>();
    private static final Set<Block> specialBlocks = new HashSet<Block>();
    private static final Set<Block> blacklistedBlocks = new HashSet<Block>();
    private static final Set<Block> creativeBlocks = new HashSet<Block>();

    public static void initSpecialBlockLists() {
        for (Object o : Block.REGISTRY) {
            Block block = (Block) o;
            if (block instanceof BlockFence || block instanceof BlockFenceGate || block instanceof BlockTrapDoor || block instanceof BlockDoor || block instanceof BlockPistonBase
                    || block instanceof BlockLadder) {
                specialBlocks.add(block);
            }
        }

        for (Object o : Block.REGISTRY) {
            Block block = (Block) o;
            if (block instanceof BlockRedstoneLight || block instanceof BlockWorkbench) {
                blacklistedBlocks.add(block);
            }
        }

        for (Object o : Block.REGISTRY) {
            Block block = (Block) o;
            if (block == Blocks.BEDROCK || block == Blocks.END_PORTAL_FRAME) {
                creativeBlocks.add(block);
            }
        }

        for (Object o : Block.REGISTRY) {
            Block block = (Block) o;
            if (block instanceof BlockFluidBase || block instanceof BlockLiquid || block instanceof IPlantable || block instanceof BlockTorch || block instanceof BlockLeaves
                    || block instanceof BlockHugeMushroom) {
                softBlocks.add(block);
            }
        }

        softBlocks.add(Blocks.SNOW);
        softBlocks.add(Blocks.VINE);
        softBlocks.add(Blocks.FIRE);

    }

    public static boolean blockSuitableForSelection(EntityPlayer player, World world, BlockPos pos) {
        if (world.getTileEntity(pos) != null) return false;
        if (world.isAirBlock(pos)) return false;
        if (blacklistedBlocks.contains(world.getBlockState(pos).getBlock())) return false;
        if (softBlocks.contains(world.getBlockState(pos).getBlock())) return false;
        if (specialBlocks.contains((world.getBlockState(pos).getBlock()))) return false;
        if (creativeBlocks.contains(world.getBlockState(pos).getBlock()) && !player.capabilities.isCreativeMode) return false;

        return true;
    }

    public static void setSelectedBlock(ItemStack stack, Block block, IBlockState state) {
        String blockName = Block.REGISTRY.getNameForObject(block).toString();
        if (stackTagCompoundNull(stack)) setDefaultTagCompound(stack);

        stack.getTagCompound().setString("BlockName", blockName);
        stack.getTagCompound().setInteger("BlockData", (byte) block.getMetaFromState(state));
    }

    public static boolean blockSuitableForExchange(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        Block newBlock = Block.getBlockFromName(stack.getTagCompound().getString("BlockName"));
        int newMeta = stack.getTagCompound().getInteger("BlockData");

        Block worldBlock = world.getBlockState(pos).getBlock();
        int worldMeta = worldBlock.getMetaFromState(world.getBlockState(pos));

        if (!blockSuitableForSelection(player, world, pos)) {
            msgPlayer(player, "Error: Invalid block!");
            return false;
        }

        if (newBlock == worldBlock && newMeta == worldMeta) {
            return false;
        }

        return true;
    }

    private static void buildExchangeList(World world, BlockPos pos, BlockPos origin, IBlockState origState, EnumFacing side, int range, List<BlockPos> exchangeList, List<BlockPos> checkedList) {

        EnumFacing[] facesAround = getFacings(side);

        for (EnumFacing dir : facesAround){
            BlockPos newPos = pos.offset(dir);

            if (checkedList.contains(newPos) || !blockInRange(origin, newPos, range)){
                continue;
            }

            checkedList.add(newPos);
            IBlockState state = world.getBlockState(newPos);

            boolean validExchange = !world.isAirBlock(newPos) && (world.isAirBlock(newPos.offset(side)) || (world.getBlockState(newPos.offset(side)) == Blocks.WATER))
                    && state == origState && state.getBlock().isReplaceable(world, newPos.offset(side));

            if (validExchange) {
                exchangeList.add(newPos);
                buildExchangeList(world, newPos, origin, origState, side, range, exchangeList, checkedList);
            }
        }

    }

    private static boolean blockInRange(BlockPos origin, BlockPos pos, int range) {
        BlockPos diff = pos.subtract(origin);
        return Math.abs(diff.getX()) <= range && Math.abs(diff.getY()) <= range && Math.abs(diff.getZ()) <= range;
    }

    public static boolean exchangeBlocks(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing) {
        Block newBlock = Block.getBlockFromName(stack.getTagCompound().getString("BlockName"));
        int newMeta = stack.getTagCompound().getInteger("BlockData");

        if (newBlock == null) return false;
        world.theProfiler.startSection("Exchangers-Building/Queueing");

        IBlockState newState = newBlock.getStateFromMeta(newMeta);
        List<BlockPos> toExchange = getBlocksToExchange(stack, pos, world, facing);

        for (BlockPos exchangePos : toExchange) {
            int slot = -1;
            if (player.capabilities.isCreativeMode) {
                placeBlockInWorld(world, exchangePos, newState);
            } else {
                try {
                    slot = findItemInInventory(player.inventory, Item.getItemFromBlock(newBlock), newMeta);
                } catch (ArrayIndexOutOfBoundsException e) {
                    msgPlayer(player, "Error: Out of blocks!");
                    return false;
                }

                if (slot >= 0 && player.inventory.mainInventory[slot].stackSize > 0) {
                    Block oldBlock = world.getBlockState(exchangePos).getBlock();
                    int oldMeta = oldBlock.getMetaFromState(world.getBlockState(exchangePos));

                    if (!placeBlockInInventory(player, oldBlock, oldMeta)) {
                        msgPlayer(player, "Error: Out of space in inventory!");
                        return false;
                    } else {
                        if (!placeBlockInWorld(world, exchangePos, newState)) {
                            msgPlayer(player, "Error: Out of blocks!");
                            return false;
                        } else {
                            if (!consumeBlockInInventory(player, newBlock, newState)) {
                                return false;
                            } else {
                                stack.damageItem(1, player);
                            }
                        }
                    }
                }
            }
        }
        world.theProfiler.endSection();

        return true;
    }

    private static boolean placeBlockInInventory(EntityPlayer player, Block block, int meta) {
        ItemStack oldStack = new ItemStack(block, 1, meta);
        boolean successPlaceInInventory = player.inventory.addItemStackToInventory(oldStack);
        IBlockState state = block.getStateFromMeta(meta);
        if (!successPlaceInInventory) {
            return false;
        }

        return true;
    }

    private static boolean consumeBlockInInventory(EntityPlayer player, Block block, IBlockState state) {
        if (!player.capabilities.isCreativeMode) {
            InventoryPlayer inv = player.inventory;
            Item item = Item.getItemFromBlock(block);
            int meta = block.getMetaFromState(state);

            int slot = findItemInInventory(inv, item, meta);

            if (slot < 0) {
                return false;
            } else {
                if (--inv.mainInventory[slot].stackSize <= 0){
                    inv.mainInventory[slot] = null;
                }

            }
        }

        return true;
    }

    private static int findItemInInventory(InventoryPlayer inv, Item item, int meta) {
        for (int i = 0; i < inv.mainInventory.length; i++) {
            if (inv.mainInventory[i] != null && inv.mainInventory[i].getItem() == item && inv.mainInventory[i].getItemDamage() == meta) {
                return i;
            }
        }
        return -1;
    }

    private static boolean placeBlockInWorld(World world, BlockPos exchangePos, IBlockState state) {

        queueExchanges(exchangePos, state, world);

        return true;
    }

    public static String getBlockName(Block block, int meta) {
        ItemStack s = new ItemStack(block, 1, meta);
        return s.getDisplayName();
    }

}
