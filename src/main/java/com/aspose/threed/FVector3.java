package com.aspose.threed;

import java.io.Serializable;

public final class FVector3 implements Struct<FVector3>, Serializable, Comparable<FVector3> {
    public float x;
    public float y;
    public float z;

    public FVector3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public FVector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public FVector3(FVector2 xy, float z) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = z;
    }

    public FVector3(Vector3 vec) {
        this.x = (float)vec.x;
        this.y = (float)vec.y;
        this.z = (float)vec.z;
    }

    public FVector3(Vector4 vec) {
        this.x = (float)vec.x;
        this.y = (float)vec.y;
        this.z = (float)vec.z;
    }

    public FVector3(FVector4 vec) {
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
    }

    public static FVector3 getZero() {
        return new FVector3(0, 0, 0);
    }

    public static FVector3 getOne() {
        return new FVector3(1, 1, 1);
    }

    public static FVector3 getUnitX() {
        return new FVector3(1, 0, 0);
    }

    public static FVector3 getUnitY() {
        return new FVector3(0, 1, 0);
    }

    public static FVector3 getUnitZ() {
        return new FVector3(0, 0, 1);
    }

    public static Vector3 create(FVector3 v) {
        return new Vector3(v.x, v.y, v.z);
    }

    public static FVector3 parse(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length >= 3) {
            return new FVector3(Float.parseFloat(parts[0]), Float.parseFloat(parts[1]), Float.parseFloat(parts[2]));
        }
        return getZero();
    }

    @Override
    public final int compareTo(FVector3 other) {
        int cmp = Float.compare(x, other.x);
        if (cmp != 0) return cmp;
        cmp = Float.compare(y, other.y);
        if (cmp != 0) return cmp;
        return Float.compare(z, other.z);
    }

    public final float get(int component) {
        switch (component) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new IndexOutOfBoundsException("Component index must be 0, 1, or 2");
        }
    }

    public final void set(int component, float value) {
        switch (component) {
            case 0: x = value; break;
            case 1: y = value; break;
            case 2: z = value; break;
            default: throw new IndexOutOfBoundsException("Component index must be 0, 1, or 2");
        }
    }

    public final FVector3 normalize() {
        float len = (float)Math.sqrt(x * x + y * y + z * z);
        if (len > 0) {
            return new FVector3(x / len, y / len, z / len);
        }
        return getZero();
    }

    public final FVector3 cross(FVector3 other) {
        return new FVector3(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        );
    }

    public static FVector3 add(FVector3 a, FVector3 b) {
        return new FVector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public static FVector3 sub(FVector3 a, FVector3 b) {
        return new FVector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public static FVector3 mul(FVector3 a, float b) {
        return new FVector3(a.x * b, a.y * b, a.z * b);
    }

    public static FVector3 mul(float b, FVector3 a) {
        return new FVector3(a.x * b, a.y * b, a.z * b);
    }

    public static FVector3 div(FVector3 a, float b) {
        return new FVector3(a.x / b, a.y / b, a.z / b);
    }

    public static FVector3 negative(FVector3 a) {
        return new FVector3(-a.x, -a.y, -a.z);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FVector3 other = (FVector3) obj;
        return x == other.x && y == other.y && z == other.z;
    }

    @Override
    public final int hashCode() {
        int result = Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + Float.floatToIntBits(z);
        return result;
    }

    @Override
    public final String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public final FVector3 clone() {
        try {
            return (FVector3) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final void copyFrom(FVector3 src) {
        this.x = src.x;
        this.y = src.y;
        this.z = src.z;
    }
}
