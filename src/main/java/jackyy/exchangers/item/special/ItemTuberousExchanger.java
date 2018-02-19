package jackyy.exchangers.item.special;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemTuberousExchanger extends ItemExchangerBase {

    public ItemTuberousExchanger(){
        setRegistryName(Exchangers.MODID + ":tuberous_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".tuberous_exchanger");
        setMaxDamage(1);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize("tooltip.tuberous_exchanger.warning"));
        }
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return killPlayer(player, player.getHeldItemMainhand())? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = killPlayer(player, player.getHeldItemMainhand());
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    private static boolean killPlayer(EntityPlayer player, ItemStack stack) {
        if (player != null) {
            stack.setCount(0);
            player.attackEntityFrom(new EntityDamageSource("tuberous_exchanger", player), 100000.0F);
            player.world.createExplosion(player, player.posX, player.posY, player.posZ, 1.0F, false);
            return true;
        }
        return false;
    }

    @Override
    public int getMaxRange() {
        return MODE_1X1;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.specialModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

}
