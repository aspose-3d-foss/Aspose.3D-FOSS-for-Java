package com.aspose.threed;

/**
 * IFC compatible C-shape profile that defined by parameters.
 * The center position of the profile is in the center of the bounding box.
 */
public class CShape extends ParameterizedProfile {
    private double depth;
    private double width;
    private double girth;
    private double wallThickness;
    private double internalFilletRadius;

    /**
     * Constructor of CShape.
     */
    public CShape() {
        this.depth = 2.0;
        this.width = 2.0;
        this.girth = 1.0;
        this.wallThickness = 1.0;
        this.internalFilletRadius = 0.0;
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
     * Gets the length of girth.
     * @return the length of girth.
     */
    public double getGirth() {
        return girth;
    }

    /**
     * Sets the length of girth.
     * @param value New value.
     */
    public void setGirth(double value) {
        this.girth = value;
    }

    /**
     * Gets the thickness of the wall.
     * @return the thickness of the wall.
     */
    public double getWallThickness() {
        return wallThickness;
    }

    /**
     * Sets the thickness of the wall.
     * @param value New value.
     */
    public void setWallThickness(double value) {
        this.wallThickness = value;
    }

    /**
     * Gets the internal fillet radius.
     * @return the internal fillet radius.
     */
    public double getInternalFilletRadius() {
        return internalFilletRadius;
    }

    /**
     * Sets the internal fillet radius.
     * @param value New value.
     */
    public void setInternalFilletRadius(double value) {
        this.internalFilletRadius = value;
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
