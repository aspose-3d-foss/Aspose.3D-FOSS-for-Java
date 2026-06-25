package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * A skin deformer contains multiple bones to work, each bone blends a part of the geometry by control point's weights.
 */
public class SkinDeformer extends Deformer {
    private List<Bone> bones;

    /**
     * Initializes a new instance of the SkinDeformer class.
     */
    public SkinDeformer() {
        this("SkinDeformer");
    }

    /**
     * Initializes a new instance of the SkinDeformer class.
     * @param name Name.
     */
    public SkinDeformer(String name) {
        super(name);
        bones = new ArrayList<Bone>();
    }

    /**
     * Gets all bones that the skin deformer contains.
     * @return the list of bones.
     */
    public List<Bone> getBones() {
        return bones;
    }
}
