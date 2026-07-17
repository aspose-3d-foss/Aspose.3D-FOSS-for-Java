package com.aspose.threed;

/**
 * Load options for STL.
 */
public class StlLoadOptions extends LoadOptions {
    private boolean flipCoordinateSystem = false;
    private boolean recalculateNormal = false;

    /**
     * Initializes of a new StlLoadOptions instance.
     */
    public StlLoadOptions() {
        super();
    }

    /**
     * Initializes of a new StlLoadOptions instance.
     * @param contentType The content type.
     */
    public StlLoadOptions(FileContentType contentType) {
        super();
    }

    /**
     * Gets whether to flip coordinate system of control points/normal during importing.
     * @return true if flip coordinate system.
     */
    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    /**
     * Sets whether to flip coordinate system of control points/normal during importing.
     * @param value New value.
     */
    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    /**
     * Ignore the normal data that stored in STL file and recalculate the normal data based on the vertex position.
     * Default value is false
     * @return true if recalculate normal.
     */
    public boolean getRecalculateNormal() {
        return recalculateNormal;
    }

    /**
     * Sets whether to ignore the normal data that stored in STL file and recalculate the normal data.
     * @param value New value.
     */
    public void setRecalculateNormal(boolean value) {
        this.recalculateNormal = value;
    }
}
