package me.jacky1356400.exchangers.handler;

import me.jacky1356400.exchangers.client.Keys;
import me.jacky1356400.exchangers.handler.network.PacketHandler;
import me.jacky1356400.exchangers.handler.network.PacketToggleMode;
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
