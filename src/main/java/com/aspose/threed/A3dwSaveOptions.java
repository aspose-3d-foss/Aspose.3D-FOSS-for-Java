package com.aspose.threed;

/**
 * Options for A3DW saving.
 */
public class A3dwSaveOptions extends SaveOptions {
    private boolean compress = true;

    /**
     * Constructor of A3dwSaveOptions.
     */
    public A3dwSaveOptions() {
    }

    /**
     * Gets whether to compress the output A3DW file.
     * @return true if compress.
     */
    public boolean getCompress() {
        return compress;
    }

    /**
     * Sets whether to compress the output A3DW file.
     * @param value New value.
     */
    public void setCompress(boolean value) {
        this.compress = value;
    }
}
