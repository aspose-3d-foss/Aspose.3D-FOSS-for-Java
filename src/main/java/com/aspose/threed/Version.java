package com.aspose.threed;

import java.io.Serializable;

public class Version implements Serializable, Cloneable {
    private final int major;
    private final int minor;
    private final int build;

    public Version(int major, int minor) {
        this(major, minor, 0);
    }

    public Version(String versionString) {
        String[] parts = versionString.split("\\.");
        this.major = parts.length > 0 ? Integer.parseInt(parts[0]) : 0;
        this.minor = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
        this.build = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
    }

    public Version(int major, int minor, int build) {
        this.major = major;
        this.minor = minor;
        this.build = build;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getBuild() {
        return build;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Version other) {
            return major == other.major && minor == other.minor && build == other.build;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return major * 10000 + minor * 100 + build;
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + build;
    }

    @Override
    public Version clone() {
        return new Version(major, minor, build);
    }
}
