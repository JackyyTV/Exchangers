package jackyy.exchangers.item.special;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.helper.StringHelper;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
        setMaxDamage(1);
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
            tooltip.add(StringHelper.localize("tooltip.tuberous_exchanger.warning"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (player != null) {
            player.getHeldItemMainhand().setCount(0);
            player.attackEntityFrom(new EntityDamageSource("tuberous_exchanger", player), 100000.0F);
            player.world.createExplosion(player, player.posX, player.posY, player.posZ, 1.0F, false);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
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
