package com.aspose.threed;

public enum Interpolation {
    /**
     * The value will remains constant to the value of the first point until the next segment.
     */
    CONSTANT,
    /**
     * Linear interpolation is a straight line between two points.
     */
    LINEAR,
    /**
     * A bezier or Hermite spline.
     */
    BEZIER,
    /**
     * Basis splines are defined by a series of control points, for which the curve is guaranteed only to go through the first and the last point.
     */
    B_SPLINE,
    /**
     * A cardinal spline is a cubic Hermite spline whose tangents are defined by the endpoints and a tension parameter.
     */
    CARDINAL_SPLINE,
    /**
     * Also called Kochanek-Bartels spline, the behavior of tangent is defined by tension/bias/continuity
     */
    TCB_SPLINE
}
