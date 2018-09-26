package jackyy.exchangers.helper;

import jackyy.exchangers.Exchangers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class ChatHelper {

    public static void msgPlayer(EntityPlayer player, String msg) {
        player.sendStatusMessage(new TextComponentTranslation(Exchangers.MODID + "." + msg), true);
    }

    public static void msgPlayerRaw(EntityPlayer player, String msg) {
        player.sendStatusMessage(new TextComponentString(msg), true);
    }

}
