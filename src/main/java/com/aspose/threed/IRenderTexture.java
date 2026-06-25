package com.aspose.threed;

/**
 * A render texture interface for rendering operations.
 */
public interface IRenderTexture extends IRenderTarget {
    /**
     * Gets the list of texture units used as render targets.
     * @return the list of texture units.
     */
    java.util.List<ITextureUnit> getTargets();
    
    /**
     * Gets the depth texture for this render target.
     * @return the depth texture unit.
     */
    ITextureUnit getDepthTexture();
}
