package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * The shape describes the deformation on a set of control points, which is similar to the cluster deformer in Maya.
 * For example, we can add a shape to a created geometry.
 * And the shape and the geometry have the same topological information but different position of the control points.
 * With varying amounts of influence, the geometry performs a deformation effect.
 */
public class Shape extends Geometry {
    private final List<Integer> indices = new ArrayList<>();

    /**
     * Initializes a new instance of the Shape class.
     */
    public Shape() {
        this("Shape");
    }

    /**
     * Initializes a new instance of the Shape class.
     * @param name Name
     */
    public Shape(String name) {
        super(name);
    }

    /**
     * Create a shape with specified control points with a default indices.
     */
    public static Shape fromControlPoints(Vector3... controlPoints) {
        Shape shape = new Shape();
        for (int i = 0; i < controlPoints.length; i++) {
            shape.getIndices().add(i);
        }
        return shape;
    }

    /**
     * Gets the indices.
     */
    public List<Integer> getIndices() {
        return indices;
    }
}
