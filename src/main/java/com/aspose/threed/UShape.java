package com.aspose.threed;

/**
 * IFC compatible U-shape defined by parameters.
 */
public class UShape extends ParameterizedProfile {
    private double depth;
    private double flangeWidth;
    private double webThickness;
    private double flangeThickness;
    private double filletRadius;
    private double edgeRadius;
    private double webEdgeRadius;

    /**
     * Constructor of UShape.
     */
    public UShape() {
        this.depth = 2.0;
        this.flangeWidth = 2.0;
        this.webThickness = 1.0;
        this.flangeThickness = 1.0;
        this.filletRadius = 0.0;
        this.edgeRadius = 0.0;
        this.webEdgeRadius = 0.0;
    }

    /**
     * Gets the length of web.
     * @return the length of web.
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Sets the length of web.
     * @param value New value.
     */
    public void setDepth(double value) {
        this.depth = value;
    }

    /**
     * Gets the length of flange.
     * @return the length of flange.
     */
    public double getFlangeWidth() {
        return flangeWidth;
    }

    /**
     * Sets the length of flange.
     * @param value New value.
     */
    public void setFlangeWidth(double value) {
        this.flangeWidth = value;
    }

    /**
     * Gets the thickness of web.
     * @return the thickness of web.
     */
    public double getWebThickness() {
        return webThickness;
    }

    /**
     * Sets the thickness of web.
     * @param value New value.
     */
    public void setWebThickness(double value) {
        this.webThickness = value;
    }

    /**
     * Gets the thickness of flange.
     * @return the thickness of flange.
     */
    public double getFlangeThickness() {
        return flangeThickness;
    }

    /**
     * Sets the thickness of flange.
     * @param value New value.
     */
    public void setFlangeThickness(double value) {
        this.flangeThickness = value;
    }

    /**
     * Gets the radius of fillet between flange and web.
     * @return the radius of fillet between flange and web.
     */
    public double getFilletRadius() {
        return filletRadius;
    }

    /**
     * Sets the radius of fillet between flange and web.
     * @param value New value.
     */
    public void setFilletRadius(double value) {
        this.filletRadius = value;
    }

    /**
     * Gets the radius of edge in flange's edge.
     * @return the radius of edge in flange's edge.
     */
    public double getEdgeRadius() {
        return edgeRadius;
    }

    /**
     * Sets the radius of edge in flange's edge.
     * @param value New value.
     */
    public void setEdgeRadius(double value) {
        this.edgeRadius = value;
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
