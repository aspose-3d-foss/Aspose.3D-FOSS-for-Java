package com.aspose.threed;

/**
 * The base class of Camera and Light
 */
public abstract class Frustum extends Entity implements IOrientable {
    private RotationMode rotationMode = RotationMode.FIXED_TARGET;
    private double nearPlane = 0.1;
    private double farPlane = 1000.0;
    private double aspect = 1.0;
    private double orthoHeight = 1.0;
    private Vector3 up = new Vector3(0, 1, 0);
    private Vector3 lookAt = new Vector3(0, 0, -1);
    private Vector3 direction = new Vector3(0, 0, -1);
    private Node target;

    protected Frustum(String name) {
        super(name);
    }

    protected Frustum() {
        super();
    }

    /**
     * Gets the frustum's orientation mode
     * This property only works when the getTarget() is null.
     * If the value is RotationMode.FIXED_TARGET, the direction is always calculated by the property getLookAt()
     * Otherwise the getLookAt() is always calculated by the getDirection()
     * @return the frustum's orientation mode
     */
    public RotationMode getRotationMode() {
        return rotationMode;
    }

    /**
     * Sets the frustum's orientation mode
     * This property only works when the getTarget() is null.
     * If the value is RotationMode.FIXED_TARGET, the direction is always calculated by the property getLookAt()
     * Otherwise the getLookAt() is always calculated by the getDirection()
     * @param value New value
     */
    public void setRotationMode(RotationMode value) {
        this.rotationMode = value;
    }

    /**
     * Gets the frustum's near plane distance.
     * @return the frustum's near plane distance.
     */
    public double getNearPlane() {
        return nearPlane;
    }

    /**
     * Sets the frustum's near plane distance.
     * @param value New value
     */
    public void setNearPlane(double value) {
        this.nearPlane = value;
    }

    /**
     * Gets the frustum's far plane distance.
     * @return the frustum's far plane distance.
     */
    public double getFarPlane() {
        return farPlane;
    }

    /**
     * Sets the frustum's far plane distance.
     * @param value New value
     */
    public void setFarPlane(double value) {
        this.farPlane = value;
    }

    /**
     * Gets the aspect ratio of the frustum
     * @return the aspect ratio of the frustum
     */
    public double getAspect() {
        return aspect;
    }

    /**
     * Sets the aspect ratio of the frustum
     * @param value New value
     */
    public void setAspect(double value) {
        this.aspect = value;
    }

    /**
     * Gets the height when frustum in orthographic projection.
     * @return the height when frustum in orthographic projection.
     */
    public double getOrthoHeight() {
        return orthoHeight;
    }

    /**
     * Sets the height when frustum in orthographic projection.
     * @param value New value
     */
    public void setOrthoHeight(double value) {
        this.orthoHeight = value;
    }

    /**
     * Gets the up direction of the camera
     * @return the up direction of the camera
     */
    public Vector3 getUp() {
        return up;
    }

    /**
     * Sets the up direction of the camera
     * @param value New value
     */
    public void setUp(Vector3 value) {
        this.up = value;
    }

    /**
     * Gets the the interested position that the camera is looking at.
     * @return the the interested position that the camera is looking at.
     */
    public Vector3 getLookAt() {
        return lookAt;
    }

    /**
     * Sets the the interested position that the camera is looking at.
     * @param value New value
     */
    public void setLookAt(Vector3 value) {
        this.lookAt = value;
    }

    /**
     * Gets the direction that the camera is looking at.
     * Changes on this property will also affects the getLookAt() and getTarget().
     * @return the direction that the camera is looking at.
     */
    public Vector3 getDirection() {
        return direction;
    }

    /**
     * Sets the direction that the camera is looking at.
     * Changes on this property will also affects the getLookAt() and getTarget().
     * @param value New value
     */
    public void setDirection(Vector3 value) {
        this.direction = value;
    }

    /**
     * Gets the target that the camera is looking at.
     * If the user supports this property, it should be prior to getLookAt() property.
     * @return the target that the camera is looking at.
     */
    public Node getTarget() {
        return target;
    }

    /**
     * Sets the target that the camera is looking at.
     * If the user supports this property, it should be prior to getLookAt() property.
     * @param value New value
     */
    public void setTarget(Node value) {
        this.target = value;
    }
}
