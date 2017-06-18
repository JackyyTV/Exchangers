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
import me.jacky1356400.exchangers.item.ItemExchangerBase;

public class GUIHandler extends Gui {

    private Minecraft mc;
    private ItemStack lastExchangeSource = null;
    private int lastExchangeSourceCount = 0;

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
        if (player.getHeldItemMainhand() == null || !(player.getHeldItemMainhand().getItem() instanceof ItemExchangerBase))  return;

        ItemStack exchangerStack = player.getHeldItemMainhand();
        ItemStack source = null;

        if (exchangerStack.hasTagCompound() && exchangerStack.getTagCompound().hasKey("BlockName")) {
            source = new ItemStack(Block.getBlockFromName(exchangerStack.getTagCompound().getString("BlockName")), 1,
                    exchangerStack.getTagCompound().getInteger("BlockData"));
        }

        if (source == null) return;

        if (player.inventory.inventoryChanged || this.lastExchangeSource == null || !source.isItemEqual(this.lastExchangeSource))
        {
            int quantity = 0;

            InventoryPlayer inv = player.inventory;

            for (int slot = 0; slot < inv.mainInventory.size(); slot++) {
                ItemStack is = inv.getStackInSlot(slot);
                if (is != null && is.isItemEqual(source)) quantity += is.getCount();
            }

            this.lastExchangeSourceCount = quantity;
            this.lastExchangeSource = source;
            player.inventory.inventoryChanged = false;
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

        mc.getRenderItem().renderItemAndEffectIntoGUI(this.lastExchangeSource, xOffset, yOffset);
        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();

        GL11.glDisable(32826);
        GL11.glDisable(GL11.GL_COLOR_MATERIAL);
        GL11.glDisable(GL11.GL_LIGHTING);

        String am = Integer.toString(this.lastExchangeSourceCount);
        if (!player.capabilities.isCreativeMode) drawItemQuantity(mc.fontRenderer, xOffset+1, yOffset+1 , am);
        else drawItemQuantity(mc.fontRenderer, xOffset+1, yOffset+1 , "Inf");

        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
    }

    public static void drawItemQuantity(FontRenderer fontRenderer, int x, int y, String quantity)
    {
        double scale = quantity.length() > 2 ? 0.5 : 1;
        double sheight = 8 * scale;
        double swidth = fontRenderer.getStringWidth(quantity) * scale;

        renderText(fontRenderer, (int) (x + 16 - swidth), (int) (y + 16 - sheight), scale, quantity);
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