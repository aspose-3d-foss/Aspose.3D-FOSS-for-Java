package com.aspose.threed;

public class VertexElementSpecular extends VertexElementFVector {
    public VertexElementSpecular() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.SPECULAR;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
