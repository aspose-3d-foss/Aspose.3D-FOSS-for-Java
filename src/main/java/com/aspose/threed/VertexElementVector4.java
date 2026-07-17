package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class VertexElementVector4 extends VertexElement {
    private final List<Vector4> data = new ArrayList<Vector4>();

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementVector4 element = new VertexElementVector4();
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        if (withData) {
            for (Vector4 v : data) {
                element.getData().add(v);
            }
        }
        return element;
    }

    public void copyTo(VertexElementVector4 target) {
        target.getData().clear();
        target.getData().addAll(this.getData());
    }

    public List<Vector4> getData() {
        return data;
    }

    public void setData(Vector4[] data) {
        this.data.clear();
        for (Vector4 v : data) {
            this.data.add(v);
        }
    }

    public void clear() {
        data.clear();
        getIndices().clear();
    }
}
