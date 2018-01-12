package jackyy.exchangers.handler;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Set;

public class RenderOverlayHandler {

    @SubscribeEvent @SuppressWarnings("deprecation")
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        RayTraceResult mouseOver = mc.objectMouseOver;
        EntityPlayerSP player = mc.thePlayer;
        World world = player.getEntityWorld();
        if (mouseOver != null && mouseOver.sideHit != null) {
            IBlockState state = world.getBlockState(mouseOver.getBlockPos());
            Block block = state.getBlock();
            if (block.getMaterial(state) != Material.AIR) {
                int meta = block.getMetaFromState(state);
                ItemStack stack = player.getHeldItemMainhand();
                float partialTicks = event.getPartialTicks();
                if (stack != null && stack.getItem() instanceof ItemExchangerBase && stack.getTagCompound() != null && mouseOver.sideHit != null) {
                    Set<BlockPos> coordinates = ExchangerHandler.findSuitableBlocks(stack, player.getEntityWorld(), mouseOver.sideHit, mouseOver.getBlockPos(), block, meta);
                    double offsetX = player.prevPosX + (player.posX - player.prevPosX) * (double) partialTicks;
                    double offsetY = player.prevPosY + (player.posY - player.prevPosY) * (double) partialTicks;
                    double offsetZ = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) partialTicks;

                    Tessellator tessellator = Tessellator.getInstance();
                    VertexBuffer buffer = tessellator.getBuffer();

                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    GlStateManager.color(1F, 1F, 1F, 1F);
                    GlStateManager.glLineWidth(4.0F);
                    GlStateManager.disableTexture2D();
                    GlStateManager.disableDepth();

                    for (BlockPos coordinate : coordinates) {
                        String exId = ExchangerHandler.getTagCompound(stack).getString("block");
                        Block exBlock = Block.getBlockFromName(exId);
                        int exMeta = ExchangerHandler.getTagCompound(stack).getInteger("meta");
                        float blockHardness = block.getBlockHardness(state, world, coordinate);
                        if (world.isAirBlock(coordinate) || (exBlock == block && exMeta == meta)) {
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
                        if ((player.isSneaking() &&
                                ((world.getTileEntity(coordinate) != null && !ExchangerHandler.isWhitelisted(world, coordinate))
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

}