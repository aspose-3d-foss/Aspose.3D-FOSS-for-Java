package com.aspose.threed;

/**
 * A viewport for rendering operations.
 */
public class Viewport {
    private Frustum frustum;
    private boolean enabled = true;
    private IRenderTarget renderTarget;
    private RelativeRectangle area;
    private int zOrder = 0;
    private Vector3 backgroundColor = new Vector3(0, 0, 0);
    private float depthClear = 1.0f;

    /**
     * Constructor of Viewport.
     */
    public Viewport() {
    }

    /**
     * Gets the frustum for this viewport.
     * @return the frustum.
     */
    public Frustum getFrustum() {
        return frustum;
    }

    /**
     * Sets the frustum for this viewport.
     * @param value The frustum.
     */
    public void setFrustum(Frustum value) {
        this.frustum = value;
    }

    /**
     * Gets whether this viewport is enabled.
     * @return true if enabled.
     */
    public boolean getEnabled() {
        return enabled;
    }

    /**
     * Sets whether this viewport is enabled.
     * @param value New value.
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the render target for this viewport.
     * @return the render target.
     */
    public IRenderTarget getRenderTarget() {
        return renderTarget;
    }

    /**
     * Gets the area of this viewport.
     * @return the area.
     */
    public RelativeRectangle getArea() {
        return area;
    }

    /**
     * Sets the area of this viewport.
     * @param value The area.
     */
    public void setArea(RelativeRectangle value) {
        this.area = value;
    }

    /**
     * Gets the Z order of this viewport.
     * @return the Z order.
     */
    public int getZOrder() {
        return zOrder;
    }

    /**
     * Sets the Z order of this viewport.
     * @param value The Z order.
     */
    public void setZOrder(int value) {
        this.zOrder = value;
    }

    /**
     * Gets the background color of this viewport.
     * @return the background color.
     */
    public Vector3 getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the background color of this viewport.
     * @param value The background color.
     */
    public void setBackgroundColor(Vector3 value) {
        this.backgroundColor = value;
    }

    /**
     * Gets the depth clear value.
     * @return the depth clear value.
     */
    public float getDepthClear() {
        return depthClear;
    }

    /**
     * Sets the depth clear value.
     * @param value The depth clear value.
     */
    public void setDepthClear(float value) {
        this.depthClear = value;
    }

    /**
     * Creates a copy of this viewport.
     * @return the cloned viewport.
     */
    public Viewport clone() {
        try {
            return (Viewport) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
