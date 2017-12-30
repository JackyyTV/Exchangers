package jackyy.exchangers.item.special;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemTuberousExchanger extends ItemExchangerBase {

    public ItemTuberousExchanger(){
        setRegistryName(Exchangers.MODID + ":tuberous_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".tuberous_exchanger");
        setMaxStackSize(1);
        setMaxDamage(1);
        setCreativeTab(Exchangers.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);
        if (StringHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.localize("tooltip.tuberousExchanger.warning"));
        }
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return killPlayer(player, stack)? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        boolean result = killPlayer(player, stack);
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, stack);
    }

    private static boolean killPlayer(EntityPlayer player, ItemStack stack) {
        if (player != null) {
            stack.stackSize = 0;
            player.attackEntityFrom(new EntityDamageSource("exchangerpotato", player), 100000.0F);
            player.worldObj.createExplosion(player, player.posX, player.posY, player.posZ, 1.0F, false);
            return true;
        }
        return false;
    }

    @Override
    public int getMaxRange() {
        return MODE_1X1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Config.specialModule) {
            list.add(new ItemStack(this));
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

}
