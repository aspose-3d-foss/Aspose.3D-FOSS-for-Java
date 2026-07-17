package com.aspose.threed;

public class VertexElementHole extends VertexElementTemplate<Boolean> {
    public VertexElementHole() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.HOLE;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
