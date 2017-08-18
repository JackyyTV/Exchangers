package me.jacky1356400.exchangers.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class Keys {

    public static final KeyBinding MODE_KEY = new KeyBinding("key.exchangermode", Keyboard.KEY_COMMA, "key.categories.exchangers");

    public static void init() {
        ClientRegistry.registerKeyBinding(MODE_KEY);
    }

}
