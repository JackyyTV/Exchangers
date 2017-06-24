package jacky.exchangers.handler;

import jacky.exchangers.client.Keys;
import jacky.exchangers.handler.network.PacketHandler;
import jacky.exchangers.handler.network.PacketToggleMode;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyBindingsHandler {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (Keys.modeKey.isPressed()) {
			PacketHandler.INSTANCE.sendToServer(new PacketToggleMode());
		}
	}
}
