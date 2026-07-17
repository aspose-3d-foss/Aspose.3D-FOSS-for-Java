package com.aspose.threed;

public class VertexElementWeight extends VertexElementDoublesTemplate {
    public VertexElementWeight() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.WEIGHT;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
