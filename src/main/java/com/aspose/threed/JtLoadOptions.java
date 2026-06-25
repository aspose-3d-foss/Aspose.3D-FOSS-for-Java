package com.aspose.threed;

/**
 * Options for JPEG2000 loading.
 */
public class JtLoadOptions extends LoadOptions {
    private boolean centerScene = false;

    /**
     * Constructor of JtLoadOptions.
     */
    public JtLoadOptions() {
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
