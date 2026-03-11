package com.aspose.threed;

import java.io.Serializable;

public final class FVector3 implements Serializable {
    public float x;
    public float y;
    public float z;

    public FVector3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public FVector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
