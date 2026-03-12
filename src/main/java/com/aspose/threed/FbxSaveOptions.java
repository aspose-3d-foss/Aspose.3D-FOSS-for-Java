package com.aspose.threed;

public class FbxSaveOptions extends SaveOptions {
    private boolean flipCoordinateSystem = false;

    public FbxSaveOptions() {
        super();
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }
}
