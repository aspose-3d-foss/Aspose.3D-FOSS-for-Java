package com.aspose.threed;

public class AxisSystem {
    private final CoordinateSystem coordinateSystem;
    private final Axis up;
    private final Axis front;

    public AxisSystem(CoordinateSystem coordinateSystem, Axis up, Axis front) {
        this.coordinateSystem = coordinateSystem;
        this.up = up;
        this.front = front;
    }

    public CoordinateSystem getCoordinateSystem() {
        return coordinateSystem;
    }

    public Axis getUp() {
        return up;
    }

    public Axis getFront() {
        return front;
    }

    public Matrix4 transformTo(AxisSystem target) {
        return Matrix4.getIdentity();
    }

    public static AxisSystem fromAssetInfo(AssetInfo assetInfo) {
        return new AxisSystem(CoordinateSystem.RIGHT_HANDED, Axis.Y_AXIS, Axis.NEGATIVE_Z_AXIS);
    }
}
