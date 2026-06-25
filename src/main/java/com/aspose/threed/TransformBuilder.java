package com.aspose.threed;

/**
 * Utility class for building transformation matrices.
 */
public class TransformBuilder {
    private Matrix4 matrix;
    private ComposeOrder order;

    /**
     * Creates a new TransformBuilder with identity matrix and specified order.
     * @param order The compose order.
     */
    public TransformBuilder(ComposeOrder order) {
        this(Matrix4.getIdentity(), order);
    }

    /**
     * Creates a new TransformBuilder with specified initial matrix and order.
     * @param initial The initial matrix.
     * @param order The compose order.
     */
    public TransformBuilder(Matrix4 initial, ComposeOrder order) {
        this.matrix = initial;
        this.order = order;
    }

    /**
     * Gets the current matrix.
     * @return The matrix.
     */
    public Matrix4 getMatrix() {
        return matrix;
    }

    /**
     * Sets the current matrix.
     * @param value The matrix.
     */
    public void setMatrix(Matrix4 value) {
        this.matrix = value;
    }

    /**
     * Gets the compose order.
     * @return The compose order.
     */
    public ComposeOrder getComposeOrder() {
        return order;
    }

    /**
     * Sets the compose order.
     * @param value The compose order.
     */
    public void setComposeOrder(ComposeOrder value) {
        this.order = value;
    }

    /**
     * Composes the specified matrix with the current matrix.
     * @param m The matrix to compose.
     */
    public void compose(Matrix4 m) {
        if (order == ComposeOrder.APPEND) {
            matrix = matrix.concatenate(m);
        } else {
            matrix = m.concatenate(matrix);
        }
    }

    /**
     * Appends the specified matrix to the current matrix.
     * @param m The matrix to append.
     * @return This builder for method chaining.
     */
    public TransformBuilder append(Matrix4 m) {
        compose(m);
        return this;
    }

    /**
     * Prepends the specified matrix to the current matrix.
     * @param m The matrix to prepend.
     * @return This builder for method chaining.
     */
    public TransformBuilder prepend(Matrix4 m) {
        matrix = m.concatenate(matrix);
        return this;
    }

    /**
     * Scales the current matrix by the specified scalar.
     * @param s The scale factor.
     * @return This builder for method chaining.
     */
    public TransformBuilder scale(double s) {
        return scale(s, s, s);
    }

    /**
     * Scales the current matrix by the specified factors.
     * @param x X scale factor.
     * @param y Y scale factor.
     * @param z Z scale factor.
     * @return This builder for method chaining.
     */
    public TransformBuilder scale(double x, double y, double z) {
        Matrix4 scale = Matrix4.scale(x, y, z);
        compose(scale);
        return this;
    }

    /**
     * Scales the current matrix by the specified vector.
     * @param s The scale vector.
     * @return This builder for method chaining.
     */
    public TransformBuilder scale(Vector3 s) {
        Matrix4 scale = Matrix4.scale(s);
        compose(scale);
        return this;
    }

    /**
     * Rotates the current matrix by the specified angle (in degrees) around the specified axis.
     * @param angle Angle in degrees.
     * @param axis Rotation axis.
     * @return This builder for method chaining.
     */
    public TransformBuilder rotateDegree(double angle, Vector3 axis) {
        return rotateRadian(angle * Math.PI / 180.0, axis);
    }

    /**
     * Rotates the current matrix by the specified angle (in radians) around the specified axis.
     * @param angle Angle in radians.
     * @param axis Rotation axis.
     * @return This builder for method chaining.
     */
    public TransformBuilder rotateRadian(double angle, Vector3 axis) {
        Matrix4 rotation = Matrix4.rotate(angle, axis);
        compose(rotation);
        return this;
    }

