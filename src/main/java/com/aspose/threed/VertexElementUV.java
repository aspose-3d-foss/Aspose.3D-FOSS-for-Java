package com.aspose.threed;

public class VertexElementUV extends VertexElementFVector {
    public VertexElementUV() {
    }

    public VertexElementUV(TextureMapping mapping) {
    }

    public VertexElementType getVertexElementType() {
        return VertexElementType.UV;
    }

    protected VertexElementFVector createInstance() {
        return new VertexElementUV();
    }

    public void addData(java.lang.Iterable<Vector2> data) {
        if (data == null)
            return;
        for (Vector2 item : data) {
            getData().add(new FVector4((float)item.x, (float)item.y, 0, 1));
        }
    }

    public void addData2(java.lang.Iterable<Vector3> data) {
        if (data == null)
            return;
        for (Vector3 item : data) {
            getData().add(new FVector4((float)item.x, (float)item.y, (float)item.z, 1));
        }
    }

    public void clear() {
        getData().clear();
        getIndices().clear();
    }
}
