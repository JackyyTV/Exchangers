package jackyy.exchangers.handler;

import jackyy.exchangers.Config;
import jackyy.exchangers.client.Keys;
import jackyy.exchangers.helper.ChatHelper;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.util.IExchanger;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.world.BlockEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ExchangerHandler extends Item implements IExchanger {

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
        if (stack.getTagCompound() == null) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("block", "minecraft:air");
            compound.setInteger("meta", 0);
            compound.setInteger("mode", 0);
            stack.setTagCompound(compound);
        } else {
            if (stack.getTagCompound().hasKey("Energy") && !stack.getTagCompound().hasKey("mode")) {
                stack.getTagCompound().setString("block", "minecraft:air");
                stack.getTagCompound().setInteger("meta", 0);
                stack.getTagCompound().setInteger("mode", 0);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.getShiftText());
        }

        setDefaultTagCompound(stack);

        NBTTagCompound compound = stack.getTagCompound();
        String id = compound.getString("block");

        if (StringHelper.isShiftKeyDown()) {
            if (id.equals("minecraft:air")) {
                tooltip.add(StringHelper.localize("tooltip.no_selected_block"));
                tooltip.add(StringHelper.localize("tooltip.current_range") + " " + modeSwitchList[compound.getInteger("mode")]);
                tooltip.add(StringHelper.localize("tooltip.max_range") + " " + modeSwitchList[getMaxRange()]);
            } else {
                Block block = Block.getBlockFromName(id);
                int meta = compound.getInteger("meta");
                tooltip.add(StringHelper.localize("tooltip.selected_block") + " " + getBlockName(block, meta));
                tooltip.add(StringHelper.localize("tooltip.current_range") + " " + modeSwitchList[compound.getInteger("mode")]);
                tooltip.add(StringHelper.localize("tooltip.max_range") + " " + modeSwitchList[getMaxRange()]);
            }
            if (Config.doExchangersSilkTouch) {
                tooltip.add(StringHelper.localize("tooltip.silk_touch.on"));
            } else {
                tooltip.add(StringHelper.localize("tooltip.silk_touch.off"));
            }
            tooltip.add(StringHelper.localize("tooltip.shift1"));
            tooltip.add(StringHelper.localize("tooltip.shift2"));
            tooltip.add(StringHelper.localize("tooltip.shift3") + " " + "(" + TextFormatting.GREEN + Keys.MODE_KEY.getDisplayName() + TextFormatting.GRAY + ")");
            tooltip.add(StringHelper.getTierText(getTier()));
        }
    }

    private int getPerBlockEnergy(ItemStack stack) {
        if (Config.unbreakingPoweredExchangers) {
            int level = MathHelper.clamp_int(EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, stack), 0, 10);
            if (new Random().nextInt(2 + level) >= 2) {
                return 0;
            }
        }
        return this.getPerBlockUse();
    }

    public void switchMode(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);

        int modeSwitch = stack.getTagCompound().getInteger("mode");

        if (player.isSneaking()) {
            modeSwitch--;
        } else {
            modeSwitch++;
        }

        ItemStack heldItem = player.getHeldItemMainhand();

        if (heldItem != null) {
            if (modeSwitch > getMaxRange()) {
                modeSwitch = MODE_1X1;
            } else if (modeSwitch < MODE_1X1) {
                modeSwitch = getMaxRange();
            }
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

    private boolean isSpecial(Block block) {
        return block instanceof BlockLog
                || block instanceof BlockRedstoneOre
                || block instanceof BlockTrapDoor
                || block instanceof BlockDoor
                || block instanceof BlockFenceGate
                || block instanceof BlockRedstoneLight;
    }

    @SuppressWarnings("deprecation")
    private void placeBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        Block block;
        int meta;
        String id = tagCompound.getString("block");
        block = Block.getBlockFromName(id);
        meta = tagCompound.getInteger("meta");

        IBlockState oldState = world.getBlockState(pos);
        Block oldblock = oldState.getBlock();

        int oldmeta = oldblock.getMetaFromState(oldState);
        float blockHardness = oldblock.getBlockHardness(oldState, world, pos);
        if (id.equals("minecraft:air")) {
            return;
        } else if ((block == oldblock) && (meta == oldmeta)) {
            return;
        } else if (world.getTileEntity(pos) != null && !this.isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, "error.invalid_block.te");
            return;
        } else if (!isCreative() && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, "error.invalid_block.unbreakable");
            return;
        } else if (!isCreative() && isPowered() && stack.getTagCompound().getInteger("Energy") < getPerBlockEnergy(stack)) {
            ChatHelper.msgPlayer(player, "error.out_of_power");
            return;
        }
        Set<BlockPos> coordinates = findSuitableBlocks(stack, world, side, pos, oldblock, oldmeta);
        boolean notEnough = false;
        world.captureBlockSnapshots = false;
        for (BlockPos coordinate : coordinates) {
            BlockEvent.PlaceEvent event = new BlockEvent.PlaceEvent(BlockSnapshot.getBlockSnapshot(world, coordinate, 3), Blocks.AIR.getDefaultState(), player, player.getActiveHand());
            world.setBlockState(coordinate, block.getStateFromMeta(meta), 3);
            if (!MinecraftForge.EVENT_BUS.post(event)) {
                if (consumeItemInInventory(Item.getItemFromBlock(block), meta, player.inventory, player)) {
                    if (!player.capabilities.isCreativeMode && !isCreative()) {
                        if (Config.doExchangersSilkTouch || EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
                            ItemStack oldblockItem = oldblock.getItem(world, pos, oldState);
                            giveItem(world, player, pos, oldblockItem);
                        } else {
                            int fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
                            List<ItemStack> oldblockItems = oldblock.getDrops(world, pos, oldState, fortuneLevel);
                            for (ItemStack oldblockItem : oldblockItems) {
                                giveItem(world, player, pos, oldblockItem);
                            }
                        }
                        if (!isPowered()) {
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
    private void selectBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        setDefaultTagCompound(stack);
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        int meta;
        if (isSpecial(block)) {
            meta = block.getDefaultState().getBlock().getMetaFromState(block.getDefaultState());
        } else {
            meta = block.getMetaFromState(state);
        }
        NBTTagCompound tagCompound = getTagCompound(stack);
        String name = getBlockName(block, meta);
        float blockHardness = block.getBlockHardness(state, world, pos);
        if (name == null) {
            ChatHelper.msgPlayer(player, "error.invalid_block.null");
            return;
        } else if (world.getTileEntity(pos) != null && !this.isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, "error.invalid_block.te");
            return;
        } else if (!isCreative() && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, "error.invalid_block.unbreakable");
            return;
        }
        String id = Block.REGISTRY.getNameForObject(block).toString();
        tagCompound.setString("block", id);
        tagCompound.setInteger("meta", meta);
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
        if (stackInSlot != null) {
            stackInSlot.stackSize--;
            if (stackInSlot.stackSize == 0) {
                inv.setInventorySlotContents(i, null);
            }
        }
        return true;
    }

    private static int findItem(Item item, int meta, InventoryPlayer inv) {
        for (int i = 0; i < 36; i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack != null && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
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
