package jackyy.exchangers.handler;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import jackyy.exchangers.client.RenderTypeExt;
import jackyy.exchangers.client.gui.ExchangersGuiScreen;
import jackyy.exchangers.client.keybind.Keys;
import jackyy.exchangers.handler.network.NetworkHandler;
import jackyy.exchangers.handler.network.packet.*;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.item.special.ItemCreativeExchanger;
import jackyy.gunpowderlib.helper.NBTHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class ClientEventsHandler {

    private static Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public void onGameOverlayRender(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.LAYER
                || !(mc.getCameraEntity() instanceof Player player)) {
            return;
        }
        if (!mc.isWindowActive() || !Minecraft.renderNames() || player.getMainHandItem().isEmpty()
                || !(player.getMainHandItem().getItem() instanceof ItemExchangerBase)) {
            return;
        }
        ItemStack stack = player.getMainHandItem();
        if (NBTHelper.hasTag(stack)) {
            Window mainWindow = mc.getWindow();
            int w = mainWindow.getGuiScaledWidth();
            int h = mainWindow.getGuiScaledHeight();
            PoseStack matrixStack = event.getMatrixStack();
            matrixStack.pushPose();
            RenderSystem.disableDepthTest();
            String exchangeRange = ExchangerHandler.rangeList[NBTHelper.getTag(stack).getInt("range")];
            float scale = exchangeRange.length() > 2 ? 1 : 1;
            float swidth = mc.font.width(exchangeRange) * scale;
            matrixStack.translate(((double) w / 2 - 2 - swidth), (double) h / 2 - 4, 0);
            matrixStack.scale(scale, scale, 1);
            mc.font.drawShadow(event.getMatrixStack(), exchangeRange, 0, 0, 0xFFFFFF);
            matrixStack.popPose();
            RenderSystem.enableDepthTest();
        }
    }

    @SubscribeEvent
    public void renderLevelStageEvent(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_TRIPWIRE_BLOCKS) {
            HitResult mouseOver = Minecraft.getInstance().hitResult;
            LocalPlayer player = mc.player;
            if (player != null && mouseOver instanceof BlockHitResult mouseOverBlock) {
                Level world = player.getLevel();
                BlockPos pos = mouseOverBlock.getBlockPos();
                BlockState state = world.getBlockState(pos);
                ItemStack stack = player.getMainHandItem();
                if (!stack.isEmpty() && stack.getItem() instanceof ItemExchangerBase && stack.getTag() != null && !state.isAir()) {
                    BlockState exState = NbtUtils.readBlockState(NBTHelper.getTag(stack).getCompound("blockstate"));
                    float blockHardness = state.getDestroySpeed(world, pos);
                    if (exState == state) {
                        return;
                    }
                    Set<BlockPos> blocks = ExchangerHandler.findSuitableBlocks(stack, player.getLevel(), player, mouseOverBlock.getDirection(), pos, state);
                    PoseStack matrixStack = event.getPoseStack();
                    MultiBufferSource.BufferSource bufferSource = mc.renderBuffers().bufferSource();
                    if ((player.isCrouching() && ((world.getBlockEntity(pos) != null && !ExchangerHandler.isWhitelisted(world, pos))
                            || ExchangerHandler.isBlacklisted(world, pos) || (!(stack.getItem() instanceof ItemCreativeExchanger) && blockHardness < -0.1f)))) {
                        renderExchangerRange(matrixStack, bufferSource, blocks, 1.0f, 0.1f, 0.1f, 1.0f);
                    } else if (player.isCrouching()) {
                        renderExchangerRange(matrixStack, bufferSource, blocks, 0.1f, 1.0f, 0.1f, 1.0f);
                    } else {
                        renderExchangerRange(matrixStack, bufferSource, blocks, 1.0f, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
        }
    }

    private void renderExchangerRange(PoseStack matrixStack, MultiBufferSource.BufferSource bufferSource, Set<BlockPos> blocks, float r, float g, float b, float a) {
        VertexConsumer builder = bufferSource.getBuffer(RenderTypeExt.BLOCK_OUTLINES);
        matrixStack.pushPose();
        Vec3 projectedView = mc.gameRenderer.getMainCamera().getPosition();
        matrixStack.translate(-projectedView.x, -projectedView.y, -projectedView.z);
        Matrix4f posMatrix = matrixStack.last().pose();
        for (BlockPos pos : blocks) {
            float x = pos.getX();
            float y = pos.getY();
            float z = pos.getZ();
            builder.vertex(posMatrix, x, y, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y + 1.0f, z).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x + 1.0f, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y, z + 1.0f).color(r, g, b, a).endVertex();
            builder.vertex(posMatrix, x, y + 1.0f, z + 1.0f).color(r, g, b, a).endVertex();
        }
        bufferSource.endBatch();
        matrixStack.popPose();
        RenderSystem.disableDepthTest();
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Player player = mc.player;
        if (player != null) {
            ItemStack heldItem = player.getMainHandItem();
            if (!heldItem.isEmpty() && heldItem.getItem() instanceof ItemExchangerBase) {
                if (Keys.OPEN_GUI_KEY.isDown()) {
                    mc.pushGuiLayer(new ExchangersGuiScreen());
                } else if (Keys.RANGE_SWITCH_KEY.isDown()) {
                    NetworkHandler.INSTANCE.sendToServer(new PacketSwitchRange());
                } else if (Keys.MODE_SWITCH_KEY.isDown()) {
                    NetworkHandler.INSTANCE.sendToServer(new PacketSwitchMode());
                } else if (Keys.FORCE_DROP_ITEMS_KEY.isDown()) {
                    NetworkHandler.INSTANCE.sendToServer(new PacketToggleForceDropItems());
                } else if (Keys.DIRECTIONAL_PLACEMENT_KEY.isDown()) {
                    NetworkHandler.INSTANCE.sendToServer(new PacketToggleDirectionalPlacement());
                } else if (Keys.FUZZY_PLACEMENT_KEY.isDown()) {
                    NetworkHandler.INSTANCE.sendToServer(new PacketToggleFuzzyPlacement());
                }
            }
        }
    }

}
