package me.jacky1356400.exchangers.handler;

import me.jacky1356400.exchangers.item.ItemExchanger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import static me.jacky1356400.exchangers.handler.ExchangerHandler.modeSwitchList;

public class GUIHandler extends Gui {

    private Minecraft mc;

    public GUIHandler(Minecraft mc) {
        super();
        this.mc = mc;
    }

    public static void drawExchangeMode(FontRenderer fontRenderer, int x, int y, String exchangeMode) {
        double scale = exchangeMode.length() > 2 ? 1 : 1;
        double swidth = fontRenderer.getStringWidth(exchangeMode) * scale;

        renderText(fontRenderer, (int) (x - 2 - swidth), y, scale, exchangeMode);
    }

    public static void renderText(FontRenderer fontRenderer, int x, int y, double scale, String text) {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, 0);
        GL11.glScaled(scale, scale, 1);
        fontRenderer.drawStringWithShadow(text, 0, 0, 0xFFFFFF);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    @SubscribeEvent
    public void onGameOverlayRender(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
        if (!(mc.getRenderViewEntity() instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) mc.getRenderViewEntity();

        if (player == null || !mc.inGameHasFocus || !Minecraft.isGuiEnabled()) return;
        if (player.getHeldItemMainhand() == null || !(player.getHeldItemMainhand().getItem() instanceof ItemExchanger))
            return;

        ItemStack stack = player.getHeldItemMainhand();

        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        int i = scaledresolution.getScaledWidth();
        int j = scaledresolution.getScaledHeight();
        int xOffset = i / 2;
        int yOffset = j / 2;

        net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();

        GL11.glDisable(32826);
        GL11.glDisable(GL11.GL_COLOR_MATERIAL);
        GL11.glDisable(GL11.GL_LIGHTING);

        if (stack.hasTagCompound()) {
            String exchangeMode = modeSwitchList[stack.getTagCompound().getInteger("mode")];
            drawExchangeMode(mc.fontRenderer, xOffset, yOffset - 4, exchangeMode);
        }

        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
    }
}