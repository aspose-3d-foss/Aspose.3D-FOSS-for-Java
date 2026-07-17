package com.aspose.threed;

/**
 * Blend factor specify pixel arithmetic.
 */
public enum BlendFactor {
    /**
     * The blend factor is vec4(0)
     */
    ZERO,
    /**
     * The blend factor is vec4(1)
     */
    ONE,
    /**
     * The blend factor is src.rgba
     */
    SRC_COLOR,
    /**
     * The blend factor is vec4(1) - src.rgba
     */
    ONE_MINUS_SRC_COLOR,
    /**
     * The blend factor is dst.rgba
     */
    DST_COLOR,
    /**
     * The blend factor is vec4(1) - dst.rgba
     */
    ONE_MINUS_DST_COLOR,
    /**
     * The blend factor is vec4(src.a)
     */
    SRC_ALPHA,
    /**
     * The blend factor is vec4(1 - src.a)
     */
    ONE_MINUS_SRC_ALPHA,
    /**
     * The blend factor is vec4(dst.a)
     */
    DST_ALPHA,
    /**
     * The blend factor is vec4(1 - dst.a)
     */
    ONE_MINUS_DST_ALPHA,
    /**
     * The blend factor is c where c is specified in RenderState.getBlendColor()
     */
    CONSTANT_COLOR,
    /**
     * The blend factor is vec4(1) - c where c is specified in RenderState.getBlendColor()
     */
    ONE_MINUS_CONSTANT_COLOR,
    /**
     * The blend factor is vec4(c.a) where c is specified in RenderState.getBlendColor()
     */
    CONSTANT_ALPHA,
    /**
     * The blend factor is vec4(1 - c.a) where c is specified in RenderState.getBlendColor()
     */
    ONE_MINUS_CONSTANT_ALPHA,
    /**
     * The blend factor is min(src.a, 1 - dst.a)
     */
    SRC_ALPHA_SATURATE;
}
