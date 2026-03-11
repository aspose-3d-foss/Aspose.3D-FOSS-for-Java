package com.aspose.threed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector3Test {
    @Test
    public void testConstructor() {
        Vector3 v = new Vector3(1, 2, 3);
        assertEquals(1, v.x);
        assertEquals(2, v.y);
        assertEquals(3, v.z);
    }

    @Test
    public void testAdd() {
        Vector3 a = new Vector3(1, 2, 3);
        Vector3 b = new Vector3(4, 5, 6);
        Vector3 c = Vector3.add(a, b);
        assertEquals(5, c.x);
        assertEquals(7, c.y);
        assertEquals(9, c.z);
    }

    @Test
    public void testDot() {
        Vector3 a = new Vector3(1, 2, 3);
        Vector3 b = new Vector3(4, 5, 6);
        assertEquals(32, a.dot(b));
    }

    @Test
    public void testCross() {
        Vector3 a = Vector3.getUnitX();
        Vector3 b = Vector3.getUnitY();
        Vector3 c = a.cross(b);
        assertEquals(0, c.x, 1e-10);
        assertEquals(0, c.y, 1e-10);
        assertEquals(1, c.z, 1e-10);
    }
}
