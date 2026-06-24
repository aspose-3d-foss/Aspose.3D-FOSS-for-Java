package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * The pose is used to store transformation matrix when the geometry is skinned.
 * The pose is a set of BonePose, each BonePose saves the concrete transformation information of the bone node.
 */
public class Pose extends A3DObject {
    private final List<BonePose> bonePoses = new ArrayList<BonePose>();

    /**
     * Initializes a new instance of the Pose class.
     */
    public Pose() {
        super();
    }

    /**
     * Initializes a new instance of the Pose class.
     * @param name Name
     */
    public Pose(String name) {
        super(name);
    }

    /**
     * Gets the type of the pose.
     * @return the type of the pose.
     */
    private PoseType poseType;

    public PoseType getPoseType() {
        return poseType;
    }

    /**
     * Sets the type of the pose.
     * @param value New value
     */
    public void setPoseType(PoseType value) {
        this.poseType = value;
    }

    /**
     * Gets all BonePose.
     * @return all BonePose.
     */
    public List<BonePose> getBonePoses() {
        return bonePoses;
    }

    /**
     * Saves pose transformation matrix for the given bone node.
     * @param node Bone Node.
     * @param matrix Transformation matrix.
     * @param localMatrix If set to true means to use local matrix otherwise means global matrix.
     */
    public void addBonePose(Node node, Matrix4 matrix, boolean localMatrix) {
        BonePose bonePose = new BonePose();
        bonePose.setNode(node);
        bonePose.setMatrix(matrix);
        bonePose.setLocal(localMatrix);
        bonePoses.add(bonePose);
    }

    /**
     * Saves pose transformation matrix for the given bone node.
     * Global transformation matrix is implied.
     * @param node Bone Node.
     * @param matrix Transformation matrix.
     */
    public void addBonePose(Node node, Matrix4 matrix) {
        addBonePose(node, matrix, false);
    }
}
