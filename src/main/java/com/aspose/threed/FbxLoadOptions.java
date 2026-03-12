package com.aspose.threed;

public class FbxLoadOptions extends LoadOptions {
    private boolean flipCoordinateSystem = false;

    public FbxLoadOptions() {
        super();
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }
}
