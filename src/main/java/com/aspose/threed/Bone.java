package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * A bone defines the subset of the geometry's control point, and defined blend weight for each control point.
 * The Bone object cannot be used directly, a SkinDeformer instance is used to deform the geometry, and SkinDeformer comes with a set of bones, each bone linked to a node.
 * NOTE: A control point of a geometry can be bounded to more than one Bones.
 */
public class Bone extends A3DObject {
    private BoneLinkMode linkMode;
    private List<Double> weights;
    private Matrix4 transform;
    private Matrix4 boneTransform;
    private Node node;

    /**
     * Initializes a new instance of the Bone class.
     */
    public Bone() {
        this("Bone");
    }

    /**
     * Initializes a new instance of the Bone class.
     * @param name Name.
     */
    public Bone(String name) {
        super(name);
        weights = new ArrayList<Double>();
        transform = new Matrix4();
        boneTransform = new Matrix4();
    }

    /**
     * A bone's link mode refers to the way in which a bone is connected or linked to its parent bone within a hierarchical structure.
     * @return A bone's link mode.
     */
    public BoneLinkMode getLinkMode() {
        return linkMode;
    }

    /**
     * A bone's link mode refers to the way in which a bone is connected or linked to its parent bone within a hierarchical structure.
     * @param value New value.
     */
    public void setLinkMode(BoneLinkMode value) {
        this.linkMode = value;
    }

    /**
     * Gets the weight for control point specified by index.
     * @param index Control point's index.
     * @return the weight at specified index, or 0 if the index is invalid.
     */
    public double getWeight(int index) {
        if (index < 0 || index >= weights.size()) {
            return 0.0;
        }
        return weights.get(index);
    }

    /**
     * Sets the weight for control point specified by index.
     * @param index Control point's index.
     * @param weight New weight.
     */
    public void setWeight(int index, double weight) {
        while (weights.size() <= index) {
            weights.add(0.0);
        }
        weights.set(index, weight);
    }

    /**
     * Gets the count of weight, this is automatically extended by setWeight(int, double).
     * @return the count of weight.
     */
    public int getWeightCount() {
        return weights.size();
    }

    /**
     * Gets the transform matrix of the node containing the bone.
     * @return the transform matrix of the node containing the bone.
     */
    public Matrix4 getTransform() {
        return transform;
    }

    /**
     * Sets the transform matrix of the node containing the bone.
     * @param value New value.
     */
    public void setTransform(Matrix4 value) {
        this.transform = value;
    }

    /**
     * Gets the transform matrix of the bone.
     * @return the transform matrix of the bone.
     */
    public Matrix4 getBoneTransform() {
        return boneTransform;
    }

    /**
     * Sets the transform matrix of the bone.
     * @param value New value.
     */
    public void setBoneTransform(Matrix4 value) {
        this.boneTransform = value;
    }

    /**
     * Gets the node. The bone node is the bone which skin attached to, the SkinDeformer will use bone node to influence the displacement of the control points.
     * @return the node.
     * @throws java.lang.IllegalStateException if node is not set.
     */
    public Node getNode() {
        if (node == null) {
            throw new IllegalStateException("Node is not set");
        }
        return node;
    }

    /**
     * Sets the node. The bone node is the bone which skin attached to, the SkinDeformer will use bone node to influence the displacement of the control points.
     * @param value New value.
     */
    public void setNode(Node value) {
        this.node = value;
    }

    /**
     * Gets or sets the weight at the specified index.
     * @param index Index of the weight.
     * @return The weight.
     */
    public double get(int index) {
        return getWeight(index);
    }

    /**
     * Sets the blend weight of specified control point.
     * @param index Index of the weight.
     * @param value New value.
     */
    public void set(int index, double value) {
        setWeight(index, value);
    }
}
