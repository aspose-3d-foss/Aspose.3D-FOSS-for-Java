package com.aspose.threed;

/**
 * Filter options during texture sampling.
 */
public enum TextureFilter {
    /**
     * No minification, this is only used by minification filter.
     */
    NONE,
    /**
     * Use point sampling
     */
    POINT,
    /**
     * Use linear interpolation for sampling
     */
    LINEAR,
    /**
     * Use anisotropic interpolation for sampling, this is only used by minification filter.
     */
    ANISOTROPIC;
}
