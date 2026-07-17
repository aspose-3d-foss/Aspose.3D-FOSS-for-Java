package com.aspose.threed;

/**
 * IFC compatible hollow circle profile.
 */
public class HollowCircleShape extends CircleShape {
    private double wallThickness;

    /**
     * Constructs a HollowCircleShape profile with default values.
     */
    public HollowCircleShape() {
        this.wallThickness = 1.0;
    }

    /**
     * Gets the difference between the outer and inner radius.
     * @return the difference between the outer and inner radius.
     */
    public double getWallThickness() {
        return wallThickness;
    }

    /**
     * Sets the difference between the outer and inner radius.
     * @param value New value.
     */
    public void setWallThickness(double value) {
        this.wallThickness = value;
    }
}
