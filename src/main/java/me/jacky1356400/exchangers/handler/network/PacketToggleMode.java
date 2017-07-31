package me.jacky1356400.exchangers.handler.network;

import io.netty.buffer.ByteBuf;
import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketToggleMode implements IMessage, IMessageHandler<PacketToggleMode, IMessage> {

    public PacketToggleMode() {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    @Override
    public IMessage onMessage(PacketToggleMode message, MessageContext context) {
        EntityPlayerMP playerMP = context.getServerHandler().player;
        ItemStack heldItem = playerMP.getHeldItemMainhand();
        if (heldItem != null && heldItem.getItem() instanceof ExchangerHandler) {
            ExchangerHandler exchanger = (ExchangerHandler) (heldItem.getItem());
            exchanger.switchMode(playerMP, heldItem);
        }
        return null;
    }
}