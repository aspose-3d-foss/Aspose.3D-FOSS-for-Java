package com.aspose.threed;

/**
 * IFC compatible L-shape profile that defined by parameters.
 */
public class LShape extends ParameterizedProfile {
    private double depth;
    private double width;
    private double thickness;
    private double filletRadius;
    private double edgeRadius;

    /**
     * Constructor of LShape.
     */
    public LShape() {
        this.depth = 2.0;
        this.width = 2.0;
        this.thickness = 1.0;
        this.filletRadius = 0.0;
        this.edgeRadius = 0.0;
    }

    /**
     * Gets the depth of the profile.
     * @return the depth of the profile.
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Sets the depth of the profile.
     * @param value New value.
     */
    public void setDepth(double value) {
        this.depth = value;
    }

    /**
     * Gets the width of the profile.
     * @return the width of the profile.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the profile.
     * @param value New value.
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets the thickness of the constant wall.
     * @return the thickness of the constant wall.
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Sets the thickness of the constant wall.
     * @param value New value.
     */
    public void setThickness(double value) {
        this.thickness = value;
    }

    /**
     * Gets the radius of the fillet.
     * @return the radius of the fillet.
     */
    public double getFilletRadius() {
        return filletRadius;
    }

    /**
     * Sets the radius of the fillet.
     * @param value New value.
     */
    public void setFilletRadius(double value) {
        this.filletRadius = value;
    }

    /**
     * Gets the radius of the edge.
     * @return the radius of the edge.
     */
    public double getEdgeRadius() {
        return edgeRadius;
    }

    /**
     * Sets the radius of the edge.
     * @param value New value.
     */
    public void setEdgeRadius(double value) {
        this.edgeRadius = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    @Override
    public Vector2 getExtent() {
        return new Vector2(width, depth);
    }
}
