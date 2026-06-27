package com.aspose.threed;

import java.io.Serializable;

/**
 * The end point to trim the curve, can be a parameter value or a Cartesian point.
 */
public final class EndPoint implements Serializable {
    private final Vector3 point;
    private final double value;
    private final boolean isCartesianPoint;

    /**
     * Default constructor.
     */
    public EndPoint() {
        this.point = Vector3.getZero();
        this.value = 0;
        this.isCartesianPoint = false;
    }

    /**
     * Construct a EndPoint from a Cartesian point.
     * @param point Point to construct
     */
    public EndPoint(Vector3 point) {
        this.point = point;
        this.value = 0;
        this.isCartesianPoint = true;
    }

    /**
     * Construct a EndPoint from a real parameter.
     * @param v The real number parameter for constructing an end point
     */
    public EndPoint(double v) {
        this.point = Vector3.getZero();
        this.value = v;
        this.isCartesianPoint = false;
    }

    /**
     * Create an end point measured in degree.
     * @param degree The value in degree
     * @return An end point constructed from degree
     */
    public static EndPoint fromDegree(double degree) {
        return new EndPoint(degree * Math.PI / 180.0);
    }

    /**
     * Create an end point measured in radian.
     * @param degree The value in radian
     * @return An end point constructed from radian
     */
    public static EndPoint fromRadian(double degree) {
        return new EndPoint(degree);
    }

    /**
     * Is the end point a Cartesian point?
     * @return Is the end point a Cartesian point?
     */
    public final boolean isCartesianPoint() {
        return isCartesianPoint;
    }

    /**
     * Gets the end point as Cartesian point, or thrown an exception.
     * @return the end point as Cartesian point, or thrown an exception.
     */
    public final Vector3 getAsPoint() {
        if (!isCartesianPoint) {
            throw new IllegalStateException("This end point is not a Cartesian point");
        }
        return point;
    }

    /**
     * Gets the end point as a real parameter, or throw an exception.
     * @return the end point as a real parameter, or throw an exception.
     */
    public final double getAsValue() {
        if (isCartesianPoint) {
            throw new IllegalStateException("This end point is not a parameter value");
        }
        return value;
    }

    /**
     * Returns a string representation of the current end point.
     */
    @Override
    public final String toString() {
        return isCartesianPoint ? "EndPoint(Point: " + point + ")" : "EndPoint(Value: " + value + ")";
    }

    @Override
    public final EndPoint clone() {
        try {
            return (EndPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Copy from another EndPoint.
     * @param src source EndPoint
     */
    public final void copyFrom(EndPoint src) {
        // This is a no-op since all fields are final and initialized in constructor
    }

    /**
     * Copy from another Object.
     * @param src source Object
     */
    public final void copyFrom(Object src) {
        if (src instanceof EndPoint) {
            // This is a no-op since all fields are final and initialized in constructor
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof EndPoint other) {
            return isCartesianPoint == other.isCartesianPoint
                    && value == other.value
                    && (isCartesianPoint ? point.equals(other.point) : true);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int result = point.hashCode();
        result = 31 * result + Double.hashCode(value);
        result = 31 * result + (isCartesianPoint ? 1 : 0);
        return result;
    }
}
