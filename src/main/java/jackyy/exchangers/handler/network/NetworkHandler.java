package jackyy.exchangers.handler.network;

import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static final String PROTOCOL_VERSION = "1";

    public static int nextID() {
        return packetId++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Reference.MODID, "main_channel"),
                () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
        INSTANCE.registerMessage(nextID(), PacketSwitchRange.class, PacketSwitchRange::toBytes, PacketSwitchRange::new, PacketSwitchRange::handle);
        INSTANCE.registerMessage(nextID(), PacketIncreaseRange.class, PacketIncreaseRange::toBytes, PacketIncreaseRange::new, PacketIncreaseRange::handle);
        INSTANCE.registerMessage(nextID(), PacketDecreaseRange.class, PacketDecreaseRange::toBytes, PacketDecreaseRange::new, PacketDecreaseRange::handle);
        INSTANCE.registerMessage(nextID(), PacketSwitchMode.class, PacketSwitchMode::toBytes, PacketSwitchMode::new, PacketSwitchMode::handle);
        INSTANCE.registerMessage(nextID(), PacketToggleForceDropItems.class, PacketToggleForceDropItems::toBytes, PacketToggleForceDropItems::new, PacketToggleForceDropItems::handle);
        INSTANCE.registerMessage(nextID(), PacketToggleDirectionalPlacement.class, PacketToggleDirectionalPlacement::toBytes, PacketToggleDirectionalPlacement::new, PacketToggleDirectionalPlacement::handle);
        INSTANCE.registerMessage(nextID(), PacketToggleFuzzyPlacement.class, PacketToggleFuzzyPlacement::toBytes, PacketToggleFuzzyPlacement::new, PacketToggleFuzzyPlacement::handle);
        INSTANCE.registerMessage(nextID(), PacketSetFuzzyPlacementChance.class, PacketSetFuzzyPlacementChance::toBytes, PacketSetFuzzyPlacementChance::new, PacketSetFuzzyPlacementChance::handle);
        INSTANCE.registerMessage(nextID(), PacketToggleVoidItems.class, PacketToggleVoidItems::toBytes, PacketToggleVoidItems::new, PacketToggleVoidItems::handle);
    }

    public static void sendToClient(Object packet, ServerPlayer player) {
        INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }

}
