package com.aspose.threed;

/**
 * This class represents a solid model by revolving a cross section provided by a profile about an axis.
 */
public class RevolvedAreaSolid extends Entity implements IMeshConvertible {
    private double angleStart = 0;
    private double angleEnd = Math.PI;
    private Vector3 axis = new Vector3(0, 1, 0);
    private Vector3 origin = new Vector3(0, 0, 0);
    private Profile shape;

    /**
     * Gets the starting angle of the revolving procedure, measured in radian.
     */
    public double getAngleStart() {
        return angleStart;
    }

    public void setAngleStart(double value) {
        this.angleStart = value;
    }

    /**
     * Gets the ending angle of the revolving procedure, measured in radian.
     */
    public double getAngleEnd() {
        return angleEnd;
    }

    public void setAngleEnd(double value) {
        this.angleEnd = value;
    }

    /**
     * Gets the axis direction.
     */
    public Vector3 getAxis() {
        return axis;
    }

    public void setAxis(Vector3 value) {
        this.axis = value;
    }

    /**
     * Gets the origin point of the revolving.
     */
    public Vector3 getOrigin() {
        return origin;
    }

    public void setOrigin(Vector3 value) {
        this.origin = value;
    }

    /**
     * Gets the base profile used to revolve.
     */
    public Profile getShape() {
        return shape;
    }

    public void setShape(Profile value) {
        this.shape = value;
    }

    /**
     * Constructor of RevolvedAreaSolid.
     */
    public RevolvedAreaSolid() {
        super("RevolvedAreaSolid");
    }

    @Override
    public Mesh toMesh() {
        throw new UnsupportedOperationException();
    }
}
