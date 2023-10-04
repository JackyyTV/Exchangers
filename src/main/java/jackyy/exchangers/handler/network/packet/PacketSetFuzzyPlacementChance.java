package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.network.CustomPayloadEvent;

public record PacketSetFuzzyPlacementChance(int chance) {

    public PacketSetFuzzyPlacementChance(int chance) {
        this.chance = chance;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(chance);
    }

    public static PacketSetFuzzyPlacementChance decode(FriendlyByteBuf buffer) {
        int chance = buffer.readInt();
        return new PacketSetFuzzyPlacementChance(chance);
    }

    public static void handle(PacketSetFuzzyPlacementChance message, CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                ItemStack heldItem = player.getMainHandItem();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.setFuzzyPlacementChance(heldItem, message.chance);
                }
            }
        });
        context.setPacketHandled(true);
    }

}
