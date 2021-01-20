package jackyy.exchangers.handler;

import jackyy.exchangers.client.gui.ExchangersGuiScreen;
import jackyy.exchangers.client.keybind.Keys;
import jackyy.exchangers.handler.network.*;
import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

@SideOnly(Side.CLIENT)
public class ClientEventsHandler {

    private static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onGameOverlayRender(RenderGameOverlayEvent event) {
        if (event.isCancelable()
                || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE
                || !(mc.getRenderViewEntity() instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) mc.getRenderViewEntity();

        if (player == null
                || !mc.inGameHasFocus
                || !Minecraft.isGuiEnabled()
                || player.getHeldItemMainhand().isEmpty()
                || !(player.getHeldItemMainhand().getItem() instanceof ItemExchangerBase))
            return;

        ItemStack stack = player.getHeldItemMainhand();

        if (NBTHelper.hasTag(stack)) {
            ScaledResolution scaledresolution = new ScaledResolution(mc);
            int w = scaledresolution.getScaledWidth();
            int h = scaledresolution.getScaledHeight();

            GlStateManager.pushMatrix();
            GlStateManager.disableDepth();
            GlStateManager.disableRescaleNormal();

            String exchangeRange = ExchangerHandler.rangeList[NBTHelper.getTag(stack).getInteger("range")];
            double scale = exchangeRange.length() > 2 ? 1 : 1;
            double swidth = mc.fontRenderer.getStringWidth(exchangeRange) * scale;
            GlStateManager.translate((w / 2 - 2 - swidth), h / 2 - 4, 0);
            GlStateManager.scale(scale, scale, 1);
            mc.fontRenderer.drawStringWithShadow(exchangeRange, 0, 0, 0xFFFFFF);

            GlStateManager.enableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
        }
    }

    @SubscribeEvent @SuppressWarnings("deprecation")
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        RayTraceResult mouseOver = mc.objectMouseOver;
        EntityPlayerSP player = mc.player;
        World world = player.getEntityWorld();
        if (mouseOver != null && mouseOver.sideHit != null) {
            IBlockState state = world.getBlockState(mouseOver.getBlockPos());
            Block block = state.getBlock();
            if (!block.isAir(state, world, mouseOver.getBlockPos())) {
                ItemStack stack = player.getHeldItemMainhand();
                float partialTicks = event.getPartialTicks();
                if (!stack.isEmpty() && stack.getItem() instanceof ItemExchangerBase && stack.getTagCompound() != null && mouseOver.sideHit != null) {
                    Set<BlockPos> coordinates = ExchangerHandler.findSuitableBlocks(stack, player.getEntityWorld(), player, mouseOver.sideHit, mouseOver.getBlockPos(), state);
                    double offsetX = player.prevPosX + (player.posX - player.prevPosX) * (double) partialTicks;
                    double offsetY = player.prevPosY + (player.posY - player.prevPosY) * (double) partialTicks;
                    double offsetZ = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) partialTicks;

                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder buffer = tessellator.getBuffer();

                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    GlStateManager.color(1F, 1F, 1F, 1F);
                    GlStateManager.glLineWidth(4.0F);
                    GlStateManager.disableTexture2D();
                    GlStateManager.disableDepth();

                    for (BlockPos coordinate : coordinates) {
                        IBlockState exState = NBTUtil.readBlockState(NBTHelper.getTag(stack).getCompoundTag("blockstate"));
                        float blockHardness = block.getBlockHardness(state, world, coordinate);
                        if (world.isAirBlock(coordinate) || exState == state) {
                            continue;
                        }
                        double renderX = coordinate.getX() - offsetX;
                        double renderY = coordinate.getY() - offsetY;
                        double renderZ = coordinate.getZ() - offsetZ;
                        AxisAlignedBB boundingBox = new AxisAlignedBB(renderX, renderY, renderZ, renderX + 1, renderY + 1, renderZ + 1).expand(0.001, 0.001, 0.001);
                        float r = 1.0f;
                        float g = 1.0f;
                        float b = 1.0f;
                        float a = 1.0f;
                        if ((player.isSneaking()
                                && ((world.getTileEntity(coordinate) != null && !ExchangerHandler.isWhitelisted(world, coordinate))
                                || ExchangerHandler.isBlacklisted(world, coordinate)
                                || (!(stack.getItem() instanceof ItemCreativeExchanger) && blockHardness < -0.1f)))) {
                            r = 1.0f;
                            g = 0.1f;
                            b = 0.1f;
                            a = 1.0f;
                        } else if (player.isSneaking()) {
                            r = 0.1f;
                            g = 1.0f;
                            b = 0.1f;
                            a = 1.0f;
                        }
                        buffer.begin(3, DefaultVertexFormats.POSITION_COLOR);
                        buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        tessellator.draw();
                        buffer.begin(3, DefaultVertexFormats.POSITION_COLOR);
                        buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        tessellator.draw();
                        buffer.begin(1, DefaultVertexFormats.POSITION_COLOR);
                        buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).color(r, g, b, a).endVertex();
                        tessellator.draw();
                    }

                    GlStateManager.disableBlend();
                    GlStateManager.enableTexture2D();
                    GlStateManager.enableDepth();
                }
            }
        }
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        EntityPlayer player = FMLClientHandler.instance().getClient().player;
        ItemStack heldItem = player.getHeldItemMainhand();
        if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
            if (Keys.OPEN_GUI_KEY.isPressed()) {
                mc.displayGuiScreen(new ExchangersGuiScreen());
            } else if (Keys.RANGE_SWITCH_KEY.isPressed()) {
                NetworkHandler.INSTANCE.sendToServer(new PacketSwitchRange());
            } else if (Keys.MODE_SWITCH_KEY.isPressed()) {
                NetworkHandler.INSTANCE.sendToServer(new PacketSwitchMode());
            } else if (Keys.FORCE_DROP_ITEMS_KEY.isPressed()) {
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleForceDropItems());
            } else if (Keys.DIRECTIONAL_PLACEMENT_KEY.isPressed()) {
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleDirectionalPlacement());
            } else if (Keys.FUZZY_PLACEMENT_KEY.isPressed()) {
                NetworkHandler.INSTANCE.sendToServer(new PacketToggleFuzzyPlacement());
            }
        }
    }

}
