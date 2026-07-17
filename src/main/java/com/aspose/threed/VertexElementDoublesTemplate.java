package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class VertexElementDoublesTemplate extends VertexElement {
    private final List<Double> data = new ArrayList<Double>();

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementDoublesTemplate element = new VertexElementDoublesTemplate();
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        if (withData) {
            for (Double v : data) {
                element.getData().add(v);
            }
        }
        return element;
    }

    public void copyTo(VertexElementDoublesTemplate target) {
        target.getData().clear();
        target.getData().addAll(this.getData());
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data.clear();
        for (double v : data) {
            this.data.add(v);
        }
    }

    public void clear() {
        data.clear();
        getIndices().clear();
    }
}
