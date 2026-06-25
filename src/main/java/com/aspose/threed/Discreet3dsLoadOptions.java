package com.aspose.threed;

/**
 * Load options for 3DS file.
 */
public class Discreet3dsLoadOptions extends LoadOptions {
    private boolean gammaCorrectedColor = false;
    private boolean flipCoordinateSystem = false;
    private boolean applyAnimationTransform = false;

    /**
     * Constructor of Discreet3dsLoadOptions.
     */
    public Discreet3dsLoadOptions() {
    }

    /**
     * A 3ds file may contains original color and gamma corrected color for same attribute,
     * Setting this to true will use the gamma corrected color if possible,
     * otherwise the Aspose.3D will try to use the original color.
     * @return true if use gamma corrected color.
     */
    public boolean getGammaCorrectedColor() {
        return gammaCorrectedColor;
    }

    /**
     * A 3ds file may contains original color and gamma corrected color for same attribute,
     * Setting this to true will use the gamma corrected color if possible,
     * otherwise the Aspose.3D will try to use the original color.
     * @param value New value.
     */
    public void setGammaCorrectedColor(boolean value) {
        this.gammaCorrectedColor = value;
    }

    /**
     * Gets flip coordinate system of control points/normal during importing/exporting.
     * @return true if flip coordinate system.
     */
    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    /**
     * Sets flip coordinate system of control points/normal during importing/exporting.
     * @param value New value.
     */
    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    /**
     * Gets whether to use the transformation defined in the first frame of animation track.
     * @return true if use animation transform.
     */
    public boolean getApplyAnimationTransform() {
        return applyAnimationTransform;
    }

    /**
     * Sets whether to use the transformation defined in the first frame of animation track.
     * @param value New value.
     */
    public void setApplyAnimationTransform(boolean value) {
        this.applyAnimationTransform = value;
    }
}
