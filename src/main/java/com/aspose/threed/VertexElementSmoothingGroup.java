package com.aspose.threed;

public class VertexElementSmoothingGroup extends VertexElementIntsTemplate {
    public VertexElementSmoothingGroup() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.SMOOTHING_GROUP;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
