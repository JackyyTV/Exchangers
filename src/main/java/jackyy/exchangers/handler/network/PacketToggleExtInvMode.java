package jackyy.exchangers.handler.network;

import io.netty.buffer.ByteBuf;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketToggleExtInvMode implements IMessage, IMessageHandler<PacketToggleExtInvMode, IMessage> {

    @Override
    public void fromBytes(ByteBuf buf) { }

    @Override
    public void toBytes(ByteBuf buf) { }

    public PacketToggleExtInvMode() { }

    @Override
    public IMessage onMessage(PacketToggleExtInvMode message, MessageContext context) {
        EntityPlayerMP playerMP = context.getServerHandler().playerEntity;
        ItemStack heldItem = playerMP.getHeldItemMainhand();
        if (heldItem != null && heldItem.getItem() instanceof ItemExchangerBase) {
            ItemExchangerBase exchanger = (ItemExchangerBase) (heldItem.getItem());
            exchanger.toggleExtMode(playerMP, heldItem);
        }
        return null;
    }

}
