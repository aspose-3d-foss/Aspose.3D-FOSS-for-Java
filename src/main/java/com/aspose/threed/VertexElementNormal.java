package com.aspose.threed;

public class VertexElementNormal extends VertexElementFVector {
    public VertexElementNormal() {
    }

    public VertexElementNormal(MappingMode mappingMode, ReferenceMode referenceMode) {
        setMappingMode(mappingMode);
        setReferenceMode(referenceMode);
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.NORMAL;
    }

    public void clear() {
        getIndices().clear();
    }
}
