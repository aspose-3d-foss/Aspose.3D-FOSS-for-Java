package com.aspose.threed;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Utilities to write matrix/vector to binary writer.
 */
public class IOExtension {
    private static class BinaryWriter extends DataOutputStream {
        public BinaryWriter() {
            super(new ByteArrayOutputStream());
        }

        public byte[] toByteArray() {
            return ((ByteArrayOutputStream) out).toByteArray();
        }
    }

    public static void write(BinaryWriter writer, Matrix4 mat) {
        try {
            writer.writeDouble(mat.m00);
            writer.writeDouble(mat.m01);
            writer.writeDouble(mat.m02);
            writer.writeDouble(mat.m03);
            writer.writeDouble(mat.m10);
            writer.writeDouble(mat.m11);
            writer.writeDouble(mat.m12);
            writer.writeDouble(mat.m13);
            writer.writeDouble(mat.m20);
            writer.writeDouble(mat.m21);
            writer.writeDouble(mat.m22);
            writer.writeDouble(mat.m23);
            writer.writeDouble(mat.m30);
            writer.writeDouble(mat.m31);
            writer.writeDouble(mat.m32);
            writer.writeDouble(mat.m33);
        } catch (IOException e) {
            // Should not happen with ByteArrayOutputStream
        }
    }

    public static void write(BinaryWriter writer, FMatrix4 mat) {
        try {
            writer.writeFloat(mat.m00);
            writer.writeFloat(mat.m01);
            writer.writeFloat(mat.m02);
            writer.writeFloat(mat.m03);
            writer.writeFloat(mat.m10);
            writer.writeFloat(mat.m11);
            writer.writeFloat(mat.m12);
            writer.writeFloat(mat.m02);
            writer.writeFloat(mat.m20);
            writer.writeFloat(mat.m10);
            writer.writeFloat(mat.m11);
            writer.writeFloat(mat.m12);
            writer.writeFloat(mat.m30);
            writer.writeFloat(mat.m20);
            writer.writeFloat(mat.m21);
            writer.writeFloat(mat.m22);
        } catch (IOException e) {
            // Should not happen with ByteArrayOutputStream
        }
    }

    public static void write(BinaryWriter writer, FVector2 v) {
        try {
            writer.writeFloat(v.x);
            writer.writeFloat(v.y);
        } catch (IOException e) {
        }
    }

    public static void write(BinaryWriter writer, FVector3 v) {
        try {
            writer.writeFloat(v.x);
            writer.writeFloat(v.y);
            writer.writeFloat(v.z);
        } catch (IOException e) {
        }
    }

    public static void write(BinaryWriter writer, FVector4 v) {
        try {
            writer.writeFloat(v.x);
            writer.writeFloat(v.y);
            writer.writeFloat(v.z);
            writer.writeFloat(v.w);
        } catch (IOException e) {
        }
    }

    public static void write(BinaryWriter writer, Vector2 v) {
        try {
            writer.writeFloat((float)v.x);
            writer.writeFloat((float)v.y);
        } catch (IOException e) {
        }
    }

    public static void write(BinaryWriter writer, Vector3 v) {
        try {
            writer.writeFloat((float)v.x);
            writer.writeFloat((float)v.y);
            writer.writeFloat((float)v.z);
        } catch (IOException e) {
        }
    }

    public static void write(BinaryWriter writer, Vector4 v) {
        try {
            writer.writeFloat((float)v.x);
            writer.writeFloat((float)v.y);
            writer.writeFloat((float)v.z);
            writer.writeFloat((float)v.w);
        } catch (IOException e) {
        }
    }
}
