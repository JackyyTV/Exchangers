package jackyy.exchangers.handler;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import jackyy.exchangers.client.CapeBufferDownload;
import jackyy.exchangers.client.Keys;
import jackyy.exchangers.handler.network.PacketHandler;
import jackyy.exchangers.handler.network.PacketToggleForceDropItemsMode;
import jackyy.exchangers.handler.network.PacketToggleMode;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@SideOnly(Side.CLIENT)
public class ClientEventsHandler {

    private static Minecraft mc = FMLClientHandler.instance().getClient();
    private static final String DEV_CAPE = "https://jackyytv.github.io/imgs/mc_mods/exchangers/capes/cape_dev.png";

    private Map<String, CapeBufferDownload> buffer = new HashMap<>();

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (mc.theWorld != null && mc.thePlayer != null && !mc.isGamePaused()) {
                for (EntityPlayer entityPlayer : mc.theWorld.playerEntities) {
                    if (entityPlayer instanceof AbstractClientPlayer) {
                        AbstractClientPlayer player = (AbstractClientPlayer) entityPlayer;
                        if (player.getUniqueID().equals(UUID.fromString("38de3769-70fa-441c-89e8-67280f3068a0"))) {
                            CapeBufferDownload download = buffer.get(player.getName());
                            if (download == null) {
                                download = new CapeBufferDownload(player.getName(), DEV_CAPE);
                                buffer.put(player.getName(), download);
                                download.start();
                            } else {
                                if (!download.downloaded) {
                                    continue;
                                }
                                setCape(player, download.getResourceLocation());
                            }
                        }
                    }
                }
            }
        }
    }

    private static void setCape(AbstractClientPlayer player, ResourceLocation cape) {
        NetworkPlayerInfo info = player.getPlayerInfo();
        if (info != null) {
            info.playerTextures.put(MinecraftProfileTexture.Type.CAPE, cape);
        }
    }

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

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keys.MODE_KEY.isPressed()) {
            PacketHandler.INSTANCE.sendToServer(new PacketToggleMode());
        }
        if (Keys.FORCE_DROP_ITEMS_KEY.isPressed()) {
            PacketHandler.INSTANCE.sendToServer(new PacketToggleForceDropItemsMode());
        }
    }

}
