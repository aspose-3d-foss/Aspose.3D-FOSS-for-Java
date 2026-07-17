package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class VertexElementIntsTemplate extends VertexElement {
    private final List<Integer> data = new ArrayList<Integer>();

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementIntsTemplate element = new VertexElementIntsTemplate();
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        if (withData) {
            for (Integer v : data) {
                element.getData().add(v);
            }
        }
        return element;
    }

    public void copyTo(VertexElementIntsTemplate target) {
        target.getData().clear();
        target.getData().addAll(this.getData());
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data.clear();
        for (int v : data) {
            this.data.add(v);
        }
    }

    public void clear() {
        data.clear();
        getIndices().clear();
    }
}
