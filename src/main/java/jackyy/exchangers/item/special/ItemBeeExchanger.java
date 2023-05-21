package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemBeeExchanger extends ItemExchangerBase {

    public ItemBeeExchanger() {
        super(new Properties().durability(DefaultValues.beeMaxDmg).rarity(Reference.RARITY_BEE));
    }

    @Override
    public String getHarvestLevel() {
        return DefaultValues.beeMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return DefaultValues.beeMaxRange;
    }

    @Override
    public int getTier() {
        return 69;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, world, tooltip, advanced);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.bee_exchanger.flavor_text"));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        super.useOn(context);
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        if (!world.isClientSide() && player != null) {
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(),
                    SoundEvents.BEEHIVE_WORK, SoundSource.BLOCKS, 1.0F, 1F);
            if (!player.isShiftKeyDown()) {
                Bee bee = new Bee(EntityType.BEE, world);
                bee.setPos(player.getX(), player.getY(), player.getZ());
                if (world.random.nextInt(5) + 1 == 5) {
                    world.addFreshEntity(bee);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.specialModule.get();
    }

}
