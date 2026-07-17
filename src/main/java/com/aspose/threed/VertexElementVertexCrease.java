package com.aspose.threed;

public class VertexElementVertexCrease extends VertexElementDoublesTemplate {
    public VertexElementVertexCrease() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.VERTEX_CREASE;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
