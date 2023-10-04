package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.network.CustomPayloadEvent;

public record PacketToggleForceDropItems() {

    public void encode(FriendlyByteBuf buffer) { }

    public static PacketToggleForceDropItems decode(FriendlyByteBuf buffer) {
        return new PacketToggleForceDropItems();
    }

    public static void handle(PacketToggleForceDropItems message, CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                ItemStack heldItem = player.getMainHandItem();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.toggleForceDropItems(player, heldItem);
                }
            }
        });
        context.setPacketHandled(true);
    }

}
