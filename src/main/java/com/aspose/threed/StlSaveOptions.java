package com.aspose.threed;

public class StlSaveOptions extends SaveOptions {
    private boolean flipCoordinateSystem = false;
    private AxisSystem axisSystem = new AxisSystem(CoordinateSystem.RIGHT_HANDED, Axis.Y_AXIS, Axis.NEGATIVE_Z_AXIS);
    private FileContentType contentType = FileContentType.BINARY;

    public StlSaveOptions() {
        super();
        setFileFormat(FileFormat.STL_BINARY);
    }

    public StlSaveOptions(FileContentType contentType) {
        super();
        this.contentType = contentType;
        setFileFormat(contentType == FileContentType.BINARY ? FileFormat.STL_BINARY : FileFormat.STLASCII);
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    public AxisSystem getAxisSystem() {
        return axisSystem;
    }

    public void setAxisSystem(AxisSystem value) {
        this.axisSystem = value;
    }

    public FileContentType getContentType() {
        return contentType;
    }

    public void setContentType(FileContentType value) {
        this.contentType = value;
        setFileFormat(value == FileContentType.BINARY ? FileFormat.STL_BINARY : FileFormat.STLASCII);
    }
}
