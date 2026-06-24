package com.aspose.threed;

/**
 * Parameterized torus.
 */
public class Torus extends Primitive {
    private double radius = 10.0;
    private double tube = 3.0;
    private int radialSegments = 16;
    private int tubularSegments = 32;
    private double arc = 360.0;

    /**
     * Initializes a new instance of the Torus class.
     */
    public Torus() {
        this("Torus", 10.0, 3.0, 16, 32, 360.0);
    }

    /**
     * Initializes a new instance of the Torus class.
     * @param name Name.
     * @param radius The radius of the torus.
     * @param tube The radius of the torus' tube.
     * @param radialSegments Radial segments.
     * @param tubularSegments Tubular segments.
     * @param arc Arc.
     */
    public Torus(String name, double radius, double tube, int radialSegments, int tubularSegments, double arc) {
        super(name);
        this.radius = radius;
        this.tube = tube;
        this.radialSegments = radialSegments;
        this.tubularSegments = tubularSegments;
        this.arc = arc;
    }

    /**
     * Gets the radius of the torus.
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    /**
     * Gets the radius of the tube.
     */
    public double getTube() {
        return tube;
    }

    public void setTube(double value) {
        this.tube = value;
    }

    /**
     * Gets the radial segments.
     */
    public int getRadialSegments() {
        return radialSegments;
    }

    public void setRadialSegments(int value) {
        this.radialSegments = value;
    }

    /**
     * Gets the tubular segments.
     */
    public int getTubularSegments() {
        return tubularSegments;
    }

    public void setTubularSegments(int value) {
        this.tubularSegments = value;
    }

    /**
     * Gets the arc.
     */
    public double getArc() {
        return arc;
    }

    public void setArc(double value) {
        this.arc = value;
    }

    @Override
    public Mesh toMesh() {
        throw new UnsupportedOperationException();
    }
}
