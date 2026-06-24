package com.aspose.threed;

/**
 * Parameterized rectangular torus.
 */
public class RectangularTorus extends Primitive {
    private double innerRadius = 17;
    private double outerRadius = 20;
    private double height = 20;
    private double arc = Math.PI;
    private double angleStart = 0;
    private int radialSegments = 10;

    /**
     * The inner radius of the rectangular torus.
     */
    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double value) {
        this.innerRadius = value;
    }

    /**
     * The outer radius of the rectangular torus.
     */
    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double value) {
        this.outerRadius = value;
    }

    /**
     * The height of the rectangular torus.
     */
    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * The total angle of the arc, measured in radian.
     */
    public double getArc() {
        return arc;
    }

    public void setArc(double value) {
        this.arc = value;
    }

    /**
     * The start angle of the arc, measured in radian.
     */
    public double getAngleStart() {
        return angleStart;
    }

    public void setAngleStart(double value) {
        this.angleStart = value;
    }

    /**
     * The radial segments.
     */
    public int getRadialSegments() {
        return radialSegments;
    }

    public void setRadialSegments(int value) {
        this.radialSegments = value;
    }

    /**
     * Constructor of RectangularTorus.
     */
    public RectangularTorus() {
        super("RectangularTorus");
    }

    @Override
    public Mesh toMesh() {
        throw new UnsupportedOperationException();
    }
}
