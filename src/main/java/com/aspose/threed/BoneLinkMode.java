package com.aspose.threed;

/**
 * A bone's link mode refers to the way in which a bone is connected or linked to its parent bone within a hierarchical structure.
 */
public enum BoneLinkMode {
    /**
     * In this mode, the transformations of child bones are normalized concerning their parent bone's transformations.
     */
    NORMALIZE,
    /**
     * Additive mode calculates the transformations of child bones by adding their own local transformations to those of their parent bones.
     */
    ADDITIVE,
    /**
     * Total One ensures that combined transformations of the parent and child bones result in a combined transformation that scales to an overall length of one unit.
     */
    TOTAL_ONE;
}
