package com.aspose.threed;

public class Transform extends A3DObject {
    private final Vector3 translation = new Vector3();
    private final Vector3 scaling = new Vector3(1, 1, 1);
    private final Vector3 rotation = new Vector3();
    private Quaternion quaternion = new Quaternion(0, 0, 0, 1);

    private final Vector3 geometricTranslation = new Vector3();
    private final Vector3 geometricScaling = new Vector3(1, 1, 1);
    private final Vector3 geometricRotation = new Vector3();

    private final Vector3 scalingOffset = new Vector3();
    private final Vector3 scalingPivot = new Vector3();
    private final Vector3 rotationOffset = new Vector3();
    private final Vector3 rotationPivot = new Vector3();
    private final Vector3 preRotation = new Vector3();
    private final Vector3 postRotation = new Vector3();

    private Matrix4 transformMatrix;

    public Transform() {
        super();
    }

    public Transform(String name) {
        super(name);
    }

    public Vector3 getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3 value) {
        this.translation.x = value.x;
        this.translation.y = value.y;
        this.translation.z = value.z;
        transformMatrix = null;
    }

    public Transform setTranslation(double x, double y, double z) {
        this.translation.x = x;
        this.translation.y = y;
        this.translation.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getScaling() {
        return scaling;
    }

    public void setScaling(Vector3 value) {
        this.scaling.x = value.x;
        this.scaling.y = value.y;
        this.scaling.z = value.z;
        transformMatrix = null;
    }

    public Transform setScale(double x, double y, double z) {
        this.scaling.x = x;
        this.scaling.y = y;
        this.scaling.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getEulerAngles() {
        return rotation;
    }

    public void setEulerAngles(Vector3 value) {
        this.rotation.x = value.x;
        this.rotation.y = value.y;
        this.rotation.z = value.z;
        transformMatrix = null;
    }

    public Transform setEulerAngles(double x, double y, double z) {
        this.rotation.x = x;
        this.rotation.y = y;
        this.rotation.z = z;
        transformMatrix = null;
        return this;
    }

    public Quaternion getRotation() {
        return quaternion;
    }

    public void setRotation(Quaternion value) {
        this.quaternion.x = value.x;
        this.quaternion.y = value.y;
        this.quaternion.z = value.z;
        this.quaternion.w = value.w;
        transformMatrix = null;
    }

    public Transform setRotation(double x, double y, double z, double w) {
        this.quaternion.x = x;
        this.quaternion.y = y;
        this.quaternion.z = z;
        this.quaternion.w = w;
        transformMatrix = null;
        return this;
    }

    public Transform setPreRotation(double x, double y, double z) {
        this.preRotation.x = x;
        this.preRotation.y = y;
        this.preRotation.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getPreRotation() {
        return preRotation;
    }

    public void setPreRotation(Vector3 value) {
        this.preRotation.x = value.x;
        this.preRotation.y = value.y;
        this.preRotation.z = value.z;
        transformMatrix = null;
    }

    public Transform setPostRotation(double x, double y, double z) {
        this.postRotation.x = x;
        this.postRotation.y = y;
        this.postRotation.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getPostRotation() {
        return postRotation;
    }

    public void setPostRotation(Vector3 value) {
        this.postRotation.x = value.x;
        this.postRotation.y = value.y;
        this.postRotation.z = value.z;
        transformMatrix = null;
    }

    public Vector3 getGeometricTranslation() {
        return geometricTranslation;
    }

    public void setGeometricTranslation(Vector3 value) {
        this.geometricTranslation.x = value.x;
        this.geometricTranslation.y = value.y;
        this.geometricTranslation.z = value.z;
        transformMatrix = null;
    }

    public Transform setGeometricTranslation(double x, double y, double z) {
        this.geometricTranslation.x = x;
        this.geometricTranslation.y = y;
        this.geometricTranslation.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getGeometricScaling() {
        return geometricScaling;
    }

    public void setGeometricScaling(Vector3 value) {
        this.geometricScaling.x = value.x;
        this.geometricScaling.y = value.y;
        this.geometricScaling.z = value.z;
        transformMatrix = null;
    }

    public Transform setGeometricScaling(double x, double y, double z) {
        this.geometricScaling.x = x;
        this.geometricScaling.y = y;
        this.geometricScaling.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getGeometricRotation() {
        return geometricRotation;
    }

    public void setGeometricRotation(Vector3 value) {
        this.geometricRotation.x = value.x;
        this.geometricRotation.y = value.y;
        this.geometricRotation.z = value.z;
        transformMatrix = null;
    }

    public Transform setGeometricRotation(double x, double y, double z) {
        this.geometricRotation.x = x;
        this.geometricRotation.y = y;
        this.geometricRotation.z = z;
        transformMatrix = null;
        return this;
    }

    public Vector3 getScalingOffset() {
        return scalingOffset;
    }

    public void setScalingOffset(Vector3 value) {
        this.scalingOffset.x = value.x;
        this.scalingOffset.y = value.y;
        this.scalingOffset.z = value.z;
        transformMatrix = null;
    }

    public Vector3 getScalingPivot() {
        return scalingPivot;
    }

    public void setScalingPivot(Vector3 value) {
        this.scalingPivot.x = value.x;
        this.scalingPivot.y = value.y;
        this.scalingPivot.z = value.z;
        transformMatrix = null;
    }

    public Vector3 getRotationOffset() {
        return rotationOffset;
    }

    public void setRotationOffset(Vector3 value) {
        this.rotationOffset.x = value.x;
        this.rotationOffset.y = value.y;
        this.rotationOffset.z = value.z;
        transformMatrix = null;
    }

    public Vector3 getRotationPivot() {
        return rotationPivot;
    }

    public void setRotationPivot(Vector3 value) {
        this.rotationPivot.x = value.x;
        this.rotationPivot.y = value.y;
        this.rotationPivot.z = value.z;
        transformMatrix = null;
    }

    public Matrix4 getTransformMatrix() {
        if (transformMatrix == null) {
            Matrix4 tm = Matrix4.translate(translation);
            Matrix4 rm = Matrix4.rotate(quaternion);
            Matrix4 sm = Matrix4.scale(scaling);
            transformMatrix = Matrix4.mul(Matrix4.mul(sm, rm), tm);
        }
        return transformMatrix;
    }

    public void setTransformMatrix(Matrix4 value) {
        this.transformMatrix = value;
    }
}
