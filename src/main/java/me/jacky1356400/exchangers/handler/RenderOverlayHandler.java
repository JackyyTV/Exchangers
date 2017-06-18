package me.jacky1356400.exchangers.handler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import me.jacky1356400.exchangers.item.*;

import java.util.List;

public class RenderOverlayHandler {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void RenderWorldLastEvent(RenderWorldLastEvent event) {

	EntityPlayerSP player = Minecraft.getMinecraft().player;
	World world = player.getEntityWorld();
	ItemStack stack = player.getHeldItemMainhand();
	Minecraft mc = Minecraft.getMinecraft();
	float partialTicks = event.getPartialTicks();

	RayTraceResult mouseOver = mc.objectMouseOver;

	if (stack != null && stack.getItem() instanceof ItemExchangerBase && stack.getTagCompound() != null
		&& mouseOver != null && mouseOver.getBlockPos() != null && mouseOver.sideHit != null) {
	    List<BlockPos> blocks = ItemExchangerBase.getBlocksToExchange(stack, mouseOver.getBlockPos(), world,
		    mc.objectMouseOver.sideHit);

	    Tessellator tessellator = Tessellator.getInstance();
	    BufferBuilder buffer = tessellator.getBuffer();

	    double offsetX = player.prevPosX + (player.posX - player.prevPosX) * (double) partialTicks;
	    double offsetY = player.prevPosY + (player.posY - player.prevPosY) * (double) partialTicks;
	    double offsetZ = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) partialTicks;

	    GlStateManager.enableBlend();
	    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
		    GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
		    GlStateManager.DestFactor.ZERO);
	    GlStateManager.color(1F, 1F, 1F, 1F);
	    GlStateManager.glLineWidth(3.0F);
	    GlStateManager.disableTexture2D();

	    for (BlockPos block : blocks) {
		if (world.isAirBlock(block)) {
		    continue;
		}

		double renderX = block.getX() - offsetX;
		double renderY = block.getY() - offsetY;
		double renderZ = block.getZ() - offsetZ;

		AxisAlignedBB boundingBox = new AxisAlignedBB(renderX, renderY, renderZ, renderX + 1, renderY + 1,
			renderZ + 1).expand(0.001, 0.001, 0.001);

		float colourR = 1F;
		float colourG = 1F;
		float colourB = 1F;
		float colourA = 1F;

		if (Block.getBlockFromName(stack.getTagCompound().getString("BlockName")) == null) {
		    colourR = 1F;
		    colourG = 0.1F;
		    colourB = 0.1F;
		    colourA = 1F;
		}

		if (player.isSneaking()) {
		    colourR = 0.1F;
		    colourG = 1F;
		    colourB = 0.1F;
		    colourA = 1F;
		}

		if (!world.getBlockState(block.offset(mc.objectMouseOver.sideHit)).getBlock().isReplaceable(world,
			block.offset(mc.objectMouseOver.sideHit))) {
		    GlStateManager.disableDepth();
		    colourR = 0.2F;
		    colourG = 0.2F;
		    colourB = 0.2F;
		    colourA = 0.2F;
		}

		buffer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		tessellator.draw();
		buffer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		tessellator.draw();
		buffer.begin(1, DefaultVertexFormats.POSITION_COLOR);
		buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		buffer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ)
			.color(colourR, colourG, colourB, colourA).endVertex();
		tessellator.draw();

		if (!world.getBlockState(block.offset(mc.objectMouseOver.sideHit)).getBlock().isReplaceable(world,
			block.offset(mc.objectMouseOver.sideHit))) {
		    GlStateManager.enableDepth();
		}
	    }

	    GlStateManager.enableTexture2D();
	    GlStateManager.disableBlend();
	}

    }

}