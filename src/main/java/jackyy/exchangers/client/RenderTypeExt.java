package jackyy.exchangers.client;

import jackyy.exchangers.util.Reference;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;

import java.util.OptionalDouble;

public class RenderTypeExt extends RenderType {

    public static final RenderType BLOCK_OUTLINES;

    public RenderTypeExt(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }

    static {
        BLOCK_OUTLINES = makeType(Reference.MODID + "_block_outlines", DefaultVertexFormats.POSITION_COLOR, 1, 256, State.getBuilder()
                .line(new LineState(OptionalDouble.of(4.0d))).layer(field_239235_M_).transparency(TRANSLUCENT_TRANSPARENCY)
                .texture(NO_TEXTURE).depthTest(DEPTH_ALWAYS).cull(CULL_DISABLED).lightmap(LIGHTMAP_DISABLED).writeMask(COLOR_WRITE)
                .build(false)
        );
    }


}
