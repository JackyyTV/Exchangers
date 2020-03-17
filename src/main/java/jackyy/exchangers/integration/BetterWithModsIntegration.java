package jackyy.exchangers.integration;

import betterwithmods.module.hardcore.world.strata.HCStrata;
import jackyy.exchangers.util.IExchanger;
import jackyy.exchangers.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BetterWithModsIntegration {

    @SubscribeEvent @Deprecated
    @Optional.Method(modid = Reference.BWM)
    public void onPlace(BlockEvent.PlaceEvent event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        if (!(event.getEntity() instanceof EntityPlayer))
            return;
        IBlockState state = event.getState();
        if (HCStrata.shouldStratify(world, state)) {
            ItemStack stack = ((EntityPlayer) event.getEntity()).getHeldItemMainhand();
            int strata = HCStrata.getStratification(world, pos, world.provider.getDimension()).ordinal();
            if (stack.getItem() instanceof IExchanger && HCStrata.STATES.containsKey(event.getState())) {
                int level = Math.max(1, ((IExchanger) stack.getItem()).getHarvestLevel());
                if (level <= strata) {
                    event.setCanceled(true);
                    ((EntityPlayer) event.getEntity()).sendStatusMessage(new TextComponentTranslation(Reference.MODID + "." + "error.event_cancelled_bwm"), false);
                }
            }
        }
    }

}
