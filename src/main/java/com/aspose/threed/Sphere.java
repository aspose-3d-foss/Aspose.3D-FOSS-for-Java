package com.aspose.threed;

/**
 * Parameterized sphere.
 */
public class Sphere extends Geometry implements IMeshConvertible {
    private double radius;
    private int widthSegments;
    private int heightSegments;
    private double phiStart;
    private double phiLength;
    private double thetaStart;
    private double thetaLength;

    /**
     * Initializes a new instance of Sphere with default radius 1.
     */
    public Sphere() {
        this(1);
    }

    /**
     * Initializes a new instance of Sphere class with specified radius.
     */
    public Sphere(double radius) {
        this("Sphere", radius, 16, 16, 0, Math.PI * 2, 0, Math.PI * 2);
    }

    /**
     * Initializes a new instance of Sphere class with specified radius, width segments and height segments.
     */
    public Sphere(double radius, int widthSegments, int heightSegments) {
        this("Sphere", radius, widthSegments, heightSegments, 0, Math.PI * 2, 0, Math.PI * 2);
    }

    /**
     * Initializes a new instance of Sphere class.
     */
    public Sphere(String name, double radius, int widthSegments, int heightSegments, double phiStart, double phiLength, double thetaStart, double thetaLength) {
        super(name);
        this.radius = radius;
        this.widthSegments = widthSegments;
        this.heightSegments = heightSegments;
        this.phiStart = phiStart;
        this.phiLength = phiLength;
        this.thetaStart = thetaStart;
        this.thetaLength = thetaLength;
    }

    /**
     * Gets or sets the width segments.
     */
    public int getWidthSegments() {
        return widthSegments;
    }

    public void setWidthSegments(int value) {
        this.widthSegments = value;
    }

    /**
     * Gets or sets the height segments.
     */
    public int getHeightSegments() {
        return heightSegments;
    }

    public void setHeightSegments(int value) {
        this.heightSegments = value;
    }

    /**
     * Gets or sets the phi start.
     */
    public double getPhiStart() {
        return phiStart;
    }

    public void setPhiStart(double value) {
        this.phiStart = value;
    }

    /**
     * Gets or sets the length of phi.
     */
    public double getPhiLength() {
        return phiLength;
    }

    public void setPhiLength(double value) {
        this.phiLength = value;
    }

    /**
     * Gets or sets the theta start.
     */
    public double getThetaStart() {
        return thetaStart;
    }

    public void setThetaStart(double value) {
        this.thetaStart = value;
    }

    /**
     * Gets or sets the length of theta.
     */
    public double getThetaLength() {
        return thetaLength;
    }

    public void setThetaLength(double value) {
        this.thetaLength = value;
    }

    /**
     * Gets or sets radius of the sphere.
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    /**
     * Convert current object to mesh.
     */
    public Mesh toMesh() {
        Mesh mesh = new Mesh(getName());
        float radius = (float) this.radius;

        for (int lat = 0; lat <= heightSegments; lat++) {
            double theta = thetaStart + thetaLength * lat / heightSegments;
            double sinTheta = Math.sin(theta);
            double cosTheta = Math.cos(theta);

            for (int lon = 0; lon <= widthSegments; lon++) {
                double phi = phiStart + phiLength * lon / widthSegments;
                double sinPhi = Math.sin(phi);
                double cosPhi = Math.cos(phi);

                float x = (float) (radius * cosPhi * sinTheta);
                float y = (float) (radius * cosTheta);
                float z = (float) (radius * sinPhi * sinTheta);

                mesh.getControlPoints().add(new Vector4(x, y, z, 1));
            }
        }

        for (int lat = 0; lat < heightSegments; lat++) {
            for (int lon = 0; lon < widthSegments; lon++) {
                int first = lat * (widthSegments + 1) + lon;
                int second = first + widthSegments + 1;

                mesh.createPolygon(first, second, second + 1, first + 1);
            }
        }

        return mesh;
    }
}
