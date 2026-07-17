package com.aspose.threed;

public class VertexElementVertexColor extends VertexElementFVector {
    public VertexElementVertexColor() {
    }

    public VertexElementVertexColor(MappingMode mappingMode, ReferenceMode referenceMode) {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.VERTEX_COLOR;
    }

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementVertexColor element = new VertexElementVertexColor();
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        return element;
    }

    public void clear() {
        getIndices().clear();
    }
}
