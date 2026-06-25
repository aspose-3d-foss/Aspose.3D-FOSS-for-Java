package com.aspose.threed;

import java.io.OutputStream;

/**
 * A TriMesh contains raw data that can be used by GPU directly.
 * This class is a utility to help to construct a mesh that only contains per-vertex data.
 */
public class TriMesh extends Entity implements Iterable<Vertex> {
    private final VertexDeclaration vertexDeclaration;
    private final java.util.List<Byte> vertices;
    private final java.util.List<Integer> indices;
    private int unmergedVerticesCount;

    /**
     * Initialize an instance of TriMesh
     * @param name The name of this TriMesh
     * @param declaration The vertex's declaration
     */
    public TriMesh(String name, VertexDeclaration declaration) {
        super(name);
        if (declaration == null) {
            throw new IllegalArgumentException("declaration");
        }
        this.vertexDeclaration = declaration;
        this.vertices = new java.util.ArrayList<>();
        this.indices = new java.util.ArrayList<>();
        this.unmergedVerticesCount = 0;
    }

    /**
     * The vertex layout of the TriMesh.
     * @return The vertex layout of the TriMesh.
     */
    public VertexDeclaration getVertexDeclaration() {
        return vertexDeclaration;
    }

    /**
     * The count of vertices in this TriMesh
     * @return The count of vertices in this TriMesh
     */
    public int getVerticesCount() {
        return vertices.size() / getVertexSize();
    }

    /**
     * The count of indices in this TriMesh
     * @return The count of indices in this TriMesh
     */
    public int getIndicesCount() {
        return indices.size();
    }

    /**
     * The count of unmerged vertices that passed in by beginVertex() and endVertex().
     * @return The count of unmerged vertices that passed in by beginVertex() and endVertex().
     */
    public int getUnmergedVerticesCount() {
        return unmergedVerticesCount;
    }

    /**
     * The capacity of pre-allocated vertices.
     * @return The capacity of pre-allocated vertices.
     */
    public int getCapacity() {
        return vertices.size();
    }

    /**
     * The total size of all vertices in bytes
     * @return The total size of all vertices in bytes
     */
    public int getVerticesSizeInBytes() {
        return vertices.size();
    }

    private int getVertexSize() {
        int size = 0;
        for (VertexField field : vertexDeclaration) {
            switch (field.getDataType()) {
                case VertexFieldDataType.Float: size += 4; break;
                case VertexFieldDataType.Double: size += 8; break;
                case VertexFieldDataType.Int8: size += 1; break;
                case VertexFieldDataType.Int16: size += 2; break;
                case VertexFieldDataType.Int32: size += 4; break;
                case VertexFieldDataType.FVector2: size += 8; break;
                case VertexFieldDataType.FVector3: size += 12; break;
                case VertexFieldDataType.FVector4: size += 16; break;
                case VertexFieldDataType.Vector2: size += 16; break;
                case VertexFieldDataType.Vector3: size += 24; break;
                case VertexFieldDataType.Vector4: size += 32; break;
                case VertexFieldDataType.ByteVector4: size += 4; break;
                case VertexFieldDataType.Int64: size += 8; break;
            }
        }
        return size;
    }

    /**
     * Create a TriMesh from given mesh object with given vertex layout.
     * @param declaration Vertex's type definition, or memory layout
     * @param mesh Source mesh
     * @return Instance of TriMesh converted from input mesh with specified vertex's memory layout
     */
    public static TriMesh fromMesh(VertexDeclaration declaration, Mesh mesh) {
        throw new UnsupportedOperationException();
    }

    /**
     * Copy the TriMesh from input with new vertex layout
     * @param input The input TriMesh for copying
     * @param vd The new vertex declaration of the output TriMesh
     * @return A new TriMesh instance with new vertex declaration.
     */
    public static TriMesh copyFrom(TriMesh input, VertexDeclaration vd) {
        throw new UnsupportedOperationException();
    }

    /**
     * Create a TriMesh from given mesh object, the vertex declaration are based on the input mesh's structure.
     * @param useFloat Use float type instead of double type for each vertex element component.
     * @return The TriMesh generated from given Mesh
     */
    public static TriMesh fromMesh(Mesh mesh, boolean useFloat) {
        throw new UnsupportedOperationException();
    }

    /**
     * Create a TriMesh from given mesh object, the vertex declaration are based on the input mesh's structure.
     * @return The TriMesh generated from given Mesh
     */
    public static TriMesh fromMesh(Mesh mesh) {
        throw new UnsupportedOperationException();
    }

    /**
     * Begin adding vertex
     * @return The reference of internal vertex object in type Vertex
     */
    public Vertex beginVertex() {
        throw new UnsupportedOperationException();
    }

    /**
     * End adding vertex
     */
    public int endVertex() {
        throw new UnsupportedOperationException();
    }

    /**
     * Write vertices data to the specified stream
     */
    public void writeVerticesTo(Stream stream) throws java.io.IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Write the indices data as 16bit integer to the stream
     */
    public void write16bIndicesTo(Stream stream) throws java.io.IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Write the indices data as 32bit integer to the stream
     */
    public void write32bIndicesTo(Stream stream) throws java.io.IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Write vertices to an OutputStream
     */
    public void writeVerticesTo(OutputStream stream) throws java.io.IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Write 16-bit indices to an OutputStream
     */
    public void write16bIndicesTo(OutputStream stream) throws java.io.IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Write 32-bit indices to an OutputStream
     */
    public void write32bIndicesTo(OutputStream stream) throws java.io.IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Vertices data as byte array
     * @return Vertices data
     */
    public byte[] verticesToArray() {
        throw new UnsupportedOperationException();
    }

    /**
     * Indices data as short array
     * @param result Result array
     */
    public void indicesToArray(short[] result) {
        throw new UnsupportedOperationException();
    }

    /**
     * Indices data as int array
     * @param result Result array
     */
    public void indicesToArray(int[] result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("TriMesh(%d vertices, %d indices)", getVerticesCount(), getIndicesCount());
    }

    /**
     * Create a TriMesh from raw data
     * @param vd Vertex declaration
     * @param vertices Vertices data
     * @param indices Indices data
     * @param generateVertexMapping Generate vertex mapping
     * @return TriMesh instance
     */
    public static TriMesh fromRawData(VertexDeclaration vd, byte[] vertices, int[] indices, boolean generateVertexMapping) {
        throw new UnsupportedOperationException();
    }

    /**
     * Load vertices from byte array
     * @param verticesInBytes Vertices data
     */
    public void loadVerticesFromBytes(byte[] verticesInBytes) {
        throw new UnsupportedOperationException();
    }

    /**
     * Add a triangle
     * @param a First vertex index
     * @param b Second vertex index
     * @param c Third vertex index
     */
    public void addTriangle(int a, int b, int c) {
        indices.add(a);
        indices.add(b);
        indices.add(c);
    }

    @Override
    public java.util.Iterator<Vertex> iterator() {
        throw new UnsupportedOperationException();
    }
}
