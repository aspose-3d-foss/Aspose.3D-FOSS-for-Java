package com.aspose.threed;

/**
 * Parameterized Cylinder.
 * It can also be used to represent a cone when one of radiusTop/radiusBottom is zero.
 */
public class Cylinder extends Geometry implements IMeshConvertible {
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
        this("Cylinder", 1, 1, 1, 32, 1, false, 0, Math.PI * 2);
    }

    /**
     * Initializes a new instance of Cylinder class.
     */
    public Cylinder(double radius, double height) {
        this("Cylinder", radius, radius, height, 32, 1, false, 0, Math.PI * 2);
    }

    /**
     * Initializes a new instance of Cylinder class.
     */
    public Cylinder(double radiusTop, double radiusBottom, double height) {
        this("Cylinder", radiusTop, radiusBottom, height, 32, 1, false, 0, Math.PI * 2);
    }

    /**
     * Initializes a new instance of Cylinder class.
     */
    public Cylinder(double radiusTop, double radiusBottom, double height, int radialSegments, int heightSegments, boolean openEnded) {
        this("Cylinder", radiusTop, radiusBottom, height, radialSegments, heightSegments, openEnded, 0, Math.PI * 2);
    }

    /**
     * Initializes a new instance of Cylinder class.
     */
    public Cylinder(String name, double radiusTop, double radiusBottom, double height, int radialSegments, int heightSegments, boolean openEnded, double thetaStart, double thetaLength) {
        super(name);
        this.radiusTop = radiusTop;
        this.radiusBottom = radiusBottom;
        this.height = height;
        this.radialSegments = radialSegments;
        this.heightSegments = heightSegments;
        this.openEnded = openEnded;
        this.thetaStart = thetaStart;
        this.thetaLength = thetaLength;
        this.generateFanCylinder = false;
        this.shearTop = new Vector2(0, 0);
        this.shearBottom = new Vector2(0, 0);
        this.offsetTop = new Vector3(0, 0, 0);
        this.offsetBottom = new Vector3(0, 0, 0);
    }

    /**
     * Gets or sets the vertices transformation offset of the bottom side.
     */
    public Vector3 getOffsetBottom() {
        return offsetBottom;
    }

    public void setOffsetBottom(Vector3 value) {
        this.offsetBottom = value;
    }

    /**
     * Gets or sets the vertices transformation offset of the top side.
     */
    public Vector3 getOffsetTop() {
        return offsetTop;
    }

    public void setOffsetTop(Vector3 value) {
        this.offsetTop = value;
    }

    /**
     * Gets or sets whether to generate fan-style cylinder when ThetaLength is less than 2*PI.
     */
    public boolean getGenerateFanCylinder() {
        return generateFanCylinder;
    }

    public void setGenerateFanCylinder(boolean value) {
        this.generateFanCylinder = value;
    }

    /**
     * Gets or sets shear transform of the bottom side.
     */
    public Vector2 getShearBottom() {
        return shearBottom;
    }

    public void setShearBottom(Vector2 value) {
        this.shearBottom = value;
    }

    /**
     * Gets or sets shear transform of the top side.
     */
    public Vector2 getShearTop() {
        return shearTop;
    }

    public void setShearTop(Vector2 value) {
        this.shearTop = value;
    }

    /**
     * Gets or sets radius of cylinder's top cap.
     */
    public double getRadiusTop() {
        return radiusTop;
    }

    public void setRadiusTop(double value) {
        this.radiusTop = value;
    }

    /**
     * Gets or sets radius of cylinder's bottom cap.
     */
    public double getRadiusBottom() {
        return radiusBottom;
    }

    public void setRadiusBottom(double value) {
        this.radiusBottom = value;
    }

    /**
     * Gets or sets height of the cylinder.
     */
    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Gets or sets radial segments.
     */
    public int getRadialSegments() {
        return radialSegments;
    }

    public void setRadialSegments(int value) {
        this.radialSegments = value;
    }

    /**
     * Gets or sets height segments.
     */
    public int getHeightSegments() {
        return heightSegments;
    }

    public void setHeightSegments(int value) {
        this.heightSegments = value;
    }

    /**
     * Gets or sets a value indicating whether this cylinder is open ended.
     */
    public boolean getOpenEnded() {
        return openEnded;
    }

    public void setOpenEnded(boolean value) {
        this.openEnded = value;
    }

    /**
     * Gets or sets theta start.
     */
    public double getThetaStart() {
        return thetaStart;
    }

    public void setThetaStart(double value) {
        this.thetaStart = value;
    }

    /**
     * Gets or sets length of theta.
     */
    public double getThetaLength() {
        return thetaLength;
    }

    public void setThetaLength(double value) {
        this.thetaLength = value;
    }

    /**
     * Convert current object to mesh.
     */
    public Mesh toMesh() {
        Mesh mesh = new Mesh(getName());
        float radiusTop = (float) this.radiusTop;
        float radiusBottom = (float) this.radiusBottom;
        float height = (float) this.height;
        float halfHeight = height / 2;

        float topCenterX = (float) (this.offsetTop.x);
        float topCenterY = (float) (halfHeight + this.offsetTop.y);
        float topCenterZ = (float) this.offsetTop.z;
        float bottomCenterX = (float) (this.offsetBottom.x);
        float bottomCenterY = (float) (-halfHeight + this.offsetBottom.y);
        float bottomCenterZ = (float) this.offsetBottom.z;

        for (int i = 0; i <= radialSegments; i++) {
            double angle = thetaStart + thetaLength * i / radialSegments;
            double sinAngle = Math.sin(angle);
            double cosAngle = Math.cos(angle);

            float x = (float) (radiusTop * cosAngle);
            float z = (float) (radiusTop * sinAngle);
            mesh.getControlPoints().add(new Vector4(x, halfHeight, z, 1));
        }

        for (int i = 0; i <= radialSegments; i++) {
            double angle = thetaStart + thetaLength * i / radialSegments;
            double sinAngle = Math.sin(angle);
            double cosAngle = Math.cos(angle);

            float x = (float) (radiusBottom * cosAngle);
            float z = (float) (radiusBottom * sinAngle);
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
