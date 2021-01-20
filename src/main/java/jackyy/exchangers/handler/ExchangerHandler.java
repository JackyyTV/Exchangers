package jackyy.exchangers.handler;

import jackyy.exchangers.handler.mode.ModeHorizontalCol;
import jackyy.exchangers.handler.mode.ModePlane;
import jackyy.exchangers.handler.mode.ModeVerticalCol;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ChatHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ExchangerHandler {

    public static final String[] rangeList = new String[] {
            "1x1", "3x3", "5x5", "7x7", "9x9",
            "11x11", "13x13", "15x15", "17x17",
            "19x19", "21x21", "23x23", "25x25"
    };

    public static void setDefaultTagCompound(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            NBTTagCompound compound = new NBTTagCompound();
            stack.setTagCompound(compound);
        }
        Set<String> keySet = NBTHelper.getTag(stack).getKeySet();
        if (!keySet.contains("blockstate")) {
            NBTHelper.getTag(stack).setTag("blockstate", new NBTTagCompound());
            NBTUtil.writeBlockState(NBTHelper.getTag(stack).getCompoundTag("blockstate"), Blocks.AIR.getDefaultState());
        }
        if (!keySet.contains("mode")) {
            NBTHelper.getTag(stack).setInteger("mode", 0);
        }
        if (!keySet.contains("range")) {
            NBTHelper.getTag(stack).setInteger("range", 0);
        }
        if (!keySet.contains("forceDropItems")) {
            NBTHelper.getTag(stack).setBoolean("forceDropItems", false);
        }
        if (!keySet.contains("directionalPlacement")) {
            NBTHelper.getTag(stack).setBoolean("directionalPlacement", false);
        }
        if (!keySet.contains("fuzzyPlacement")) {
            NBTHelper.getTag(stack).setBoolean("fuzzyPlacement", false);
        }
        if (!keySet.contains("fuzzyPlacementChance")) {
            NBTHelper.getTag(stack).setInteger("fuzzyPlacementChance", 100);
        }
        if (!keySet.contains("voidItems")) {
            NBTHelper.getTag(stack).setBoolean("voidItems", false);
        }
    }

    private static int getExPerBlockUse(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getPerBlockUse();
    }

    private static int getPerBlockEnergy(ItemStack stack) {
        if (ModConfig.misc.unbreakingPoweredExchangers) {
            int level = MathHelper.clamp(EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, stack), 0, 10);
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

    public static void switchRange(ItemStack stack, boolean decrease) {
        setDefaultTagCompound(stack);
        int rangeSwitch = NBTHelper.getTag(stack).getInteger("range");
        if (decrease) {
            rangeSwitch--;
        } else {
            rangeSwitch++;
        }
        if (!stack.isEmpty()) {
            if (rangeSwitch > getExRange(stack)) {
                rangeSwitch = 0;
            } else if (rangeSwitch < 0) {
                rangeSwitch = getExRange(stack);
            }
        }
        NBTHelper.getTag(stack).setInteger("range", rangeSwitch);
    }

    public static void switchMode(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        int mode = NBTHelper.getTag(stack).getInteger("mode");
        if (player.isSneaking()) {
            mode--;
        } else {
            mode++;
        }
        if (!stack.isEmpty()) {
            if (mode > 2) {
                mode = 0;
            } else if (mode < 0) {
                mode = 2;
            }
        }
        NBTHelper.getTag(stack).setInteger("mode", mode);
        switch (mode) {
            case 0:
                ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", TextFormatting.GREEN + ModePlane.getDisplayName()));
                break;
            case 1:
                ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", TextFormatting.GREEN + ModeHorizontalCol.getDisplayName()));
                break;
            case 2:
                ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", TextFormatting.GREEN + ModeVerticalCol.getDisplayName()));
                break;
        }
    }

    public static void toggleForceDropItems(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("forceDropItems");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).setBoolean("forceDropItems", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.force_drop_items.on" : "msg.force_drop_items.off");
    }

    public static void toggleDirectionalPlacement(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("directionalPlacement");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).setBoolean("directionalPlacement", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.directional_placement.on" : "msg.directional_placement.off");
    }

    public static void toggleFuzzyPlacement(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("fuzzyPlacement");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).setBoolean("fuzzyPlacement", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.fuzzy_placement.on" : "msg.fuzzy_placement.off");
    }

    public static void setFuzzyPlacementChance(ItemStack stack, int chance) {
        setDefaultTagCompound(stack);
        int currentChance = NBTHelper.getTag(stack).getInteger("fuzzyPlacementChance");
        if (!stack.isEmpty()) {
            currentChance = chance;
        }
        NBTHelper.getTag(stack).setInteger("fuzzyPlacementChance", currentChance);
    }

    public static void toggleVoidItems(EntityPlayer player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("voidItems");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).setBoolean("voidItems", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.void_items.on" : "msg.void_items.off");
    }

    public static boolean isWhitelisted(World world, BlockPos pos) {
        for (String block : ModConfig.misc.blocksWhitelist) {
            if (world.getBlockState(pos).getBlock().getRegistryName().equals(new ResourceLocation(block))) {
                return true;
            }
        }
        return false;
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
        NBTTagCompound tag = NBTHelper.getTag(stack);
        IBlockState state = NBTUtil.readBlockState(tag.getCompoundTag("blockstate"));
        Block block = state.getBlock();
        IBlockState oldState = world.getBlockState(pos);
        Block oldblock = oldState.getBlock();
        float blockHardness = oldblock.getBlockHardness(oldState, world, pos);

        if (block == Blocks.AIR) {
            return;
        } else if ((block == oldblock) && (state == oldState)) {
            return;
        } else if (world.getTileEntity(pos) != null && !isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.te");
            return;
        } else if (isBlacklisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.blacklisted");
            return;
        } else if (!getExIsCreative(stack) && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.unbreakable");
            return;
        } else if (!getExIsCreative(stack) && getExIsPowered(stack) && NBTHelper.getTag(stack).getInteger("Energy") < getPerBlockEnergy(stack)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.out_of_power");
            return;
        } else if (!getExIsCreative(stack) && getExHarvestLevel(stack) < oldblock.getHarvestLevel(oldState)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.low_harvest_level");
            return;
        }

        Set<BlockPos> suitableBlocks = findSuitableBlocks(stack, world, player, side, pos, oldState);
        Set<BlockPos> toBePlaced = new HashSet<>();
        boolean notEnough = false;
        world.captureBlockSnapshots = false;

        for (BlockPos blockPos : suitableBlocks) {
            if (tag.getBoolean("fuzzyPlacement")) {
                if (new Random().nextInt(100) < tag.getInteger("fuzzyPlacementChance")) {
                    toBePlaced.add(blockPos);
                }
            } else {
                toBePlaced = suitableBlocks;
            }
        }

        for (BlockPos coordinate : toBePlaced) {
            BlockEvent.PlaceEvent event = new BlockEvent.PlaceEvent(BlockSnapshot.getBlockSnapshot(world, coordinate, 3), Blocks.AIR.getDefaultState(), player, player.getActiveHand());
            if (!tag.getBoolean("directionalPlacement")) {
                world.setBlockState(coordinate, state, 3);
            }
            if (tag.getBoolean("directionalPlacement")) {
                Vec3d vec = player.getLookVec();
                IBlockState placeState = block.getStateForPlacement(world, pos, side, ((float) vec.x), ((float) vec.y), ((float) vec.z), block.getItem(world, pos, state).getMetadata(), player, player.getActiveHand());
                world.setBlockState(coordinate, placeState, 3);
            }
            if (!MinecraftForge.EVENT_BUS.post(event)) {
                if (consumeItemInInventory(Item.getItemFromBlock(block), block.getItem(world, pos, state).getMetadata(), player.inventory, player)) {
                    if (!player.capabilities.isCreativeMode && !getExIsCreative(stack) && !tag.getBoolean("voidItems")) {
                        if (ModConfig.misc.doExchangersSilkTouch || EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
                            ItemStack oldblockItem;
                            if (oldblock.canSilkHarvest(world, pos, oldState, player) && !(oldblock instanceof IShearable)) {
                                oldblockItem = getSilkTouchDrop(oldState);
                            } else {
                                oldblockItem = oldblock.getPickBlock(oldState, null, world, pos, player);
                            }
                            if (oldblockItem.getItem().equals(Items.AIR)) {
                                oldblockItem = oldblock.getPickBlock(oldState, null, world, pos, player);
                            }
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
                        } else if (tag.getInteger("Energy") >= getPerBlockEnergy(stack)) {
                            tag.setInteger("Energy", tag.getInteger("Energy") - getPerBlockEnergy(stack));
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
                ChatHelper.msgPlayer(player, Reference.MODID, "error.event_cancelled");
            }
        }
        if (notEnough) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.out_of_block");
        }
        world.captureBlockSnapshots = true;
    }

    @SuppressWarnings("deprecation")
    public static void selectBlock(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        setDefaultTagCompound(stack);
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        float blockHardness = block.getBlockHardness(state, world, pos);
        if (world.getTileEntity(pos) != null && !isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.te");
            return;
        } else if (isBlacklisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.blacklisted");
            return;
        } else if (!getExIsCreative(stack) && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.unbreakable");
            return;
        }
        NBTUtil.writeBlockState(NBTHelper.getTag(stack).getCompoundTag("blockstate"), state);
    }

    public static Set<BlockPos> findSuitableBlocks(ItemStack stack, World world, EntityPlayer player, EnumFacing sideHit, BlockPos pos, IBlockState centerState) {
        Set<BlockPos> coordinates = new HashSet<>();
        int range = NBTHelper.getTag(stack).getInteger("range");
        int mode = NBTHelper.getTag(stack).getInteger("mode");

        switch (mode) {
            case 0:
                ModePlane.invoke(coordinates, range, world, sideHit, pos, centerState);
                break;
            case 1:
                ModeHorizontalCol.invoke(coordinates, range, world, player, sideHit, pos, centerState);
                break;
            case 2:
                ModeVerticalCol.invoke(coordinates, range, world, player, sideHit, pos, centerState);
                break;
        }

        return coordinates;
    }

    public static void checkAndAddBlock(World world, BlockPos pos, IBlockState centerState, Set<BlockPos> coordinates) {
        IBlockState state = world.getBlockState(pos);
        if (state == centerState)
            coordinates.add(pos);
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
            return !extracted.isEmpty();
        } else {
            playerInv.decrStackSize(i, 1);
        }
        return true;
    }

    private static int findItem(Item item, int meta, IInventory inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    private static int findItemInContainer(Item item, int meta, IItemHandler inv) {
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    private static IItemHandler findItemHolder(IInventory inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && stack.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null) && !stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
                return stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            }
        }
        return null;
    }

    private static ItemStack getSilkTouchDrop(IBlockState state) {
        Block block = state.getBlock();
        Item item = Item.getItemFromBlock(block);
        int i = 0;
        if (item.getHasSubtypes()) {
            i = block.getMetaFromState(state);
        }
        return new ItemStack(item, 1, i);
    }

    private static void giveItem(World world, EntityPlayer player, ItemStack oldStack) {
        EntityItem entityItem = new EntityItem(world, player.posX, player.posY, player.posZ, oldStack);
        if (NBTHelper.getTag(player.getHeldItemMainhand()).getBoolean("forceDropItems")) {
            world.spawnEntity(entityItem);
        } else {
            if (!player.inventory.addItemStackToInventory(oldStack)) {
                world.spawnEntity(entityItem);
            }
        }
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
