package com.aspose.threed;

import java.io.Serializable;

public final class Vector2 implements Serializable, Comparable<Vector2> {
    public double x;
    public double y;

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector3 vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    public Vector2(FVector2 vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    public double getU() {
        return x;
    }

    public void setU(double value) {
        this.x = value;
    }

    public double getV() {
        return y;
    }

    public void setV(double value) {
        this.y = value;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double dot(Vector2 rhs) {
        return x * rhs.x + y * rhs.y;
    }

    public boolean equals(Vector2 rhs) {
        return x == rhs.x && y == rhs.y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vector2 other && equals(other);
    }

    @Override
    public int hashCode() {
        long xl = Double.doubleToLongBits(x);
        long yl = Double.doubleToLongBits(y);
        return (int)(xl ^ (xl >>> 32) ^ yl ^ (yl >>> 32));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double cross(Vector2 v) {
        return x * v.y - y * v.x;
    }

    public Vector2 normalize() {
        double len = getLength();
        if (len > 0) {
            return new Vector2(x / len, y / len);
        }
        return new Vector2(0, 0);
    }

    public int compareTo(Vector2 other) {
        int cmp = Double.compare(x, other.x);
        if (cmp != 0) return cmp;
        return Double.compare(y, other.y);
    }

    public static Vector2 add(Vector2 lhs, Vector2 rhs) {
        return new Vector2(lhs.x + rhs.x, lhs.y + rhs.y);
    }

    public static Vector2 sub(Vector2 lhs, Vector2 rhs) {
        return new Vector2(lhs.x - rhs.x, lhs.y - rhs.y);
    }

    public static Vector2 div(Vector2 lhs, double rhs) {
        return new Vector2(lhs.x / rhs, lhs.y / rhs);
    }

    public static Vector2 mul(Vector2 lhs, double rhs) {
        return new Vector2(lhs.x * rhs, lhs.y * rhs);
    }

    public static Vector2 mul(double lhs, Vector2 rhs) {
        return new Vector2(lhs * rhs.x, lhs * rhs.y);
    }

    public static boolean op_eq(Vector2 lhs, Vector2 rhs) {
        return lhs.equals(rhs);
    }

    public static boolean op_ne(Vector2 lhs, Vector2 rhs) {
        return !lhs.equals(rhs);
    }
}
