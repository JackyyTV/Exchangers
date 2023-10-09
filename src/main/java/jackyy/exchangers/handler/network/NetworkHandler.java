package jackyy.exchangers.handler.network;

import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel channel;

    public static void registerMessages() {
        channel = ChannelBuilder
                .named(new ResourceLocation(Reference.MODID, "main_channel"))
                .networkProtocolVersion(1)
                .acceptedVersions((s, v) -> v == 1)
                .simpleChannel();

        channel.messageBuilder(PacketSwitchRange.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketSwitchRange::encode)
                .decoder(PacketSwitchRange::decode)
                .consumerNetworkThread(PacketSwitchRange::handle)
                .add();

        channel.messageBuilder(PacketIncreaseRange.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketIncreaseRange::encode)
                .decoder(PacketIncreaseRange::decode)
                .consumerNetworkThread(PacketIncreaseRange::handle)
                .add();

        channel.messageBuilder(PacketDecreaseRange.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketDecreaseRange::encode)
                .decoder(PacketDecreaseRange::decode)
                .consumerNetworkThread(PacketDecreaseRange::handle)
                .add();

        channel.messageBuilder(PacketSwitchMode.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketSwitchMode::encode)
                .decoder(PacketSwitchMode::decode)
                .consumerNetworkThread(PacketSwitchMode::handle)
                .add();

        channel.messageBuilder(PacketToggleForceDropItems.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketToggleForceDropItems::encode)
                .decoder(PacketToggleForceDropItems::decode)
                .consumerNetworkThread(PacketToggleForceDropItems::handle)
                .add();

        channel.messageBuilder(PacketToggleDirectionalPlacement.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketToggleDirectionalPlacement::encode)
                .decoder(PacketToggleDirectionalPlacement::decode)
                .consumerNetworkThread(PacketToggleDirectionalPlacement::handle)
                .add();

        channel.messageBuilder(PacketToggleFuzzyPlacement.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketToggleFuzzyPlacement::encode)
                .decoder(PacketToggleFuzzyPlacement::decode)
                .consumerNetworkThread(PacketToggleFuzzyPlacement::handle)
                .add();

        channel.messageBuilder(PacketSetFuzzyPlacementChance.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketSetFuzzyPlacementChance::encode)
                .decoder(PacketSetFuzzyPlacementChance::decode)
                .consumerNetworkThread(PacketSetFuzzyPlacementChance::handle)
                .add();

        channel.messageBuilder(PacketToggleVoidItems.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PacketToggleVoidItems::encode)
                .decoder(PacketToggleVoidItems::decode)
                .consumerNetworkThread(PacketToggleVoidItems::handle)
                .add();
    }

    public static void sendToClient(Object packet, ServerPlayer player) {
        if (channel.isRemotePresent(player.connection.getConnection()) && !player.connection.getConnection().isMemoryConnection())
            channel.send(packet, PacketDistributor.PLAYER.with(player));
    }

    public static void sendToServer(Object packet) {
        channel.send(packet, PacketDistributor.SERVER.noArg());
    }

}
