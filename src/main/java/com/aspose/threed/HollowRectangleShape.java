package com.aspose.threed;

/**
 * IFC compatible hollow rectangular shape with both inner/outer rounding corners.
 */
public class HollowRectangleShape extends RectangleShape {
    private double wallThickness;
    private double innerFilletRadius;

    /**
     * Constructs a HollowRectangleShape profile with default values.
     */
    public HollowRectangleShape() {
        this.wallThickness = 1.0;
        this.innerFilletRadius = 0.0;
    }

    /**
     * Gets the thickness between the boundary of the rectangle and the inner hole.
     * @return the thickness between the boundary of the rectangle and the inner hole.
     */
    public double getWallThickness() {
        return wallThickness;
    }

    /**
     * Sets the thickness between the boundary of the rectangle and the inner hole.
     * @param value New value.
     */
    public void setWallThickness(double value) {
        this.wallThickness = value;
    }

    /**
     * Gets the inner fillet radius of the inner rectangle.
     * @return the inner fillet radius of the inner rectangle.
     */
    public double getInnerFilletRadius() {
        return innerFilletRadius;
    }

    /**
     * Sets the inner fillet radius of the inner rectangle.
     * @param value New value.
     */
    public void setInnerFilletRadius(double value) {
        this.innerFilletRadius = value;
    }
}
