package jackyy.exchangers.handler;

import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemHandler {

    public static boolean consumeItemInInventory(Item item, Inventory playerInv, Player player) {
        if (player.isCreative() || ExchangerHandler.getExIsCreative(player.getMainHandItem())) {
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
            playerInv.removeItem(i, 1);
            return true;
        }
        return false;
    }

    public static int findItem(Item item, Inventory inv) {
        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
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

    public static NonNullList<IItemHandler> findItemContainers(Inventory inv) {
        NonNullList<IItemHandler> containers = NonNullList.create();
        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
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

    public static void giveItem(Level world, Player player, ItemStack oldStack) {
        ItemEntity entityItem = new ItemEntity(world, player.getX(), player.getY(), player.getZ(), oldStack);
        if (NBTHelper.getTag(player.getMainHandItem()).getBoolean("forceDropItems")) {
            world.addFreshEntity(entityItem);
        } else {
            if (!player.getInventory().add(oldStack)) {
                world.addFreshEntity(entityItem);
            }
        }
    }

}
