package com.aspose.threed;

/**
 * Save options for STL.
 */
public class StlSaveOptions extends SaveOptions {
    private AxisSystem axisSystem = new AxisSystem(CoordinateSystem.RIGHT_HANDED, Axis.Y_AXIS, Axis.NEGATIVE_Z_AXIS);
    private boolean flipCoordinateSystem = false;

    /**
     * Initializes of a new StlSaveOptions instance.
     */
    public StlSaveOptions() {
        super();
    }

    /**
     * Initializes of a new StlSaveOptions instance.
     * @param contentType The content type.
     */
    public StlSaveOptions(FileContentType contentType) {
        super();
        // For STL, the file format is determined by the content type
        // Binary -> STL_BINARY, ASCII -> STLASCII
        if (contentType == FileContentType.BINARY) {
            setFileFormat(FileFormat.STL_BINARY);
        } else {
            setFileFormat(FileFormat.STLASCII);
        }
    }

    /**
     * Gets the axis system in the exported stl file.
     * @return the axis system in the exported stl file.
     */
    public AxisSystem getAxisSystem() {
        return axisSystem;
    }

    /**
     * Sets the axis system in the exported stl file.
     * @param value New value.
     */
    public void setAxisSystem(AxisSystem value) {
        this.axisSystem = value;
    }

    /**
     * Gets whether flip coordinate system of control points/normal during exporting.
     * @return true if flip coordinate system.
     */
    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    /**
     * Sets whether flip coordinate system of control points/normal during exporting.
     * @param value New value.
     */
    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }
}
