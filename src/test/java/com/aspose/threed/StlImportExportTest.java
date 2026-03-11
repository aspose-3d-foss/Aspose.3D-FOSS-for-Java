package com.aspose.threed;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StlImportExportTest {
    private static final String STL_BINARY = "testdata/input/stl_binary.stl";
    private static final String STL_ASCII = "testdata/input/stl_ascii.stl";

    @Test
    public void testImportStlBinary() throws Exception {
        Scene scene = Scene.fromFile(STL_BINARY);
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
    }

    @Test
    public void testImportStlAscii() throws Exception {
        Scene scene = Scene.fromFile(STL_ASCII);
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
    }

    @Test
    public void testStlExportBinary() throws Exception {
        Scene scene = Scene.fromFile(STL_BINARY);
        
        String outputPath = "testdata/output/stl_binary_export.stl";
        java.io.File outputFile = new java.io.File(outputPath);
        outputFile.getParentFile().mkdirs();
        
        scene.save(outputPath);
        
        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
    }

    @Test
    public void testStlExportAscii() throws Exception {
        Scene scene = Scene.fromFile(STL_BINARY);
        
        String outputPath = "testdata/output/stl_ascii_export.stl";
        java.io.File outputFile = new java.io.File(outputPath);
        outputFile.getParentFile().mkdirs();
        
        scene.save(outputPath);
        
        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
        
        String content = new String(java.nio.file.Files.readAllBytes(outputFile.toPath()));
        assertTrue(content.startsWith("solid"));
        assertTrue(content.contains("facet"));
    }

    @Test
    public void testStlRoundtripBinary() throws Exception {
        Scene scene = Scene.fromFile(STL_BINARY);
        
        String outputPath = "testdata/output/stl_roundtrip.stl";
        scene.save(outputPath);
        
        Scene reimported = Scene.fromFile(outputPath);
        assertNotNull(reimported);
    }
}
