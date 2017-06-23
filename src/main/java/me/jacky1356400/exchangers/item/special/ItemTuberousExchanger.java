package me.jacky1356400.exchangers.item.special;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemTuberousExchanger extends ItemExchangerBase {

    public ItemTuberousExchanger() {
        setRegistryName(Exchangers.MODID + ":tuberous_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".tuberous_exchanger");
        setMaxStackSize(1);
        setMaxDamage(1);
        setCreativeTab(Exchangers.exchangersCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        tooltip.add(StringHelper.getTierText(0));
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize("tooltip.tuberousExchanger.warning"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return killPlayer(player, player.getHeldItem(hand)) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = killPlayer(player, player.getHeldItem(hand));
        return ActionResult.newResult(result ? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    private static boolean killPlayer(EntityPlayer player, ItemStack stack) {

        if (player instanceof EntityPlayer) {
            stack.setCount(0);
            player.attackEntityFrom(new EntityDamageSource("exchangerpotato", player), 100000.0F);
            player.world.createExplosion(player, player.posX, player.posY, player.posZ, 1.0F, false);

            return true;
        }

        return false;

    }

}
