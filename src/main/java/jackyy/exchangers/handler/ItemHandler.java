package jackyy.exchangers.handler;

import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemHandler {

    public static boolean consumeItemInInventory(Item item, PlayerInventory playerInv, PlayerEntity player) {
        if (player.isCreative() || ExchangerHandler.getExIsCreative(player.getHeldItemMainhand())) {
            return true;
        }
        int i = findItem(item, playerInv);
        if (i < 0) {
            NonNullList<IItemHandler> containers = findItemContainers(playerInv);
            if (containers.isEmpty())
                return false;
            for (IItemHandler container : containers) {
                i = findItemInContainer(item, container);
                if (i < 0)
                    continue;
                container.extractItem(i, 1, false);
                return true;
            }
        } else {
            playerInv.decrStackSize(i, 1);
            return true;
        }
        return false;
    }

    public static int findItem(Item item, IInventory inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && (stack.getItem() == item)) {
                return i;
            }
        }
        return -1;
    }

    public static int findItemInContainer(Item item, IItemHandler inv) {
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!inv.extractItem(i, 1, true).isEmpty() && (stack.getItem() == item)) {
                return i;
            }
        }
        return -1;
    }

    public static NonNullList<IItemHandler> findItemContainers(IInventory inv) {
        NonNullList<IItemHandler> containers = NonNullList.create();
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            IItemHandler container = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElse(null);
            if (!stack.isEmpty() && container != null && !stack.getCapability(CapabilityEnergy.ENERGY, null).isPresent()) {
                containers.add(container);
            }
        }
        return containers;
    }

    public static ItemStack getSilkTouchDrop(BlockState state) {
        Block block = state.getBlock();
        Item item = block.asItem();
        return new ItemStack(item, 1);
    }

    public static void giveItem(World world, PlayerEntity player, ItemStack oldStack) {
        ItemEntity entityItem = new ItemEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), oldStack);
        if (NBTHelper.getTag(player.getHeldItemMainhand()).getBoolean("forceDropItems")) {
            world.addEntity(entityItem);
        } else {
            if (!player.inventory.addItemStackToInventory(oldStack)) {
                world.addEntity(entityItem);
            }
        }
    }

}
