package com.aspose.threed;

import java.io.Serializable;

/**
 * The axis-aligned bounding box for Vector2
 */
public final class BoundingBox2D implements Struct<BoundingBox2D>, Serializable {
    private Vector2 minimum;
    private Vector2 maximum;
    private BoundingBoxExtent extent;

    /**
     * The null bounding box
     */
    public static final BoundingBox2D NULL = createNull();

    /**
     * The infinite bounding box
     */
    public static final BoundingBox2D INFINITE = createInfinite();

    private static BoundingBox2D createNull() {
        BoundingBox2D box = new BoundingBox2D();
        box.minimum = new Vector2(0, 0);
        box.maximum = new Vector2(0, 0);
        box.extent = BoundingBoxExtent.NULL;
        return box;
    }

    private static BoundingBox2D createInfinite() {
        BoundingBox2D box = new BoundingBox2D();
        box.minimum = new Vector2(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        box.maximum = new Vector2(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.extent = BoundingBoxExtent.INFINITE;
        return box;
    }

    /**
     * Initializes a new instance of the BoundingBox2D class.
     */
    public BoundingBox2D() {
        this.minimum = new Vector2();
        this.maximum = new Vector2();
        this.extent = BoundingBoxExtent.NULL;
    }

    /**
     * Gets the extent of the bounding box.
     * @return the extent of the bounding box.
     */
    public final BoundingBoxExtent getExtent() {
        return extent;
    }

    /**
     * The minimum corner of the bounding box
     * @return The minimum corner of the bounding box
     */
    public final Vector2 getMinimum() {
        return minimum;
    }

    /**
     * The maximum corner of the bounding box
     * @return The maximum corner of the bounding box
     */
    public final Vector2 getMaximum() {
        return maximum;
    }

    /**
     * Merges the new box into the current bounding box.
     * @param pt The point to merge
     */
    public final void merge(Vector2 pt) {
        if (extent == BoundingBoxExtent.NULL) {
            minimum = pt;
            maximum = pt;
            extent = BoundingBoxExtent.FINITE;
        } else {
            if (pt.x < minimum.x) minimum.x = pt.x;
            if (pt.y < minimum.y) minimum.y = pt.y;
            if (pt.x > maximum.x) maximum.x = pt.x;
            if (pt.y > maximum.y) maximum.y = pt.y;
        }
    }

    /**
     * Merges the new box into the current bounding box.
     * @param bb The bounding box to merge
     */
    public final void merge(BoundingBox2D bb) {
        if (bb.extent == BoundingBoxExtent.NULL) {
            return;
        }

        if (extent == BoundingBoxExtent.NULL) {
            minimum = bb.minimum;
            maximum = bb.maximum;
            extent = BoundingBoxExtent.FINITE;
        } else {
            if (bb.minimum.x < minimum.x) minimum.x = bb.minimum.x;
            if (bb.minimum.y < minimum.y) minimum.y = bb.minimum.y;
            if (bb.maximum.x > maximum.x) maximum.x = bb.maximum.x;
            if (bb.maximum.y > maximum.y) maximum.y = bb.maximum.y;
        }
    }

    /**
     * Gets the string representation of the bounding box.
     */
    @Override
    public final String toString() {
        return "Minimum: " + minimum + ", Maximum: " + maximum;
    }

    /**
     * Clone current instance
     * @return cloned instance
     */
    @Override
    public final BoundingBox2D clone() {
        BoundingBox2D clone = new BoundingBox2D();
        clone.minimum = new Vector2(minimum.x, minimum.y);
        clone.maximum = new Vector2(maximum.x, maximum.y);
        clone.extent = extent;
        return clone;
    }

    /**
     * Copy internal state from argument t
     * @param t source instance to copy
     */
    public final void copyFrom(BoundingBox2D t) {
        if (t == null) {
            return;
        }
        this.minimum = new Vector2(t.minimum.x, t.minimum.y);
        this.maximum = new Vector2(t.maximum.x, t.maximum.y);
        this.extent = t.extent;
    }

    /**
     * Returns the hash code for this instance
     * @return The hash code of the bounding box
     */
    @Override
    public final int hashCode() {
        int result = minimum.hashCode();
        result = 31 * result + maximum.hashCode();
        return result;
    }

    /**
     * Determines if two objects are equal
     * @param obj The object to compare
     * @return true if two objects are equal
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BoundingBox2D other = (BoundingBox2D) obj;
        return minimum.equals(other.minimum) && maximum.equals(other.maximum);
    }
}
