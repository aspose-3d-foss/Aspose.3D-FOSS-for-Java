package com.aspose.threed;

/**
 * Box primitive.
 */
public class Box extends Geometry implements IMeshConvertible {
    private double length;
    private double width;
    private double height;
    private int lengthSegments;
    private int widthSegments;
    private int heightSegments;

    /**
     * Initializes a new instance of Box class.
     */
    public Box() {
        this("Box", 1, 1, 1, 1, 1, 1);
    }

    /**
     * Initializes a new instance of Box class.
     */
    public Box(double length, double width, double height) {
        this("Box", length, width, height, 1, 1, 1);
    }

    /**
     * Initializes a new instance of Box class.
     */
    public Box(String name, double length, double width, double height, int lengthSegments, int widthSegments, int heightSegments) {
        super(name);
        this.length = length;
        this.width = width;
        this.height = height;
        this.lengthSegments = lengthSegments;
        this.widthSegments = widthSegments;
        this.heightSegments = heightSegments;
    }

    /**
     * Gets or sets length segments.
     */
    public int getLengthSegments() {
        return lengthSegments;
    }

    public void setLengthSegments(int value) {
        this.lengthSegments = value;
    }

    /**
     * Gets or sets width segments.
     */
    public int getWidthSegments() {
        return widthSegments;
    }

    public void setWidthSegments(int value) {
        this.widthSegments = value;
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
     * Gets or sets length of box aligned in z-axis.
     */
    public double getLength() {
        return length;
    }

    public void setLength(double value) {
        this.length = value;
    }

    /**
     * Gets or sets width of box aligned in x-axis.
     */
    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets or sets height of box aligned in y-axis.
     */
    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Convert current object to mesh.
     */
    public Mesh toMesh() {
        Mesh mesh = new Mesh(getName());
        double halfLength = length / 2;
        double halfWidth = width / 2;
        double halfHeight = height / 2;

        mesh.getControlPoints().add(new Vector4(-halfWidth, -halfHeight, -halfLength, 1));
        mesh.getControlPoints().add(new Vector4(halfWidth, -halfHeight, -halfLength, 1));
        mesh.getControlPoints().add(new Vector4(halfWidth, halfHeight, -halfLength, 1));
        mesh.getControlPoints().add(new Vector4(-halfWidth, halfHeight, -halfLength, 1));
        mesh.getControlPoints().add(new Vector4(-halfWidth, -halfHeight, halfLength, 1));
        mesh.getControlPoints().add(new Vector4(halfWidth, -halfHeight, halfLength, 1));
        mesh.getControlPoints().add(new Vector4(halfWidth, halfHeight, halfLength, 1));
        mesh.getControlPoints().add(new Vector4(-halfWidth, halfHeight, halfLength, 1));

        mesh.createPolygon(0, 1, 2, 3);
        mesh.createPolygon(4, 5, 6, 7);
        mesh.createPolygon(0, 4, 7, 3);
        mesh.createPolygon(1, 5, 6, 2);
        mesh.createPolygon(0, 1, 5, 4);
        mesh.createPolygon(3, 2, 6, 7);

        return mesh;
    }
}
