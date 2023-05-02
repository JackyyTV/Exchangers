package jackyy.exchangers.client;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import jackyy.exchangers.util.Reference;
import net.minecraft.client.renderer.RenderType;

import java.util.OptionalDouble;

public class RenderTypeExt extends RenderType {

    public static final RenderType BLOCK_OUTLINES;

    public RenderTypeExt(String nameIn, VertexFormat formatIn, VertexFormat.Mode drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }

    static {
        BLOCK_OUTLINES = create(Reference.MODID + "_block_outlines", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.LINES, 256, false, false, RenderType.CompositeState.builder()
                .setShaderState(ShaderStateShard.RENDERTYPE_LINES_SHADER).setLineState(new LineStateShard(OptionalDouble.of(4.0d))).setLayeringState(NO_LAYERING).setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setTextureState(NO_TEXTURE).setDepthTestState(NO_DEPTH_TEST).setCullState(NO_CULL).setLightmapState(NO_LIGHTMAP).setWriteMaskState(COLOR_WRITE)
                .createCompositeState(false)
        );
    }

}
