package com.aspose.threed;

public class StlLoadOptions extends LoadOptions {
    private boolean flipCoordinateSystem = false;
    private boolean recalculateNormal = false;
    private FileContentType contentType;

    public StlLoadOptions() {
        super();
        this.contentType = FileContentType.ASCII;
    }

    public StlLoadOptions(FileContentType contentType) {
        super();
        this.contentType = contentType;
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    public boolean getRecalculateNormal() {
        return recalculateNormal;
    }

    public void setRecalculateNormal(boolean value) {
        this.recalculateNormal = value;
    }

    public FileContentType getContentType() {
        return contentType;
    }

    public void setContentType(FileContentType value) {
        this.contentType = value;
    }
}
