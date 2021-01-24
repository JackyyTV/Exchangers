package jackyy.exchangers.handler.network.packet;

import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketSwitchRange {

    public PacketSwitchRange() { }

    public PacketSwitchRange(PacketBuffer buffer) { }

    public void toBytes(PacketBuffer buffer) { }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayerEntity player = context.get().getSender();
            if (player != null) {
                ItemStack heldItem = player.getHeldItemMainhand();
                if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                    ExchangerHandler.switchRange(heldItem, player.isSneaking());
                }
            }
        });
        context.get().setPacketHandled(true);
    }

}
