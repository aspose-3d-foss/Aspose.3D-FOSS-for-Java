package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class VertexElementTemplate<T> extends VertexElement {
    private final List<T> data = new ArrayList<T>();

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementTemplate<T> element = new VertexElementTemplate<T>();
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        if (withData) {
            for (T v : data) {
                element.getData().add(v);
            }
        }
        return element;
    }

    public void copyTo(VertexElementTemplate<T> target) {
        target.getData().clear();
        target.getData().addAll(this.getData());
    }

    public List<T> getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data.clear();
        for (T v : data) {
            this.data.add(v);
        }
    }

    public void clear() {
        data.clear();
        getIndices().clear();
    }
}
