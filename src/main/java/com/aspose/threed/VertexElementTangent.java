package com.aspose.threed;

public class VertexElementTangent extends VertexElementFVector {
    public VertexElementTangent() {
    }

    public VertexElementTangent(MappingMode mappingMode, ReferenceMode referenceMode) {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.TANGENT;
    }

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementTangent element = new VertexElementTangent();
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
