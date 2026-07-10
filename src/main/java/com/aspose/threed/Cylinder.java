package com.aspose.threed;

/**
 * Parameterized Cylinder.
 * It can also be used to represent a cone when one of radiusTop/radiusBottom is zero.
 */
public class Cylinder extends Primitive implements IMeshConvertible {
    private double radiusTop;
    private double radiusBottom;
    private double height;
    private int radialSegments;
    private int heightSegments;
    private boolean openEnded;
    private double thetaStart;
    private double thetaLength;
    private boolean generateFanCylinder;
    private Vector2 shearTop;
    private Vector2 shearBottom;
    private Vector3 offsetTop;
    private Vector3 offsetBottom;

    /**
     * Initializes a new instance of Cylinder class.
     */
    public Cylinder() {
        this(1, 1, 1, 32, 1, false);
    }

    /**
     * Initializes a new instance of Cylinder class.
     * @param radiusTop Radius of cylinder's top cap.
     * @param radiusBottom Radius of cylinder's bottom cap.
     * @param height Height of the cylinder.
     * @param radialSegments Radial segments of both top and bottom circles..
     * @param heightSegments Height segments.
     * @param openEnded If set to true the cylinder would have no bottom/top caps..
     */
    public Cylinder(double radiusTop, double radiusBottom, double height, int radialSegments, int heightSegments, boolean openEnded) {
        this.radiusTop = radiusTop;
        this.radiusBottom = radiusBottom;
        this.height = height;
        this.radialSegments = radialSegments;
        this.heightSegments = heightSegments;
        this.openEnded = openEnded;
        this.thetaStart = 0;
        this.thetaLength = Math.PI * 2;
        this.generateFanCylinder = false;
        this.shearTop = new Vector2(0, 0);
        this.shearBottom = new Vector2(0, 0);
        this.offsetTop = new Vector3(0, 0, 0);
        this.offsetBottom = new Vector3(0, 0, 0);
    }

    /**
     * Gets the vertices transformation offset of the bottom side.
     * @return the vertices transformation offset of the bottom side.
     */
    public Vector3 getOffsetBottom() {
        return offsetBottom;
    }

    public void setOffsetBottom(Vector3 value) {
        this.offsetBottom = value;
    }

    /**
     * Gets the vertices transformation offset of the top side.
     * @return the vertices transformation offset of the top side.
     */
    public Vector3 getOffsetTop() {
        return offsetTop;
    }

    public void setOffsetTop(Vector3 value) {
        this.offsetTop = value;
    }

    /**
     * Gets whether to generate the fan-style cylinder when the ThetaLength is less than 2*PI, otherwise the model will not be cut.
     * @return whether to generate the fan-style cylinder when the ThetaLength is less than 2*PI, otherwise the model will not be cut.
     */
    public boolean getGenerateFanCylinder() {
        return generateFanCylinder;
    }

    public void setGenerateFanCylinder(boolean value) {
        this.generateFanCylinder = value;
    }

    /**
     * Gets of the shear transform of the bottom side, vector stores the (x-axis, z-axis) shear value that measured in radian, default value is (0, 0)
     * @return of the shear transform of the bottom side, vector stores the (x-axis, z-axis) shear value that measured in radian, default value is (0, 0)
     */
    public Vector2 getShearBottom() {
        return shearBottom;
    }

    public void setShearBottom(Vector2 value) {
        this.shearBottom = value;
    }

    /**
     * Gets of the shear transform of the top side, vector stores the (x-axis, z-axis) shear value that measured in radian, default value is (0, 0)
     * @return of the shear transform of the top side, vector stores the (x-axis, z-axis) shear value that measured in radian, default value is (0, 0)
     */
    public Vector2 getShearTop() {
        return shearTop;
    }

    public void setShearTop(Vector2 value) {
        this.shearTop = value;
    }

    /**
     * Gets the radius of cylinder's top cap.
     * @return the radius of cylinder's top cap.
     */
    public double getRadiusTop() {
        return radiusTop;
    }

