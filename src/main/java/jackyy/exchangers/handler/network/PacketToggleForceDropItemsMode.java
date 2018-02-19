package jackyy.exchangers.handler.network;

import io.netty.buffer.ByteBuf;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketToggleForceDropItemsMode implements IMessage, IMessageHandler<PacketToggleForceDropItemsMode, IMessage> {

    @Override
    public void fromBytes(ByteBuf buf) { }

    @Override
    public void toBytes(ByteBuf buf) { }

    public PacketToggleForceDropItemsMode() { }

    @Override
    public IMessage onMessage(PacketToggleForceDropItemsMode message, MessageContext context) {
        EntityPlayerMP playerMP = context.getServerHandler().player;
        ItemStack heldItem = playerMP.getHeldItemMainhand();
        if (heldItem != ItemStack.EMPTY && heldItem.getItem() instanceof ItemExchangerBase) {
            ItemExchangerBase exchanger = (ItemExchangerBase) (heldItem.getItem());
            exchanger.toggleForceDropItems(playerMP, heldItem);
        }
        return null;
    }

}
