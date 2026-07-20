package com.aspose.threed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VertexElementTemplateTests {
    @Test
    public void data_ShouldBeWritable() {
        TestVertexElementTemplate element = new TestVertexElementTemplate();

        assertNotNull(element.getData());
        assertEquals(0, element.getData().size());

        element.getData().add(1.5);
        element.getData().add(2.5);
        assertEquals(2, element.getData().size());
    }

    @Test
    public void copyTo_ShouldCopyData() {
        TestVertexElementTemplate source = new TestVertexElementTemplate();
        source.getData().add(1.5);
        source.getData().add(2.5);

        TestVertexElementTemplate target = new TestVertexElementTemplate();
        source.copyTo(target);

        assertEquals(2, target.getData().size());
        assertEquals(1.5, target.getData().get(0), 1e-10);
        assertEquals(2.5, target.getData().get(1), 1e-10);
    }

    @Test
    public void setData_ShouldSetData() {
        TestVertexElementTemplate element = new TestVertexElementTemplate();
        Double[] data = {1.0, 2.0, 3.0};

        element.setData(data);

        assertEquals(3, element.getData().size());
        assertEquals(1.0, element.getData().get(0), 1e-10);
        assertEquals(2.0, element.getData().get(1), 1e-10);
        assertEquals(3.0, element.getData().get(2), 1e-10);
    }

    @Test
    public void clear_ShouldClearData() {
        TestVertexElementTemplate element = new TestVertexElementTemplate();
        element.getData().add(1.0);
        element.getData().add(2.0);

        element.clear();

        assertEquals(0, element.getData().size());
    }

    private static class TestVertexElementTemplate extends VertexElementTemplate<Double> {
        public TestVertexElementTemplate() {
            super();
        }
    }
}
