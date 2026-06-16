package com.aspose.threed;

import java.io.Serializable;

public class BoundingBox implements Serializable {
    private Vector3 minimum;
    private Vector3 maximum;

    public static final BoundingBox NULL = new BoundingBox(new Vector3(0, 0, 0), new Vector3(0, 0, 0));
    public static final BoundingBox INFINITE = new BoundingBox(
        new Vector3(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
        new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
    );

    public BoundingBox() {
        this.minimum = new Vector3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        this.maximum = new Vector3(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    public BoundingBox(Vector3 minimum, Vector3 maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public BoundingBox(FVector3 minimum, FVector3 maximum) {
        this.minimum = new Vector3(minimum.x, minimum.y, minimum.z);
        this.maximum = new Vector3(maximum.x, maximum.y, maximum.z);
    }

    public BoundingBox(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        this.minimum = new Vector3(minX, minY, minZ);
        this.maximum = new Vector3(maxX, maxY, maxZ);
    }

    public BoundingBoxExtent getExtent() {
        if (minimum.x == Double.NEGATIVE_INFINITY && minimum.y == Double.NEGATIVE_INFINITY && minimum.z == Double.NEGATIVE_INFINITY &&
            maximum.x == Double.POSITIVE_INFINITY && maximum.y == Double.POSITIVE_INFINITY && maximum.z == Double.POSITIVE_INFINITY) {
            return BoundingBoxExtent.Infinite;
        }
        if (minimum.x == 0 && minimum.y == 0 && minimum.z == 0 &&
            maximum.x == 0 && maximum.y == 0 && maximum.z == 0) {
            return BoundingBoxExtent.Null;
        }
        return BoundingBoxExtent.Finite;
    }

    public Vector3 getMinimum() {
        return minimum;
    }

    public Vector3 getMaximum() {
        return maximum;
    }

    public Vector3 getSize() {
        return Vector3.sub(maximum, minimum);
    }

    public Vector3 getCenter() {
        return Vector3.mul(Vector3.add(minimum, maximum), 0.5);
    }

    public double scale() {
        Vector3 size = getSize();
        return Math.max(Math.abs(size.x), Math.max(Math.abs(size.y), Math.abs(size.z)));
    }

    public void merge(Vector4 pt) {
        merge(new Vector3(pt.x / pt.w, pt.y / pt.w, pt.z / pt.w));
    }

    public void merge(Vector3 pt) {
        minimum.x = Math.min(minimum.x, pt.x);
        minimum.y = Math.min(minimum.y, pt.y);
        minimum.z = Math.min(minimum.z, pt.z);
        maximum.x = Math.max(maximum.x, pt.x);
        maximum.y = Math.max(maximum.y, pt.y);
        maximum.z = Math.max(maximum.z, pt.z);
    }

    public void merge(FVector3 pt) {
        merge(new Vector3(pt.x, pt.y, pt.z));
    }

    public void merge(double x, double y, double z) {
        merge(new Vector3(x, y, z));
    }

    public void merge(BoundingBox bb) {
        minimum.x = Math.min(minimum.x, bb.minimum.x);
        minimum.y = Math.min(minimum.y, bb.minimum.y);
        minimum.z = Math.min(minimum.z, bb.minimum.z);
        maximum.x = Math.max(maximum.x, bb.maximum.x);
        maximum.y = Math.max(maximum.y, bb.maximum.y);
        maximum.z = Math.max(maximum.z, bb.maximum.z);
    }

    public boolean overlapsWith(BoundingBox box) {
        return minimum.x <= box.maximum.x && maximum.x >= box.minimum.x &&
               minimum.y <= box.maximum.y && maximum.y >= box.minimum.y &&
               minimum.z <= box.maximum.z && maximum.z >= box.minimum.z;
    }

    public boolean contains(Vector3 p) {
        return p.x >= minimum.x && p.x <= maximum.x &&
               p.y >= minimum.y && p.y <= maximum.y &&
               p.z >= minimum.z && p.z <= maximum.z;
    }

    public boolean contains(BoundingBox bbox) {
        return minimum.x <= bbox.minimum.x && maximum.x >= bbox.maximum.x &&
               minimum.y <= bbox.minimum.y && maximum.y >= bbox.maximum.y &&
               minimum.z <= bbox.minimum.z && maximum.z >= bbox.maximum.z;
    }

    @Override
    public String toString() {
        return "Minimum: " + minimum + ", Maximum: " + maximum;
    }

    @Override
    public int hashCode() {
        int result = minimum.hashCode();
        result = 31 * result + maximum.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BoundingBox other = (BoundingBox) obj;
        return minimum.equals(other.minimum) && maximum.equals(other.maximum);
    }
}
