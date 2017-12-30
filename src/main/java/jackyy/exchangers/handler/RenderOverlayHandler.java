package jackyy.exchangers.handler;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.util.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.Set;

public class RenderOverlayHandler {

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;
        ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
        if (StackUtil.isEmpty(stack)) {
            return;
        }
        if ((stack.getItem() instanceof ItemExchangerBase)) {
            renderOverlay(event, player, stack);
        }
    }

    private static void renderOutlines(RenderWorldLastEvent evt, EntityPlayerSP p, Set<BlockPos> coordinates, int r, int g, int b) {
        double doubleX = p.lastTickPosX + (p.posX - p.lastTickPosX) * evt.getPartialTicks();
        double doubleY = p.lastTickPosY + (p.posY - p.lastTickPosY) * evt.getPartialTicks();
        double doubleZ = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * evt.getPartialTicks();

        RenderHelper.disableStandardItemLighting();
        Minecraft.getMinecraft().entityRenderer.disableLightmap();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableAlpha();
        GlStateManager.depthMask(false);

        GlStateManager.pushMatrix();
        GlStateManager.translate(-doubleX, -doubleY, -doubleZ);

        renderOutlines(coordinates, r, g, b, 4);

        GlStateManager.popMatrix();

        Minecraft.getMinecraft().entityRenderer.enableLightmap();
        GlStateManager.enableTexture2D();
    }

    private static void renderOutlines(Set<BlockPos> coordinates, int r, int g, int b, int thickness) {
        Tessellator tessellator = Tessellator.getInstance();

        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(1, DefaultVertexFormats.POSITION_COLOR);

        GL11.glLineWidth(thickness);
        for (BlockPos coordinate : coordinates) {
            float x = coordinate.getX();
            float y = coordinate.getY();
            float z = coordinate.getZ();

            renderHighLightedBlocksOutline(buffer, x, y, z, r / 255.0F, g / 255.0F, b / 255.0F, 1.0F);
        }
        tessellator.draw();
    }

    private static void renderHighLightedBlocksOutline(VertexBuffer buffer, float mx, float my, float mz, float r, float g, float b, float a) {
        buffer.pos(mx, my, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx, my, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx, my + 1.0F, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx, my, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx, my, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my + 1.0F, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx, my + 1.0F, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my + 1.0F, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my + 1.0F, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my + 1.0F, mz).color(r, g, b, a).endVertex();

        buffer.pos(mx, my + 1.0F, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx, my + 1.0F, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx, my + 1.0F, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my + 1.0F, mz).color(r, g, b, a).endVertex();

        buffer.pos(mx + 1.0F, my, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my, mz).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my + 1.0F, mz).color(r, g, b, a).endVertex();

        buffer.pos(mx, my, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx + 1.0F, my, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx, my, mz + 1.0F).color(r, g, b, a).endVertex();
        buffer.pos(mx, my + 1.0F, mz + 1.0F).color(r, g, b, a).endVertex();
    }

    @SideOnly(Side.CLIENT) @SuppressWarnings("deprecation")
    public void renderOverlay(RenderWorldLastEvent evt, EntityPlayerSP player, ItemStack stack) {
        RayTraceResult mouseOver = Minecraft.getMinecraft().objectMouseOver;
        if ((mouseOver != null) && (mouseOver.getBlockPos() != null) && (mouseOver.sideHit != null)) {
            IBlockState state = player.getEntityWorld().getBlockState(mouseOver.getBlockPos());
            Block block = state.getBlock();
            if ((block != null) && (block.getMaterial(state) != Material.AIR)) {
                int meta = block.getMetaFromState(state);

                int exId = ExchangerHandler.getTagCompound(stack).getInteger("block");
                Block exBlock = Block.REGISTRY.getObjectById(exId);
                int exMeta = ExchangerHandler.getTagCompound(stack).getInteger("meta");
                if ((exBlock == block) && (exMeta == meta)) {
                    return;
                }
                Set<BlockPos> coordinates = ExchangerHandler.findSuitableBlocks(stack, player.getEntityWorld(), mouseOver.sideHit, mouseOver.getBlockPos(), block, meta);
                renderOutlines(evt, player, coordinates, 200, 230, 180);
            }
        }
    }

}