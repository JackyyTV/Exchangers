package jackyy.exchangers.handler.network.packet;

import io.netty.buffer.ByteBuf;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketToggleDirectionalPlacement implements IMessage, IMessageHandler<PacketToggleDirectionalPlacement, IMessage> {

    @Override
    public void fromBytes(ByteBuf buf) { }

    @Override
    public void toBytes(ByteBuf buf) { }

    public PacketToggleDirectionalPlacement() { }

    @Override
    public IMessage onMessage(PacketToggleDirectionalPlacement message, MessageContext context) {
        EntityPlayerMP playerMP = context.getServerHandler().player;
        ItemStack heldItem = playerMP.getHeldItemMainhand();
        if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
            ExchangerHandler.toggleDirectionalPlacement(playerMP, heldItem);
        }
        return null;
    }

}
