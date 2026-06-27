package com.aspose.threed;

/**
 * Base class of struct array.
 */
public abstract class Structs {
    /**
     * Creates a new instance of Structs.
     */
    protected Structs() {
    }
    
    /**
     * Length of this array.
     * @return number of elements in this array
     */
    public final int length() {
        throw new UnsupportedOperationException("Not implemented in FOSS version");
    }
    
    /**
     * Size in bytes of single struct.
     * @return the size of the struct
     */
    public final int structSize() {
        throw new UnsupportedOperationException("Not implemented in FOSS version");
    }
    
    /**
     * Write the content to specified stream.
     * @param stream Which stream to write the struct to
     * @throws java.io.IOException when failed to write to stream.
     */
    public void writeTo(Stream stream) throws java.io.IOException {
        throw new UnsupportedOperationException("Not implemented in FOSS version");
    }
    
    /**
     * Write the content to specified stream.
     * @param stream Which stream to write the struct to
     * @throws java.io.IOException when failed to write to stream.
     */
    public void writeTo(java.io.OutputStream stream) throws java.io.IOException {
        throw new UnsupportedOperationException("Not implemented in FOSS version");
    }
    
    /**
     * Returns a string representation of this struct array.
     * @return A string representation of this struct array
     */
    public String toString() {
        return super.toString();
    }
}
