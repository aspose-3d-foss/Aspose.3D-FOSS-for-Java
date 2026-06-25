package com.aspose.threed;

/**
 * A point cloud represents a collection of points in 3D space.
 * Point cloud can be used to represent 3D scanned data or sparse 3D models.
 */
public class PointCloud extends Entity {
    /**
     * Constructor of PointCloud.
     */
    public PointCloud() {
        this("PointCloud");
    }

    /**
     * Constructor of PointCloud.
     * @param name The name of the point cloud.
     */
    public PointCloud(String name) {
        super(name);
    }
}
