package com.aspose.threed;

public class ObjLoadOptions extends LoadOptions {
    private boolean flipCoordinateSystem = false;
    private boolean enableMaterials = true;
    private double scale = 1.0;
    private boolean normalizeNormal = false;

    public ObjLoadOptions() {
        super();
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    public boolean getEnableMaterials() {
        return enableMaterials;
    }

    public void setEnableMaterials(boolean value) {
        this.enableMaterials = value;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double value) {
        this.scale = value;
    }

    public boolean getNormalizeNormal() {
        return normalizeNormal;
    }

    public void setNormalizeNormal(boolean value) {
        this.normalizeNormal = value;
    }
}
