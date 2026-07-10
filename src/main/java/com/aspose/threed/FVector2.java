package com.aspose.threed;

import java.io.Serializable;

public final class FVector2 implements Struct<FVector2>, Serializable, Comparable<FVector2> {
    public float x;
    public float y;

    public FVector2() {
        this.x = 0;
        this.y = 0;
    }

    public FVector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FVector2(FVector3 vec) {
        this.x = vec.x;
        this.y = vec.y;
    }

    public FVector2(Vector2 vec) {
        this.x = (float)vec.x;
        this.y = (float)vec.y;
    }

    public static Vector2 create(FVector2 v) {
        return new Vector2(v.x, v.y);
    }

    @Override
    public final int compareTo(FVector2 other) {
        int cmp = Float.compare(x, other.x);
        if (cmp != 0) return cmp;
        return Float.compare(y, other.y);
    }

    public final boolean equals(FVector2 rhs) {
        return x == rhs.x && y == rhs.y;
    }

    @Override
    public final boolean equals(Object obj) {
        return obj instanceof FVector2 other && equals(other);
    }

    @Override
    public final int hashCode() {
        int xl = Float.floatToIntBits(x);
        int yl = Float.floatToIntBits(y);
        return xl ^ yl;
    }

    @Override
    public final String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static FVector2 add(FVector2 a, FVector2 b) {
        return new FVector2(a.x + b.x, a.y + b.y);
    }

    public static FVector2 sub(FVector2 a, FVector2 b) {
        return new FVector2(a.x - b.x, a.y - b.y);
    }

    public static FVector2 mul(FVector2 a, float b) {
        return new FVector2(a.x * b, a.y * b);
    }

    public static boolean op_eq(FVector2 a, FVector2 b) {
        return a.equals(b);
    }

    public static boolean op_ne(FVector2 a, FVector2 b) {
        return !a.equals(b);
    }

    @Override
    public final FVector2 clone() {
        try {
            return (FVector2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final void copyFrom(FVector2 src) {
        this.x = src.x;
        this.y = src.y;
    }
}
