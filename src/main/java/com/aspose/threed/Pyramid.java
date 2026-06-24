package com.aspose.threed;

/**
 * Parameterized pyramid.
 */
public class Pyramid extends Primitive {
    private Vector2 bottomArea = new Vector2(10, 10);
    private Vector2 topArea = new Vector2(1, 1);
    private Vector3 bottomOffset = new Vector3(0, 0, 0);
    private double height = 5;

    /**
     * Area of the bottom cap.
     */
    public Vector2 getBottomArea() {
        return bottomArea;
    }

    public void setBottomArea(Vector2 value) {
        this.bottomArea = value;
    }

    /**
     * Area of the top cap.
     */
    public Vector2 getTopArea() {
        return topArea;
    }

    public void setTopArea(Vector2 value) {
        this.topArea = value;
    }

    /**
     * Offset for bottom vertices.
     */
    public Vector3 getBottomOffset() {
        return bottomOffset;
    }

    public void setBottomOffset(Vector3 value) {
        this.bottomOffset = value;
    }

    /**
     * Height of the pyramid.
     */
    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Construct a new pyramid instance with default bottom area(10, 10) and default height(5).
     */
    public Pyramid() {
        this(10, 10, 1, 1, 5);
    }

    /**
     * Construct a new pyramid instance with specified bottom area and top area and height.
     * @param xbottom The x-direction length of the bottom area
     * @param ybottom The y-direction length of the bottom area
     * @param xtop The x-direction length of the top area
     * @param ytop The y-direction length of the top area
     * @param height The height of the pyramid
     */
    public Pyramid(double xbottom, double ybottom, double xtop, double ytop, double height) {
        super("Pyramid");
        this.bottomArea = new Vector2(xbottom, ybottom);
        this.topArea = new Vector2(xtop, ytop);
        this.height = height;
    }

    @Override
    public Mesh toMesh() {
        throw new UnsupportedOperationException();
    }
}
