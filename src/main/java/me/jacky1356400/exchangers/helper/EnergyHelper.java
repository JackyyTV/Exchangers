package me.jacky1356400.exchangers.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class EnergyHelper {

    public static ItemStack setDefaultEnergyTag(ItemStack container, int energy) {

        if (!container.hasTagCompound()) {
            container.setTagCompound(new NBTTagCompound());
        }
        container.getTagCompound().setInteger("Energy", energy);

        return container;
    }

}
