package jackyy.exchangers.handler;

import jackyy.exchangers.client.Keys;
import jackyy.exchangers.handler.network.PacketHandler;
import jackyy.exchangers.handler.network.PacketToggleExtInvMode;
import jackyy.exchangers.handler.network.PacketToggleMode;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyBindingsHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keys.MODE_KEY.isPressed()) {
            PacketHandler.INSTANCE.sendToServer(new PacketToggleMode());
        } else if (Keys.EXT_INV_KEY.isPressed()) {
            PacketHandler.INSTANCE.sendToServer(new PacketToggleExtInvMode());
        }
    }
}
