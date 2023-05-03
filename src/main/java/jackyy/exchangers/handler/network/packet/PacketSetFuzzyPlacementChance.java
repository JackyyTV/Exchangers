package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSetFuzzyPlacementChance {

    private int chance;

    public PacketSetFuzzyPlacementChance(int chance) {
        this.chance = chance;
    }

    public PacketSetFuzzyPlacementChance(PacketBuffer buffer) {
        chance = buffer.readInt();
    }

    public void toBytes(PacketBuffer buffer) {
        buffer.writeInt(chance);
    }

    public static void handle(PacketSetFuzzyPlacementChance message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayerEntity player = context.get().getSender();
            if (player != null) {
                ItemStack heldItem = player.getHeldItemMainhand();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.setFuzzyPlacementChance(heldItem, message.chance);
                }
            }
        });
        context.get().setPacketHandled(true);
    }

}
