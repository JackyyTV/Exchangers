package jackyy.exchangers.handler.network;

import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel CHANNEL = ChannelBuilder
            .named(new ResourceLocation(Reference.MODID, "main_channel"))
            .networkProtocolVersion(1)
            .simpleChannel()

            .messageBuilder(PacketSwitchRange.class)
            .encoder(PacketSwitchRange::encode)
            .decoder(PacketSwitchRange::decode)
            .consumerNetworkThread(PacketSwitchRange::handle)
            .add()

            .messageBuilder(PacketIncreaseRange.class)
            .encoder(PacketIncreaseRange::encode)
            .decoder(PacketIncreaseRange::decode)
            .consumerNetworkThread(PacketIncreaseRange::handle)
            .add()

            .messageBuilder(PacketDecreaseRange.class)
            .encoder(PacketDecreaseRange::encode)
            .decoder(PacketDecreaseRange::decode)
            .consumerNetworkThread(PacketDecreaseRange::handle)
            .add()

            .messageBuilder(PacketSwitchMode.class)
            .encoder(PacketSwitchMode::encode)
            .decoder(PacketSwitchMode::decode)
            .consumerNetworkThread(PacketSwitchMode::handle)
            .add()

            .messageBuilder(PacketToggleForceDropItems.class)
            .encoder(PacketToggleForceDropItems::encode)
            .decoder(PacketToggleForceDropItems::decode)
            .consumerNetworkThread(PacketToggleForceDropItems::handle)
            .add()

            .messageBuilder(PacketToggleDirectionalPlacement.class)
            .encoder(PacketToggleDirectionalPlacement::encode)
            .decoder(PacketToggleDirectionalPlacement::decode)
            .consumerNetworkThread(PacketToggleDirectionalPlacement::handle)
            .add()

            .messageBuilder(PacketToggleFuzzyPlacement.class)
            .encoder(PacketToggleFuzzyPlacement::encode)
            .decoder(PacketToggleFuzzyPlacement::decode)
            .consumerNetworkThread(PacketToggleFuzzyPlacement::handle)
            .add()

            .messageBuilder(PacketSetFuzzyPlacementChance.class)
            .encoder(PacketSetFuzzyPlacementChance::encode)
            .decoder(PacketSetFuzzyPlacementChance::decode)
            .consumerNetworkThread(PacketSetFuzzyPlacementChance::handle)
            .add()

            .messageBuilder(PacketToggleVoidItems.class)
            .encoder(PacketToggleVoidItems::encode)
            .decoder(PacketToggleVoidItems::decode)
            .consumerNetworkThread(PacketToggleVoidItems::handle)
            .add();

    public static void sendToClient(Object packet, ServerPlayer player) {
        if (CHANNEL.isRemotePresent(player.connection.getConnection()) && !player.connection.getConnection().isMemoryConnection())
            CHANNEL.send(packet, PacketDistributor.PLAYER.with(player));
    }

    public static void sendToServer(Object packet) {
        CHANNEL.send(packet, PacketDistributor.SERVER.noArg());
    }

}
