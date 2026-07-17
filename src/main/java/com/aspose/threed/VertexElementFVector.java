package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class VertexElementFVector extends VertexElement {
    private final List<FVector4> data = new ArrayList<FVector4>();

    protected VertexElementFVector() {
    }

    protected VertexElementFVector(VertexElementType type) {
        this.type = type;
    }

    public VertexElement clone(boolean withData, boolean withIndices) {
        VertexElementFVector element = new VertexElementFVector(this.getVertexElementType());
        element.setName(getName());
        element.setMappingMode(getMappingMode());
        element.setReferenceMode(getReferenceMode());
        if (withIndices) {
            element.getIndices().addAll(getIndices());
        }
        if (withData) {
            for (FVector4 v : data) {
                element.getData().add(v);
            }
        }
        return element;
    }

    public void copyTo(VertexElementFVector target) {
        target.getData().clear();
        target.getData().addAll(this.getData());
    }

    public List<FVector4> getData() {
        return data;
    }

    public void setData(FVector4[] data) {
        this.data.clear();
        for (FVector4 v : data) {
            this.data.add(v);
        }
    }

    public void setData(FVector3[] data) {
        this.data.clear();
        for (FVector3 v : data) {
            this.data.add(new FVector4(v.x, v.y, v.z, 1));
        }
    }

    public void setData(FVector2[] data) {
        this.data.clear();
        for (FVector2 v : data) {
            this.data.add(new FVector4(v.x, v.y, 0, 1));
        }
    }

    public void clear() {
        data.clear();
        getIndices().clear();
    }
}
