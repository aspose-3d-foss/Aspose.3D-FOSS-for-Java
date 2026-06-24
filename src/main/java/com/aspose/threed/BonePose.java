package com.aspose.threed;

/**
 * The BonePose contains the transformation matrix for a bone node
 */
public class BonePose extends A3DObject {
    /**
     * Initializes a new instance of the BonePose class
     */
    public BonePose() {
        super();
    }

    /**
     * Gets the scene node, points to a skinned skeleton node
     */
    private Node node;

    public Node getNode() {
        return node;
    }

    /**
     * Sets the scene node, points to a skinned skeleton node
     */
    public void setNode(Node value) {
        this.node = value;
    }

    /**
     * Gets the transform matrix of the node in current pose.
     */
    private Matrix4 matrix;

    public Matrix4 getMatrix() {
        return matrix;
    }

    /**
     * Sets the transform matrix of the node in current pose.
     */
    public void setMatrix(Matrix4 value) {
        this.matrix = value;
    }

    /**
     * Gets if the matrix is defined in local coordinate.
     */
    private boolean isLocal;

    public boolean isLocal() {
        return isLocal;
    }

    /**
     * Sets if the matrix is defined in local coordinate.
     */
    public void setLocal(boolean value) {
        this.isLocal = value;
    }
}
