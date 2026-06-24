package com.aspose.threed;

/**
 * An Ellipse defines a set of points that form the shape of ellipse.
 */
public class Ellipse extends Curve {
    private double semiAxis1 = 10.0;
    private double semiAxis2 = 10.0;

    /**
     * Radius on X-axis.
     */
    public double getSemiAxis1() {
        return semiAxis1;
    }

    public void setSemiAxis1(double value) {
        this.semiAxis1 = value;
    }

    /**
     * Radius on Y-axis.
     */
    public double getSemiAxis2() {
        return semiAxis2;
    }

    public void setSemiAxis2(double value) {
        this.semiAxis2 = value;
    }

    /**
     * Constructor of Ellipse.
     */
    public Ellipse() {
        this.semiAxis1 = 10.0;
        this.semiAxis2 = 10.0;
    }
}
