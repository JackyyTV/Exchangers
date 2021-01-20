package jackyy.exchangers.handler.network.packet;

import io.netty.buffer.ByteBuf;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketIncreaseRange implements IMessage, IMessageHandler<PacketIncreaseRange, IMessage> {

    @Override
    public void fromBytes(ByteBuf buf) { }

    @Override
    public void toBytes(ByteBuf buf) { }

    public PacketIncreaseRange() { }

    @Override
    public IMessage onMessage(PacketIncreaseRange message, MessageContext context) {
        EntityPlayerMP playerMP = context.getServerHandler().player;
        ItemStack heldItem = playerMP.getHeldItemMainhand();
        if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
            ExchangerHandler.switchRange(heldItem, false);
        }
        return null;
    }

}
