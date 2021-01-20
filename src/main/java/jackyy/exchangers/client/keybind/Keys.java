package jackyy.exchangers.client.keybind;

import jackyy.exchangers.util.Reference;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class Keys {

    public static final KeyBinding OPEN_GUI_KEY = createKey("open_gui", Keyboard.KEY_COMMA);
    public static final KeyBinding RANGE_SWITCH_KEY = createKey("range_switch", Keyboard.KEY_NONE);
    public static final KeyBinding MODE_SWITCH_KEY = createKey("mode_switch", Keyboard.KEY_NONE);
    public static final KeyBinding FORCE_DROP_ITEMS_KEY = createKey("force_drop_items_mode_toggle", Keyboard.KEY_NONE);
    public static final KeyBinding DIRECTIONAL_PLACEMENT_KEY = createKey("directional_placement_mode_toggle", Keyboard.KEY_NONE);
    public static final KeyBinding FUZZY_PLACEMENT_KEY = createKey("fuzzy_placement_mode_toggle", Keyboard.KEY_NONE);
    public static final KeyBinding VOID_ITEMS_KEY = createKey("void_items_mode_toggle", Keyboard.KEY_NONE);

    private static KeyBinding createKey(String name, int keyCode) {
        return new KeyBinding(Reference.KEY_PREFIX + name, ExchangersKeyConflictContext.INSTANCE, keyCode, Reference.KEY_CATEGORY);
    }

    public static void init() {
        ClientRegistry.registerKeyBinding(OPEN_GUI_KEY);
        ClientRegistry.registerKeyBinding(RANGE_SWITCH_KEY);
        ClientRegistry.registerKeyBinding(MODE_SWITCH_KEY);
        ClientRegistry.registerKeyBinding(FORCE_DROP_ITEMS_KEY);
        ClientRegistry.registerKeyBinding(DIRECTIONAL_PLACEMENT_KEY);
        ClientRegistry.registerKeyBinding(FUZZY_PLACEMENT_KEY);
        ClientRegistry.registerKeyBinding(VOID_ITEMS_KEY);
    }

}
