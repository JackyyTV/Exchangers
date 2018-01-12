package jackyy.exchangers.handler;

import jackyy.exchangers.item.ItemExchangerBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GUIHandler extends Gui {

    private Minecraft mc = Minecraft.getMinecraft();

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
                || player.getHeldItemMainhand() == null
                || !(player.getHeldItemMainhand().getItem() instanceof ItemExchangerBase))
            return;

        ItemStack stack = player.getHeldItemMainhand();

        if (stack.getTagCompound() != null) {
            ScaledResolution scaledresolution = new ScaledResolution(mc);
            int w = scaledresolution.getScaledWidth();
            int h = scaledresolution.getScaledHeight();

            GlStateManager.pushMatrix();
            GlStateManager.disableDepth();
            GlStateManager.disableRescaleNormal();

            String exchangeMode = ExchangerHandler.modeSwitchList[stack.getTagCompound().getInteger("mode")];
            double scale = exchangeMode.length() > 2 ? 1 : 1;
            double swidth = mc.fontRendererObj.getStringWidth(exchangeMode) * scale;
            GlStateManager.translate((w / 2 - 2 - swidth), h / 2 - 4, 0);
            GlStateManager.scale(scale, scale, 1);
            mc.fontRendererObj.drawStringWithShadow(exchangeMode, 0, 0, 0xFFFFFF);

            GlStateManager.enableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
        }
    }

}