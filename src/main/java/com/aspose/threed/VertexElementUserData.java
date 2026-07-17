package com.aspose.threed;

public class VertexElementUserData extends VertexElement {
    private Object data;

    public VertexElementUserData() {
    }

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementUserData element = new VertexElementUserData();
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        if (withData) {
            element.setData(getData());
        }
        return element;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object value) {
        this.data = value;
    }

    public void clear() {
        this.data = null;
        getIndices().clear();
    }
}
