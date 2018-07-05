package jackyy.exchangers.handler;

import jackyy.exchangers.helper.ChatHelper;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.*;

public class ExchangerHandler {

    public static final String[] modeSwitchList = new String[] {
            "1x1", "3x3", "5x5", "7x7", "9x9",
            "11x11", "13x13", "15x15", "17x17",
            "19x19", "21x21", "23x23", "25x25" };

    public static void setDefaultTagCompound(ItemStack stack) {
        if (stack.getTagCompound() == null) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("block", "minecraft:air");
            compound.setTag("blockstate", new NBTTagCompound());
            compound.setInteger("mode", 0);
            compound.setBoolean("forceDropItems", false);
            stack.setTagCompound(compound);
        } else {
            if (!stack.getTagCompound().hasKey("block")) {
                stack.getTagCompound().setString("block", "minecraft:air");
            } else if (!stack.getTagCompound().hasKey("blockstate")) {
                stack.getTagCompound().setTag("blockstate", new NBTTagCompound());
            } else if (!stack.getTagCompound().hasKey("mode")) {
                stack.getTagCompound().setInteger("mode", 0);
            } else if (!stack.getTagCompound().hasKey("forceDropItems")) {
                stack.getTagCompound().setBoolean("forceDropItems", false);
            } else if (stack.getTagCompound().hasKey("meta")) {
                stack.getTagCompound().removeTag("meta");
            }
        }
    }

    private static int getExPerBlockUse(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getPerBlockUse();
    }

    private static int getPerBlockEnergy(ItemStack stack) {
        if (ModConfig.misc.unbreakingPoweredExchangers) {
            int level = MathHelper.clamp_int(EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, stack), 0, 10);
            if (new Random().nextInt(2 + level) >= 2) {
                return 0;
            }
        }
        return getExPerBlockUse(stack);
    }

    private static int getExHarvestLevel(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getHarvestLevel();
    }

    private static int getExRange(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getMaxRange();
    }

    private static boolean getExIsCreative(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).isCreative();
    }

    private static boolean getExIsPowered(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).isPowered();
    }

    public static void switchMode(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        int modeSwitch = stack.getTagCompound().getInteger("mode");
        if (player.isSneaking()) {
            modeSwitch--;
        } else {
            modeSwitch++;
        }
        ItemStack heldItem = player.getHeldItemMainhand();
        if (heldItem != null) {
            if (modeSwitch > getExRange(stack)) {
                modeSwitch = 0;
            } else if (modeSwitch < 0) {
                modeSwitch = getExRange(stack);
            }
        }
        stack.getTagCompound().setInteger("mode", modeSwitch);
    }

    public static void toggleForceDropItems(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = stack.getTagCompound().getBoolean("forceDropItems");
        ItemStack heldItem = player.getHeldItemMainhand();
        if (heldItem != null) {
            toggle = !toggle;
        }
        stack.getTagCompound().setBoolean("forceDropItems", toggle);
        ChatHelper.msgPlayer(player, toggle ? "msg.force_drop_items.on" : "msg.force_drop_items.off");
    }

    public static boolean isWhitelisted(World world, BlockPos pos) {
        for (String block : ModConfig.misc.blocksWhitelist) {
            if (world.getBlockState(pos).getBlock().getRegistryName().equals(new ResourceLocation(block))) {
                return true;
            }
        }
        return world.getBlockState(pos).getBlock().getRegistryName().equals("tconstruct:seared");
    }

    public static boolean isBlacklisted(World world, BlockPos pos) {
        for (String block : ModConfig.misc.blocksBlacklist) {
            if (world.getBlockState(pos).getBlock().getRegistryName().equals(new ResourceLocation(block))) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    public static void placeBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        String id = tagCompound.getString("block");
        Block block = Block.getBlockFromName(id);
        IBlockState state = NBTUtil.readBlockState(tagCompound.getCompoundTag("blockstate"));
        IBlockState oldState = world.getBlockState(pos);
        Block oldblock = oldState.getBlock();
        int oldmeta = oldblock.getMetaFromState(oldState);
        float blockHardness = oldblock.getBlockHardness(oldState, world, pos);

        if (id.equals("minecraft:air")) {
            return;
        } else if ((block == oldblock) && (state == oldState)) {
            return;
        } else if (world.getTileEntity(pos) != null && !isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, "error.invalid_block.te");
            return;
        } else if (isBlacklisted(world, pos)) {
            ChatHelper.msgPlayer(player, "error.blacklisted");
            return;
        } else if (!getExIsCreative(stack) && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, "error.invalid_block.unbreakable");
            return;
        } else if (!getExIsCreative(stack) && getExIsPowered(stack) && stack.getTagCompound().getInteger("Energy") < getPerBlockEnergy(stack)) {
            ChatHelper.msgPlayer(player, "error.out_of_power");
            return;
        } else if (!getExIsCreative(stack) && getExHarvestLevel(stack) < oldblock.getHarvestLevel(oldState)) {
            ChatHelper.msgPlayer(player, "error.low_harvest_level");
            return;
        }

        Set<BlockPos> coordinates = findSuitableBlocks(stack, world, side, pos, oldblock, oldmeta);
        boolean notEnough = false;
        world.captureBlockSnapshots = false;

        for (BlockPos coordinate : coordinates) {
            BlockEvent.PlaceEvent event = new BlockEvent.PlaceEvent(BlockSnapshot.getBlockSnapshot(world, coordinate, 3), Blocks.AIR.getDefaultState(), player, player.getActiveHand());
            world.setBlockState(coordinate, state, 3);
            if (!MinecraftForge.EVENT_BUS.post(event)) {
                if (consumeItemInInventory(Item.getItemFromBlock(block), state.getBlock().getItem(world, pos, state).getMetadata(), player.inventory, player)) {
                    if (!player.capabilities.isCreativeMode && !getExIsCreative(stack)) {
                        if (ModConfig.misc.doExchangersSilkTouch || EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
                            ItemStack oldblockItem = oldblock.getItem(world, pos, oldState);
                            giveItem(world, player, oldblockItem);
                        } else {
                            int fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
                            List<ItemStack> oldblockItems = oldblock.getDrops(world, pos, oldState, fortuneLevel);
                            for (ItemStack oldblockItem : oldblockItems) {
                                giveItem(world, player, oldblockItem);
                            }
                        }
                        if (!getExIsPowered(stack)) {
                            stack.damageItem(1, player);
                        } else if (stack.getTagCompound().getInteger("Energy") >= getPerBlockEnergy(stack)) {
                            stack.getTagCompound().setInteger("Energy", stack.getTagCompound().getInteger("Energy") - getPerBlockEnergy(stack));
                        }
                        player.openContainer.detectAndSendChanges();
                    }
                    world.playSound(null, coordinate.getX(), coordinate.getY(), coordinate.getZ(),
                            SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.BLOCKS, 0.1F, 1F);
                } else {
                    world.restoringBlockSnapshots = true;
                    event.getBlockSnapshot().restore(true);
                    world.restoringBlockSnapshots = false;
                    notEnough = true;
                }
            } else {
                world.restoringBlockSnapshots = true;
                event.getBlockSnapshot().restore(true);
                world.restoringBlockSnapshots = false;
                ChatHelper.msgPlayer(player, "error.event_cancelled");
            }
        }
        if (notEnough) {
            ChatHelper.msgPlayer(player, "error.out_of_block");
        }
        world.captureBlockSnapshots = true;
    }

    @SuppressWarnings("deprecation")
    public static void selectBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        setDefaultTagCompound(stack);
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        NBTTagCompound tagCompound = getTagCompound(stack);
        float blockHardness = block.getBlockHardness(state, world, pos);
        if (world.getTileEntity(pos) != null && !isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, "error.invalid_block.te");
            return;
        } else if (isBlacklisted(world, pos)) {
            ChatHelper.msgPlayer(player, "error.blacklisted");
            return;
        } else if (!getExIsCreative(stack) && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, "error.invalid_block.unbreakable");
            return;
        }
        String id = Block.REGISTRY.getNameForObject(block).toString();
        tagCompound.setString("block", id);
        NBTUtil.writeBlockState(tagCompound.getCompoundTag("blockstate"), state);
    }

    public static Set<BlockPos> findSuitableBlocks(ItemStack stack, World world, EnumFacing sideHit, BlockPos pos, Block centerBlock, int centerMeta) {
        Set<BlockPos> coordinates = new HashSet<>();
        int mode = stack.getTagCompound().getInteger("mode");

        List<BlockPos> possibleLocs = new ArrayList<>();
        possibleLocs.add(pos);
        int index = 0;
        do {
            BlockPos currentPos = possibleLocs.get(index);
            checkAndAddBlock(world, currentPos, centerBlock, centerMeta, coordinates);
            switch (sideHit) {
                case UP:
                    getConnectedBlocksUD(possibleLocs, world, currentPos, pos, centerBlock, centerMeta, mode, true);
                    break;
                case DOWN:
                    getConnectedBlocksUD(possibleLocs, world, currentPos, pos, centerBlock, centerMeta, mode, false);
                    break;
                case SOUTH:
                    getConnectedBlocksNS(possibleLocs, world, currentPos, pos, centerBlock, centerMeta, mode, true);
                    break;
                case NORTH:
                    getConnectedBlocksNS(possibleLocs, world, currentPos, pos, centerBlock, centerMeta, mode, false);
                    break;
                case EAST:
                    getConnectedBlocksEW(possibleLocs, world, currentPos, pos, centerBlock, centerMeta, mode,true);
                    break;
                case WEST:
                    getConnectedBlocksEW(possibleLocs, world, currentPos, pos, centerBlock, centerMeta, mode, false);
                    break;
            }
            index++;
        } while (index < possibleLocs.size());
        return coordinates;
    }

    private static void checkAndAddBlock(World world, BlockPos pos, Block centerBlock, int centerMeta, Set<BlockPos> coordinates) {
        IBlockState state = world.getBlockState(pos);
        if ((state.getBlock() == centerBlock) && (state.getBlock().getMetaFromState(state) == centerMeta))
            coordinates.add(pos);
    }

    private static boolean checkBlock(World world, BlockPos pos, Block centerBlock, int centerMeta) {
        IBlockState state = world.getBlockState(pos);
        return (state.getBlock() == centerBlock) && (state.getBlock().getMetaFromState(state) == centerMeta);
    }

    private static void getConnectedBlocksUD(List<BlockPos> possibleLocs, World world, BlockPos currentPos, BlockPos centerPos, Block centerBlock, int centerMeta, int mode, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.add(x, 0, y);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getX() <= centerPos.getX() + mode && newPos.getX() >= centerPos.getX() - mode)
                        if (newPos.getZ() <= centerPos.getZ() + mode && newPos.getZ() >= centerPos.getZ() - mode)
                            if (!world.getBlockState(newPos.add(0, side ? 1 : -1, 0)).isFullBlock() && checkBlock(world, newPos, centerBlock, centerMeta))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static void getConnectedBlocksNS(List<BlockPos> possibleLocs, World world, BlockPos currentPos, BlockPos centerPos, Block centerBlock, int centerMeta, int mode, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.add(x, y, 0);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getX() <= centerPos.getX() + mode && newPos.getX() >= centerPos.getX() - mode)
                        if (newPos.getY() <= centerPos.getY() + mode && newPos.getY() >= centerPos.getY() - mode)
                            if (!world.getBlockState(newPos.add(0, 0, side ? 1 : -1)).isFullBlock() && checkBlock(world, newPos, centerBlock, centerMeta))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static void getConnectedBlocksEW(List<BlockPos> possibleLocs, World world, BlockPos currentPos, BlockPos centerPos, Block centerBlock, int centerMeta, int mode, boolean side) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                BlockPos newPos = currentPos.add(0, x, y);
                if (!isLocationContained(possibleLocs, newPos))
                    if (newPos.getY() <= centerPos.getY() + mode && newPos.getY() >= centerPos.getY() - mode)
                        if (newPos.getZ() <= centerPos.getZ() + mode && newPos.getZ() >= centerPos.getZ() - mode)
                            if (!world.getBlockState(newPos.add(side ? 1 : -1, 0, 0)).isFullBlock() && checkBlock(world, newPos, centerBlock, centerMeta))
                                possibleLocs.add(newPos);
            }
        }
    }

    private static boolean isLocationContained(List<BlockPos> possibleLocs, BlockPos toFind) {
        for (BlockPos pos : possibleLocs)
            if (pos.getX() == toFind.getX() && pos.getY() == toFind.getY() && pos.getZ() == toFind.getZ())
                return true;
        return false;
    }

    private static boolean consumeItemInInventory(Item item, int meta, InventoryPlayer playerInv, EntityPlayer player) {
        if (player.capabilities.isCreativeMode || getExIsCreative(player.getHeldItemMainhand())) {
            return true;
        }
        int i = findItem(item, meta, playerInv);
        if (i < 0) {
            IItemHandler inv = findItemHolder(playerInv);
            if (inv == null)
                return false;
            i = findItemInContainer(item, meta, inv);
            if (i < 0)
                return false;
            ItemStack extracted = inv.extractItem(i, 1, false);
            return extracted != null;
        } else {
            playerInv.decrStackSize(i, 1);
        }
        return true;
    }

    private static int findItem(Item item, int meta, IInventory inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    private static int findItemInContainer(Item item, int meta, IItemHandler inv) {
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    private static IItemHandler findItemHolder(IInventory inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && stack.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
                return stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            }
        }
        return null;
    }

    private static void giveItem(World world, EntityPlayer player, ItemStack oldStack) {
        EntityItem entityItem = new EntityItem(world, player.posX, player.posY, player.posZ, oldStack);
        if (player.getHeldItemMainhand().getTagCompound().getBoolean("forceDropItems")) {
            world.spawnEntityInWorld(entityItem);
        } else {
            if (!player.inventory.addItemStackToInventory(oldStack)) {
                world.spawnEntityInWorld(entityItem);
            }
        }
    }

    public static NBTTagCompound getTagCompound(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    public static String getBlockName(Block block, int meta) {
        ItemStack stack = new ItemStack(block, 1, meta);
        String name;
        try {
            name = stack.getDisplayName();
            return name;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "Unable to fetch block name.";
    }

}
