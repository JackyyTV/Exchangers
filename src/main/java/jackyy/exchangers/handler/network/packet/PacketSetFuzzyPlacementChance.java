package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSetFuzzyPlacementChance {

    private int chance;

    public PacketSetFuzzyPlacementChance(int chance) {
        this.chance = chance;
    }

    public PacketSetFuzzyPlacementChance(FriendlyByteBuf buffer) {
        chance = buffer.readInt();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeInt(chance);
    }

    public static void handle(PacketSetFuzzyPlacementChance message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            if (player != null) {
                ItemStack heldItem = player.getMainHandItem();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.setFuzzyPlacementChance(heldItem, message.chance);
                }
            }
        });
        context.get().setPacketHandled(true);
    }

}
