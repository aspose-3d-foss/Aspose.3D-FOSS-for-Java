package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * NURBS curve is a curve represented by NURBS(Non-uniform rational basis spline),
 * A NURBS curve is defined by its getOrder(), a set of weighted Geometry.getControlPoints() and a getKnotVectors() The w component in control point is used as control point's weight, whatever it is a CurveDimension.TWO_DIMENSIONAL or CurveDimension.THREE_DIMENSIONAL
 */
public class NurbsCurve extends Curve {
    private final List<Vector4> controlPoints = new ArrayList<>();
    private int order = 3;
    private CurveDimension dimension = CurveDimension.THREE_DIMENSIONAL;
    private NurbsType curveType = NurbsType.OPEN;
    private final List<Double> knotVectors = new ArrayList<>();
    private final List<Integer> multiplicity = new ArrayList<>();
    private boolean rational = true;

    /**
     * Gets all control points.
     */
    public List<Vector4> getControlPoints() {
        return controlPoints;
    }

    /**
     * Initializes a new instance of the NurbsCurve class.
     */
    public NurbsCurve() {
        this("NurbsCurve");
    }

    /**
     * Initializes a new instance of the NurbsCurve class.
     * @param name Name
     */
    public NurbsCurve(String name) {
        super(name);
    }

    /**
     * Gets the multiplicity.
     */
    public List<Integer> getMultiplicity() {
        return multiplicity;
    }

    /**
     * Gets the order of a NURBS curve, it defines the number of nearby control points that influence any given point on the curve.
     */
    public int getOrder() {
        return order;
    }

    public void setOrder(int value) {
        this.order = value;
    }

    /**
     * Gets the degree of a NURBS curve, the degree are defined as Order - 1.
     */
    public int getDegree() {
        return order - 1;
    }

    public void setDegree(int value) {
        this.order = value + 1;
    }

    /**
     * Gets the curve's dimension.
     */
    public CurveDimension getDimension() {
        return dimension;
    }

    public void setDimension(CurveDimension value) {
        this.dimension = value;
    }

    /**
     * Gets the type of the curve.
     */
    public NurbsType getCurveType() {
        return curveType;
    }

    public void setCurveType(NurbsType value) {
        this.curveType = value;
    }

    /**
     * Gets the knot vector, it is a sequence of parameter values that determines where and how the control points affect the NURBS curve.
     */
    public List<Double> getKnotVectors() {
        return knotVectors;
    }

    /**
     * Gets whether it is rational.
     */
    public boolean getRational() {
        return rational;
    }

    public void setRational(boolean value) {
        this.rational = value;
    }

    /**
     * Evaluate the NURBS curve
     * @param steps The evaluation frequency between two neighbor knots, default value is 20
     * @return Points in the curve
     */
    public Vector4[] evaluate(int steps) {
        throw new UnsupportedOperationException();
    }

    /**
     * Evaluate the NURBS curve
     * @return Points in the curve
     */
    public Vector4[] evaluate() {
        return evaluate(20);
    }

    /**
     * Evaluate the curve's point at specified position
     * @param u The position in the curve, between 0 and 1
     * @return The point at the specified position
     */
    public Vector4 evaluateAt(double u) {
        throw new UnsupportedOperationException();
    }
}
