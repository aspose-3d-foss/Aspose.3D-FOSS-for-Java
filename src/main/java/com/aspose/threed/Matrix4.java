package com.aspose.threed;

import java.io.Serializable;

public final class Matrix4 implements Struct<Matrix4>, Serializable {
    public double m00, m01, m02, m03;
    public double m10, m11, m12, m13;
    public double m20, m21, m22, m23;
    public double m30, m31, m32, m33;

    public Matrix4() {
        m00 = 1; m01 = 0; m02 = 0; m03 = 0;
        m10 = 0; m11 = 1; m12 = 0; m13 = 0;
        m20 = 0; m21 = 0; m22 = 1; m23 = 0;
        m30 = 0; m31 = 0; m32 = 0; m33 = 1;
    }

    public Matrix4(double m00, double m01, double m02, double m03,
                   double m10, double m11, double m12, double m13,
                   double m20, double m21, double m22, double m23,
                   double m30, double m31, double m32, double m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    public Matrix4(float[] values) {
        if (values.length >= 16) {
            m00 = values[0]; m01 = values[1]; m02 = values[2]; m03 = values[3];
            m10 = values[4]; m11 = values[5]; m12 = values[6]; m13 = values[7];
            m20 = values[8]; m21 = values[9]; m22 = values[10]; m23 = values[11];
            m30 = values[12]; m31 = values[13]; m32 = values[14]; m33 = values[15];
        }
    }

    public Matrix4(double[] values) {
        if (values.length >= 16) {
            m00 = values[0]; m01 = values[1]; m02 = values[2]; m03 = values[3];
            m10 = values[4]; m11 = values[5]; m12 = values[6]; m13 = values[7];
            m20 = values[8]; m21 = values[9]; m22 = values[10]; m23 = values[11];
            m30 = values[12]; m31 = values[13]; m32 = values[14]; m33 = values[15];
        }
    }

    public Matrix4(Vector4 r0, Vector4 r1, Vector4 r2, Vector4 r3) {
        this.m00 = r0.x; this.m01 = r0.y; this.m02 = r0.z; this.m03 = r0.w;
        this.m10 = r1.x; this.m11 = r1.y; this.m12 = r1.z; this.m13 = r1.w;
        this.m20 = r2.x; this.m21 = r2.y; this.m22 = r2.z; this.m23 = r2.w;
        this.m30 = r3.x; this.m31 = r3.y; this.m32 = r3.z; this.m33 = r3.w;
    }

    public static Matrix4 getIdentity() {
        return new Matrix4();
    }

    public static Matrix4 translate(Vector3 v) {
        Matrix4 m = getIdentity();
        m.m03 = v.x;
        m.m13 = v.y;
        m.m23 = v.z;
        return m;
    }

    public static Matrix4 translate(double x, double y, double z) {
        return translate(new Vector3(x, y, z));
    }

    public static Matrix4 scale(Vector3 v) {
        Matrix4 m = getIdentity();
        m.m00 = v.x;
        m.m11 = v.y;
        m.m22 = v.z;
        return m;
    }

    public static Matrix4 scale(double s) {
        return scale(new Vector3(s, s, s));
    }

    public static Matrix4 scale(double x, double y, double z) {
        return scale(new Vector3(x, y, z));
    }

    public static Matrix4 rotate(double angle, Vector3 axis) {
        return rotate(Quaternion.fromAngleAxis(angle, axis));
    }

    public static Matrix4 rotate(Quaternion q) {
        q = q.normalize();
        double x = q.x, y = q.y, z = q.z, w = q.w;
        double xx = x * x, yy = y * y, zz = z * z;
        double xy = x * y, xz = x * z, yz = y * z;
        double wx = w * x, wy = w * y, wz = w * z;

        Matrix4 m = getIdentity();
        m.m00 = 1 - 2 * (yy + zz);
        m.m10 = 2 * (xy - wz);
        m.m20 = 2 * (xz + wy);
        m.m01 = 2 * (xy + wz);
        m.m11 = 1 - 2 * (xx + zz);
        m.m21 = 2 * (yz - wx);
        m.m02 = 2 * (xz - wy);
        m.m12 = 2 * (yz + wx);
        m.m22 = 1 - 2 * (xx + yy);
        return m;
    }

    public static Matrix4 rotateFromEuler(Vector3 e) {         return rotateFromEuler(e.x, e.y, e.z);
     }

     public static Matrix4 rotateFromEuler(double x, double y, double z) {
         return rotate(Quaternion.fromEulerAngle(x, y, z));
     }
    public static Matrix4 mul(Matrix4 a, Matrix4 b) {
        return new Matrix4(
            a.m00 * b.m00 + a.m01 * b.m10 + a.m02 * b.m20 + a.m03 * b.m30,
            a.m00 * b.m01 + a.m01 * b.m11 + a.m02 * b.m21 + a.m03 * b.m31,
            a.m00 * b.m02 + a.m01 * b.m12 + a.m02 * b.m22 + a.m03 * b.m32,
            a.m00 * b.m03 + a.m01 * b.m13 + a.m02 * b.m23 + a.m03 * b.m33,
            a.m10 * b.m00 + a.m11 * b.m10 + a.m12 * b.m20 + a.m13 * b.m30,
            a.m10 * b.m01 + a.m11 * b.m11 + a.m12 * b.m21 + a.m13 * b.m31,
            a.m10 * b.m02 + a.m11 * b.m12 + a.m12 * b.m22 + a.m13 * b.m32,
            a.m10 * b.m03 + a.m11 * b.m13 + a.m12 * b.m23 + a.m13 * b.m33,
            a.m20 * b.m00 + a.m21 * b.m10 + a.m22 * b.m20 + a.m23 * b.m30,
            a.m20 * b.m01 + a.m21 * b.m11 + a.m22 * b.m21 + a.m23 * b.m31,
            a.m20 * b.m02 + a.m21 * b.m12 + a.m22 * b.m22 + a.m23 * b.m32,
            a.m20 * b.m03 + a.m21 * b.m13 + a.m22 * b.m23 + a.m23 * b.m33,
            a.m30 * b.m00 + a.m31 * b.m10 + a.m32 * b.m20 + a.m33 * b.m30,
            a.m30 * b.m01 + a.m31 * b.m11 + a.m32 * b.m21 + a.m33 * b.m31,
            a.m30 * b.m02 + a.m31 * b.m12 + a.m32 * b.m22 + a.m33 * b.m32,
            a.m30 * b.m03 + a.m31 * b.m13 + a.m32 * b.m23 + a.m33 * b.m33
        );
    }

    public static Matrix4 mul(Matrix4 m, double s) {
        return new Matrix4(
            m.m00 * s, m.m01 * s, m.m02 * s, m.m03 * s,
            m.m10 * s, m.m11 * s, m.m12 * s, m.m13 * s,
            m.m20 * s, m.m21 * s, m.m22 * s, m.m23 * s,
            m.m30 * s, m.m31 * s, m.m32 * s, m.m33 * s
        );
    }

    public static Vector3 mul(Matrix4 m, Vector3 v) {
        return new Vector3(
            m.m00 * v.x + m.m01 * v.y + m.m02 * v.z + m.m03,
            m.m10 * v.x + m.m11 * v.y + m.m12 * v.z + m.m13,
            m.m20 * v.x + m.m21 * v.y + m.m22 * v.z + m.m23
        );
    }

    public static FVector3 mul(Matrix4 m, FVector3 v) {
        return new FVector3(
            (float)(m.m00 * v.x + m.m01 * v.y + m.m02 * v.z + m.m03),
            (float)(m.m10 * v.x + m.m11 * v.y + m.m12 * v.z + m.m13),
            (float)(m.m20 * v.x + m.m21 * v.y + m.m22 * v.z + m.m23)
        );
    }

    public static Vector4 mul(Matrix4 m, Vector4 v) {
        return new Vector4(
            m.m00 * v.x + m.m01 * v.y + m.m02 * v.z + m.m03 * v.w,
            m.m10 * v.x + m.m11 * v.y + m.m12 * v.z + m.m13 * v.w,
            m.m20 * v.x + m.m21 * v.y + m.m22 * v.z + m.m23 * v.w,
            m.m30 * v.x + m.m31 * v.y + m.m32 * v.z + m.m33 * v.w
        );
    }

    public static FVector4 mul(Matrix4 m, FVector4 v) {
        return new FVector4(
            (float)(m.m00 * v.x + m.m01 * v.y + m.m02 * v.z + m.m03 * v.w),
            (float)(m.m10 * v.x + m.m11 * v.y + m.m12 * v.z + m.m13 * v.w),
            (float)(m.m20 * v.x + m.m21 * v.y + m.m22 * v.z + m.m23 * v.w),
            (float)(m.m30 * v.x + m.m31 * v.y + m.m32 * v.z + m.m33 * v.w)
        );
    }

    public final Matrix4 concatenate(Matrix4 m) {
        return mul(this, m);
    }

    public final Matrix4 transpose() {
        return new Matrix4(
            m00, m10, m20, m30,
            m01, m11, m21, m31,
            m02, m12, m22, m32,
            m03, m13, m23, m33
        );
    }

    public final double getDeterminant() {
        return m00 * (m11 * (m22 * m33 - m23 * m32) -
                      m12 * (m21 * m33 - m23 * m31) +
                      m13 * (m21 * m32 - m22 * m31)) -
               m01 * (m10 * (m22 * m33 - m23 * m32) -
                      m12 * (m20 * m33 - m23 * m30) +
                      m13 * (m20 * m32 - m22 * m30)) +
               m02 * (m10 * (m21 * m33 - m23 * m31) -
                      m11 * (m20 * m33 - m23 * m30) +
                      m13 * (m20 * m31 - m21 * m30)) -
               m03 * (m10 * (m21 * m32 - m22 * m31) -
                      m11 * (m20 * m32 - m22 * m30) +
                      m12 * (m20 * m31 - m21 * m30));
    }

    public final Matrix4 inverse() {
        double det = getDeterminant();
        if (Math.abs(det) < 1e-10) {
            return getIdentity();
        }

        double invDet = 1.0 / det;
        return new Matrix4(
            (m11 * (m22 * m33 - m23 * m32) - m12 * (m21 * m33 - m23 * m31) + m13 * (m21 * m32 - m22 * m31)) * invDet,
            (m02 * (m21 * m33 - m23 * m31) - m01 * (m22 * m33 - m23 * m32) + m03 * (m21 * m32 - m22 * m31)) * invDet,
            (m01 * (m12 * m33 - m13 * m32) - m02 * (m11 * m33 - m13 * m31) + m03 * (m11 * m32 - m12 * m31)) * invDet,
            (m02 * (m11 * m23 - m13 * m21) - m01 * (m12 * m23 - m13 * m22) + m03 * (m11 * m22 - m12 * m21)) * invDet,
            (m12 * (m20 * m33 - m23 * m30) - m10 * (m22 * m33 - m23 * m32) + m13 * (m20 * m32 - m22 * m30)) * invDet,
            (m00 * (m22 * m33 - m23 * m32) - m02 * (m20 * m33 - m23 * m30) + m03 * (m20 * m32 - m22 * m30)) * invDet,
            (m02 * (m10 * m33 - m13 * m30) - m00 * (m12 * m33 - m13 * m32) + m03 * (m10 * m32 - m12 * m30)) * invDet,
            (m00 * (m12 * m23 - m13 * m22) - m02 * (m10 * m23 - m13 * m20) + m03 * (m10 * m22 - m12 * m20)) * invDet,
            (m10 * (m21 * m32 - m22 * m31) - m11 * (m20 * m32 - m22 * m30) + m12 * (m20 * m31 - m21 * m30)) * invDet,
            (m01 * (m20 * m32 - m22 * m30) - m00 * (m21 * m32 - m22 * m31) + m02 * (m20 * m31 - m21 * m30)) * invDet,
            (m00 * (m11 * m32 - m12 * m31) - m01 * (m10 * m32 - m12 * m30) + m02 * (m10 * m31 - m11 * m30)) * invDet,
            (m01 * (m10 * m22 - m12 * m20) - m00 * (m11 * m22 - m12 * m21) + m02 * (m10 * m21 - m11 * m20)) * invDet,
            (m11 * (m20 * m23 - m21 * m33) - m10 * (m21 * m23 - m22 * m31) + m12 * (m20 * m31 - m21 * m30)) * invDet,
            (m00 * (m21 * m23 - m22 * m31) - m01 * (m20 * m23 - m22 * m30) + m02 * (m20 * m31 - m21 * m30)) * invDet,
            (m01 * (m10 * m23 - m12 * m30) - m00 * (m11 * m23 - m12 * m31) + m02 * (m10 * m31 - m11 * m30)) * invDet,
            (m00 * (m11 * m22 - m12 * m21) - m01 * (m10 * m22 - m12 * m20) + m02 * (m10 * m21 - m11 * m20)) * invDet
        );
    }

    public final Matrix4 normalize() {
        return this;
    }
     public final void setTRS(Vector3 translation, Vector3 rotation, Vector3 scale) {
         setTRS(translation, Quaternion.fromEulerAngle(rotation.x, rotation.y, rotation.z), scale);
     }
    public final void setTRS(Vector3 t, Quaternion r, Vector3 s) {
        Matrix4 tm = translate(t);
        Matrix4 rm = rotate(r);
        Matrix4 sm = scale(s);
        Matrix4 result = mul(mul(sm, rm), tm);
        this.m00 = result.m00; this.m01 = result.m01; this.m02 = result.m02; this.m03 = result.m03;
        this.m10 = result.m10; this.m11 = result.m11; this.m12 = result.m12; this.m13 = result.m13;
        this.m20 = result.m20; this.m21 = result.m21; this.m22 = result.m22; this.m23 = result.m23;
        this.m30 = result.m30; this.m31 = result.m31; this.m32 = result.m32; this.m33 = result.m33;
    }

    public final boolean decompose(Vector3 scale, Vector3 rotation, Quaternion q) {
        return false;
    }

    public final double[] toArray() {
        return new double[] {
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33
        };
    }

    @Override
    public final String toString() {
        return String.format("[[%f, %f, %f, %f], [%f, %f, %f, %f], [%f, %f, %f, %f], [%f, %f, %f, %f]]",
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33);
    }

    @Override
    public final Matrix4 clone() {
        try {
            return (Matrix4) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Matrix4(this);
        }
    }

    public Matrix4(Matrix4 other) {
        this.m00 = other.m00; this.m01 = other.m01; this.m02 = other.m02; this.m03 = other.m03;
        this.m10 = other.m10; this.m11 = other.m11; this.m12 = other.m12; this.m13 = other.m13;
        this.m20 = other.m20; this.m21 = other.m21; this.m22 = other.m22; this.m23 = other.m23;
        this.m30 = other.m30; this.m31 = other.m31; this.m32 = other.m32; this.m33 = other.m33;
    }

    @Override
    public final void copyFrom(Matrix4 src) {
        this.m00 = src.m00; this.m01 = src.m01; this.m02 = src.m02; this.m03 = src.m03;
        this.m10 = src.m10; this.m11 = src.m11; this.m12 = src.m12; this.m13 = src.m13;
        this.m20 = src.m20; this.m21 = src.m21; this.m22 = src.m22; this.m23 = src.m23;
        this.m30 = src.m30; this.m31 = src.m31; this.m32 = src.m32; this.m33 = src.m33;
    }

    @Override
    public final int hashCode() {
        long bits = Double.doubleToLongBits(m00);
        bits = bits * 31 + Double.doubleToLongBits(m01);
        bits = bits * 31 + Double.doubleToLongBits(m02);
        bits = bits * 31 + Double.doubleToLongBits(m03);
        bits = bits * 31 + Double.doubleToLongBits(m10);
        bits = bits * 31 + Double.doubleToLongBits(m11);
        bits = bits * 31 + Double.doubleToLongBits(m12);
        bits = bits * 31 + Double.doubleToLongBits(m13);
        bits = bits * 31 + Double.doubleToLongBits(m20);
        bits = bits * 31 + Double.doubleToLongBits(m21);
        bits = bits * 31 + Double.doubleToLongBits(m22);
        bits = bits * 31 + Double.doubleToLongBits(m23);
        bits = bits * 31 + Double.doubleToLongBits(m30);
        bits = bits * 31 + Double.doubleToLongBits(m31);
        bits = bits * 31 + Double.doubleToLongBits(m32);
        bits = bits * 31 + Double.doubleToLongBits(m33);
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof Matrix4 other) {
            return m00 == other.m00 && m01 == other.m01 && m02 == other.m02 && m03 == other.m03 &&
                   m10 == other.m10 && m11 == other.m11 && m12 == other.m12 && m13 == other.m13 &&
                   m20 == other.m20 && m21 == other.m21 && m22 == other.m22 && m23 == other.m23 &&
                   m30 == other.m30 && m31 == other.m31 && m32 == other.m32 && m33 == other.m33;
        }
        return false;
    }
}
