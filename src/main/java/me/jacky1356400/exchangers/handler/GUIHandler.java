package me.jacky1356400.exchangers.handler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import static me.jacky1356400.exchangers.handler.ExchangerHandler.modeSwitchList;

public class GUIHandler extends Gui {

	private Minecraft mc;
	private ItemStack lastExchangeSource = ItemStack.EMPTY;
	private int lastExchangeSourceCount = 0;
	private static int timesChanged = 0;

	public GUIHandler(Minecraft mc)
	{
		super();
		this.mc = mc;
	}

	@SubscribeEvent
	public void onGameOverlayRender(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
		if (!(mc.getRenderViewEntity() instanceof EntityPlayer)) return;

		EntityPlayer player = (EntityPlayer) mc.getRenderViewEntity();

		if (player == null || !mc.inGameHasFocus || !Minecraft.isGuiEnabled()) return;
		if (player.getHeldItemMainhand() == null || !(player.getHeldItemMainhand().getItem() instanceof ExchangerHandler))  return;

		ItemStack exchangerStack = player.getHeldItemMainhand();
		ItemStack source = ItemStack.EMPTY;

		if (exchangerStack.hasTagCompound()){
			int stateID = exchangerStack.getTagCompound().getInteger("state");
			source = new ItemStack(Block.getStateById(stateID).getBlock(), 1, stateID >> 12 & 15);
		}

		if (source.isEmpty())
			return;

		if (player.inventory.getTimesChanged() > timesChanged || this.lastExchangeSource.isEmpty()
				|| !source.isItemEqual(this.lastExchangeSource)) {
			int quantity = 0;

			InventoryPlayer inv = player.inventory;

			for (int slot = 0; slot < inv.mainInventory.size(); slot++) {
				ItemStack is = inv.getStackInSlot(slot);
				if (is != null && is.isItemEqual(source))
					quantity += is.getCount();
			}

			this.lastExchangeSourceCount = quantity;
			this.lastExchangeSource = source;
			timesChanged = player.inventory.getTimesChanged();
		}

		ScaledResolution scaledresolution = new ScaledResolution(this.mc);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		int xOffset = i/2;
		int yOffset = j/2;

		net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();

		GL11.glEnable(32826 /* GL_RESCALE_NORMAL_EXT */);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glEnable(GL11.GL_LIGHTING);

		mc.getRenderItem().renderItemAndEffectIntoGUI(this.lastExchangeSource, xOffset+2, yOffset+2);
		net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();

		GL11.glDisable(32826);
		GL11.glDisable(GL11.GL_COLOR_MATERIAL);
		GL11.glDisable(GL11.GL_LIGHTING);

		String am = Integer.toString(this.lastExchangeSourceCount);
		if (!player.capabilities.isCreativeMode) drawItemQuantity(mc.fontRenderer, xOffset+4, yOffset+2 , am);
		else drawItemQuantity(mc.fontRenderer, xOffset+2, yOffset+1 , "Inf");
		String exchangeMode;
		exchangeMode = new String(modeSwitchList[exchangerStack.getTagCompound().getInteger("ExchangeMode")]);
		drawExchangeMode(mc.fontRenderer, xOffset+1, yOffset+2 , exchangeMode);

		net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
	}

	public static void drawItemQuantity(FontRenderer fontRenderer, int x, int y, String quantity)
	{
		double scale = quantity.length() > 2 ? 0.5 : 1;
		double sheight = 8 * scale;
		double swidth = fontRenderer.getStringWidth(quantity) * scale;

		renderText(fontRenderer, (int) (x + 16 - swidth), (int) (y + 16 - sheight), scale, quantity);
	}

	public static void drawExchangeMode(FontRenderer fontRenderer, int x, int y, String exchangeMode)
	{
		double scale = exchangeMode.length() > 2 ? 1 : 1;
		double sheight = 8 * scale;
		double swidth = fontRenderer.getStringWidth(exchangeMode) * scale;

		renderText(fontRenderer, (int) (x - 2 - swidth), (int) (y + 16 - sheight), scale, exchangeMode);
	}

	public static void renderText(FontRenderer fontRenderer, int x, int y, double scale, String text)
	{
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, 0);
		GL11.glScaled(scale, scale, 1);
		fontRenderer.drawStringWithShadow(text, 0, 0, 0xFFFFFF);
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}
}