    public void setRadiusTop(double value) {
        this.radiusTop = value;
    }

    /**
     * Gets the radius of cylinder's bottom cap.
     * @return the radius of cylinder's bottom cap.
     */
    public double getRadiusBottom() {
        return radiusBottom;
    }

    public void setRadiusBottom(double value) {
        this.radiusBottom = value;
    }

    /**
     * Gets the height of the cylinder.
     * @return the height of the cylinder.
     */
    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Gets the radial segments.
     * @return the radial segments.
     */
    public int getRadialSegments() {
        return radialSegments;
    }

    public void setRadialSegments(int value) {
        this.radialSegments = value;
    }

    /**
     * Gets the height segments.
     * @return the height segments.
     */
    public int getHeightSegments() {
        return heightSegments;
    }

    public void setHeightSegments(int value) {
        this.heightSegments = value;
    }

    /**
     * Gets a value indicating whether this Cylinder open ended.
     *   The default value is false.
     * @return a value indicating whether this Cylinder open ended.
     *  The default value is false.
     */
    public boolean getOpenEnded() {
        return openEnded;
    }

    public void setOpenEnded(boolean value) {
        this.openEnded = value;
    }

    /**
     * Gets the theta start.
     *   The default value is 0.
     * @return the theta start.
     *  The default value is 0.
     */
    public double getThetaStart() {
        return thetaStart;
    }

    public void setThetaStart(double value) {
        this.thetaStart = value;
    }

    /**
     * Gets the length of the theta.
     *   The default value is 2π.
     * @return the length of the theta.
     *  The default value is 2π.
     */
    public double getThetaLength() {
        return thetaLength;
    }

    public void setThetaLength(double value) {
        this.thetaLength = value;
    }

    /**
     * Convert current object to mesh
     * @return The mesh.
     */
    public Mesh toMesh() {
        Mesh mesh = new Mesh(getName());
        double halfHeight = height / 2;

        double topCenterX = this.offsetTop.x;
        double topCenterY = halfHeight + this.offsetTop.y;
        double topCenterZ = this.offsetTop.z;
        double bottomCenterX = this.offsetBottom.x;
        double bottomCenterY = -halfHeight + this.offsetBottom.y;
        double bottomCenterZ = this.offsetBottom.z;

        for (int i = 0; i <= radialSegments; i++) {
            double angle = thetaStart + thetaLength * i / radialSegments;
            double sinAngle = Math.sin(angle);
            double cosAngle = Math.cos(angle);

            double x = radiusTop * cosAngle;
            double z = radiusTop * sinAngle;
            mesh.getControlPoints().add(new Vector4(x, halfHeight, z, 1));
        }

        for (int i = 0; i <= radialSegments; i++) {
            double angle = thetaStart + thetaLength * i / radialSegments;
            double sinAngle = Math.sin(angle);
            double cosAngle = Math.cos(angle);

            double x = radiusBottom * cosAngle;
            double z = radiusBottom * sinAngle;
            mesh.getControlPoints().add(new Vector4(x, -halfHeight, z, 1));
        }

        for (int i = 0; i < radialSegments; i++) {
            mesh.createPolygon(i, i + 1, radialSegments + i + 2, radialSegments + i + 1);
        }

        if (!openEnded && radiusTop > 0) {
            int topIndex = mesh.getControlPoints().size();
            mesh.getControlPoints().add(new Vector4(topCenterX, topCenterY, topCenterZ, 1));
            for (int i = 0; i < radialSegments; i++) {
                mesh.createPolygon(topIndex, i, i + 1);
            }
        }

        if (!openEnded && radiusBottom > 0) {
            int bottomIndex = mesh.getControlPoints().size();
            mesh.getControlPoints().add(new Vector4(bottomCenterX, bottomCenterY, bottomCenterZ, 1));
            int bottomStart = radialSegments + 1;
            for (int i = 0; i < radialSegments; i++) {
                mesh.createPolygon(bottomIndex, bottomStart + i + 1, bottomStart + i);
            }
        }

        return mesh;
    }
}
