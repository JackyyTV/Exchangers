package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.network.CustomPayloadEvent;

public record PacketToggleVoidItems() {

    public void encode(FriendlyByteBuf buffer) { }

    public static PacketToggleVoidItems decode(FriendlyByteBuf buffer) {
        return new PacketToggleVoidItems();
    }

    public static void handle(PacketToggleVoidItems message, CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                ItemStack heldItem = player.getMainHandItem();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.toggleVoidItems(player, heldItem);
                }
            }
        });
        context.setPacketHandled(true);
    }

}
