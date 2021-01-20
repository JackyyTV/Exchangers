package jackyy.exchangers.handler.network;

import jackyy.exchangers.handler.network.packet.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {

    public static SimpleNetworkWrapper INSTANCE;
    private static int packetId = 0;

    public static int nextID() {
        return packetId++;
    }

    public static void registerMessages(String channelName) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
        INSTANCE.registerMessage(PacketSwitchRange.class, PacketSwitchRange.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketIncreaseRange.class, PacketIncreaseRange.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketDecreaseRange.class, PacketDecreaseRange.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketSwitchMode.class, PacketSwitchMode.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketToggleForceDropItems.class, PacketToggleForceDropItems.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketToggleDirectionalPlacement.class, PacketToggleDirectionalPlacement.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketToggleFuzzyPlacement.class, PacketToggleFuzzyPlacement.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketSetFuzzyPlacementChance.class, PacketSetFuzzyPlacementChance.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketToggleVoidItems.class, PacketToggleVoidItems.class, nextID(), Side.SERVER);
    }

}
