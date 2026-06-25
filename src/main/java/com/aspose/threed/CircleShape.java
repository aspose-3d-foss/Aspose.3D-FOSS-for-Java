package com.aspose.threed;

/**
 * IFC compatible circle profile, which can be used to construct a mesh through LinearExtrusion.
 */
public class CircleShape extends ParameterizedProfile {
    private double radius;

    /**
     * Constructs a CircleShape profile with default radius (5).
     */
    public CircleShape() {
        this.radius = 5.0;
    }

    /**
     * Constructs a CircleShape profile with specified radius.
     * @param radius The radius of the circle.
     */
    public CircleShape(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     * @return the radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     * @param value New value.
     */
    public void setRadius(double value) {
        this.radius = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    @Override
    public Vector2 getExtent() {
        return new Vector2(radius * 2, radius * 2);
    }
}
