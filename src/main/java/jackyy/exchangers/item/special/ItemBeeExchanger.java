package jackyy.exchangers.item.special;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ItemBeeExchanger extends ItemExchangerBase {

    public ItemBeeExchanger() {
        super(new Properties().maxDamage(DefaultValues.beeMaxDmg).rarity(Reference.RARITY_BEE));
    }

    @Override
    public int getHarvestLevel() {
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
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.bee_exchanger.flavor_text"));
        }
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        super.onItemUse(context);
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getPos();
        if (!world.isRemote && player != null) {
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(),
                    SoundEvents.BLOCK_BEEHIVE_WORK, SoundCategory.BLOCKS, 1.0F, 1F);
            if (!player.isSneaking()) {
                BeeEntity bee = new BeeEntity(EntityType.BEE, world);
                bee.setPosition(pos.getX(), pos.getY(), pos.getZ());
                if (world.rand.nextInt(5) + 1 == 5) {
                    world.addEntity(bee);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.specialModule.get();
    }

}
