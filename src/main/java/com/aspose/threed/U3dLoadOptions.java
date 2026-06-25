package com.aspose.threed;

/**
 * Options for U3D loading.
 */
public class U3dLoadOptions extends LoadOptions {
    private boolean centerScene = false;

    /**
     * Constructor of U3dLoadOptions.
     */
    public U3dLoadOptions() {
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
