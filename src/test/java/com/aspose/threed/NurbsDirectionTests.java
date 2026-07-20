package com.aspose.threed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NurbsDirectionTests {
    @Test
    public void constructor_ShouldInitializeDefaultValues() {
        NurbsDirection direction = new NurbsDirection();

        assertNotNull(direction);
        assertEquals(3, direction.getOrder());
        assertEquals(2, direction.getDegree());
        assertEquals(10, direction.getDivisions());
        assertEquals(NurbsType.OPEN, direction.getType());
        assertEquals(4, direction.getCount());
    }

    @Test
    public void knotVectors_ShouldBeWritable() {
        NurbsDirection direction = new NurbsDirection();
        java.util.List<Double> knotVectors = direction.getKnotVectors();

        assertNotNull(knotVectors);
        assertEquals(0, knotVectors.size());

        knotVectors.add(0.0);
        knotVectors.add(1.0);
        assertEquals(2, knotVectors.size());
    }

    @Test
    public void multiplicity_ShouldBeWritable() {
        NurbsDirection direction = new NurbsDirection();
        java.util.List<Integer> multiplicity = direction.getMultiplicity();

        assertNotNull(multiplicity);
        assertEquals(0, multiplicity.size());

        multiplicity.add(2);
        assertEquals(1, multiplicity.size());
    }

    @Test
    public void order_ShouldBeSettable() {
        NurbsDirection direction = new NurbsDirection();
        direction.setOrder(4);

        assertEquals(4, direction.getOrder());
    }

    @Test
    public void degree_ShouldBeSettable() {
        NurbsDirection direction = new NurbsDirection();
        direction.setDegree(2);

        assertEquals(2, direction.getDegree());
    }

    @Test
    public void divisions_ShouldBeSettable() {
        NurbsDirection direction = new NurbsDirection();
        direction.setDivisions(20);

        assertEquals(20, direction.getDivisions());
    }

    @Test
    public void type_ShouldBeSettable() {
        NurbsDirection direction = new NurbsDirection();
        direction.setType(NurbsType.CLOSED);

        assertEquals(NurbsType.CLOSED, direction.getType());
    }

    @Test
    public void count_ShouldBeSettable() {
        NurbsDirection direction = new NurbsDirection();
        direction.setCount(8);

        assertEquals(8, direction.getCount());
    }
}
