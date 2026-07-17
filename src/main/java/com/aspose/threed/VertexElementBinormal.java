package com.aspose.threed;

public class VertexElementBinormal extends VertexElementFVector {
    public VertexElementBinormal() {
    }

    public VertexElementBinormal(MappingMode mappingMode, ReferenceMode referenceMode) {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.BINORMAL;
    }

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementBinormal element = new VertexElementBinormal();
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
