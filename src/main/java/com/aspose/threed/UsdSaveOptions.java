package com.aspose.threed;

/**
 * Options for USD saving.
 */
public class UsdSaveOptions extends SaveOptions {
    private boolean exportTextures = true;

    /**
     * Constructor of UsdSaveOptions.
     */
    public UsdSaveOptions() {
    }

    /**
     * Gets whether to export textures.
     * @return true if export textures.
     */
    public boolean getExportTextures() {
        return exportTextures;
    }

    /**
     * Sets whether to export textures.
     * @param value New value.
     */
    public void setExportTextures(boolean value) {
        this.exportTextures = value;
    }
}
