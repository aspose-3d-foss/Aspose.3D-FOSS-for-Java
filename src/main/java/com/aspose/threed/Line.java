package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * A polyline is a path defined by a set of points with getControlPoints(), and connected by getSegments(),
 * which means it can also be a set of connected line segments.
 * The line is usually a linear object, which means it cannot be used to represent a curve, in order to represent a curve, uses NurbsCurve.
 */
public class Line extends Curve {
    private final List<Vector4> controlPoints = new ArrayList<>();
    private boolean visible = true;
    private final List<int[]> segments = new ArrayList<>();

    /**
     * Gets all control points.
     */
    public List<Vector4> getControlPoints() {
        return controlPoints;
    }

    /**
     * Gets if the geometry is visible.
     */
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean value) {
        this.visible = value;
    }

    /**
     * Gets the segments of the line.
     */
    public List<int[]> getSegments() {
        return segments;
    }

    /**
     * Initializes a new instance of the Line class.
     */
    public Line() {
        this("Line");
    }

    /**
     * Initializes a new instance of the Line class.
     * @param name Name.
     */
    public Line(String name) {
        super(name);
    }

    /**
     * Construct a Line instance from a set of points.
     */
    public static Line fromPoints(Vector3... points) {
        Line line = new Line();
        for (Vector3 point : points) {
            line.getControlPoints().add(new Vector4(point.x, point.y, point.z, 1));
        }
        return line;
    }

    /**
     * Generate the sequence 0,1,2,3....getControlPoints().Length-1 to getSegments() so the ControlPoints can be used as a single line.
     */
    public void makeDefaultIndices() {
        segments.clear();
        int[] segment = new int[controlPoints.size()];
        for (int i = 0; i < segment.length; i++) {
            segment[i] = i;
        }
        segments.add(segment);
    }
}
