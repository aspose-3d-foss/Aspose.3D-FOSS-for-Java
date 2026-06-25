package com.aspose.threed;

/**
 * A buffer interface for rendering operations.
 */
public interface IBuffer extends java.io.Closeable {
    /**
     * Gets the size of the buffer in bytes.
     * @return the size of the buffer.
     */
    int getSize();
    
    /**
     * Loads data into the buffer.
     * @param data The data to load.
     */
    void loadData(byte[] data);
}
