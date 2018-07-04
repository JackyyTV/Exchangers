package jackyy.exchangers.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.io.*;

public class NBTHelper {

    public static NBTTagCompound getTag(ItemStack stack) {
        if(!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
        return stack.getTagCompound();
    }

    public static boolean hasTag(ItemStack stack) {
        return stack.hasTagCompound();
    }

    public static void setInt(ItemStack stack, String key, int val) {
        getTag(stack).setInteger(key, val);
    }

    public static int getInt(ItemStack stack, String key) {
        return hasTag(stack) ? getTag(stack).getInteger(key) : 0;
    }

    public static int receiveEnergy(ItemStack container, int energy, int maxEnergy, boolean simulate) {
        int stored = getEnergyStored(container);
        int accepted = Math.min(energy, maxEnergy-stored);
        if (!simulate) {
            stored += accepted;
            setInt(container, "Energy", stored);
        }
        return accepted;
    }

    public static int extractEnergy(ItemStack container, int energy, boolean simulate) {
        int stored = getEnergyStored(container);
        int extracted = Math.min(energy, stored);
        if (!simulate) {
            stored -= extracted;
            setInt(container, "Energy", stored);
        }
        return extracted;
    }

    public static int getEnergyStored(ItemStack container) {
        return getInt(container, "Energy");
    }

    public static byte[] serializeToBytes(Object obj) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream objOutput = new ObjectOutputStream(output);
        objOutput.writeObject(obj);
        return output.toByteArray();
    }

    public static Object deserializeToObject(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream input = new ByteArrayInputStream(data);
        ObjectInputStream objInput = new ObjectInputStream(input);
        return objInput.readObject();
    }

}
