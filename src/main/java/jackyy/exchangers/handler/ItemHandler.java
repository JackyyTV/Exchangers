package jackyy.exchangers.handler;

import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemHandler {

    public static boolean consumeItemInInventory(Item item, int meta, InventoryPlayer playerInv, EntityPlayer player) {
        if (player.capabilities.isCreativeMode || ExchangerHandler.getExIsCreative(player.getHeldItemMainhand())) {
            return true;
        }
        int i = findItem(item, meta, playerInv);
        if (i < 0) {
            NonNullList<IItemHandler> containers = findItemContainers(playerInv);
            if (containers.isEmpty())
                return false;
            for (IItemHandler container : containers) {
                i = findItemInContainer(item, meta, container);
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

    public static int findItem(Item item, int meta, IInventory inv) {
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    public static int findItemInContainer(Item item, int meta, IItemHandler inv) {
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!inv.extractItem(i, 1, true).isEmpty() && (stack.getItem() == item) && (meta == stack.getItemDamage())) {
                return i;
            }
        }
        return -1;
    }

    public static NonNullList<IItemHandler> findItemContainers(IInventory inv) {
        NonNullList<IItemHandler> containers = NonNullList.create();
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty() && stack.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null) && !stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
                containers.add(stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null));
            }
        }
        return containers;
    }

    public static ItemStack getSilkTouchDrop(IBlockState state) {
        Block block = state.getBlock();
        Item item = Item.getItemFromBlock(block);
        int i = 0;
        if (item.getHasSubtypes()) {
            i = block.getMetaFromState(state);
        }
        return new ItemStack(item, 1, i);
    }

    public static void giveItem(World world, EntityPlayer player, ItemStack oldStack) {
        EntityItem entityItem = new EntityItem(world, player.posX, player.posY, player.posZ, oldStack);
        if (NBTHelper.getTag(player.getHeldItemMainhand()).getBoolean("forceDropItems")) {
            world.spawnEntity(entityItem);
        } else {
            if (!player.inventory.addItemStackToInventory(oldStack)) {
                world.spawnEntity(entityItem);
            }
        }
    }

}
