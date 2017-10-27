package me.jacky1356400.exchangers.item.special;

import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchanger;
import me.jacky1356400.exchangers.util.EnumTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemTuberousExchanger extends ItemExchanger {

    public ItemTuberousExchanger() {
        super("expotato", EnumTier.ZERO, 1);
    }

    private static boolean killPlayer(EntityPlayer player, ItemStack stack) {
        stack.setCount(0);
        player.attackEntityFrom(new EntityDamageSource("exchangerpotato", player), 100000.0F);
        player.world.createExplosion(player, player.posX, player.posY, player.posZ, 1.0F, false);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
        super.addInformation(stack, world, tooltip, bool);
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize("tooltip.tuberousExchanger.warning"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                      float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        return killPlayer(player, stack) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        boolean result = killPlayer(player, stack);
        return ActionResult.newResult(result ? EnumActionResult.SUCCESS : EnumActionResult.FAIL, stack);
    }

}
