package com.aspose.threed;

/**
 * Share vertex/control point data between sub-meshes or each sub-mesh has its own compacted data.
 */
public enum SplitMeshPolicy {
    /**
     * Control points and vertex elements data will be cloned
     */
    CLONE_DATA,
    /**
     * Only used control points and vertex elements data will be copied to the sub-mesh
     */
    COMPACT_DATA;
}
