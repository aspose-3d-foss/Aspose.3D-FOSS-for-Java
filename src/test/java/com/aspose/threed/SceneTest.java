package com.aspose.threed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SceneTest {
    @Test
    public void testSceneCreation() {
        Scene scene = new Scene();
        assertNotNull(scene.getRootNode());
        assertEquals("RootNode", scene.getRootNode().getName());
    }

    @Test
    public void testSceneFromEntity() {
        Scene scene = new Scene();
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
    }

    @Test
    public void testNodeCreation() {
        Scene scene = new Scene();
        Node node = scene.getRootNode().createChildNode("TestNode");
        assertNotNull(node);
        assertEquals("TestNode", node.getName());
        assertEquals(1, scene.getRootNode().getChildNodes().size());
    }

    @Test
    public void testTransform() {
        Node node = new Node("Test");
        Transform t = node.getTransform();
        assertNotNull(t);
        t.setTranslation(1, 2, 3);
        assertEquals(1, t.getTranslation().x, 1e-10);
        assertEquals(2, t.getTranslation().y, 1e-10);
        assertEquals(3, t.getTranslation().z, 1e-10);
    }
}
