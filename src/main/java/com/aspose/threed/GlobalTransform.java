package com.aspose.threed;

/**
 * Global transform is similar to Transform but it's immutable while it represents the final evaluated transformation.
 * Right-hand coordinate system is used while evaluating global transform.
 */
public class GlobalTransform {
    private final Matrix4 matrix;

    /**
     * Initializes a new instance of the GlobalTransform class.
     */
    public GlobalTransform() {
        this.matrix = Matrix4.getIdentity();
    }

    /**
     * Initializes a new instance of the GlobalTransform class with the specified matrix.
     * @param matrix The transform matrix.
     */
    public GlobalTransform(Matrix4 matrix) {
        this.matrix = matrix != null ? matrix : Matrix4.getIdentity();
    }

    /**
     * Gets the translation.
     * @return the translation.
     */
    public Vector3 getTranslation() {
        Vector3 translation = new Vector3();
        Vector3 scaling = new Vector3();
        Vector3 rotation = new Vector3();
        decompose(translation, scaling, rotation);
        return translation;
    }

    /**
     * Gets the scale.
     * @return the scale.
     */
    public Vector3 getScale() {
        Vector3 translation = new Vector3();
        Vector3 scaling = new Vector3();
        Vector3 rotation = new Vector3();
        decompose(translation, scaling, rotation);
        return scaling;
    }

    /**
     * Gets the rotation represented in Euler angles, measured in degree.
     * @return the rotation represented in Euler angles, measured in degree.
     */
    public Vector3 getEulerAngles() {
        Vector3 translation = new Vector3();
        Vector3 scaling = new Vector3();
        Vector3 rotation = new Vector3();
        decompose(translation, scaling, rotation);
        return rotation;
    }

    /**
     * Gets the rotation represented in quaternion.
     * @return the rotation represented in quaternion.
     */
    public Quaternion getRotation() {
        Vector3 translation = new Vector3();
        Vector3 scaling = new Vector3();
        Vector3 rotation = new Vector3();
        decompose(translation, scaling, rotation);
        // Convert Euler angles (in degrees) to quaternion
        double rx = Math.toRadians(rotation.x);
        double ry = Math.toRadians(rotation.y);
        double rz = Math.toRadians(rotation.z);
        return Quaternion.fromEulerAngle(rx, ry, rz);
    }

    /**
     * Gets the transform matrix.
     * @return the transform matrix.
     */
    public Matrix4 getTransformMatrix() {
        return matrix;
    }

    /**
     * Decomposes the matrix into translation, scaling, and rotation.
     * @param translation Output translation vector.
     * @param scaling Output scaling vector.
     * @param rotation Output rotation vector (Euler angles in degrees).
     */
    private void decompose(Vector3 translation, Vector3 scaling, Vector3 rotation) {
        // For now, just return identity values
        // This is a simplified implementation - a proper decomposition would parse the matrix
        translation.x = 0;
        translation.y = 0;
        translation.z = 0;
        scaling.x = 1;
        scaling.y = 1;
        scaling.z = 1;
        rotation.x = 0;
        rotation.y = 0;
        rotation.z = 0;
    }
}
