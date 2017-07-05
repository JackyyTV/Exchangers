package me.jacky1356400.exchangers.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class Keys {

	public static KeyBinding modeKey;

	public static void init() {
		modeKey = new KeyBinding("key.exchangermode", Keyboard.KEY_COMMA, "key.categories.exchangers");
		ClientRegistry.registerKeyBinding(modeKey);
	}

}
