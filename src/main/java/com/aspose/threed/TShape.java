package com.aspose.threed;

/**
 * IFC compatible T-shape defined by parameters.
 */
public class TShape extends ParameterizedProfile {
    private double depth;
    private double flangeWidth;
    private double webThickness;
    private double flangeThickness;
    private double filletRadius;
    private double flangeEdgeRadius;
    private double webEdgeRadius;

    /**
     * Constructor of TShape.
     */
    public TShape() {
        this.depth = 2.0;
        this.flangeWidth = 2.0;
        this.webThickness = 1.0;
        this.flangeThickness = 1.0;
        this.filletRadius = 0.0;
        this.flangeEdgeRadius = 0.0;
        this.webEdgeRadius = 0.0;
    }

    /**
     * Gets the length of the web.
     * @return the length of the web.
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Sets the length of the web.
     * @param value New value.
     */
    public void setDepth(double value) {
        this.depth = value;
    }

    /**
     * Gets the length of the flange.
     * @return the length of the flange.
     */
    public double getFlangeWidth() {
        return flangeWidth;
    }

    /**
     * Sets the length of the flange.
     * @param value New value.
     */
    public void setFlangeWidth(double value) {
        this.flangeWidth = value;
    }

    /**
     * Gets the wall thickness of web.
     * @return the wall thickness of web.
     */
    public double getWebThickness() {
        return webThickness;
    }

    /**
     * Sets the wall thickness of web.
     * @param value New value.
     */
    public void setWebThickness(double value) {
        this.webThickness = value;
    }

    /**
     * Gets the wall thickness of flange.
     * @return the wall thickness of flange.
     */
    public double getFlangeThickness() {
        return flangeThickness;
    }

    /**
     * Sets the wall thickness of flange.
     * @param value New value.
     */
    public void setFlangeThickness(double value) {
        this.flangeThickness = value;
    }

    /**
     * Gets the radius of fillet between web and flange.
     * @return the radius of fillet between web and flange.
     */
    public double getFilletRadius() {
        return filletRadius;
    }

    /**
     * Sets the radius of fillet between web and flange.
     * @param value New value.
     */
    public void setFilletRadius(double value) {
        this.filletRadius = value;
    }

    /**
     * Gets the radius of the flange edge.
     * @return the radius of the flange edge.
     */
    public double getFlangeEdgeRadius() {
        return flangeEdgeRadius;
    }

    /**
     * Sets the radius of the flange edge.
     * @param value New value.
     */
    public void setFlangeEdgeRadius(double value) {
        this.flangeEdgeRadius = value;
    }

    /**
     * Gets the radius of web edge.
     * @return the radius of web edge.
     */
    public double getWebEdgeRadius() {
        return webEdgeRadius;
    }

    /**
     * Sets the radius of web edge.
     * @param value New value.
     */
    public void setWebEdgeRadius(double value) {
        this.webEdgeRadius = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    @Override
    public Vector2 getExtent() {
        return new Vector2(flangeWidth, depth);
    }
}
