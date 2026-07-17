package com.aspose.threed;

/**
 * Load options for glTF format.
 */
public class GltfLoadOptions extends LoadOptions {
    private boolean flipTexCoordV = true;

    /**
     * Constructor of GltfLoadOptions.
     */
    public GltfLoadOptions() {
        super();
    }

    /**
     * Gets or sets whether to flip the V coordinate of texture coordinates during import.
     * Default value is true.
     * @return true if flip texture coordinate V.
     */
    public boolean getFlipTexCoordV() {
        return flipTexCoordV;
    }

    /**
     * Sets whether to flip the V coordinate of texture coordinates during import.
     * @param value New value.
     */
    public void setFlipTexCoordV(boolean value) {
        this.flipTexCoordV = value;
    }
}
