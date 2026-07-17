package com.aspose.threed;

/**
 * IFC compatible Trapezium shape defined by parameters.
 */
public class TrapeziumShape extends ParameterizedProfile {
    private double bottomXDim;
    private double topXDim;
    private double yDim;
    private double topXOffset;

    /**
     * Constructor of TrapeziumShape.
     */
    public TrapeziumShape() {
        this.bottomXDim = 2.0;
        this.topXDim = 2.0;
        this.yDim = 2.0;
        this.topXOffset = 0.0;
    }

    /**
     * Gets the extent of the bottom line measured along the x-axis.
     * @return the extent of the bottom line measured along the x-axis.
     */
    public double getBottomXDim() {
        return bottomXDim;
    }

    /**
     * Sets the extent of the bottom line measured along the x-axis.
     * @param value New value.
     */
    public void setBottomXDim(double value) {
        this.bottomXDim = value;
    }

    /**
     * Gets the extent of the top line measured along the x-axis.
     * @return the extent of the top line measured along the x-axis.
     */
    public double getTopXDim() {
        return topXDim;
    }

    /**
     * Sets the extent of the top line measured along the x-axis.
     * @param value New value.
     */
    public void setTopXDim(double value) {
        this.topXDim = value;
    }

    /**
     * Gets the distance between the top and bottom lines measured along the y-axis.
     * @return the distance between the top and bottom lines measured along the y-axis.
     */
    public double getYDim() {
        return yDim;
    }

    /**
     * Sets the distance between the top and bottom lines measured along the y-axis.
     * @param value New value.
     */
    public void setYDim(double value) {
        this.yDim = value;
    }

    /**
     * Gets the offset from the beginning of the top line to the bottom line.
     * @return the offset from the beginning of the top line to the bottom line.
     */
    public double getTopXOffset() {
        return topXOffset;
    }

    /**
     * Sets the offset from the beginning of the top line to the bottom line.
     * @param value New value.
     */
    public void setTopXOffset(double value) {
        this.topXOffset = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    @Override
    public Vector2 getExtent() {
        return new Vector2(Math.max(bottomXDim, topXDim), yDim);
    }
}
