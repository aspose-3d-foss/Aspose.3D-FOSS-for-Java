package com.aspose.threed;

/**
 * An index buffer interface for rendering operations.
 */
public interface IIndexBuffer extends IBuffer {
    /**
     * Gets the data type of the indices.
     * @return the index data type.
     */
    IndexDataType getIndexDataType();
    
    /**
     * Gets the number of indices in the buffer.
     * @return the count of indices.
     */
    int getCount();
    
    /**
     * Loads index data into the buffer.
     * @param indices The integer index array.
     */
    void loadData(int[] indices);
    
    /**
     * Loads index data into the buffer.
     * @param indices The short index array.
     */
    void loadData(short[] indices);
}
