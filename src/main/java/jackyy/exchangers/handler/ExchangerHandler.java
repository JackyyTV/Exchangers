package jackyy.exchangers.handler;

import jackyy.exchangers.handler.mode.ModeHorizontalCol;
import jackyy.exchangers.handler.mode.ModePlane;
import jackyy.exchangers.handler.mode.ModeVerticalCol;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ChatHelper;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.level.BlockEvent;

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
        if (!stack.hasTag()) {
            CompoundTag compound = new CompoundTag();
            stack.setTag(compound);
        }
        Set<String> keySet = NBTHelper.getTag(stack).getAllKeys();
        if (!keySet.contains("blockstate")) {
            NBTHelper.getTag(stack).put("blockstate", NbtUtils.writeBlockState(Blocks.AIR.defaultBlockState()));
        }
        if (!keySet.contains("mode")) {
            NBTHelper.getTag(stack).putInt("mode", 0);
        }
        if (!keySet.contains("range")) {
            NBTHelper.getTag(stack).putInt("range", 0);
        }
        if (!keySet.contains("forceDropItems")) {
            NBTHelper.getTag(stack).putBoolean("forceDropItems", false);
        }
        if (!keySet.contains("directionalPlacement")) {
            NBTHelper.getTag(stack).putBoolean("directionalPlacement", false);
        }
        if (!keySet.contains("fuzzyPlacement")) {
            NBTHelper.getTag(stack).putBoolean("fuzzyPlacement", false);
        }
        if (!keySet.contains("fuzzyPlacementChance")) {
            NBTHelper.getTag(stack).putInt("fuzzyPlacementChance", 100);
        }
        if (!keySet.contains("voidItems")) {
            NBTHelper.getTag(stack).putBoolean("voidItems", false);
        }
    }

    public static int getExPerBlockUse(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getPerBlockUse();
    }

    public static int getPerBlockEnergy(ItemStack stack) {
        if (ModConfigs.CONFIG.unbreakingPoweredExchangers.get()) {
            int level = Mth.clamp(stack.getEnchantmentLevel(Enchantments.UNBREAKING), 0, 10);
            if (new Random().nextInt(2 + level) >= 2) {
                return 0;
            }
        }
        return getExPerBlockUse(stack);
    }

    public static Tier getExHarvestLevel(ItemStack stack) {
        ItemExchangerBase exchanger = ((ItemExchangerBase) stack.getItem());
        Tier tier = TierSortingRegistry.byName(new ResourceLocation(exchanger.getHarvestLevel()));
        Tier defaultTier = TierSortingRegistry.byName(new ResourceLocation(exchanger.getDefaultHarvestLevel()));
        return tier == null ? defaultTier : tier;
    }

    public static int getExRange(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getMaxRange();
    }

    public static boolean getExIsCreative(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).isCreative();
    }

    public static boolean getExIsPowered(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).isPowered();
    }

    public static void switchRange(ItemStack stack, boolean decrease) {
        setDefaultTagCompound(stack);
        int rangeSwitch = NBTHelper.getTag(stack).getInt("range");
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
        NBTHelper.getTag(stack).putInt("range", rangeSwitch);
    }

    public static void switchMode(Player player, ItemStack stack) {
        setDefaultTagCompound(stack);
        int mode = NBTHelper.getTag(stack).getInt("mode");
        if (player.isShiftKeyDown()) {
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
        NBTHelper.getTag(stack).putInt("mode", mode);
        switch (mode) {
            case 0 ->
                    ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", ModePlane.getDisplayName().withStyle(ChatFormatting.GREEN)));
            case 1 ->
                    ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", ModeHorizontalCol.getDisplayName().withStyle(ChatFormatting.GREEN)));
            case 2 ->
                    ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", ModeVerticalCol.getDisplayName().withStyle(ChatFormatting.GREEN)));
        }
    }

    public static void toggleForceDropItems(Player player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("forceDropItems");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("forceDropItems", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.force_drop_items.on" : "msg.force_drop_items.off");
    }

    public static void toggleDirectionalPlacement(Player player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("directionalPlacement");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("directionalPlacement", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.directional_placement.on" : "msg.directional_placement.off");
    }

    public static void toggleFuzzyPlacement(Player player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("fuzzyPlacement");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("fuzzyPlacement", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.fuzzy_placement.on" : "msg.fuzzy_placement.off");
    }

    public static void setFuzzyPlacementChance(ItemStack stack, int chance) {
        setDefaultTagCompound(stack);
        int currentChance = NBTHelper.getTag(stack).getInt("fuzzyPlacementChance");
        if (!stack.isEmpty()) {
            currentChance = chance;
        }
        NBTHelper.getTag(stack).putInt("fuzzyPlacementChance", currentChance);
    }

    public static void toggleVoidItems(Player player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("voidItems");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("voidItems", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.void_items.on" : "msg.void_items.off");
    }

    public static boolean isWhitelisted(Level world, BlockPos pos) {
        for (String block : ModConfigs.CONFIG.blocksWhitelist.get().trim().split(";")) {
            if (world.getBlockState(pos).getBlockHolder().is(new ResourceLocation(block))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlacklisted(Level world, BlockPos pos) {
        for (String block : ModConfigs.CONFIG.blocksBlacklist.get().trim().split(";")) {
            if (world.getBlockState(pos).getBlockHolder().is(new ResourceLocation(block))) {
                return true;
            }
        }
        return false;
    }

    public static void placeBlock(ItemStack stack, Player player, Level world, BlockPos pos, Direction side, UseOnContext context) {
        CompoundTag tag = NBTHelper.getTag(stack);
        BlockState state = NbtUtils.readBlockState(world.holderLookup(Registries.BLOCK), tag.getCompound("blockstate"));
        Block block = state.getBlock();
        BlockState oldState = world.getBlockState(pos);
        Block oldblock = oldState.getBlock();
        float blockHardness = oldState.getDestroySpeed(world, pos);

        if (block == Blocks.AIR) {
            return;
        } else if ((block == oldblock) && (state == oldState)) {
            return;
        } else if (world.getBlockEntity(pos) != null && !isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.te");
            return;
        } else if (isBlacklisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.blacklisted");
            return;
        } else if (!getExIsCreative(stack)) {
            if (blockHardness < -0.1F) {
                ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.unbreakable");
                return;
            } else if (getExIsPowered(stack) && NBTHelper.getTag(stack).getInt(EnergyHelper.ENERGY_NBT) < getPerBlockEnergy(stack)) {
                ChatHelper.msgPlayer(player, Reference.MODID, "error.out_of_power");
                return;
            } else if (!TierSortingRegistry.isCorrectTierForDrops(getExHarvestLevel(stack), oldState)) {
                ChatHelper.msgPlayer(player, Reference.MODID, "error.low_harvest_level");
                return;
            }
        }

        Set<BlockPos> suitableBlocks = findSuitableBlocks(stack, world, player, side, pos, oldState);
        Set<BlockPos> toBePlaced = new HashSet<>();
        boolean notEnough = false;
        world.captureBlockSnapshots = false;

        for (BlockPos blockPos : suitableBlocks) {
            if (tag.getBoolean("fuzzyPlacement")) {
                if (new Random().nextInt(100) < tag.getInt("fuzzyPlacementChance")) {
                    toBePlaced.add(blockPos);
                }
            } else {
                toBePlaced = suitableBlocks;
            }
        }

        for (BlockPos coordinate : toBePlaced) {
            BlockEvent.EntityPlaceEvent event = new BlockEvent.EntityPlaceEvent(BlockSnapshot.create(world.dimension(), world, coordinate, 3), Blocks.AIR.defaultBlockState(), player);
            if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, false);
            }
            if (!tag.getBoolean("directionalPlacement")) {
                world.setBlock(coordinate, state, 3);
            }
            if (tag.getBoolean("directionalPlacement")) {
                BlockState placeState = block.getStateForPlacement(new BlockPlaceContext(context));
                if (placeState != null) {
                    world.setBlock(coordinate, placeState, 3);
                } else {
                    world.setBlock(coordinate, state, 3);
                }
            }
            if (!MinecraftForge.EVENT_BUS.post(event)) {
                if (ItemHandler.consumeItemInInventory(block.asItem(), player.getInventory(), player)) {
                    if (!player.isCreative()&& !getExIsCreative(stack) && !tag.getBoolean("voidItems")) {
                        if (ModConfigs.CONFIG.doExchangersSilkTouch.get() || stack.getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0) {
                            ItemStack oldblockItem;
                            if (!(oldblock instanceof IForgeShearable)) {
                                oldblockItem = ItemHandler.getSilkTouchDrop(oldState);
                            } else {
                                oldblockItem = oldblock.getCloneItemStack(oldState, null, world, pos, player);
                            }
                            if (oldblockItem.getItem().equals(Items.AIR)) {
                                oldblockItem = oldblock.getCloneItemStack(oldState, null, world, pos, player);
                            }
                            ItemHandler.giveItem(world, player, oldblockItem);
                        } else {
                            ServerLevel serverWorld = (ServerLevel) world;
                            ItemStack tool;
                            if (oldState.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
                                tool = new ItemStack(Items.NETHERITE_PICKAXE);
                            } else if (oldState.is(BlockTags.MINEABLE_WITH_AXE)) {
                                tool = new ItemStack(Items.NETHERITE_AXE);
                            } else if (oldState.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                                tool = new ItemStack(Items.NETHERITE_SHOVEL);
                            } else {
                                tool = new ItemStack(Items.STICK);
                            }
                            int fortuneLevel = stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE);
                            tool.enchant(Enchantments.BLOCK_FORTUNE, fortuneLevel);
                            LootContext.Builder builder = new LootContext.Builder(serverWorld).withRandom(serverWorld.random)
                                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                                    .withParameter(LootContextParams.TOOL, tool);
                            List<ItemStack> oldblockItems = oldState.getDrops(builder);
                            for (ItemStack oldblockItem : oldblockItems) {
                                ItemHandler.giveItem(world, player, oldblockItem);
                            }
                        }
                        if (!getExIsPowered(stack)) {
                            stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                        } else if (tag.getInt(EnergyHelper.ENERGY_NBT) >= getPerBlockEnergy(stack)) {
                            tag.putInt(EnergyHelper.ENERGY_NBT, tag.getInt(EnergyHelper.ENERGY_NBT) - getPerBlockEnergy(stack));
                        }
                        player.containerMenu.broadcastChanges();
                    }
                    world.playSound(null, coordinate.getX(), coordinate.getY(), coordinate.getZ(),
                            SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 0.1F, 1F);
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

    public static void selectBlock(ItemStack stack, Player player, Level world, BlockPos pos) {
        setDefaultTagCompound(stack);
        BlockState state = world.getBlockState(pos);
        float blockHardness = state.getDestroySpeed(world, pos);
        if (world.getBlockEntity(pos) != null && !isWhitelisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.te");
            return;
        } else if (isBlacklisted(world, pos)) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.blacklisted");
            return;
        } else if (!getExIsCreative(stack) && blockHardness < -0.1F) {
            ChatHelper.msgPlayer(player, Reference.MODID, "error.invalid_block.unbreakable");
            return;
        }
        NBTHelper.getTag(stack).put("blockstate", NbtUtils.writeBlockState(state));
    }

    public static Set<BlockPos> findSuitableBlocks(ItemStack stack, Level world, Player player, Direction sideHit, BlockPos pos, BlockState centerState) {
        Set<BlockPos> coordinates = new HashSet<>();
        int range = NBTHelper.getTag(stack).getInt("range");
        int mode = NBTHelper.getTag(stack).getInt("mode");

        switch (mode) {
            case 0 -> ModePlane.invoke(coordinates, range, world, sideHit, pos, centerState);
            case 1 -> ModeHorizontalCol.invoke(coordinates, range, world, player, sideHit, pos, centerState);
            case 2 -> ModeVerticalCol.invoke(coordinates, range, world, player, sideHit, pos, centerState);
        }

        return coordinates;
    }

    public static void checkAndAddBlock(Level world, BlockPos pos, BlockState centerState, Set<BlockPos> coordinates) {
        BlockState state = world.getBlockState(pos);
        if (state == centerState)
            coordinates.add(pos);
    }

    public static MutableComponent getBlockName(Block block) {
        ItemStack stack = new ItemStack(block, 1);
        MutableComponent name;
        try {
            name = stack.getDisplayName().plainCopy();
            return name;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return Component.literal("Unable to fetch block name.");
    }

}
