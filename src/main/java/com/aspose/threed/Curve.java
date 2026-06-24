package com.aspose.threed;

import com.aspose.threed.Vector3;

/**
 * The base class of all curve implementations.
 */
public abstract class Curve extends Entity {
    private Vector3 color = new Vector3(1, 1, 1);

    /**
     * Gets or sets the color of the line, default value is white(1, 1, 1).
     */
    public Vector3 getColor() {
        return color;
    }

    public void setColor(Vector3 color) {
        this.color = color;
    }

    /**
     * Protected constructor to allow derived classes to set name.
     * @param name The name of the curve.
     */
    protected Curve(String name) {
        super(name);
    }

    /**
     * Constructor.
     */
    public Curve() {
        this("Curve");
    }
}
