package com.aspose.threed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NurbsCurveTests {
    @Test
    public void constructor_ShouldInitializeDefaultValues() {
        NurbsCurve curve = new NurbsCurve();

        assertNotNull(curve);
        assertEquals(2, curve.getOrder());
        assertEquals(1, curve.getDegree());
        assertFalse(curve.getRational());
        assertEquals(CurveDimension.THREE_DIMENSIONAL, curve.getDimension());
        assertEquals(NurbsType.OPEN, curve.getCurveType());
    }

    @Test
    public void constructorWithName_ShouldInitializeWithName() {
        NurbsCurve curve = new NurbsCurve("TestCurve");

        assertEquals("TestCurve", curve.getName());
    }

    @Test
    public void controlPoints_ShouldBeWritable() {
        NurbsCurve curve = new NurbsCurve();
        java.util.List<Vector4> controlPoints = curve.getControlPoints();

        assertNotNull(controlPoints);
        assertEquals(0, controlPoints.size());

        controlPoints.add(new Vector4(1, 2, 3, 1));
        assertEquals(1, controlPoints.size());
    }

    @Test
    public void multiplicity_ShouldBeWritable() {
        NurbsCurve curve = new NurbsCurve();
        java.util.List<Integer> multiplicity = curve.getMultiplicity();

        assertNotNull(multiplicity);
        assertEquals(0, multiplicity.size());

        multiplicity.add(2);
        assertEquals(1, multiplicity.size());
    }

    @Test
    public void knotVectors_ShouldBeWritable() {
        NurbsCurve curve = new NurbsCurve();
        java.util.List<Double> knotVectors = curve.getKnotVectors();

        assertNotNull(knotVectors);
        assertEquals(0, knotVectors.size());

        knotVectors.add(0.0);
        knotVectors.add(1.0);
        assertEquals(2, knotVectors.size());
    }

    @Test
    public void order_ShouldBeSettable() {
        NurbsCurve curve = new NurbsCurve();
        curve.setOrder(4);

        assertEquals(4, curve.getOrder());
        assertEquals(3, curve.getDegree());
    }

    @Test
    public void degree_ShouldBeSettable() {
        NurbsCurve curve = new NurbsCurve();
        curve.setDegree(2);

        assertEquals(3, curve.getOrder());
        assertEquals(2, curve.getDegree());
    }

    @Test
    public void rational_ShouldBeSettable() {
        NurbsCurve curve = new NurbsCurve();
        curve.setRational(true);

        assertTrue(curve.getRational());
    }

    @Test
    public void dimension_ShouldBeSettable() {
        NurbsCurve curve = new NurbsCurve();
        curve.setDimension(CurveDimension.TWO_DIMENSIONAL);

        assertEquals(CurveDimension.TWO_DIMENSIONAL, curve.getDimension());
    }

    @Test
    public void curveType_ShouldBeSettable() {
        NurbsCurve curve = new NurbsCurve();
        curve.setCurveType(NurbsType.CLOSED);

        assertEquals(NurbsType.CLOSED, curve.getCurveType());
    }

    @Test
    public void evaluate_ShouldThrowUnsupportedOperationException() {
        NurbsCurve curve = new NurbsCurve();

        assertThrows(UnsupportedOperationException.class, () -> curve.evaluate(10));
    }

    @Test
    public void evaluateAt_ShouldThrowUnsupportedOperationException() {
        NurbsCurve curve = new NurbsCurve();

        assertThrows(UnsupportedOperationException.class, () -> curve.evaluateAt(0.5));
    }
}
