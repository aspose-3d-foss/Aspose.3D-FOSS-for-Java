package com.aspose.threed;

/**
 * Parameterized plane.
 */
public class Plane extends Primitive {
    private double length = 1.0;
    private double width = 1.0;
    private int lengthSegments = 1;
    private int widthSegments = 1;
    private Vector3 up = new Vector3(0, 1, 0);

    /**
     * Initializes a new instance of the Plane with default size 1x1.
     */
    public Plane() {
        this(1, 1);
    }

    /**
     * Initializes a new instance of the Plane.
     * @param length Length of the plane
     * @param width Width of the plane
     */
    public Plane(double length, double width) {
        this("Plane", length, width, 1, 1);
    }

    /**
     * Initializes a new instance of the Plane.
     * @param name Name of the plane
     * @param length Length of the plane
     * @param width Width of the plane
     * @param lengthSegments Length segments
     * @param widthSegments Width segments
     */
    public Plane(String name, double length, double width, int lengthSegments, int widthSegments) {
        super(name);
        this.length = length;
        this.width = width;
        this.lengthSegments = lengthSegments;
        this.widthSegments = widthSegments;
    }

    /**
     * Gets the up vector of the plane, default value is (0, 1, 0), this affects the generation of the plane
     */
    public Vector3 getUp() {
        return up;
    }

    public void setUp(Vector3 value) {
        this.up = value;
    }

    /**
     * Gets the length of the plane.
     */
    public double getLength() {
        return length;
    }

    public void setLength(double value) {
        this.length = value;
    }

    /**
     * Gets the width of the plane.
     */
    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets the length segments.
     */
    public int getLengthSegments() {
        return lengthSegments;
    }

    public void setLengthSegments(int value) {
        this.lengthSegments = value;
    }

    /**
     * Gets the width segments.
     */
    public int getWidthSegments() {
        return widthSegments;
    }

    public void setWidthSegments(int value) {
        this.widthSegments = value;
    }

    /**
     * Convert current object to mesh.
     */
    public Mesh toMesh() {
        // TODO: Implement mesh conversion
        return new Mesh();
    }
}
