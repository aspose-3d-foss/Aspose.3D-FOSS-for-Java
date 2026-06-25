package com.aspose.threed;

/**
 * Linear extrusion takes a 2D shape as input and extends the shape in the 3rd dimension.
 */
public class LinearExtrusion extends Entity {
    private Profile shape;
    private Vector3 direction;
    private double height;
    private int slices;
    private boolean center;
    private Vector3 twistOffset;
    private double twist;

    /**
     * Constructor of instance.
     */
    public LinearExtrusion() {
        this("LinearExtrusion");
    }

    /**
     * Constructor of instance.
     * @param shape The base shape to be extruded.
     * @param height The height of the extruded geometry.
     */
    public LinearExtrusion(Profile shape, double height) {
        this("LinearExtrusion");
        this.shape = shape;
        this.height = height;
    }

    /**
     * Constructor of instance.
     * @param name Entity name.
     */
    protected LinearExtrusion(String name) {
        super(name);
        this.shape = null;
        this.direction = new Vector3(0, 0, 1);
        this.height = 1.0;
        this.slices = 1;
        this.center = false;
        this.twistOffset = new Vector3(0, 0, 0);
        this.twist = 0;
    }

    /**
     * The base shape to be extruded.
     * @return the base shape.
     */
    public Profile getShape() {
        return shape;
    }

    /**
     * The base shape to be extruded.
     * @param value New value.
     */
    public void setShape(Profile value) {
        this.shape = value;
    }

    /**
     * The direction of extrusion, default value is (0, 0, 1).
     * @return the direction vector.
     */
    public Vector3 getDirection() {
        return direction;
    }

    /**
     * The direction of extrusion, default value is (0, 0, 1).
     * @param value New value.
     */
    public void setDirection(Vector3 value) {
        this.direction = value;
    }

    /**
     * The height of the extruded geometry, default value is 1.0.
     * @return the height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * The height of the extruded geometry, default value is 1.0.
     * @param value New value.
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * The slices of the twisted extruded geometry, default value is 1.
     * @return the number of slices.
     */
    public int getSlices() {
        return slices;
    }

    /**
     * The slices of the twisted extruded geometry, default value is 1.
     * @param value New value.
     */
    public void setSlices(int value) {
        this.slices = value;
    }

    /**
     * If this value is false, the linear extrusion Z range is from 0 to height, otherwise the range is from -height/2 to height/2.
     * @return true if centered.
     */
    public boolean getCenter() {
        return center;
    }

    /**
     * If this value is false, the linear extrusion Z range is from 0 to height, otherwise the range is from -height/2 to height/2.
     * @param value New value.
     */
    public void setCenter(boolean value) {
        this.center = value;
    }

    /**
     * The offset that used in twisting, default value is (0, 0, 0).
     * @return the twist offset vector.
     */
    public Vector3 getTwistOffset() {
        return twistOffset;
    }

    /**
     * The offset that used in twisting, default value is (0, 0, 0).
     * @param value New value.
     */
    public void setTwistOffset(Vector3 value) {
        this.twistOffset = value;
    }

    /**
     * The number of degrees of through which the shape is extruded.
     * @return the twist angle in degrees.
     */
    public double getTwist() {
        return twist;
    }

    /**
     * The number of degrees of through which the shape is extruded.
     * @param value New value.
     */
    public void setTwist(double value) {
        this.twist = value;
    }

    /**
     * Convert the extrusion to mesh.
     * @return The converted mesh.
     * @throws UnsupportedOperationException always - conversion not yet implemented.
     */
    public Mesh toMesh() {
        throw new UnsupportedOperationException("LinearExtrusion to mesh conversion is not yet implemented");
    }
}
