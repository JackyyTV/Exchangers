package me.jacky1356400.exchangers.handler;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.client.Keys;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchangerBase;
import me.jacky1356400.exchangers.item.ItemExchangerBaseRF;
import me.jacky1356400.exchangers.item.enderio.*;
import me.jacky1356400.exchangers.item.mekanism.ItemAdvancedExchanger;
import me.jacky1356400.exchangers.item.mekanism.ItemBasicExchanger;
import me.jacky1356400.exchangers.item.mekanism.ItemEliteExchanger;
import me.jacky1356400.exchangers.item.mekanism.ItemUltimateExchanger;
import me.jacky1356400.exchangers.item.special.ItemCreativeExchanger;
import me.jacky1356400.exchangers.item.special.ItemTuberousExchanger;
import me.jacky1356400.exchangers.item.thermalexpansion.*;
import me.jacky1356400.exchangers.item.vanilla.*;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fluids.BlockFluidBase;

import java.util.*;

import static me.jacky1356400.exchangers.handler.WorldEventHandler.queueExchanges;
import static me.jacky1356400.exchangers.helper.ChatHelper.msgPlayer;
import static me.jacky1356400.exchangers.helper.DirectionHelper.getFacings;

public class ExchangerHandler extends Item {

    public static final int MODE_1X1 = 0;
    public static final int MODE_3X3 = 1;
    public static final int MODE_5X5 = 2;
    public static final int MODE_7X7 = 3;
    public static final int MODE_9X9 = 4;
    public static final int MODE_11X11 = 5;
    public static final int MODE_13X13 = 6;
    public static final int MODE_15X15 = 7;
    public static final int MODE_17X17 = 8;
    public static final int MODE_19X19 = 9;
    public static final int MODE_21X21 = 10;
    public static final int MODE_23X23 = 11;
    public static final int MODE_25X25 = 12;

