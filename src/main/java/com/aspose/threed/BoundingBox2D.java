package com.aspose.threed;

import java.io.Serializable;

public class BoundingBox2D implements Serializable {
    private Vector2 minimum;
    private Vector2 maximum;
    private BoundingBoxExtent extent;

    public static final BoundingBox2D NULL = new BoundingBox2D(new Vector2(0, 0), new Vector2(0, 0));
    public static final BoundingBox2D INFINITE = new BoundingBox2D(
        new Vector2(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
        new Vector2(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
    );

    public BoundingBox2D() {
        this.minimum = new Vector2();
        this.maximum = new Vector2();
        this.extent = BoundingBoxExtent.Null;
    }

    public BoundingBox2D(Vector2 minimum, Vector2 maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.extent = BoundingBoxExtent.Finite;
    }

    public BoundingBoxExtent getExtent() {
        return extent;
    }

    public Vector2 getMinimum() {
        return minimum;
    }

    public Vector2 getMaximum() {
        return maximum;
    }

    public void merge(Vector2 pt) {
        if (extent == BoundingBoxExtent.Null) {
            minimum = pt;
            maximum = pt;
            extent = BoundingBoxExtent.Finite;
        } else {
            if (pt.x < minimum.x) minimum.x = pt.x;
            if (pt.y < minimum.y) minimum.y = pt.y;
            if (pt.x > maximum.x) maximum.x = pt.x;
            if (pt.y > maximum.y) maximum.y = pt.y;
        }
    }

    public void merge(BoundingBox2D bb) {
        if (bb.extent == BoundingBoxExtent.Null) {
            return;
        }

        if (extent == BoundingBoxExtent.Null) {
            minimum = bb.minimum;
            maximum = bb.maximum;
            extent = BoundingBoxExtent.Finite;
        } else {
            if (bb.minimum.x < minimum.x) minimum.x = bb.minimum.x;
            if (bb.minimum.y < minimum.y) minimum.y = bb.minimum.y;
            if (bb.maximum.x > maximum.x) maximum.x = bb.maximum.x;
            if (bb.maximum.y > maximum.y) maximum.y = bb.maximum.y;
        }
    }

    @Override
    public String toString() {
        return "Minimum: " + minimum + ", Maximum: " + maximum;
    }
}
