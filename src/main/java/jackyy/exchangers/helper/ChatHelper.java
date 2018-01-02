package jackyy.exchangers.helper;

import jackyy.exchangers.Exchangers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;

public class ChatHelper {

    public static void msgPlayer(EntityPlayer player, String msg) {
        player.addChatMessage(new TextComponentTranslation(Exchangers.MODID + "." + msg));
    }

}
