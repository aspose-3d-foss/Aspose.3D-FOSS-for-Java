package com.aspose.threed;

public class GltfLoadOptions extends LoadOptions {
    private boolean flipCoordinateSystem = false;
    private boolean prettyPrint = false;

    public GltfLoadOptions() {
        super();
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    public boolean getPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(boolean value) {
        this.prettyPrint = value;
    }
}
