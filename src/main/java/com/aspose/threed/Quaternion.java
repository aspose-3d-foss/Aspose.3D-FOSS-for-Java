package com.aspose.threed;

import java.io.Serializable;

public final class Quaternion implements Serializable {
    public double x;
    public double y;
    public double z;
    public double w;

    public Quaternion() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 1;
    }

    public Quaternion(double w, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static Quaternion fromEulerAngle(double pitch, double yaw, double roll) {
        double cx = Math.cos(pitch * 0.5);
        double sx = Math.sin(pitch * 0.5);
        double cy = Math.cos(yaw * 0.5);
        double sy = Math.sin(yaw * 0.5);
        double cz = Math.cos(roll * 0.5);
        double sz = Math.sin(roll * 0.5);

        double qw = cx * cy * cz + sx * sy * sz;
        double qx = sx * cy * cz - cx * sy * sz;
        double qy = cx * sy * cz + sx * cy * sz;
        double qz = cx * cy * sz - sx * sy * cz;

        return new Quaternion(qw, qx, qy, qz);
    }

    public static Quaternion fromAngleAxis(double angle, Vector3 axis) {
        double halfAngle = angle * 0.5;
        double s = Math.sin(halfAngle);
        return new Quaternion(
            Math.cos(halfAngle),
            axis.x * s,
            axis.y * s,
            axis.z * s
        );
    }

    public static Quaternion getIdentity() {
        return new Quaternion(1, 0, 0, 0);
    }

    public Quaternion normalize() {
        double len = Math.sqrt(x*x + y*y + z*z + w*w);
        if (len > 0) {
            x /= len;
            y /= len;
            z /= len;
            w /= len;
        }
        return this;
    }

    public Quaternion conjugate() {
        return new Quaternion(w, -x, -y, -z);
    }

    public static Quaternion multiply(Quaternion a, Quaternion b) {
        return new Quaternion(
            a.w * b.w - a.x * b.x - a.y * b.y - a.z * b.z,
            a.w * b.x + a.x * b.w + a.y * b.z - a.z * b.y,
            a.w * b.y - a.x * b.z + a.y * b.w + a.z * b.x,
            a.w * b.z + a.x * b.y - a.y * b.x + a.z * b.w
        );
    }

    public Quaternion multiply(Quaternion q) {
        return multiply(this, q);
    }
}
