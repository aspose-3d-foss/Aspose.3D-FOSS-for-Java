package com.aspose.threed;

import com.aspose.threed.A3DObject;
import com.aspose.threed.Vector2;
import com.aspose.threed.Vector3;

/**
 * Base class for all concrete textures.
 * Texture defines the look and feel of a geometry surface.
 */
public class TextureBase extends A3DObject {
    private double alpha = 1.0;
    private AlphaSource alphaSource = AlphaSource.None;
    private WrapMode wrapModeU = WrapMode.Wrap;
    private WrapMode wrapModeV = WrapMode.Wrap;
    private WrapMode wrapModeW = WrapMode.Wrap;
    private TextureFilter minFilter = TextureFilter.None;
    private TextureFilter magFilter = TextureFilter.None;
    private TextureFilter mipFilter = TextureFilter.None;
    private Vector3 uvRotation = new Vector3(0, 0, 0);
    private Vector2 uvScale = new Vector2(1, 1);
    private Vector2 uvTranslation = new Vector2(0, 0);

    /**
     * Initializes a new instance of the TextureBase class.
     */
    public TextureBase(String name) {
        super(name);
    }

    /**
     * Gets or sets the default alpha value of the texture.
     * This is valid when the AlphaSource is FixedValue.
     * Default value is 1.0, valid value range is between 0 and 1.
     */
    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Gets or sets whether the texture defines the alpha channel.
     * Default value is PixelAlpha.
     */
    public AlphaSource getAlphaSource() {
        return alphaSource;
    }

    public void setAlphaSource(AlphaSource alphaSource) {
        this.alphaSource = alphaSource;
    }

    /**
     * Gets or sets the texture wrap modes in U.
     */
    public WrapMode getWrapModeU() {
        return wrapModeU;
    }

    public void setWrapModeU(WrapMode wrapModeU) {
        this.wrapModeU = wrapModeU;
    }

    /**
     * Gets or sets the texture wrap modes in V.
     */
    public WrapMode getWrapModeV() {
        return wrapModeV;
    }

    public void setWrapModeV(WrapMode wrapModeV) {
        this.wrapModeV = wrapModeV;
    }

    /**
     * Gets or sets the texture wrap modes in W.
     */
    public WrapMode getWrapModeW() {
        return wrapModeW;
    }

    public void setWrapModeW(WrapMode wrapModeW) {
        this.wrapModeW = wrapModeW;
    }

    /**
     * Gets or sets the filter for minification.
     */
    public TextureFilter getMinFilter() {
        return minFilter;
    }

    public void setMinFilter(TextureFilter minFilter) {
        this.minFilter = minFilter;
    }

    /**
     * Gets or sets the filter for magnification.
     */
    public TextureFilter getMagFilter() {
        return magFilter;
    }

    public void setMagFilter(TextureFilter magFilter) {
        this.magFilter = magFilter;
    }

    /**
     * Gets or sets the filter for mip-level sampling.
     */
    public TextureFilter getMipFilter() {
        return mipFilter;
    }

    public void setMipFilter(TextureFilter mipFilter) {
        this.mipFilter = mipFilter;
    }

    /**
     * Gets or sets the rotation of the texture.
     */
    public Vector3 getUVRotation() {
        return uvRotation;
    }

    public void setUVRotation(Vector3 uvRotation) {
        this.uvRotation = uvRotation;
    }

    /**
     * Gets or sets the UV scale.
     */
    public Vector2 getUVScale() {
        return uvScale;
    }

    public void setUVScale(Vector2 uvScale) {
        this.uvScale = uvScale;
    }

    /**
     * Gets or sets the UV translation.
     */
    public Vector2 getUVTranslation() {
        return uvTranslation;
    }

    public void setUVTranslation(Vector2 uvTranslation) {
        this.uvTranslation = uvTranslation;
    }

    /**
     * Sets the UV translation.
     */
    public void setTranslation(double u, double v) {
        this.uvTranslation = new Vector2(u, v);
    }

    /**
     * Sets the UV scale.
     */
    public void setScale(double u, double v) {
        this.uvScale = new Vector2(u, v);
    }

    /**
     * Sets the UV rotation.
     */
    public void setRotation(double u, double v) {
        this.uvRotation = new Vector3(u, v, 0);
    }
}
