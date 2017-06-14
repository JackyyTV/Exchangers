package me.jacky1356400.exchangers.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class ChatHelper {

    public static void msgPlayer(EntityPlayer player, String msg) {
        player.addChatMessage(new TextComponentString(msg));
    }

}
