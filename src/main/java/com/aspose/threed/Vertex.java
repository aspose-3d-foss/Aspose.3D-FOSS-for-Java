package com.aspose.threed;

import java.io.Serializable;

/**
 * Vertex reference, used to access the raw vertex in TriMesh.
 */
public abstract class Vertex implements Comparable<Vertex> {
    public Vertex() {
    }

    /**
     * Compare the vertex with another vertex instance
     * @param other Another vertex to compare
     * @return 0 if equal, negative if less than, positive if greater than
     */
    public int compareTo(Vertex other) {
        return System.identityHashCode(this) - System.identityHashCode(other);
    }

    /**
     * Read the vector4 field
     * @param field The field with a Vector4/FVector4 data type
     * @return The vector4 value
     */
    public Vector4 readVector4(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the vector4 field
     * @param field The field with a Vector4/FVector4 data type
     * @return The FVector4 value
     */
    public FVector4 readFVector4(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the vector3 field
     * @param field The field with a Vector3/FVector3 data type
     * @return The vector3 value
     */
    public Vector3 readVector3(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the vector3 field
     * @param field The field with a Vector3/FVector3 data type
     * @return The FVector3 value
     */
    public FVector3 readFVector3(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the vector2 field
     * @param field The field with a Vector2/FVector2 data type
     * @return The vector2 value
     */
    public Vector2 readVector2(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the vector2 field
     * @param field The field with a Vector2/FVector2 data type
     * @return The FVector2 value
     */
    public FVector2 readFVector2(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the double field
     * @param field The field with a float/double compatible data type
     * @return The double value
     */
    public double readDouble(VertexField field) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read the float field
     * @param field The field with a float/double compatible data type
     * @return The float value
     */
    public float readFloat(VertexField field) {
        throw new UnsupportedOperationException();
    }
}
