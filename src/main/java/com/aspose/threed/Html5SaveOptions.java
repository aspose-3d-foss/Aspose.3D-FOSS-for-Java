package com.aspose.threed;

/**
 * Options for HTML5 saving.
 */
public class Html5SaveOptions extends SaveOptions {
    private boolean embedAssets = true;

    /**
     * Constructor of Html5SaveOptions.
     */
    public Html5SaveOptions() {
    }

    /**
     * Gets whether to embed assets (textures, scripts) in the output HTML.
     * @return true if embed assets.
     */
    public boolean getEmbedAssets() {
        return embedAssets;
    }

    /**
     * Sets whether to embed assets (textures, scripts) in the output HTML.
     * @param value New value.
     */
    public void setEmbedAssets(boolean value) {
        this.embedAssets = value;
    }
}
