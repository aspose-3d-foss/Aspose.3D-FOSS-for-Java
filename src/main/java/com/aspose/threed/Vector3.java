package com.aspose.threed;

import java.io.Serializable;

public final class Vector3 implements Struct<Vector3>, Serializable, Comparable<Vector3> {
    public double x;
    public double y;
    public double z;

    public Vector3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(double val) {
        this.x = val;
        this.y = val;
        this.z = val;
    }

    public Vector3(FVector3 fv3) {
        this.x = fv3.x;
        this.y = fv3.y;
        this.z = fv3.z;
    }

    public Vector3(Vector4 v4) {
        this.x = v4.x;
        this.y = v4.y;
        this.z = v4.z;
    }

    public static Vector3 getZero() {
        return new Vector3(0, 0, 0);
    }

    public static Vector3 getOne() {
        return new Vector3(1, 1, 1);
    }

    public static Vector3 getUnitX() {
        return new Vector3(1, 0, 0);
    }

    public static Vector3 getUnitY() {
        return new Vector3(0, 1, 0);
    }

    public static Vector3 getUnitZ() {
        return new Vector3(0, 0, 1);
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public final double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public final double getLength2() {
        return x * x + y * y + z * z;
    }

    public final Vector3 normalize() {
        double len = getLength();
        if (len > 0) {
            x /= len;
            y /= len;
            z /= len;
        }
        return this;
    }

    public final double dot(Vector3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public final Vector3 cross(Vector3 v) {
        return new Vector3(
            y * v.z - z * v.y,
            z * v.x - x * v.z,
            x * v.y - y * v.x
        );
    }

    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public static Vector3 sub(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public static Vector3 mul(Vector3 a, Vector3 b) {
        return new Vector3(a.x * b.x, a.y * b.y, a.z * b.z);
    }

    public static Vector3 mul(Vector3 v, double s) {
        return new Vector3(v.x * s, v.y * s, v.z * s);
    }

    public static Vector3 mul(double s, Vector3 v) {
        return new Vector3(v.x * s, v.y * s, v.z * s);
    }

    public static Vector3 div(Vector3 v, double s) {
        return new Vector3(v.x / s, v.y / s, v.z / s);
    }

    public static Vector3 div(Vector3 a, Vector3 b) {
        return new Vector3(a.x / b.x, a.y / b.y, a.z / b.z);
    }

    public static Vector3 negative(Vector3 v) {
        return new Vector3(-v.x, -v.y, -v.z);
    }

    public static boolean op_eq(Vector3 a, Vector3 b) {
        return a.equals(b);
    }

    public static boolean op_ne(Vector3 a, Vector3 b) {
        return !a.equals(b);
    }

    public final double get(int index) {
        return switch (index) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new IndexOutOfBoundsException();
        };
    }

    public final void set(int index, double value) {
        switch (index) {
            case 0 -> x = value;
            case 1 -> y = value;
            case 2 -> z = value;
            default -> throw new IndexOutOfBoundsException();
        };
    }

    public final double angleBetween(Vector3 a, Vector3 b) {
        double dot = a.dot(b);
        double len = a.getLength() * b.getLength();
        if (len > 0) {
            return Math.acos(Math.max(-1, Math.min(1, dot / len)));
        }
        return 0;
    }

    public final double angleBetween(Vector3 v) {
        return angleBetween(this, v);
    }

    public static FVector3 create(Vector3 v) {
        return new FVector3((float) v.x, (float) v.y, (float) v.z);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Vector3 other) {
            return x == other.x && y == other.y && z == other.z;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        long bits = Double.doubleToLongBits(x);
        bits += Double.doubleToLongBits(y) * 31;
        bits += Double.doubleToLongBits(z) * 37;
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public final String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public final Vector3 clone() {
        try {
            return (Vector3) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Vector3(x, y, z);
        }
    }

    @Override
    public final void copyFrom(Vector3 src) {
        this.x = src.x;
        this.y = src.y;
        this.z = src.z;
    }

    @Override
    public int compareTo(Vector3 other) {
        int cmp = Double.compare(x, other.x);
        if (cmp != 0) return cmp;
        cmp = Double.compare(y, other.y);
        if (cmp != 0) return cmp;
        return Double.compare(z, other.z);
    }

    public final Vector3 sin() {
        return new Vector3(Math.sin(x), Math.sin(y), Math.sin(z));
    }

    public final Vector3 cos() {
        return new Vector3(Math.cos(x), Math.cos(y), Math.cos(z));
    }

    public static Vector3 parse(String s) {
        String[] parts = s.split("[,\\s()]+");
        double x = 0, y = 0, z = 0;
        if (parts.length >= 3) {
            x = Double.parseDouble(parts[0].trim());
            y = Double.parseDouble(parts[1].trim());
            z = Double.parseDouble(parts[2].trim());
        }
        return new Vector3(x, y, z);
    }
}
