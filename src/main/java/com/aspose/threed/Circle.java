package com.aspose.threed;

/**
 * A Circle curve consists of a set of points in the edge of the circle shape.
 */
public class Circle extends Curve {
    private double radius = 10;

    /**
     * The radius of the circle curve, default value is 10.
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor of Circle.
     */
    public Circle() {
        this.radius = 10;
    }
}
