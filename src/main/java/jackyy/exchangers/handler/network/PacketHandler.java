package jackyy.exchangers.handler.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE;
    private static int packetId = 0;

    public static int nextID() {
        return packetId++;
    }

    public static void registerMessages(String channelName) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
        INSTANCE.registerMessage(PacketSwitchRange.class, PacketSwitchRange.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketSwitchMode.class, PacketSwitchMode.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketToggleForceDropItemsMode.class, PacketToggleForceDropItemsMode.class, nextID(), Side.SERVER);
    }
}
