package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemTuberousExchanger extends ItemExchangerBase {

    public ItemTuberousExchanger() {
        super(new Properties().durability(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, world, tooltip, advanced);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.tuberous_exchanger.warning"));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null) {
            player.getMainHandItem().setCount(0);
            player.hurt(player.damageSources().magic(), Float.MAX_VALUE);
            player.level().explode(player, player.getX(), player.getY(), player.getZ(), 1.0F, Level.ExplosionInteraction.NONE);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.specialModule.get();
    }

}
