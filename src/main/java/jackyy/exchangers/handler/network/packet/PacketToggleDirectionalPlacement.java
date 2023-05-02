package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketToggleDirectionalPlacement {

    public PacketToggleDirectionalPlacement() { }

    public PacketToggleDirectionalPlacement(FriendlyByteBuf buffer) { }

    public void toBytes(FriendlyByteBuf buffer) { }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            if (player != null) {
                ItemStack heldItem = player.getMainHandItem();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.toggleDirectionalPlacement(player, heldItem);
                }
            }
        });
        context.get().setPacketHandled(true);
    }

}
