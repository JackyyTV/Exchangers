package me.jacky1356400.exchangers.handler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.jacky1356400.exchangers.util.Exchange;

import java.util.*;

public class WorldEventHandler {

    public static Map<Integer, Set<Exchange>> exchanges = new HashMap();

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        exchangeTick(event.world);
    }

    public static void queueExchanges(BlockPos pos, IBlockState state, World world) {
        int dimId = world.provider.getDimension();
        Set<Exchange> queue = (LinkedHashSet) exchanges.get(dimId);

        if (queue == null) {
            exchanges.put(dimId, new LinkedHashSet());
            queue = exchanges.get(dimId);
        }

        queue.add(new Exchange(pos, state));
        exchanges.put(dimId, queue);
    }

    private void exchangeTick(World world) {
        int dimId = world.provider.getDimension();
        Set<Exchange> queue = exchanges.get(dimId);

        if (queue == null || queue.size() == 0) return;

        world.theProfiler.startSection("BBE-Exchanging");
        List<Exchange> queueList = new ArrayList<Exchange>(queue);
        Exchange exchange = queueList.get(0);

        world.destroyBlock(exchange.pos, false);
        world.setBlockState(exchange.pos, exchange.state, 3);

        queue.remove(exchange);
        world.theProfiler.endSection();
    }

}