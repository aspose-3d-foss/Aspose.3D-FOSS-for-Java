package com.aspose.threed;

import java.io.Serializable;

public final class FVector4 implements Serializable {
    public float x;
    public float y;
    public float z;
    public float w;

    public FVector4() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    public FVector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
}
