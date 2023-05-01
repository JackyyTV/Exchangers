package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.List;

public class ItemTuberousExchanger extends ItemExchangerBase {

    public ItemTuberousExchanger() {
        super(new Properties().defaultMaxDamage(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.tuberous_exchanger.warning"));
        }
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        if (player != null) {
            player.getHeldItemMainhand().setCount(0);
            player.attackEntityFrom(new EntityDamageSource("tuberous_exchanger", player), Float.MAX_VALUE);
            player.world.createExplosion(player, player.getPosX(), player.getPosY(), player.getPosZ(), 1.0F, Explosion.Mode.NONE);
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.specialModule.get();
    }

}
