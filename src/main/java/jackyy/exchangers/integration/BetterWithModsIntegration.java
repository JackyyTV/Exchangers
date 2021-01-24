package jackyy.exchangers.integration;

/*
import betterwithmods.module.hardcore.world.strata.HCStrata;
import jackyy.exchangers.util.IExchanger;
import jackyy.exchangers.util.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
*/

public class BetterWithModsIntegration {

    /*
    @SubscribeEvent @Deprecated
    public void onPlace(BlockEvent.EntityPlaceEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity))
            return;
        World world = event.getEntity().world;
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        if (HCStrata.shouldStratify(world, state)) {
            ItemStack stack = ((PlayerEntity) event.getEntity()).getHeldItemMainhand();
            int strata = HCStrata.getStratification(world, pos, world.getDimensionKey()).ordinal();
            if (stack.getItem() instanceof IExchanger && HCStrata.STATES.containsKey(event.getState())) {
                int level = Math.max(1, ((IExchanger) stack.getItem()).getHarvestLevel());
                if (level <= strata) {
                    event.setCanceled(true);
                    ((PlayerEntity) event.getEntity()).sendStatusMessage(new TranslationTextComponent(Reference.MODID + "." + "error.event_cancelled_bwm"), false);
                }
            }
        }
    }
    */

}
