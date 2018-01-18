package jackyy.exchangers.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class Keys {

    public static final KeyBinding MODE_KEY = new KeyBinding("key.exchanger_mode", new IKeyConflictContext() {
        @Override
        public boolean isActive() {
            return KeyConflictContext.IN_GAME.isActive();
        }
        @Override
        public boolean conflicts(IKeyConflictContext other) {
            return other == this || KeyConflictContext.IN_GAME.isActive();
        }
    }, Keyboard.KEY_COMMA, "key.categories.exchangers");

    public static final KeyBinding EXT_INV_KEY = new KeyBinding("key.exchanger_external_inventory", new IKeyConflictContext() {
        @Override
        public boolean isActive() {
            return KeyConflictContext.IN_GAME.isActive();
        }
        @Override
        public boolean conflicts(IKeyConflictContext other) {
            return other == this || KeyConflictContext.IN_GAME.isActive();
        }
    }, Keyboard.KEY_PERIOD, "key.categories.exchangers");

    public static void init() {
        ClientRegistry.registerKeyBinding(MODE_KEY);
        ClientRegistry.registerKeyBinding(EXT_INV_KEY);
    }

}
