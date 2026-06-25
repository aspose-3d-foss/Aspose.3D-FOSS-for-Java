package com.aspose.threed;

/**
 * Options for X (DirectX) loading.
 */
public class XLoadOptions extends LoadOptions {
    private boolean centerScene = false;

    /**
     * Constructor of XLoadOptions.
     */
    public XLoadOptions() {
    }

    /**
     * Gets whether to center the scene after loading.
     * @return true if center the scene.
     */
    public boolean getCenterScene() {
        return centerScene;
    }

    /**
     * Sets whether to center the scene after loading.
     * @param value New value.
     */
    public void setCenterScene(boolean value) {
        this.centerScene = value;
    }
}
