package com.aspose.threed;

/**
 * Options for AMF saving.
 */
public class AmfSaveOptions extends SaveOptions {
    private boolean enableCompression = true;

    /**
     * Constructor of AmfSaveOptions.
     */
    public AmfSaveOptions() {
    }

    /**
     * Whether to use compression to reduce the final file size, default value is true.
     * @return true if enable compression.
     */
    public boolean getEnableCompression() {
        return enableCompression;
    }

    /**
     * Sets whether to use compression to reduce the final file size.
     * @param value New value.
     */
    public void setEnableCompression(boolean value) {
        this.enableCompression = value;
    }
}
