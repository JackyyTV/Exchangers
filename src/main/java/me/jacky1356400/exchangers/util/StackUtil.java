package me.jacky1356400.exchangers.util;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StackUtil {

    @Nullable
    public static ItemStack incStackSize(@Nonnull ItemStack stack, int amount) {
        stack.setCount(stack.getCount() + amount);
        if (stack.getCount() <= 0) {
            return ItemStack.EMPTY;
        }
        return stack;
    }

    public static int getStackSize(@Nullable ItemStack stack) {
        if (stack == ItemStack.EMPTY) {
            return 0;
        }
        return stack.getCount();
    }

    @Nullable
    public static ItemStack getEmptyStack(@Nullable ItemStack stack) {
        return ItemStack.EMPTY;
    }

    public static boolean isValid(@Nullable ItemStack stack) {
        if (stack == ItemStack.EMPTY) {
            return false;
        }
        return stack.getCount() > 0;
    }

    public static boolean isEmpty(@Nullable ItemStack stack) {
        if (stack == stack.EMPTY) {
            return true;
        }
        return stack.getCount() <= 0;
    }

}
