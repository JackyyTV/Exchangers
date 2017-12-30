package jackyy.exchangers.handler;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

public class EventsHandler {

    @SubscribeEvent
    public void onEntityTargeted(LivingSetAttackTargetEvent event) {
        if (event.getTarget() == null)
            return;
        if (!(event.getTarget() instanceof EntityPlayer) || event.getTarget() instanceof FakePlayer)
            return;
        if (!(event.getEntity() instanceof EntityLiving))
            return;

        EntityPlayer player = (EntityPlayer) event.getTarget();
        EntityLiving entity = (EntityLiving) event.getEntity();

        if (entity instanceof EntityCreeper) {
            if (player.getUniqueID().equals(UUID.fromString("38de3769-70fa-441c-89e8-67280f3068a0"))) {
                entity.setAttackTarget(null);
                entity.setRevengeTarget(null);
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity() instanceof EntityLiving))
            return;
        EntityLiving entity = (EntityLiving) event.getEntity();
        if (entity.getAttackTarget() == null || !(entity.getAttackTarget() instanceof EntityPlayer) || entity.getAttackTarget() instanceof FakePlayer)
            return;
        EntityPlayer player = (EntityPlayer) entity.getAttackTarget();

        if (entity instanceof EntityCreeper) {
            if (player.getUniqueID().equals(UUID.fromString("38de3769-70fa-441c-89e8-67280f3068a0"))) {
                entity.setAttackTarget(null);
                entity.setRevengeTarget(null);
            }
        }
    }

}
