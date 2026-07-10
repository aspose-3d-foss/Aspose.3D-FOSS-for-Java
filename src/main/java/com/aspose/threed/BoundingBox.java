package com.aspose.threed;

import java.io.Serializable;

/**
 * The axis-aligned bounding box
 */
public final class BoundingBox implements Struct<BoundingBox>, Serializable {
    private Vector3 minimum;
    private Vector3 maximum;

    /**
     * The null bounding box
     */
    public static BoundingBox getNull() {
        return new BoundingBox(Vector3.getZero(), Vector3.getZero());
    }

    /**
     * The infinite bounding box
     */
    public static BoundingBox getInfinite() {
        return new BoundingBox(
            new Vector3(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
        );
    }

    /**
     * Initialize a finite bounding box with given minimum and maximum corner
     * @param minimum The minimum corner
     * @param maximum The maximum corner
     */
    public BoundingBox(Vector3 minimum, Vector3 maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    /**
     * Initializes a new instance of the BoundingBox.
     */
    public BoundingBox() {
        this.minimum = new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        this.maximum = new Vector3(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    /**
     * Initialize a finite bounding box with given minimum and maximum corner
     * @param minimum The minimum corner
     * @param maximum The maximum corner
     */
    public BoundingBox(FVector3 minimum, FVector3 maximum) {
        this.minimum = new Vector3(minimum.x, minimum.y, minimum.z);
        this.maximum = new Vector3(maximum.x, maximum.y, maximum.z);
    }

    /**
     * Initialize a finite bounding box with given minimum and maximum corner
     * @param minX The minimum corner's X
     * @param minY The minimum corner's Y
     * @param minZ The minimum corner's Z
     * @param maxX The maximum corner's X
     * @param maxY The maximum corner's Y
     * @param maxZ The maximum corner's Z
     */
    public BoundingBox(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        this.minimum = new Vector3(minX, minY, minZ);
        this.maximum = new Vector3(maxX, maxY, maxZ);
    }

    /**
     * Construct a bounding box from given geometry
     * @param geometry The geometry to calculate bounding box
     * @return The bounding box of given geometry
     */
    public static BoundingBox fromGeometry(Geometry geometry) {
        if (geometry == null)
            return getNull();

        var bbox = geometry.getBoundingBox();
        return bbox;
    }

    /**
     * Gets the extent of the bounding box.
     * @return the extent of the bounding box.
     */
    public final BoundingBoxExtent getExtent() {
        if (minimum.x == Double.NEGATIVE_INFINITY && minimum.y == Double.NEGATIVE_INFINITY && minimum.z == Double.NEGATIVE_INFINITY &&
            maximum.x == Double.POSITIVE_INFINITY && maximum.y == Double.POSITIVE_INFINITY && maximum.z == Double.POSITIVE_INFINITY) {
            return BoundingBoxExtent.INFINITE;
        }
        if (minimum.x == 0 && minimum.y == 0 && minimum.z == 0 &&
            maximum.x == 0 && maximum.y == 0 && maximum.z == 0) {
            return BoundingBoxExtent.NULL;
        }
        return BoundingBoxExtent.FINITE;
    }

    /**
     * The minimum corner of the bounding box
     * @return The minimum corner of the bounding box
     */
    public final Vector3 getMinimum() {
        return minimum;
    }

    /**
     * The maximum corner of the bounding box
     * @return The maximum corner of the bounding box
     */
    public final Vector3 getMaximum() {
        return maximum;
    }

    /**
     * Calculates the absolute largest coordinate value of any contained point.
     * @return the calculated absolute largest coordinate value of any contained point.
     */
    public final double scale() {
        Vector3 size = getSize();
        return Math.max(Math.abs(size.x), Math.max(Math.abs(size.y), Math.abs(size.z)));
    }

    /**
     * The size of the bounding box
     * @return The size of the bounding box
     */
    public final Vector3 getSize() {
        return Vector3.sub(maximum, minimum);
    }

    /**
     * The center of the bounding box.
     * @return The center of the bounding box.
     */
    public final Vector3 getCenter() {
        return Vector3.mul(Vector3.add(minimum, maximum), 0.5);
    }

    /**
     * Merge current bounding box with given point
     * @param pt The point to merge
     */
    public final void merge(Vector4 pt) {
        merge(new Vector3(pt.x / pt.w, pt.y / pt.w, pt.z / pt.w));
    }

    /**
     * Merge current bounding box with given point
     * @param pt The point to merge
     */
    public final void merge(Vector3 pt) {
        minimum = new Vector3(
            Math.min(minimum.x, pt.x),
            Math.min(minimum.y, pt.y),
            Math.min(minimum.z, pt.z));
        maximum = new Vector3(
            Math.max(maximum.x, pt.x),
            Math.max(maximum.y, pt.y),
            Math.max(maximum.z, pt.z));
    }

    /**
     * Merge current bounding box with given point
     * @param pt The point to merge
     */
    public final void merge(FVector3 pt) {
        merge(new Vector3(pt.x, pt.y, pt.z));
    }

    /**
     * Merge current bounding box with given point
     * @param x The point to be merged into the bounding box
     * @param y The point to be merged into the bounding box
     * @param z The point to be merged into the bounding box
     */
    public final void merge(double x, double y, double z) {
        merge(new Vector3(x, y, z));
    }

    /**
     * Merges the new box into the current bounding box.
     * @param bb The bounding box to merge
     */
    public final void merge(BoundingBox bb) {
        minimum = new Vector3(
            Math.min(minimum.x, bb.minimum.x),
            Math.min(minimum.y, bb.minimum.y),
            Math.min(minimum.z, bb.minimum.z));
        maximum = new Vector3(
            Math.max(maximum.x, bb.maximum.x),
            Math.max(maximum.y, bb.maximum.y),
            Math.max(maximum.z, bb.maximum.z));
    }

    /**
     * Operator overloading for multiply, new bounding box's minimum and maximum corner will be transformed by the matrix.
     * @param bbox The input bounding box.
     * @param mat The matrix used to transform the bounding box's corners
     * @return The product of bounding box and transform matrix.
     */
    public static BoundingBox mul(BoundingBox bbox, Matrix4 mat) {
        // Transform all 8 corners and compute new bounding box
        Vector3[] corners = new Vector3[] {
            new Vector3(bbox.minimum.x, bbox.minimum.y, bbox.minimum.z),
            new Vector3(bbox.maximum.x, bbox.minimum.y, bbox.minimum.z),
            new Vector3(bbox.minimum.x, bbox.maximum.y, bbox.minimum.z),
            new Vector3(bbox.maximum.x, bbox.maximum.y, bbox.minimum.z),
            new Vector3(bbox.minimum.x, bbox.minimum.y, bbox.maximum.z),
            new Vector3(bbox.maximum.x, bbox.minimum.y, bbox.maximum.z),
            new Vector3(bbox.minimum.x, bbox.maximum.y, bbox.maximum.z),
            new Vector3(bbox.maximum.x, bbox.maximum.y, bbox.maximum.z),
        };

        Vector3 min = new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Vector3 max = new Vector3(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

        for (Vector3 corner : corners) {
            Vector3 transformed = Matrix4.mul(mat, corner);
            min = new Vector3(
                Math.min(min.x, transformed.x),
                Math.min(min.y, transformed.y),
                Math.min(min.z, transformed.z));
            max = new Vector3(
                Math.max(max.x, transformed.x),
                Math.max(max.y, transformed.y),
                Math.max(max.z, transformed.z));
        }

        return new BoundingBox(min, max);
    }

    /**
     * Gets the string representation of the bounding box.
     * @return The string representation of the bounding box.
     */
    @Override
    public final String toString() {
        return "Minimum: " + minimum + ", Maximum: " + maximum;
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
        BoundingBox other = (BoundingBox) obj;
        return minimum.equals(other.minimum) && maximum.equals(other.maximum);
    }

    /**
     * Check if current bounding box overlaps with specified bounding box.
     * @param box The other bounding box to test
     * @return True if the current bounding box overlaps with the given one.
     */
    public final boolean overlapsWith(BoundingBox box) {
        return minimum.x <= box.maximum.x && maximum.x >= box.minimum.x &&
               minimum.y <= box.maximum.y && maximum.y >= box.minimum.y &&
               minimum.z <= box.maximum.z && maximum.z >= box.minimum.z;
    }

    /**
     * Check if the point p is inside the bounding box
     * @param p The point to test
     * @return True if the point is inside the bounding box
     */
    public final boolean contains(Vector3 p) {
        return p.x >= minimum.x && p.x <= maximum.x &&
               p.y >= minimum.y && p.y <= maximum.y &&
               p.z >= minimum.z && p.z <= maximum.z;
    }

    /**
     * The bounding box to check if it's inside current bounding box.
     * @param bbox The bounding box to check
     * @return True if the bounding box is inside current bounding box
     */
    public final boolean contains(BoundingBox bbox) {
        return minimum.x <= bbox.minimum.x && maximum.x >= bbox.maximum.x &&
               minimum.y <= bbox.minimum.y && maximum.y >= bbox.maximum.y &&
               minimum.z <= bbox.minimum.z && maximum.z >= bbox.maximum.z;
    }

    /**
     * Description copied from interface: Struct
     * @return cloned instance
     */
    @Override
    public final BoundingBox clone() {
        return new BoundingBox(minimum, maximum);
    }

    /**
     * Description copied from interface: Struct
     * @param src source instance to copy
     */
    public final void copyFrom(BoundingBox src) {
        this.minimum = src.minimum;
        this.maximum = src.maximum;
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
}