    /**
     * Rotates the current matrix by the specified quaternion.
     * @param q The quaternion.
     * @return This builder for method chaining.
     */
    public TransformBuilder rotate(Quaternion q) {
        Matrix4 rotation = Matrix4.rotate(q);
        compose(rotation);
        return this;
    }

    /**
     * Rotates the current matrix by the specified Euler angles (in degrees).
     * @param degX X angle in degrees.
     * @param degY Y angle in degrees.
     * @param degZ Z angle in degrees.
     * @return This builder for method chaining.
     */
    public TransformBuilder rotateEulerDegree(double degX, double degY, double degZ) {
        return rotateEulerRadian(degX * Math.PI / 180.0, degY * Math.PI / 180.0, degZ * Math.PI / 180.0);
    }

    /**
     * Rotates the current matrix by the specified Euler angles (in radians).
     * @param x X angle in radians.
     * @param y Y angle in radians.
     * @param z Z angle in radians.
     * @return This builder for method chaining.
     */
    public TransformBuilder rotateEulerRadian(double x, double y, double z) {
        return rotateEulerRadian(new Vector3(x, y, z));
    }

    /**
     * Rotates the current matrix by the specified Euler angles (in radians).
     * @param r The Euler angles vector.
     * @return This builder for method chaining.
     */
    public TransformBuilder rotateEulerRadian(Vector3 r) {
        rotateRadian(r, RotationOrder.XYZ);
        return this;
    }

    /**
     * Translates the current matrix by the specified vector.
     * @param tx X translation.
     * @param ty Y translation.
     * @param tz Z translation.
     * @return This builder for method chaining.
     */
    public TransformBuilder translate(double tx, double ty, double tz) {
        Matrix4 translation = Matrix4.translate(tx, ty, tz);
        compose(translation);
        return this;
    }

    /**
     * Translates the current matrix by the specified vector.
     * @param v The translation vector.
     * @return This builder for method chaining.
     */
    public TransformBuilder translate(Vector3 v) {
        Matrix4 translation = Matrix4.translate(v);
        compose(translation);
        return this;
    }

    /**
     * Resets the matrix to identity.
     */
    public void reset() {
        matrix = Matrix4.getIdentity();
    }

    /**
     * Rotates the current matrix by the specified Euler angles (in degrees) with the specified order.
     * @param rot The Euler angles in degrees.
     * @param order The rotation order.
     */
    public void rotateDegree(Vector3 rot, RotationOrder order) {
        rotateRadian(new Vector3(rot.x * Math.PI / 180.0, rot.y * Math.PI / 180.0, rot.z * Math.PI / 180.0), order);
    }

    /**
     * Rotates the current matrix by the specified Euler angles (in radians) with the specified order.
     * @param rot The Euler angles in radians.
     * @param order The rotation order.
     */
    public void rotateRadian(Vector3 rot, RotationOrder order) {
        Matrix4 rx = Matrix4.rotateFromEuler(new Vector3(rot.x, 0, 0));
        Matrix4 ry = Matrix4.rotateFromEuler(new Vector3(0, rot.y, 0));
        Matrix4 rz = Matrix4.rotateFromEuler(new Vector3(0, 0, rot.z));

        Matrix4 combined;
        switch (order) {
            case XYZ:
                combined = Matrix4.mul(Matrix4.mul(rx, ry), rz);
                break;
            case XZY:
                combined = Matrix4.mul(Matrix4.mul(rx, rz), ry);
                break;
            case YZX:
                combined = Matrix4.mul(Matrix4.mul(ry, rz), rx);
                break;
            case YXZ:
                combined = Matrix4.mul(Matrix4.mul(ry, rx), rz);
                break;
            case ZXY:
                combined = Matrix4.mul(Matrix4.mul(rz, rx), ry);
                break;
            case ZYX:
                combined = Matrix4.mul(Matrix4.mul(rz, ry), rx);
                break;
            default:
                throw new IllegalArgumentException("Unknown rotation order");
        }

        compose(combined);
    }
}
