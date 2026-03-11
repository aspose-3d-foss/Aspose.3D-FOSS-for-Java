package com.aspose.threed;

public class ObjSaveOptions extends SaveOptions {
    private boolean applyUnitScale = false;
    private boolean pointCloud = false;
    private boolean verbose = false;
    private boolean serializeW = false;
    private boolean enableMaterials = true;
    private boolean flipCoordinateSystem = false;
    private AxisSystem axisSystem = new AxisSystem(CoordinateSystem.RIGHT_HANDED, Axis.Y_AXIS, Axis.NEGATIVE_Z_AXIS);

    public ObjSaveOptions() {
        super();
        setFileFormat(FileFormat.WAVEFRONTOBJ);
    }

    public boolean getApplyUnitScale() {
        return applyUnitScale;
    }

    public void setApplyUnitScale(boolean value) {
        this.applyUnitScale = value;
    }

    public boolean getPointCloud() {
        return pointCloud;
    }

    public void setPointCloud(boolean value) {
        this.pointCloud = value;
    }

    public boolean getVerbose() {
        return verbose;
    }

    public void setVerbose(boolean value) {
        this.verbose = value;
    }

    public boolean getSerializeW() {
        return serializeW;
    }

    public void setSerializeW(boolean value) {
        this.serializeW = value;
    }

    public boolean getEnableMaterials() {
        return enableMaterials;
    }

    public void setEnableMaterials(boolean value) {
        this.enableMaterials = value;
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
}
