package com.aspose.threed;

/**
 * IFC compatible rectangular shape with rounding corners.
 */
public class RectangleShape extends ParameterizedProfile {
    private double roundingRadius;
    private double xDim;
    private double yDim;

    /**
     * Constructor of RectangleShape.
     */
    public RectangleShape() {
        this.roundingRadius = 0.0;
        this.xDim = 2.0;
        this.yDim = 2.0;
    }

    /**
     * Gets the radius of the circular arcs of all four corners, measured in degrees.
     * Default value is 0.0.
     * @return the radius of the circular arcs of all four corners, measured in degrees.
     */
    public double getRoundingRadius() {
        return roundingRadius;
    }

    /**
     * Sets the radius of the circular arcs of all four corners, measured in degrees.
     * Default value is 0.0.
     * @param value New value.
     */
    public void setRoundingRadius(double value) {
        this.roundingRadius = value;
    }

    /**
     * Gets the extent of the rectangle in the direction of x-axis.
     * Default value is 2.0.
     * @return the extent of the rectangle in the direction of x-axis.
     */
    public double getXDim() {
        return xDim;
    }

    /**
     * Sets the extent of the rectangle in the direction of x-axis.
     * Default value is 2.0.
     * @param value New value.
     */
    public void setXDim(double value) {
        this.xDim = value;
    }

    /**
     * Gets the extent of the rectangle in the direction of y-axis.
     * Default value is 2.0.
     * @return the extent of the rectangle in the direction of y-axis.
     */
    public double getYDim() {
        return yDim;
    }

    /**
     * Sets the extent of the rectangle in the direction of y-axis.
     * Default value is 2.0.
     * @param value New value.
     */
    public void setYDim(double value) {
        this.yDim = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    @Override
    public Vector2 getExtent() {
        return new Vector2(xDim, yDim);
    }
}
