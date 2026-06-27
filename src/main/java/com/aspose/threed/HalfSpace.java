package com.aspose.threed;

/**
 * HalfSpace represents a infinity space which is split by a plane, this can be used with BooleanOperator.
 */
public class HalfSpace extends Entity {
    private Vector3 normal;
    private Vector3 position;

    /**
     * Constructs a new instance of HalfSpace.
     */
    public HalfSpace() {
        super("HalfSpace");
        this.normal = Vector3.getUnitY();
        this.position = Vector3.getZero();
    }

    /**
     * The normal of the split plane, the plane is defined as N * P + D = 0 where N is Normal and P is any point on the plane.
     * @return The normal of the split plane, the plane is defined as N * P + D = 0 where N is Normal and P is any point on the plane.
     */
    public Vector3 getNormal() {
        return normal;
    }

    /**
     * The normal of the split plane, the plane is defined as N * P + D = 0 where N is Normal and P is any point on the plane.
     * @param value New value
     */
    public void setNormal(Vector3 value) {
        this.normal = value;
    }

    /**
     * The any point on the split plane, the plane is defined as N * P + D = 0 where N is Normal and P is any point on the plane.
     * @return The any point on the split plane, the plane is defined as N * P + D = 0 where N is Normal and P is any point on the plane.
     */
    public Vector3 getPosition() {
        return position;
    }

    /**
     * The any point on the split plane, the plane is defined as N * P + D = 0 where N is Normal and P is any point on the plane.
     * @param value New value
     */
    public void setPosition(Vector3 value) {
        this.position = value;
    }
}
