package com.aspose.threed;

import java.io.Serializable;

public final class FMatrix4 implements Struct<FMatrix4>, Serializable {
    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    public FMatrix4() {
        m00 = 1; m01 = 0; m02 = 0; m03 = 0;
        m10 = 0; m11 = 1; m12 = 0; m13 = 0;
        m20 = 0; m21 = 0; m22 = 1; m23 = 0;
        m30 = 0; m31 = 0; m32 = 0; m33 = 1;
    }

    public FMatrix4(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    public FMatrix4(Matrix4 mat) {
        m00 = (float)mat.m00; m01 = (float)mat.m01; m02 = (float)mat.m02; m03 = (float)mat.m03;
        m10 = (float)mat.m10; m11 = (float)mat.m11; m12 = (float)mat.m12; m13 = (float)mat.m13;
        m20 = (float)mat.m20; m21 = (float)mat.m21; m22 = (float)mat.m22; m23 = (float)mat.m23;
        m30 = (float)mat.m30; m31 = (float)mat.m31; m32 = (float)mat.m32; m33 = (float)mat.m33;
    }

    public static FMatrix4 getIdentity() {
        return new FMatrix4(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
    }

    public final FMatrix4 concatenate(FMatrix4 m) {
        return FMatrix4.mul(this, m);
    }

    public final FMatrix4 concatenate(Matrix4 m) {
        FMatrix4 other = new FMatrix4(m);
        return FMatrix4.mul(this, other);
    }

    public final FMatrix4 transpose() {
        return new FMatrix4(
            m00, m10, m20, m30,
            m01, m11, m21, m31,
            m02, m12, m22, m32,
            m03, m13, m23, m33
        );
    }

    public final FMatrix4 inverse() {
        return getIdentity();
    }

    public static FMatrix4 mul(FMatrix4 lhs, float v) {
        return new FMatrix4(
            lhs.m00 * v, lhs.m01 * v, lhs.m02 * v, lhs.m03 * v,
            lhs.m10 * v, lhs.m11 * v, lhs.m12 * v, lhs.m13 * v,
            lhs.m20 * v, lhs.m21 * v, lhs.m22 * v, lhs.m23 * v,
            lhs.m30 * v, lhs.m31 * v, lhs.m32 * v, lhs.m33 * v
        );
    }

    public static FMatrix4 mul(FMatrix4 lhs, FMatrix4 rhs) {
        return new FMatrix4(
            lhs.m00 * rhs.m00 + lhs.m01 * rhs.m10 + lhs.m02 * rhs.m20 + lhs.m03 * rhs.m30,
            lhs.m00 * rhs.m01 + lhs.m01 * rhs.m11 + lhs.m02 * rhs.m21 + lhs.m03 * rhs.m31,
            lhs.m00 * rhs.m02 + lhs.m01 * rhs.m12 + lhs.m02 * rhs.m22 + lhs.m03 * rhs.m32,
            lhs.m00 * rhs.m03 + lhs.m01 * rhs.m13 + lhs.m02 * rhs.m23 + lhs.m03 * rhs.m33,

            lhs.m10 * rhs.m00 + lhs.m11 * rhs.m10 + lhs.m12 * rhs.m20 + lhs.m13 * rhs.m30,
            lhs.m10 * rhs.m01 + lhs.m11 * rhs.m11 + lhs.m12 * rhs.m21 + lhs.m13 * rhs.m31,
            lhs.m10 * rhs.m02 + lhs.m11 * rhs.m12 + lhs.m12 * rhs.m22 + lhs.m13 * rhs.m32,
            lhs.m10 * rhs.m03 + lhs.m11 * rhs.m13 + lhs.m12 * rhs.m23 + lhs.m13 * rhs.m33,

            lhs.m20 * rhs.m00 + lhs.m21 * rhs.m10 + lhs.m22 * rhs.m20 + lhs.m23 * rhs.m30,
            lhs.m20 * rhs.m01 + lhs.m21 * rhs.m11 + lhs.m22 * rhs.m21 + lhs.m23 * rhs.m31,
            lhs.m20 * rhs.m02 + lhs.m21 * rhs.m12 + lhs.m22 * rhs.m22 + lhs.m23 * rhs.m32,
            lhs.m20 * rhs.m03 + lhs.m21 * rhs.m13 + lhs.m22 * rhs.m23 + lhs.m23 * rhs.m33,

            lhs.m30 * rhs.m00 + lhs.m31 * rhs.m10 + lhs.m32 * rhs.m20 + lhs.m33 * rhs.m30,
            lhs.m30 * rhs.m01 + lhs.m31 * rhs.m11 + lhs.m32 * rhs.m21 + lhs.m33 * rhs.m31,
            lhs.m30 * rhs.m02 + lhs.m31 * rhs.m12 + lhs.m32 * rhs.m22 + lhs.m33 * rhs.m32,
            lhs.m30 * rhs.m03 + lhs.m31 * rhs.m13 + lhs.m32 * rhs.m23 + lhs.m33 * rhs.m33
        );
    }

    public static FVector3 mul(FMatrix4 m, FVector3 v) {
        return new FVector3(
            m.m00 * v.x + m.m01 * v.y + m.m02 * v.z + m.m03,
            m.m10 * v.x + m.m11 * v.y + m.m12 * v.z + m.m13,
            m.m20 * v.x + m.m21 * v.y + m.m22 * v.z + m.m23
        );
    }

    @Override
    public final FMatrix4 clone() {
        try {
            return (FMatrix4) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final void copyFrom(FMatrix4 other) {
        this.m00 = other.m00; this.m01 = other.m01; this.m02 = other.m02; this.m03 = other.m03;
        this.m10 = other.m10; this.m11 = other.m11; this.m12 = other.m12; this.m13 = other.m13;
        this.m20 = other.m20; this.m21 = other.m21; this.m22 = other.m22; this.m23 = other.m23;
        this.m30 = other.m30; this.m31 = other.m31; this.m32 = other.m32; this.m33 = other.m33;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FMatrix4 other = (FMatrix4) obj;
        return m00 == other.m00 && m01 == other.m01 && m02 == other.m02 && m03 == other.m03 &&
               m10 == other.m10 && m11 == other.m11 && m12 == other.m12 && m13 == other.m13 &&
               m20 == other.m20 && m21 == other.m21 && m22 == other.m22 && m23 == other.m23 &&
               m30 == other.m30 && m31 == other.m31 && m32 == other.m32 && m33 == other.m33;
    }

    @Override
    public final int hashCode() {
        int result = Float.floatToIntBits(m00);
        result = 31 * result + Float.floatToIntBits(m01);
        result = 31 * result + Float.floatToIntBits(m02);
        result = 31 * result + Float.floatToIntBits(m03);
        result = 31 * result + Float.floatToIntBits(m10);
        result = 31 * result + Float.floatToIntBits(m11);
        result = 31 * result + Float.floatToIntBits(m12);
        result = 31 * result + Float.floatToIntBits(m13);
        result = 31 * result + Float.floatToIntBits(m20);
        result = 31 * result + Float.floatToIntBits(m21);
        result = 31 * result + Float.floatToIntBits(m22);
        result = 31 * result + Float.floatToIntBits(m23);
        result = 31 * result + Float.floatToIntBits(m30);
        result = 31 * result + Float.floatToIntBits(m31);
        result = 31 * result + Float.floatToIntBits(m32);
        result = 31 * result + Float.floatToIntBits(m33);
        return result;
    }
}
