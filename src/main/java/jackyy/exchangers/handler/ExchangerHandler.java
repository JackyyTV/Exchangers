package jackyy.exchangers.handler;

import jackyy.exchangers.Config;
import jackyy.exchangers.client.Keys;
import jackyy.exchangers.helper.ChatHelper;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.util.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static final String[] modeSwitchList = new String[] {
            "1x1", "3x3", "5x5", "7x7", "9x9",
            "11x11", "13x13", "15x15", "17x17",
            "19x19", "21x21", "23x23", "25x25" };

    public static void setDefaultTagCompound(ItemStack stack) {
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setInteger("block", 0);
        stack.getTagCompound().setInteger("meta", 0);
        stack.getTagCompound().setInteger("mode", 0);
    }

    public static boolean stackTagCompoundNull(ItemStack stack) {
        return stack.getTagCompound() == null;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText());
        }

        if (stackTagCompoundNull(stack))
            setDefaultTagCompound(stack);

        NBTTagCompound compound = stack.getTagCompound();

        if (StringHelper.isShiftKeyDown()) {
            if (compound.getInteger("block") == 0) {
                tooltip.add(StringHelper.localize("tooltip.noselectedblock"));
                tooltip.add(StringHelper.localize("tooltip.currentrange") + " " + modeSwitchList[compound.getInteger("mode")]);
                tooltip.add(StringHelper.localize("tooltip.maxrange") + " " + modeSwitchList[getMaxRange()]);
            } else {
                int id = compound.getInteger("block");
                Block block = Block.getBlockById(id);
                int meta = compound.getInteger("meta");

                tooltip.add(StringHelper.localize("tooltip.selectedblock") + " " + getBlockName(block, meta));
                tooltip.add(StringHelper.localize("tooltip.currentrange") + " " + modeSwitchList[compound.getInteger("mode")]);
                tooltip.add(StringHelper.localize("tooltip.maxrange") + " " + modeSwitchList[getMaxRange()]);
            }
            tooltip.add(StringHelper.localize("tooltip.shift1"));
            tooltip.add(StringHelper.localize("tooltip.shift2"));
            tooltip.add(StringHelper.localize("tooltip.shift3") + " " + "(" + Keys.MODE_KEY.getDisplayName() + ")");
            tooltip.add(StringHelper.getTierText(getTier()));
        }
    }

    public int getTier() {
        return this.getTier();
    }

    public int getMaxRange() {
        return this.getMaxRange();
    }

    public int getMaxEnergy() {
        return this.getMaxEnergy();
    }

    public int getPerBlockUse() {
        return this.getPerBlockUse();
    }

    public boolean isCreative() {
        return false;
    }

    public boolean isPowered() {
        return false;
    }

    public void switchMode(EntityPlayer player, ItemStack stack) {
        if (stackTagCompoundNull(stack))
            setDefaultTagCompound(stack);

        int modeSwitch = stack.getTagCompound().getInteger("mode");
        modeSwitch++;

        ItemStack heldItem = player.getHeldItemMainhand();

        if (heldItem != null) {
            if (modeSwitch > getMaxRange())
                modeSwitch = MODE_1X1;
        }

        stack.getTagCompound().setInteger("mode", modeSwitch);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (player.isSneaking()) {
                selectBlock(stack, player, world, pos);
            } else {
                placeBlock(stack, player, world, pos, side);
            }
        }
        return EnumActionResult.SUCCESS;
    }

    private boolean isWhitelisted(World world, BlockPos pos) {
        for (String block : Config.blocksWhitelist) {
            if (world.getBlockState(pos).getBlock().getRegistryName().equals(new ResourceLocation(block))) {
                return true;
            }
        }
        return world.getBlockState(pos).getBlock().getRegistryName().getResourceDomain().equals("tconstruct");
    }

    @SuppressWarnings("deprecation")
    private void placeBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        Block block;
        int meta;
        int id = tagCompound.getInteger("block");
        block = Block.REGISTRY.getObjectById(id);
        meta = tagCompound.getInteger("meta");

        IBlockState oldState = world.getBlockState(pos);
        Block oldblock = oldState.getBlock();

        int oldmeta = oldblock.getMetaFromState(oldState);
        float blockHardness = oldblock.getBlockHardness(oldState, world, pos);
        if (id == 0) {
            return;
        }
        if ((block == oldblock) && (meta == oldmeta)) {
            return;
        }
        if (world.getTileEntity(pos) != null && !this.isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, StringHelper.localize("error.invalidblock.te"));
            return;
        }
        if (blockHardness < -0.1F) {
            if (!isCreative()) {
                ChatHelper.msgPlayer(player, StringHelper.localize("error.invalidblock.unbreakable"));
                return;
            }
        }
        if (isPowered() && stack.getTagCompound().getInteger("Energy") < getPerBlockUse()) {
            if (!isCreative()) {
                ChatHelper.msgPlayer(player, StringHelper.localize("error.nopower"));
                return;
            }
        }
        Set<BlockPos> coordinates = findSuitableBlocks(stack, world, side, pos, oldblock, oldmeta);
        boolean notEnough = false;
        for (BlockPos coordinate : coordinates) {
            if (consumeItemInInventory(Item.getItemFromBlock(block), meta, player.inventory, player)) {
                if (!player.capabilities.isCreativeMode && !isCreative()) {
                    ItemStack oldblockItem = oldblock.getItem(world, pos, oldState);
                    giveItem(world, player, pos, oldblockItem);
                    if (!isPowered() && !isCreative()) {
                        stack.damageItem(1, player);
                    } else if (stack.getTagCompound().getInteger("Energy") >= getPerBlockUse()) {
                        stack.getTagCompound().setInteger("Energy", stack.getTagCompound().getInteger("Energy") - getPerBlockUse());
                    }
                }
                world.playSound(null, coordinate.getX(), coordinate.getY(), coordinate.getZ(), SoundEvents.ENTITY_ENDERMEN_TELEPORT,
                        SoundCategory.BLOCKS, 0.1F, 1F);
                world.setBlockState(coordinate, block.getStateFromMeta(meta), 3);
                player.openContainer.detectAndSendChanges();
            }
            else {
                notEnough = true;
            }
        }
        if (notEnough) {
            ChatHelper.msgPlayer(player, StringHelper.localize("error.outofblock"));
        }
    }

    @SuppressWarnings("deprecation")
    private void selectBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        if (stackTagCompoundNull(stack))
            setDefaultTagCompound(stack);
        IBlockState state = world.getBlockState(pos).getBlock().getDefaultState();
        Block block = state.getBlock();
        int meta = block.getMetaFromState(state);
        NBTTagCompound tagCompound = getTagCompound(stack);
        String name = getBlockName(block, meta);
        float blockHardness = block.getBlockHardness(state, world, pos);
        if (name == null) {
            ChatHelper.msgPlayer(player, StringHelper.localize("error.invalidblock.null"));
        }
        if (world.getTileEntity(pos) != null && !this.isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, StringHelper.localize("error.invalidblock.te"));
            return;
        }
        if (blockHardness < -0.1F) {
            if (!isCreative()) {
                ChatHelper.msgPlayer(player, StringHelper.localize("error.invalidblock.unbreakable"));
            }
        }
        else {
            int id = Block.REGISTRY.getIDForObject(block);
            tagCompound.setInteger("block", id);
            tagCompound.setInteger("meta", meta);
        }
    }

    @SuppressWarnings("unchecked")
    protected static Set<BlockPos> findSuitableBlocks(ItemStack stack, World world, EnumFacing sideHit, BlockPos pos, Block centerBlock, int centerMeta) {
        Set<BlockPos> coordinates = new HashSet();
        int mode = stack.getTagCompound().getInteger("mode");
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        switch (sideHit) {
            case UP:
            case DOWN:
                for (int dx = x - mode; dx <= x + mode; dx++) {
                    for (int dz = z - mode; dz <= z + mode; dz++) {
                        checkAndAddBlock(world, dx, y, dz, centerBlock, centerMeta, coordinates);
                    }
                }
                break;
            case SOUTH:
            case NORTH:
                for (int dx = x - mode; dx <= x + mode; dx++) {
                    for (int dy = y - mode; dy <= y + mode; dy++) {
                        checkAndAddBlock(world, dx, dy, z, centerBlock, centerMeta, coordinates);
                    }
                }
                break;
            case EAST:
            case WEST:
                for (int dy = y - mode; dy <= y + mode; dy++) {
                    for (int dz = z - mode; dz <= z + mode; dz++) {
                        checkAndAddBlock(world, x, dy, dz, centerBlock, centerMeta, coordinates);
                    }
                }
        }
        return coordinates;
    }

    private static void checkAndAddBlock(World world, int x, int y, int z, Block centerBlock, int centerMeta, Set<BlockPos> coordinates) {
        BlockPos pos = new BlockPos(x, y, z);
        IBlockState state = world.getBlockState(pos);
        if ((state.getBlock() == centerBlock) && (state.getBlock().getMetaFromState(state) == centerMeta)) {
            coordinates.add(pos);
        }
    }

    private boolean consumeItemInInventory(Item item, int meta, InventoryPlayer inv, EntityPlayer player) {
        if (player.capabilities.isCreativeMode || isCreative()) {
            return true;
        }
        int i = findItem(item, meta, inv);
        if (i < 0) {
            return false;
        }
        ItemStack stackInSlot = inv.getStackInSlot(i);
        stackInSlot = StackUtil.incStackSize(stackInSlot, -1);
        if (StackUtil.getStackSize(stackInSlot) == 0) {
            inv.setInventorySlotContents(i, StackUtil.getEmptyStack());
        }
        return true;
    }

    private static int findItem(Item item, int meta, InventoryPlayer inv) {
        for (int i = 0; i < 36; i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if ((StackUtil.isValid(stack)) && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    private static void giveItem(World world, EntityPlayer player, BlockPos pos, ItemStack oldStack) {
        if (!player.inventory.addItemStackToInventory(oldStack)) {
            EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), oldStack);
            world.spawnEntityInWorld(entityItem);
        }
    }

    protected static NBTTagCompound getTagCompound(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    private static String getBlockName(Block block, int meta) {
        ItemStack stack = new ItemStack(block, 1, meta);
        return stack.getDisplayName();
    }

}
