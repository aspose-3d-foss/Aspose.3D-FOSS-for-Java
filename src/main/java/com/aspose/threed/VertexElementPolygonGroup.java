package com.aspose.threed;

public class VertexElementPolygonGroup extends VertexElementIntsTemplate {
    public VertexElementPolygonGroup() {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.POLYGON_GROUP;
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
