package com.aspose.threed;

public class VertexElementMaterial extends VertexElement {
    public VertexElementMaterial() {
    }

    public VertexElementMaterial(MappingMode mappingMode, ReferenceMode referenceMode) {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.MATERIAL;
    }

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementMaterial element = new VertexElementMaterial();
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
