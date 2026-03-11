package com.aspose.threed;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ObjImportExportTest {
    private static final String CUBE_OBJ = "testdata/input/cube.obj";

    @Test
    public void testImportCube() throws Exception {
        Scene scene = Scene.fromFile(CUBE_OBJ);
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
        assertFalse(scene.getRootNode().getChildNodes().isEmpty());
    }

    @Test
    public void testImportExportCube() throws Exception {
        Scene scene = Scene.fromFile(CUBE_OBJ);
        
        String outputPath = "testdata/output/test_export.obj";
        java.io.File outputFile = new java.io.File(outputPath);
        outputFile.getParentFile().mkdirs();
        
        scene.save(outputPath);
        
        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
        
        Scene reimported = Scene.fromFile(outputPath);
        assertNotNull(reimported);
    }

    @Test
    public void testMeshStructure() throws Exception {
        Scene scene = Scene.fromFile(CUBE_OBJ);
        Node rootNode = scene.getRootNode();
        
        assertFalse(rootNode.getChildNodes().isEmpty());
        
        for (Node child : rootNode.getChildNodes()) {
            Entity entity = child.getEntity();
            if (entity instanceof Mesh) {
                Mesh mesh = (Mesh) entity;
                assertNotNull(mesh.getControlPoints());
                assertTrue(mesh.getControlPoints().size() > 0);
                assertTrue(mesh.getPolygonCount() > 0);
            }
        }
    }
}
