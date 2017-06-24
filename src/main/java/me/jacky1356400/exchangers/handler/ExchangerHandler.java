package me.jacky1356400.exchangers.handler;

import static me.jacky1356400.exchangers.handler.WorldEventHandler.queueExchanges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.jacky1356400.exchangers.client.Keys;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchanger;
import me.jacky1356400.exchangers.item.ItemPoweredExchanger;
import me.jacky1356400.exchangers.util.Data;
import me.jacky1356400.exchangers.util.Tier;
import me.jacky1356400.exchangers.helper.DirectionHelper;
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
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fluids.BlockFluidBase;

public abstract class ExchangerHandler extends Item {

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
		stack.getTagCompound().setInteger("state", 0);
		stack.getTagCompound().setInteger("ExchangeMode", 0);
	}

	public static boolean stackTagCompoundNull(ItemStack stack) {
		return stack.getTagCompound() == null;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
			tooltip.add(StringHelper.getShiftText());
		}
		if (!StringHelper.isShiftKeyDown()) {
			return;
		}

		if (stackTagCompoundNull(stack))
			setDefaultTagCompound(stack);
		NBTTagCompound compound = stack.getTagCompound();

		if (compound == null || compound.getInteger("state") == 0) {
			tooltip.add(StringHelper.localize("tooltip.noselectedblock"));
		} else {

			int stateID = compound.getInteger("state");

			tooltip.add(StringHelper.localize("tooltip.selectedblock") + " "
					+ new ItemStack(Block.getStateById(stateID).getBlock(), 1, stateID >> 12 & 15).getDisplayName());
			tooltip.add(StringHelper.localize("tooltip.selectedmode") + " "
					+ modeSwitchList[compound.getInteger("ExchangeMode")]);
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

		if (!heldItem.isEmpty() && stack.getItem() instanceof ItemExchanger) {
			ItemExchanger k = (ItemExchanger) stack.getItem();
			if (modeSwitch > k.getTier().getMaxSize())
				modeSwitch = MODE_1X1;
		}

		stack.getTagCompound().setInteger("ExchangeMode", modeSwitch);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return EnumActionResult.SUCCESS;
		ItemStack stack = player.getHeldItem(hand);

		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();

		if (player.isSneaking()) {

			if (blockSuitableForSelection(player, world, pos)) {
				setSelectedBlock(stack, block, state);
				return EnumActionResult.SUCCESS;
			} else {
				player.sendMessage(new TextComponentTranslation(Data.MODID + ".error.invalidblock"));
				return EnumActionResult.FAIL;
			}
		} else {
			if (blockSuitableForExchange(stack, player, world, pos)
					&& exchangeBlocks(stack, player, world, pos, facing))
				return EnumActionResult.SUCCESS;
			return EnumActionResult.FAIL;
		}
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
		Block block = world.getBlockState(pos).getBlock();

		return (world.getTileEntity(pos) == null && !world.isAirBlock(pos) && !blacklistedBlocks.contains(block)
				&& !softBlocks.contains(block) && !specialBlocks.contains(block)
				&& !(creativeBlocks.contains(block) && !player.capabilities.isCreativeMode));
	}

	public static void setSelectedBlock(ItemStack stack, Block block, IBlockState state) {
		if (stackTagCompoundNull(stack))
			setDefaultTagCompound(stack);
		stack.getTagCompound().setInteger("state", Block.getStateId(state));
	}

	public static boolean blockSuitableForExchange(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
		int newMeta = stack.getTagCompound().getInteger("state");

		int worldMeta = Block.getStateId(world.getBlockState(pos));

		if (!blockSuitableForSelection(player, world, pos)) {
			player.sendMessage(new TextComponentTranslation(Data.MODID + ".error.invalidblock"));
			return false;
		}

		return newMeta != worldMeta;
	}

	public static void buildExchangeList(World world, BlockPos pos, BlockPos origin, IBlockState origState,
			EnumFacing side, int range, List<BlockPos> exchangeList, List<BlockPos> checkedList) {

		EnumFacing[] facesAround = DirectionHelper.getFacings(side);

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
		if (!(heldItem.getItem() instanceof ItemExchanger))
			return false;
		ItemExchanger exchanger = (ItemExchanger) heldItem.getItem();
		if (!player.capabilities.isCreativeMode || exchanger.getTier() != Tier.CREATIVE) {
			InventoryPlayer inv = player.inventory;
			Item item = Item.getItemFromBlock(block);
			int meta = block.getMetaFromState(state);

			ItemStack stack = findItemInInventory(inv, item, meta);

			if (stack.isEmpty())
				return false;
			else
				stack.shrink(1);
		}

		return true;
	}

	public static ItemStack findItemInInventory(InventoryPlayer inv, Item item, int meta) {
		for (int i = 0; i < inv.mainInventory.size(); i++) {
			ItemStack stack = inv.mainInventory.get(i);
			if (!stack.isEmpty() && stack.getItem() == item && stack.getItemDamage() == meta) {
				return stack;
			}
		}
		return ItemStack.EMPTY;
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
		int stateID = stack.getTagCompound().getInteger("state");

		if (stateID == 0)
			return false;
		world.profiler.startSection("Exchangers-Building/Queueing");

		IBlockState newState = Block.getStateById(stateID);
		List<BlockPos> toExchange = getBlocksToExchange(stack, pos, world, facing);

		for (BlockPos exchangePos : toExchange) {
			ItemStack slot = ItemStack.EMPTY;
			ItemStack heldItem = player.getHeldItemMainhand();
			if (!(heldItem.getItem() instanceof ItemExchanger))
				return false;
			ItemExchanger exchanger = (ItemExchanger) heldItem.getItem();
			if (player.capabilities.isCreativeMode || exchanger.getTier() == Tier.CREATIVE) {
				placeBlockInWorld(world, exchangePos, newState);
			} else {
				try {
					slot = findItemInInventory(player.inventory, Item.getItemFromBlock(newState.getBlock()),
							stateID >> 12 & 15);
				} catch (ArrayIndexOutOfBoundsException e) {
					return false;
				}
				if (!slot.isEmpty()) {
					Block oldBlock = world.getBlockState(exchangePos).getBlock();
					int oldMeta = oldBlock.getMetaFromState(world.getBlockState(exchangePos));
					int energy = stack.getTagCompound().getInteger("Energy");
					if (exchanger.isPowered() && energy < ((ItemPoweredExchanger) exchanger).getPerBlockCost()) {
						player.sendMessage(new TextComponentTranslation(Data.MODID + ".error.nopower"));
						return false;
					}
					if (placeBlockInInventory(player, oldBlock, oldMeta)
							&& placeBlockInWorld(world, exchangePos, newState)
							&& consumeBlockInInventory(player, newState.getBlock(), newState)) {
						if (!exchanger.isPowered() && exchanger.getTier() != Tier.CREATIVE)
							stack.damageItem(1, player);
						else if (exchanger.isPowered()) {
							ItemPoweredExchanger powered = (ItemPoweredExchanger) exchanger;
							if (energy >= powered.getPerBlockCost())
								stack.getTagCompound().setInteger("Energy", energy - powered.getPerBlockCost());
						}
					} else
						return false;
				}
			}
		}
		world.profiler.endSection();

		return true;
	}

}