    public static final String[] modeSwitchList = new String[] { "1x1", "3x3", "5x5", "7x7", "9x9", "11x11", "13x13",
            "15x15", "17x17", "19x19", "21x21", "23x23", "25x25" };

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
        if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText());
        }
        if (!StringHelper.isShiftKeyDown()) {
            return;
        }

        if (stackTagCompoundNull(stack))
            setDefaultTagCompound(stack);
        NBTTagCompound compound = stack.getTagCompound();

        if (compound == null || Block.getBlockFromName(compound.getString("BlockName")) == null) {
            tooltip.add(StringHelper.localize("tooltip.noselectedblock"));
        } else {
            String name = compound.getString("BlockName");
            Block block = Block.getBlockFromName(name);

            int meta = compound.getByte("BlockData");

            tooltip.add(StringHelper.localize("tooltip.selectedblock") + " " + getBlockName(block, meta));
            tooltip.add(StringHelper.localize("tooltip.selectedmode") + " " + modeSwitchList[compound.getInteger("ExchangeMode")]);
        }
        if (StringHelper.isShiftKeyDown()) {
            tooltip.remove(StringHelper.getShiftText());
            tooltip.add(StringHelper.localize("tooltip.shift1"));
            tooltip.add(StringHelper.localize("tooltip.shift2"));
            tooltip.add(StringHelper.localize("tooltip.shift3") + " " + "(" + Keys.modeKey.getDisplayName() + ")");
        }
    }

    public void switchMode(EntityPlayer player, ItemStack stack) {
        if (stackTagCompoundNull(stack))
            setDefaultTagCompound(stack);

        int modeSwitch = stack.getTagCompound().getInteger("ExchangeMode");
        modeSwitch++;

        ItemStack heldItem = player.getHeldItemMainhand();

        if (heldItem != null) {
            //Special Exchangers
            if (heldItem.getItem() instanceof ItemTuberousExchanger) {
                if (modeSwitch > MODE_1X1)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemCreativeExchanger) {
                if (modeSwitch > MODE_25X25)
                    modeSwitch = MODE_1X1;
            }
            //Vanilla Exchangers
            if (heldItem.getItem() instanceof ItemWoodenExchanger) {
                if (modeSwitch > MODE_1X1)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemStoneExchanger) {
                if (modeSwitch > MODE_3X3)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemGoldenExchanger) {
                if (modeSwitch > MODE_5X5)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemIronExchanger) {
                if (modeSwitch > MODE_7X7)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemDiamondExchanger) {
                if (modeSwitch > MODE_9X9)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemEmeraldExchanger) {
                if (modeSwitch > MODE_11X11)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemEmeraldExchanger) {
                if (modeSwitch > MODE_13X13)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemObsidianExchanger) {
                if (modeSwitch > MODE_15X15)
                    modeSwitch = MODE_1X1;
            }
            //Ender IO Exchangers
            if (heldItem.getItem() instanceof ItemConductiveIronExchanger) {
                if (modeSwitch > MODE_3X3)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemPulsatingIronExchanger) {
                if (modeSwitch > MODE_5X5)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemElectricalSteelExchanger) {
                if (modeSwitch > MODE_9X9)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemEnergeticExchanger) {
                if (modeSwitch > MODE_11X11)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemDarkSteelExchanger) {
                if (modeSwitch > MODE_13X13)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemVibrantExchanger) {
                if (modeSwitch > MODE_15X15)
                    modeSwitch = MODE_1X1;
            }
            //Thermal Expansion Exchangers
            if (heldItem.getItem() instanceof ItemLeadstoneExchanger) {
                if (modeSwitch > MODE_3X3)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemLeadstoneExchanger) {
                if (modeSwitch > MODE_7X7)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemReinforcedExchanger) {
                if (modeSwitch > MODE_11X11)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemSignalumExchanger) {
                if (modeSwitch > MODE_13X13)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemResonantExchanger) {
                if (modeSwitch > MODE_15X15)
                    modeSwitch = MODE_1X1;
            }
            //Mekanism Exchangers
            if (heldItem.getItem() instanceof ItemBasicExchanger) {
                if (modeSwitch > MODE_7X7)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemAdvancedExchanger) {
                if (modeSwitch > MODE_11X11)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemEliteExchanger) {
                if (modeSwitch > MODE_13X13)
                    modeSwitch = MODE_1X1;
            }
            if (heldItem.getItem() instanceof ItemUltimateExchanger) {
                if (modeSwitch > MODE_15X15)
                    modeSwitch = MODE_1X1;
            }
        }

        stack.getTagCompound().setInteger("ExchangeMode", modeSwitch);
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return EnumActionResult.PASS;
        }

        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if (player.isSneaking()) {

            if (blockSuitableForSelection(player, world, pos)) {
                setSelectedBlock(stack, block, state);
                return EnumActionResult.SUCCESS;
            } else {
                msgPlayer(player, StringHelper.localize("error.invalidblock"));
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

    public static List<BlockPos> getBlocksToExchange(ItemStack stack, BlockPos pos, World world, EnumFacing side) {

        int modeSwitch = stack.getTagCompound().getInteger("ExchangeMode");
        int range = modeSwitch;
        IBlockState state = world.getBlockState(pos);

        List<BlockPos> exchangeList = new ArrayList<BlockPos>();
        List<BlockPos> checkedList = new ArrayList<BlockPos>();

        exchangeList.add(pos);
        checkedList.add(pos);

        buildExchangeList(world, pos, pos, state, side, range, exchangeList, checkedList);

        if (!exchangeList.isEmpty()) {
            world.playSound(null, (double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F),
                    (double) ((float) pos.getZ() + 0.5F),
                    SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.endermen.teleport")),
                    SoundCategory.BLOCKS, 1F, 1F);

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
            if (block instanceof BlockFence || block instanceof BlockFenceGate || block instanceof BlockTrapDoor
                    || block instanceof BlockDoor || block instanceof BlockPistonBase || block instanceof BlockLadder) {
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
            if (block instanceof BlockFluidBase || block instanceof BlockLiquid || block instanceof IPlantable
                    || block instanceof BlockTorch || block instanceof BlockLeaves
                    || block instanceof BlockHugeMushroom) {
                softBlocks.add(block);
            }
        }

        softBlocks.add(Blocks.SNOW);
        softBlocks.add(Blocks.VINE);
        softBlocks.add(Blocks.FIRE);
        softBlocks.add(Blocks.AIR);

    }

    public static boolean blockSuitableForSelection(EntityPlayer player, World world, BlockPos pos) {
        if (world.getTileEntity(pos) != null)
            return false;
        if (world.isAirBlock(pos))
            return false;
        if (blacklistedBlocks.contains(world.getBlockState(pos).getBlock()))
            return false;
        if (softBlocks.contains(world.getBlockState(pos).getBlock()))
            return false;
        if (specialBlocks.contains((world.getBlockState(pos).getBlock())))
            return false;
        if (creativeBlocks.contains(world.getBlockState(pos).getBlock()) && !player.capabilities.isCreativeMode)
            return false;

        return true;
    }

    public static void setSelectedBlock(ItemStack stack, Block block, IBlockState state) {
        String blockName = Block.REGISTRY.getNameForObject(block).toString();
        if (stackTagCompoundNull(stack))
            setDefaultTagCompound(stack);

        stack.getTagCompound().setString("BlockName", blockName);
        stack.getTagCompound().setInteger("BlockData", (byte) block.getMetaFromState(state));
    }

    public static boolean blockSuitableForExchange(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        Block newBlock = Block.getBlockFromName(stack.getTagCompound().getString("BlockName"));
        int newMeta = stack.getTagCompound().getInteger("BlockData");

        Block worldBlock = world.getBlockState(pos).getBlock();
        int worldMeta = worldBlock.getMetaFromState(world.getBlockState(pos));

        if (!blockSuitableForSelection(player, world, pos)) {
            msgPlayer(player, StringHelper.localize("error.invalidblock"));
            return false;
        }

        if (newBlock == worldBlock && newMeta == worldMeta) {
            return false;
        }

        return true;
    }

    public static void buildExchangeList(World world, BlockPos pos, BlockPos origin, IBlockState origState,
                                          EnumFacing side, int range, List<BlockPos> exchangeList, List<BlockPos> checkedList) {

        EnumFacing[] facesAround = getFacings(side);

        for (EnumFacing dir : facesAround) {
            BlockPos newPos = pos.offset(dir);

            if (checkedList.contains(newPos) || !blockInRange(origin, newPos, range)) {
                continue;
            }

            checkedList.add(newPos);
            IBlockState state = world.getBlockState(newPos);

            // TODO: This is just gross
            boolean validExchange = !world.isAirBlock(newPos)
                    && (world.isAirBlock(newPos.offset(side))
                    || (world.getBlockState(newPos.offset(side)) == Blocks.WATER))
                    && state == origState && state.getBlock().isReplaceable(world, newPos.offset(side));

            if (validExchange) {
                exchangeList.add(newPos);
                buildExchangeList(world, newPos, origin, origState, side, range, exchangeList, checkedList);
            }
        }

    }

    public static boolean blockInRange(BlockPos origin, BlockPos pos, int range) {
        BlockPos diff = pos.subtract(origin);
        return Math.abs(diff.getX()) <= range && Math.abs(diff.getY()) <= range && Math.abs(diff.getZ()) <= range;
    }

    public static boolean placeBlockInInventory(EntityPlayer player, Block block, int meta) {
        ItemStack oldStack = new ItemStack(block, 1, meta);
        boolean successPlaceInInventory = player.inventory.addItemStackToInventory(oldStack);
        if (!successPlaceInInventory) {
            return false;
        }
        return true;
    }

    public static boolean consumeBlockInInventory(EntityPlayer player, Block block, IBlockState state) {
        ItemStack heldItem = player.getHeldItemMainhand();
        if (!player.capabilities.isCreativeMode || !(heldItem.getItem() instanceof ItemCreativeExchanger)) {
            InventoryPlayer inv = player.inventory;
            Item item = Item.getItemFromBlock(block);
            int meta = block.getMetaFromState(state);

            int slot = findItemInInventory(inv, item, meta);

            if (slot < 0) {
                return false;
            } else {
                if (--inv.mainInventory[slot].stackSize <= 0) {
                    inv.mainInventory[slot] = null;
                }

            }
        }

        return true;
    }

    public static int findItemInInventory(InventoryPlayer inv, Item item, int meta) {
        for (int i = 0; i < inv.mainInventory.length; i++) {
            if (inv.mainInventory[i] != null && inv.mainInventory[i].getItem() == item
                    && inv.mainInventory[i].getItemDamage() == meta) {
                return i;
            }
        }
        return -1;
    }

    public static boolean placeBlockInWorld(World world, BlockPos exchangePos, IBlockState state) {

        queueExchanges(exchangePos, state, world);

        return true;
    }

    public static String getBlockName(Block block, int meta) {
        ItemStack s = new ItemStack(block, 1, meta);
        return s.getDisplayName();
    }

    public static boolean exchangeBlocks(ItemStack stack, EntityPlayer player, World world, BlockPos pos,
                                         EnumFacing facing) {
        Block newBlock = Block.getBlockFromName(stack.getTagCompound().getString("BlockName"));
        int newMeta = stack.getTagCompound().getInteger("BlockData");

        if (newBlock == null)
            return false;
        world.theProfiler.startSection("Exchangers-Building/Queueing");

        IBlockState newState = newBlock.getStateFromMeta(newMeta);
        List<BlockPos> toExchange = getBlocksToExchange(stack, pos, world, facing);

        for (BlockPos exchangePos : toExchange) {
            int slot = -1;
            ItemStack heldItem = player.getHeldItemMainhand();
            if (player.capabilities.isCreativeMode || heldItem.getItem() instanceof ItemCreativeExchanger) {
                placeBlockInWorld(world, exchangePos, newState);
            } else {
                try {
                    slot = findItemInInventory(player.inventory, Item.getItemFromBlock(newBlock), newMeta);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
                if (slot >= 0 && player.inventory.mainInventory[slot].stackSize > 0) {
                    Block oldBlock = world.getBlockState(exchangePos).getBlock();
                    int oldMeta = oldBlock.getMetaFromState(world.getBlockState(exchangePos));
                    int energy = stack.getTagCompound().getInteger("Energy");
                    if (stack.getItem() instanceof ItemExchangerBaseRF && energy <= 0) {
                        msgPlayer(player, StringHelper.localize("error.nopower"));
                        return false;
                    } else {
                        if (!placeBlockInInventory(player, oldBlock, oldMeta)) {
                            return false;
                        } else {
                            if (!placeBlockInWorld(world, exchangePos, newState)) {
                                return false;
                            } else {
                                if (!consumeBlockInInventory(player, newBlock, newState)) {
                                    return false;
                                } else {
                                    //Vanilla Exchangers
                                    if (stack.getItem() instanceof ItemExchangerBase && !(stack.getItem() instanceof ItemCreativeExchanger)) {
                                        stack.damageItem(1, player);
                                    }
                                    //Ender IO Exchangers
                                    if (stack.getItem() instanceof ItemConductiveIronExchanger && stack.getTagCompound().getInteger("Energy") >= Config.conductiveIronExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.conductiveIronExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemPulsatingIronExchanger && stack.getTagCompound().getInteger("Energy") >= Config.pulsatingIronExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.pulsatingIronExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemElectricalSteelExchanger && stack.getTagCompound().getInteger("Energy") >= Config.electricalSteelExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.electricalSteelExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemEnergeticExchanger && stack.getTagCompound().getInteger("Energy") >= Config.energeticExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.energeticExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemDarkSteelExchanger && stack.getTagCompound().getInteger("Energy") >= Config.darkSteelExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.darkSteelExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemVibrantExchanger && stack.getTagCompound().getInteger("Energy") >= Config.vibrantExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.vibrantExchangerPerBlockRF);
                                    }
                                    //Thermal Expansion Exchangers
                                    if (stack.getItem() instanceof ItemLeadstoneExchanger && stack.getTagCompound().getInteger("Energy") >= Config.leadstoneExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.leadstoneExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemHardenedExchanger && stack.getTagCompound().getInteger("Energy") >= Config.hardenedExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.hardenedExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemReinforcedExchanger && stack.getTagCompound().getInteger("Energy") >= Config.reinforcedExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.reinforcedExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemSignalumExchanger && stack.getTagCompound().getInteger("Energy") >= Config.signalumExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.signalumExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemResonantExchanger && stack.getTagCompound().getInteger("Energy") >= Config.resonantExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.resonantExchangerPerBlockRF);
                                    }
                                    //Mekanism Exchangers
                                    if (stack.getItem() instanceof ItemBasicExchanger && stack.getTagCompound().getInteger("Energy") >= Config.basicExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.basicExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemAdvancedExchanger && stack.getTagCompound().getInteger("Energy") >= Config.advancedExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.advancedExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemEliteExchanger && stack.getTagCompound().getInteger("Energy") >= Config.eliteExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.eliteExchangerPerBlockRF);
                                    }
                                    if (stack.getItem() instanceof ItemUltimateExchanger && stack.getTagCompound().getInteger("Energy") >= Config.ultimateExchangerPerBlockRF) {
                                        stack.getTagCompound().setInteger("Energy", energy - Config.ultimateExchangerPerBlockRF);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        world.theProfiler.endSection();

        return true;
    }

}
