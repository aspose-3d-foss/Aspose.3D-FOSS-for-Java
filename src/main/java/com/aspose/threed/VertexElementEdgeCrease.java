package com.aspose.threed;

public class VertexElementEdgeCrease extends VertexElementDoublesTemplate {
    public VertexElementEdgeCrease() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.EDGE_CREASE;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
