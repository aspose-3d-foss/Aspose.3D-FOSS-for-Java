package com.aspose.threed;

/**
 * Defines whether the texture contains the alpha channel.
 */
public enum AlphaSource {
    /**
     * No alpha is defined in the texture
     */
    NONE,
    
    /**
     * The alpha is defined by pixel's alpha channel
     */
    PIXEL_ALPHA,
    
    /**
     * The Alpha is a fixed value which is defined by TextureBase.getAlpha()
     */
    FIXED_VALUE;
}
