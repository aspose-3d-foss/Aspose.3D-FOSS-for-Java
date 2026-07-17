package com.aspose.threed;

public class VertexElementVisibility extends VertexElementTemplate<Boolean> {
    public VertexElementVisibility() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.VISIBILITY;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
