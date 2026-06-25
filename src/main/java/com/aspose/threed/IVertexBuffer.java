package com.aspose.threed;

/**
 * A vertex buffer interface for rendering operations.
 */
public interface IVertexBuffer extends IBuffer {
    /**
     * Loads data from a TriMesh into the buffer.
     * @param mesh The mesh to load data from.
     */
    void loadData(TriMesh mesh);
    
    /**
     * Loads vertex data into the buffer.
     * @param offset The offset in bytes.
     * @param count The number of vertices.
     */
    void loadData(long offset, int count);
    
    /**
     * Gets the vertex declaration for this buffer.
     * @return the vertex declaration.
     */
    VertexDeclaration getVertexDeclaration();
}
