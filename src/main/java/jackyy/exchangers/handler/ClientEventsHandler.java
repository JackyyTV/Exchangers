package jackyy.exchangers.handler;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import jackyy.exchangers.client.RenderTypeExt;
import jackyy.exchangers.client.gui.ExchangersGuiScreen;
import jackyy.exchangers.client.keybind.Keys;
import jackyy.exchangers.handler.network.NetworkHandler;
import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class ClientEventsHandler {

    private static Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public void onGameOverlayRender(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE
                || !(mc.getRenderViewEntity() instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity player = (PlayerEntity) mc.getRenderViewEntity();
        if (player == null || !mc.isGameFocused() || !Minecraft.isGuiEnabled() || player.getHeldItemMainhand().isEmpty()
                || !(player.getHeldItemMainhand().getItem() instanceof ItemExchangerBase)) {
            return;
        }
        ItemStack stack = player.getHeldItemMainhand();
        if (NBTHelper.hasTag(stack)) {
            MainWindow mainWindow = mc.getMainWindow();
            int w = mainWindow.getScaledWidth();
            int h = mainWindow.getScaledHeight();
            MatrixStack matrixStack = event.getMatrixStack();
            matrixStack.push();
            RenderSystem.disableDepthTest();
            String exchangeRange = ExchangerHandler.rangeList[NBTHelper.getTag(stack).getInt("range")];
            float scale = exchangeRange.length() > 2 ? 1 : 1;
            float swidth = mc.fontRenderer.getStringWidth(exchangeRange) * scale;
            matrixStack.translate(((double) w / 2 - 2 - swidth), (double) h / 2 - 4, 0);
            matrixStack.scale(scale, scale, 1);
            mc.fontRenderer.drawStringWithShadow(event.getMatrixStack(), exchangeRange, 0, 0, 0xFFFFFF);
            matrixStack.pop();
            RenderSystem.enableDepthTest();
        }
    }

    @SubscribeEvent @SuppressWarnings("deprecation")
    public void renderWorldLastEvent(RenderWorldLastEvent event) {
        RayTraceResult mouseOver = Minecraft.getInstance().objectMouseOver;
        ClientPlayerEntity player = mc.player;
        if (player != null && mouseOver instanceof BlockRayTraceResult) {
            World world = player.getEntityWorld();
            BlockRayTraceResult mouseOverBlock = (BlockRayTraceResult) mouseOver;
            BlockPos pos = mouseOverBlock.getPos();
            BlockState state = world.getBlockState(pos);
            ItemStack stack = player.getHeldItemMainhand();
            if (!stack.isEmpty() && stack.getItem() instanceof ItemExchangerBase && stack.getTag() != null && !state.isAir(world, pos) && (state.getFluidState() == Fluids.EMPTY.getDefaultState())) {
                BlockState exState = NBTUtil.readBlockState(NBTHelper.getTag(stack).getCompound("blockstate"));
                float blockHardness = state.getBlockHardness(world, pos);
                if (exState == state) {
                    return;
                }
                Set<BlockPos> blocks = ExchangerHandler.findSuitableBlocks(stack, player.getEntityWorld(), player, mouseOverBlock.getFace(), pos, state);
                MatrixStack matrixStack = event.getMatrixStack();
                IRenderTypeBuffer.Impl bufferSource = mc.getRenderTypeBuffers().getBufferSource();
                if ((player.isSneaking() && ((world.getTileEntity(pos) != null && !ExchangerHandler.isWhitelisted(world, pos))
                        || ExchangerHandler.isBlacklisted(world, pos) || (!(stack.getItem() instanceof ItemCreativeExchanger) && blockHardness < -0.1f)))) {
                    renderExchangerRange(matrixStack, bufferSource, blocks, 1.0f, 0.1f, 0.1f, 1.0f);
                } else if (player.isSneaking()) {
                    renderExchangerRange(matrixStack, bufferSource, blocks, 0.1f, 1.0f, 0.1f, 1.0f);
                } else {
                    renderExchangerRange(matrixStack, bufferSource, blocks, 1.0f, 1.0f, 1.0f, 1.0f);
                }
            }
        }
    }

    private void renderExchangerRange(MatrixStack matrixStack, IRenderTypeBuffer.Impl bufferSource, Set<BlockPos> blocks, float r, float g, float b, float a) {
        IVertexBuilder builder = bufferSource.getBuffer(RenderTypeExt.BLOCK_OUTLINES);
        matrixStack.push();
        Vector3d projectedView = mc.gameRenderer.getActiveRenderInfo().getProjectedView();
        matrixStack.translate(-projectedView.x, -projectedView.y, -projectedView.z);
        Matrix4f posMatrix = matrixStack.getLast().getMatrix();
        for (BlockPos pos : blocks) {
            float x = pos.getX();
            float y = pos.getY();
            float z = pos.getZ();
            builder.pos(posMatrix, x, y, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x + 1.0f, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.pos(posMatrix, x, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
        }
        matrixStack.pop();
        RenderSystem.disableDepthTest();
        bufferSource.finish(RenderTypeExt.BLOCK_OUTLINES);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        PlayerEntity player = mc.player;
        if (player != null) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                ExchangerHandler.setDefaultTagCompound(heldItem);
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

}
