package com.aspose.threed;

public class BoundingBox {
    private final Vector3 minimum = new Vector3(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    private final Vector3 maximum = new Vector3(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);

    public BoundingBox() {
    }

    public BoundingBox(Vector3 minimum, Vector3 maximum) {
        this.minimum.x = minimum.x;
        this.minimum.y = minimum.y;
        this.minimum.z = minimum.z;
        this.maximum.x = maximum.x;
        this.maximum.y = maximum.y;
        this.maximum.z = maximum.z;
    }

    public Vector3 getMinimum() {
        return minimum;
    }

    public Vector3 getMaximum() {
        return maximum;
    }
}
