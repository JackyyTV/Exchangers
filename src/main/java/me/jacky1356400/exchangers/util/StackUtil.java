package me.jacky1356400.exchangers.util;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StackUtil {

    @Nullable
    public static ItemStack incStackSize(@Nonnull ItemStack stack, int amount) {
        stack.stackSize += amount;
        if (stack.stackSize <= 0) {
            return null;
        }
        return stack;
    }

    public static int getStackSize(@Nullable ItemStack stack) {
        if (stack == null) {
            return 0;
        }
        return stack.stackSize;
    }

    @Nullable
    public static ItemStack getEmptyStack() {
        return null;
    }

    public static boolean isValid(@Nullable ItemStack stack) {
        if (stack == null) {
            return false;
        }
        return stack.stackSize > 0;
    }

    public static boolean isEmpty(@Nullable ItemStack stack) {
        if (stack == null) {
            return true;
        }
        return stack.stackSize <= 0;
    }

}
