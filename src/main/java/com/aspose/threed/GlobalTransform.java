package com.aspose.threed;

public class GlobalTransform {
    private final Matrix4 matrix = Matrix4.getIdentity();
    private final Vector3 translation = new Vector3();
    private final Vector3 rotation = new Vector3();
    private final Vector3 scale = new Vector3(1, 1, 1);

    public GlobalTransform() {
    }

    public Matrix4 getMatrix() {
        return matrix;
    }

    public Vector3 getTranslation() {
        return translation;
    }

    public Vector3 getRotation() {
        return rotation;
    }

    public Vector3 getScale() {
        return scale;
    }
}
