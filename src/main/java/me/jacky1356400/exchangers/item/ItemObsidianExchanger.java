package me.jacky1356400.exchangers.item;

import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.handler.ExchangerHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import static me.jacky1356400.exchangers.helper.ChatHelper.msgPlayer;

public class ItemObsidianExchanger extends Item {

    public ItemObsidianExchanger(){
        setRegistryName(Exchangers.MODID + ":obsidian_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".obsidian_exchanger");
        setMaxStackSize(1);
        setMaxDamage(Config.obsidianExchangerMaxDamage);
        setCreativeTab(Exchangers.exchangersCreativeTab);
    }

    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public static final int MODE_INITIAL = 2;
    public static final int MODE_1X1 = 0;
    public static final int MODE_3X3 = 1;
    public static final int MODE_5X5 = 2;
    public static final int MODE_7X7 = 3;
    public static final int MODE_9X9 = 4;
    public static final int MODE_11X11 = 5;
    public static final int MODE_13X13 = 6;
    public static final int MODE_15X15 = 7;


    public static final String[] modeSwitchList = new String[] {"1x1", "3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15"};
    public static final Integer[] modeSwitchRange = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7};
    public static final Integer[] modeSwitchRanges = new Integer[] {1, 3, 5, 7, 9, 11, 13, 15};

    public void switchMode(EntityPlayer player, ItemStack stack) {
        if (stackTagCompoundNull(stack)) setDefaultTagCompound(stack);

        int modeSwitch = stack.getTagCompound().getInteger("ExchangeMode");
        modeSwitch++;

        if (modeSwitch > MODE_15X15) modeSwitch = 0;

        stack.getTagCompound().setInteger("ExchangeMode", modeSwitch);
        msgPlayer(player, "Exchanger mode set to " + modeSwitchList[modeSwitch]);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
        super.addInformation(stack, player, tooltip, bool);

        if (stackTagCompoundNull(stack)) setDefaultTagCompound(stack);
        NBTTagCompound compound = stack.getTagCompound();

        if (compound == null || Block.getBlockFromName(compound.getString("BlockName")) == null) {
            tooltip.add(ChatFormatting.RED + "No Selected Block");
        } else {
            String name = compound.getString("BlockName");
            Block block = Block.getBlockFromName(name);

            int meta = compound.getByte("BlockData");

            tooltip.add(ChatFormatting.LIGHT_PURPLE + "Selected Block: " + ExchangerHandler.getBlockName(block, meta));
            tooltip.add(ChatFormatting.LIGHT_PURPLE + "Selected Mode: " + modeSwitchList[compound.getInteger("ExchangeMode")]);
        }

        tooltip.add("Sneak right click on block to select.");
        tooltip.add("Right click on a block to exchange.");
        tooltip.add("Mode key (default 'comma') to switch modes.");
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return EnumActionResult.PASS;
        }

        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        int meta = block.getMetaFromState(state);

        if (player.isSneaking()) {

            if (ExchangerHandler.blockSuitableForSelection(player, world, pos)) {
                msgPlayer(player, "Selected Block - " + ExchangerHandler.getBlockName(block, meta));
                ExchangerHandler.setSelectedBlock(stack, block, state);
                return EnumActionResult.SUCCESS;
            } else {
                msgPlayer(player, "Invalid Selected Block - " + ExchangerHandler.getBlockName(block, meta));
                return EnumActionResult.FAIL;
            }
        } else {
            if (ExchangerHandler.blockSuitableForExchange(stack, player, world, pos)) {

                int mode = stack.getTagCompound().getInteger("ExchangeMode");

                boolean success = false;

                switch (facing.getIndex()){
                    case 0:
                        for(int x = 0; x < (modeSwitchRanges[mode]+1); x++){
                            for (int z = 0; z < (modeSwitchRanges[mode]+1); z++){
                                BlockPos pos2 = pos.add(x, 0, z);
                                if(world.isAirBlock(pos2)) continue;
                                if(!success){
                                    success = ExchangerHandler.exchangeBlocks(stack, player, world, pos2, facing);
                                } else {
                                    ExchangerHandler.exchangeBlocks(stack, player, world, pos2, facing);
                                }
                            }
                        }
                        break;
                    case 1:
                        for(int x = 0; x < (modeSwitchRanges[mode]+1); x++){
                            for (int z = 0; z < (modeSwitchRanges[mode]+1); z++){
                                BlockPos pos2 = pos.add(x, 0, z);
                                if(world.isAirBlock(pos2)) continue;
                                if(!success){
                                    success = ExchangerHandler.exchangeBlocks(stack, player, world, pos2, facing);
                                } else {
                                    ExchangerHandler.exchangeBlocks(stack, player, world, pos2, facing);
                                }
                            }
                        }
                        break;
                }

                if (success) {
                    return EnumActionResult.SUCCESS;
                }

            } else {
                return EnumActionResult.FAIL;
            }
        }

        return EnumActionResult.SUCCESS;
    }

    public static boolean stackTagCompoundNull(ItemStack stack) {
        return stack.getTagCompound() == null;
    }

    public static void setDefaultTagCompound(ItemStack stack) {
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setString("BlockName", "");
        stack.getTagCompound().setInteger("BlockData", 0);
        stack.getTagCompound().setInteger("ExchangeMode", 3);
    }

}
