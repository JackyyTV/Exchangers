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
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.world.BlockEvent;

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
            CompoundNBT compound = new CompoundNBT();
            stack.setTag(compound);
        }
        Set<String> keySet = NBTHelper.getTag(stack).keySet();
        if (!keySet.contains("blockstate")) {
            NBTHelper.getTag(stack).put("blockstate", NBTUtil.writeBlockState(Blocks.AIR.getDefaultState()));
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
            int level = MathHelper.clamp(EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, stack), 0, 10);
            if (new Random().nextInt(2 + level) >= 2) {
                return 0;
            }
        }
        return getExPerBlockUse(stack);
    }

    public static int getExHarvestLevel(ItemStack stack) {
        return ((ItemExchangerBase) stack.getItem()).getHarvestLevel();
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

    public static void switchMode(PlayerEntity player, ItemStack stack) {
        setDefaultTagCompound(stack);
        int mode = NBTHelper.getTag(stack).getInt("mode");
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
        NBTHelper.getTag(stack).putInt("mode", mode);
        switch (mode) {
            case 0:
                ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", ModePlane.getDisplayName().mergeStyle(TextFormatting.GREEN)));
                break;
            case 1:
                ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", ModeHorizontalCol.getDisplayName().mergeStyle(TextFormatting.GREEN)));
                break;
            case 2:
                ChatHelper.msgPlayerRaw(player, StringHelper.localize(Reference.MODID, "msg.mode", ModeVerticalCol.getDisplayName().mergeStyle(TextFormatting.GREEN)));
                break;
        }
    }

    public static void toggleForceDropItems(PlayerEntity player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("forceDropItems");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("forceDropItems", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.force_drop_items.on" : "msg.force_drop_items.off");
    }

    public static void toggleDirectionalPlacement(PlayerEntity player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("directionalPlacement");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("directionalPlacement", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.directional_placement.on" : "msg.directional_placement.off");
    }

    public static void toggleFuzzyPlacement(PlayerEntity player, ItemStack stack) {
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

    public static void toggleVoidItems(PlayerEntity player, ItemStack stack) {
        setDefaultTagCompound(stack);
        boolean toggle = NBTHelper.getTag(stack).getBoolean("voidItems");
        if (!stack.isEmpty()) {
            toggle = !toggle;
        }
        NBTHelper.getTag(stack).putBoolean("voidItems", toggle);
        ChatHelper.msgPlayer(player, Reference.MODID, toggle ? "msg.void_items.on" : "msg.void_items.off");
    }

    public static boolean isWhitelisted(World world, BlockPos pos) {
        for (String block : ModConfigs.CONFIG.blocksWhitelist.get().trim().split(";")) {
            if (world.getBlockState(pos).getBlock().getRegistryName().equals(new ResourceLocation(block))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlacklisted(World world, BlockPos pos) {
        for (String block : ModConfigs.CONFIG.blocksBlacklist.get().trim().split(";")) {
            if (world.getBlockState(pos).getBlock().getRegistryName().equals(new ResourceLocation(block))) {
                return true;
            }
        }
        return false;
    }

    public static void placeBlock(ItemStack stack, PlayerEntity player, World world, BlockPos pos, Direction side, ItemUseContext context) {
        CompoundNBT tag = NBTHelper.getTag(stack);
        BlockState state = NBTUtil.readBlockState(tag.getCompound("blockstate"));
        Block block = state.getBlock();
        BlockState oldState = world.getBlockState(pos);
        Block oldblock = oldState.getBlock();
        float blockHardness = oldState.getBlockHardness(world, pos);

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
        } else if (!getExIsCreative(stack) && getExIsPowered(stack) && NBTHelper.getTag(stack).getInt(EnergyHelper.ENERGY_NBT) < getPerBlockEnergy(stack)) {
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
                if (new Random().nextInt(100) < tag.getInt("fuzzyPlacementChance")) {
                    toBePlaced.add(blockPos);
                }
            } else {
                toBePlaced = suitableBlocks;
            }
        }

        for (BlockPos coordinate : toBePlaced) {
            BlockEvent.EntityPlaceEvent event = new BlockEvent.EntityPlaceEvent(BlockSnapshot.create(world.getDimensionKey(), world, coordinate, 3), Blocks.AIR.getDefaultState(), player);
            if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                state = state.with(BlockStateProperties.WATERLOGGED, false);
            }
            if (!tag.getBoolean("directionalPlacement")) {
                world.setBlockState(coordinate, state, 3);
            }
            if (tag.getBoolean("directionalPlacement")) {
                BlockState placeState = block.getStateForPlacement(new BlockItemUseContext(context));
                if (placeState != null) {
                    world.setBlockState(coordinate, placeState, 3);
                } else {
                    world.setBlockState(coordinate, state, 3);
                }
            }
            if (!MinecraftForge.EVENT_BUS.post(event)) {
                if (ItemHandler.consumeItemInInventory(block.asItem(), player.inventory, player)) {
                    if (!player.isCreative()&& !getExIsCreative(stack) && !tag.getBoolean("voidItems")) {
                        if (ModConfigs.CONFIG.doExchangersSilkTouch.get() || EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
                            ItemStack oldblockItem;
                            if (!(oldblock instanceof IForgeShearable)) {
                                oldblockItem = ItemHandler.getSilkTouchDrop(oldState);
                            } else {
                                oldblockItem = oldblock.getPickBlock(oldState, null, world, pos, player);
                            }
                            if (oldblockItem.getItem().equals(Items.AIR)) {
                                oldblockItem = oldblock.getPickBlock(oldState, null, world, pos, player);
                            }
                            ItemHandler.giveItem(world, player, oldblockItem);
                        } else {
                            ServerWorld serverWorld = (ServerWorld) world;
                            ToolType harvestTool = oldState.getHarvestTool();
                            ItemStack tool;
                            if (harvestTool == ToolType.PICKAXE) {
                                tool = new ItemStack(Items.NETHERITE_PICKAXE);
                            } else if (harvestTool == ToolType.AXE) {
                                tool = new ItemStack(Items.NETHERITE_AXE);
                            } else if (harvestTool == ToolType.SHOVEL) {
                                tool = new ItemStack(Items.NETHERITE_SHOVEL);
                            } else {
                                tool = new ItemStack(Items.STICK);
                            }
                            int fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
                            tool.addEnchantment(Enchantments.FORTUNE, fortuneLevel);
                            LootContext.Builder builder = new LootContext.Builder(serverWorld).withRandom(serverWorld.rand)
                                    .withParameter(LootParameters.ORIGIN, Vector3d.copyCentered(pos))
                                    .withParameter(LootParameters.TOOL, tool);
                            List<ItemStack> oldblockItems = oldState.getDrops(builder);
                            for (ItemStack oldblockItem : oldblockItems) {
                                ItemHandler.giveItem(world, player, oldblockItem);
                            }
                        }
                        if (!getExIsPowered(stack)) {
                            stack.damageItem(1, player, (entity) -> entity.sendBreakAnimation(EquipmentSlotType.MAINHAND));
                        } else if (tag.getInt(EnergyHelper.ENERGY_NBT) >= getPerBlockEnergy(stack)) {
                            tag.putInt(EnergyHelper.ENERGY_NBT, tag.getInt(EnergyHelper.ENERGY_NBT) - getPerBlockEnergy(stack));
                        }
                        player.openContainer.detectAndSendChanges();
                    }
                    world.playSound(null, coordinate.getX(), coordinate.getY(), coordinate.getZ(),
                            SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 0.1F, 1F);
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

    public static void selectBlock(ItemStack stack, PlayerEntity player, World world, BlockPos pos) {
        setDefaultTagCompound(stack);
        BlockState state = world.getBlockState(pos);
        float blockHardness = state.getBlockHardness(world, pos);
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
        NBTHelper.getTag(stack).put("blockstate", NBTUtil.writeBlockState(state));
    }

    public static Set<BlockPos> findSuitableBlocks(ItemStack stack, World world, PlayerEntity player, Direction sideHit, BlockPos pos, BlockState centerState) {
        Set<BlockPos> coordinates = new HashSet<>();
        int range = NBTHelper.getTag(stack).getInt("range");
        int mode = NBTHelper.getTag(stack).getInt("mode");

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

    public static void checkAndAddBlock(World world, BlockPos pos, BlockState centerState, Set<BlockPos> coordinates) {
        BlockState state = world.getBlockState(pos);
        if (state == centerState)
            coordinates.add(pos);
    }

    public static IFormattableTextComponent getBlockName(Block block) {
        ItemStack stack = new ItemStack(block, 1);
        IFormattableTextComponent name;
        try {
            name = stack.getDisplayName().copyRaw();
            return name;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new StringTextComponent("Unable to fetch block name.");
    }

}
