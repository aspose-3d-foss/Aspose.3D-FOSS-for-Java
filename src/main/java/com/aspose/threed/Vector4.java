package com.aspose.threed;

import java.io.Serializable;

public final class Vector4 implements Serializable {
    public double x;
    public double y;
    public double z;
    public double w;

    public Vector4() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    public Vector4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
}
