package jackyy.exchangers.client.keybind;

import com.mojang.blaze3d.platform.InputConstants;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Keys {

    public static final Lazy<KeyMapping> OPEN_GUI_KEY = Lazy.of(() -> createKey("open_gui", GLFW.GLFW_KEY_COMMA));
    public static final Lazy<KeyMapping> RANGE_SWITCH_KEY = Lazy.of(() -> createKey("range_switch", GLFW.GLFW_KEY_UNKNOWN));
    public static final Lazy<KeyMapping> MODE_SWITCH_KEY = Lazy.of(() -> createKey("mode_switch", GLFW.GLFW_KEY_UNKNOWN));
    public static final Lazy<KeyMapping> FORCE_DROP_ITEMS_KEY = Lazy.of(() -> createKey("force_drop_items_mode_toggle", GLFW.GLFW_KEY_UNKNOWN));
    public static final Lazy<KeyMapping> DIRECTIONAL_PLACEMENT_KEY = Lazy.of(() -> createKey("directional_placement_mode_toggle", GLFW.GLFW_KEY_UNKNOWN));
    public static final Lazy<KeyMapping> FUZZY_PLACEMENT_KEY = Lazy.of(() -> createKey("fuzzy_placement_mode_toggle", GLFW.GLFW_KEY_UNKNOWN));
    public static final Lazy<KeyMapping> VOID_ITEMS_KEY = Lazy.of(() -> createKey("void_items_mode_toggle", GLFW.GLFW_KEY_UNKNOWN));

    private static KeyMapping createKey(String name, int keyCode) {
        return new KeyMapping(Reference.KEY_PREFIX + name, ExchangersKeyConflictContext.INSTANCE, InputConstants.Type.KEYSYM, keyCode, Reference.KEY_CATEGORY);
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_GUI_KEY.get());
        event.register(RANGE_SWITCH_KEY.get());
        event.register(MODE_SWITCH_KEY.get());
        event.register(FORCE_DROP_ITEMS_KEY.get());
        event.register(DIRECTIONAL_PLACEMENT_KEY.get());
        event.register(FUZZY_PLACEMENT_KEY.get());
        event.register(VOID_ITEMS_KEY.get());
    }

}
