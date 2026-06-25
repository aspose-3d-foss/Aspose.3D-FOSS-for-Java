package com.aspose.threed;

/**
 * Options for AMF saving.
 */
public class AmfSaveOptions extends SaveOptions {
    private boolean compress = true;

    /**
     * Constructor of AmfSaveOptions.
     */
    public AmfSaveOptions() {
    }

    /**
     * Gets whether to compress the output AMF file.
     * @return true if compress.
     */
    public boolean getCompress() {
        return compress;
    }

    /**
     * Sets whether to compress the output AMF file.
     * @param value New value.
     */
    public void setCompress(boolean value) {
        this.compress = value;
    }
}
