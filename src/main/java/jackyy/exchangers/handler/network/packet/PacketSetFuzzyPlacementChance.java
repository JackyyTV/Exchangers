package jackyy.exchangers.handler.network.packet;

import io.netty.buffer.ByteBuf;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSetFuzzyPlacementChance implements IMessage, IMessageHandler<PacketSetFuzzyPlacementChance, IMessage> {

    private int chance;

    public PacketSetFuzzyPlacementChance() { }

    public PacketSetFuzzyPlacementChance(int chance) {
        this.chance = chance;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        chance = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(chance);
    }

    @Override
    public IMessage onMessage(PacketSetFuzzyPlacementChance message, MessageContext context) {
        EntityPlayerMP playerMP = context.getServerHandler().player;
        ItemStack heldItem = playerMP.getHeldItemMainhand();
        if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
            ExchangerHandler.setFuzzyPlacementChance(heldItem, message.chance);
        }
        return null;
    }

}
