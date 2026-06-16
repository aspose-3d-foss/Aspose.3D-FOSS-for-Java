package com.aspose.threed;

import java.io.Serializable;

public final class FMatrix4 implements Serializable {
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

    public FMatrix4 concatenate(FMatrix4 m2) {
        return this.mul(m2);
    }

    public FMatrix4 transpose() {
        return new FMatrix4(
            m00, m10, m20, m30,
            m01, m11, m21, m31,
            m02, m12, m22, m32,
            m03, m13, m23, m33
        );
    }

    public FMatrix4 inverse() {
        return getIdentity();
    }

    public FMatrix4 mul(FMatrix4 right) {
        return new FMatrix4(
            m00 * right.m00 + m01 * right.m10 + m02 * right.m20 + m03 * right.m30,
            m00 * right.m01 + m01 * right.m11 + m02 * right.m21 + m03 * right.m31,
            m00 * right.m02 + m01 * right.m12 + m02 * right.m22 + m03 * right.m32,
            m00 * right.m03 + m01 * right.m13 + m02 * right.m23 + m03 * right.m33,

            m10 * right.m00 + m11 * right.m10 + m12 * right.m20 + m13 * right.m30,
            m10 * right.m01 + m11 * right.m11 + m12 * right.m21 + m13 * right.m31,
            m10 * right.m02 + m11 * right.m12 + m12 * right.m22 + m13 * right.m32,
            m10 * right.m03 + m11 * right.m13 + m12 * right.m23 + m13 * right.m33,

            m20 * right.m00 + m21 * right.m10 + m22 * right.m20 + m23 * right.m30,
            m20 * right.m01 + m21 * right.m11 + m22 * right.m21 + m23 * right.m31,
            m20 * right.m02 + m21 * right.m12 + m22 * right.m22 + m23 * right.m32,
            m20 * right.m03 + m21 * right.m13 + m22 * right.m23 + m23 * right.m33,

            m30 * right.m00 + m31 * right.m10 + m32 * right.m20 + m33 * right.m30,
            m30 * right.m01 + m31 * right.m11 + m32 * right.m21 + m33 * right.m31,
            m30 * right.m02 + m31 * right.m12 + m32 * right.m22 + m33 * right.m32,
            m30 * right.m03 + m31 * right.m13 + m32 * right.m23 + m33 * right.m33
        );
    }

    public static FMatrix4 mul(FMatrix4 lhs, float v) {
        return new FMatrix4(
            lhs.m00 * v, lhs.m01 * v, lhs.m02 * v, lhs.m03 * v,
            lhs.m10 * v, lhs.m11 * v, lhs.m12 * v, lhs.m13 * v,
            lhs.m20 * v, lhs.m21 * v, lhs.m22 * v, lhs.m23 * v,
            lhs.m30 * v, lhs.m31 * v, lhs.m32 * v, lhs.m33 * v
        );
    }

    public static boolean op_eq(FMatrix4 left, FMatrix4 right) {
        return left.equals(right);
    }

    public static boolean op_ne(FMatrix4 left, FMatrix4 right) {
        return !left.equals(right);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FMatrix4 other = (FMatrix4) obj;
        return m00 == other.m00 && m01 == other.m01 && m02 == other.m02 && m03 == other.m03 &&
               m10 == other.m10 && m11 == other.m11 && m12 == other.m12 && m13 == other.m13 &&
               m20 == other.m20 && m21 == other.m21 && m22 == other.m22 && m23 == other.m23 &&
               m30 == other.m30 && m31 == other.m31 && m32 == other.m32 && m33 == other.m33;
    }

    @Override
    public int hashCode() {
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

    public static FVector3 mul(FMatrix4 m, FVector3 v) {
        return new FVector3(
            m.m00 * v.x + m.m01 * v.y + m.m02 * v.z + m.m03,
            m.m10 * v.x + m.m11 * v.y + m.m12 * v.z + m.m13,
            m.m20 * v.x + m.m21 * v.y + m.m22 * v.z + m.m23
        );
    }
}