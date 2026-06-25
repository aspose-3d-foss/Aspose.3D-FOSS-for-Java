package com.aspose.threed;

/**
 * IFC compatible ellipse profile, which can be used to construct a mesh through LinearExtrusion.
 */
public class EllipseShape extends ParameterizedProfile {
    private double semiAxis1;
    private double semiAxis2;

    /**
     * Constructs an EllipseShape profile with default semi-axes.
     */
    public EllipseShape() {
        this.semiAxis1 = 5.0;
        this.semiAxis2 = 3.0;
    }

    /**
     * Constructs an EllipseShape profile with specified semi-axes.
     * @param semiAxis1 Radius on X-axis.
     * @param semiAxis2 Radius on Y-axis.
     */
    public EllipseShape(double semiAxis1, double semiAxis2) {
        this.semiAxis1 = semiAxis1;
        this.semiAxis2 = semiAxis2;
    }

    /**
     * Gets the radius on X-axis.
     * @return the semi-axis 1.
     */
    public double getSemiAxis1() {
        return semiAxis1;
    }

    /**
     * Sets the radius on X-axis.
     * @param value New value.
     */
    public void setSemiAxis1(double value) {
        this.semiAxis1 = value;
    }

    /**
     * Gets the radius on Y-axis.
     * @return the semi-axis 2.
     */
    public double getSemiAxis2() {
        return semiAxis2;
    }

    /**
     * Sets the radius on Y-axis.
     * @param value New value.
     */
    public void setSemiAxis2(double value) {
        this.semiAxis2 = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    @Override
    public Vector2 getExtent() {
        return new Vector2(semiAxis1 * 2, semiAxis2 * 2);
    }
}
