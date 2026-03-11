package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class VertexElement {
    private final VertexElementType type;
    private final MappingMode mappingMode;
    private final ReferenceMode referenceMode;
    private final List<Integer> indices = new ArrayList<>();
    private final List<Object> data = new ArrayList<>();

    protected VertexElement(VertexElementType type, MappingMode mappingMode, ReferenceMode referenceMode) {
        this.type = type;
        this.mappingMode = mappingMode;
        this.referenceMode = referenceMode;
    }

    public VertexElementType getType() {
        return type;
    }

    public MappingMode getMappingMode() {
        return mappingMode;
    }

    public ReferenceMode getReferenceMode() {
        return referenceMode;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data.clear();
        this.data.addAll(data);
    }

    public void setIndices(List<Integer> indices) {
        this.indices.clear();
        this.indices.addAll(indices);
    }

    public VertexElement clone() {
        VertexElement element = new VertexElement(type, mappingMode, referenceMode);
        element.indices.addAll(this.indices);
        element.data.addAll(this.data);
        return element;
    }
}
