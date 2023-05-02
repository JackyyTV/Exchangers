package jackyy.exchangers.client.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class Keys {

    public static final KeyMapping OPEN_GUI_KEY = createKey("open_gui", GLFW.GLFW_KEY_COMMA);
    public static final KeyMapping RANGE_SWITCH_KEY = createKey("range_switch", GLFW.GLFW_KEY_UNKNOWN);
    public static final KeyMapping MODE_SWITCH_KEY = createKey("mode_switch", GLFW.GLFW_KEY_UNKNOWN);
    public static final KeyMapping FORCE_DROP_ITEMS_KEY = createKey("force_drop_items_mode_toggle", GLFW.GLFW_KEY_UNKNOWN);
    public static final KeyMapping DIRECTIONAL_PLACEMENT_KEY = createKey("directional_placement_mode_toggle", GLFW.GLFW_KEY_UNKNOWN);
    public static final KeyMapping FUZZY_PLACEMENT_KEY = createKey("fuzzy_placement_mode_toggle", GLFW.GLFW_KEY_UNKNOWN);
    public static final KeyMapping VOID_ITEMS_KEY = createKey("void_items_mode_toggle", GLFW.GLFW_KEY_UNKNOWN);

    private static KeyMapping createKey(String name, int keyCode) {
        return new KeyMapping(Reference.KEY_PREFIX + name, ExchangersKeyConflictContext.INSTANCE, InputConstants.Type.KEYSYM, keyCode, Reference.KEY_CATEGORY);
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
