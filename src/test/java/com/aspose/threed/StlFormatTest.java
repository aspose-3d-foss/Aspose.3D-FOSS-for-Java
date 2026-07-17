package com.aspose.threed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class StlFormatTest {
    @Test
    public void testStlBinaryExport() throws IOException {
        Scene scene = new Scene();
        Mesh mesh = new Mesh("TestMesh");
        
        mesh.addControlPoint(0, 0, 0);
        mesh.addControlPoint(1, 0, 0);
        mesh.addControlPoint(0, 1, 0);
        mesh.addControlPoint(0, 0, 1);
        
        mesh.createPolygon(new int[]{0, 1, 2});
        mesh.createPolygon(new int[]{0, 1, 3});
        mesh.createPolygon(new int[]{0, 2, 3});
        mesh.createPolygon(new int[]{1, 2, 3});
        
        scene.getRootNode().createChildNode("TestNode", mesh);
        
        Path outputPath = Files.createTempFile("test_export", ".stl");
        try {
            StlSaveOptions options = new StlSaveOptions();
            // Set the file format explicitly
            options.setFileFormat(FileFormat.STL_BINARY);
            scene.save(outputPath.toString(), options);
            
            assertTrue(Files.exists(outputPath));
            assertTrue(Files.size(outputPath) > 80, "STL binary file should be larger than header");
            
            byte[] content = Files.readAllBytes(outputPath);
            assertEquals(84 + (4 * 50), content.length, "Binary STL with 4 faces should be 284 bytes");
        } finally {
            Files.deleteIfExists(outputPath);
        }
    }
    
    @Test
    public void testStlAsciiExport() throws IOException {
        Scene scene = new Scene();
        Mesh mesh = new Mesh("TestMesh");
        
        mesh.addControlPoint(0, 0, 0);
        mesh.addControlPoint(1, 0, 0);
        mesh.addControlPoint(0, 1, 0);
        
        mesh.createPolygon(new int[]{0, 1, 2});
        
        scene.getRootNode().createChildNode("TestNode", mesh);
        
        Path outputPath = Files.createTempFile("test_export_ascii", ".stl");
        try {
            StlSaveOptions options = new StlSaveOptions();
            // Set the file format explicitly
            options.setFileFormat(FileFormat.STLASCII);
            scene.save(outputPath.toString(), options);
            
            assertTrue(Files.exists(outputPath));
            String content = Files.readString(outputPath);
            
            assertTrue(content.contains("solid"), "ASCII STL should start with 'solid'");
            assertTrue(content.contains("endsolid"), "ASCII STL should end with 'endsolid'");
            assertTrue(content.contains("facet normal"), "ASCII STL should contain facet data");
            assertTrue(content.contains("vertex"), "ASCII STL should contain vertex data");
        } finally {
            Files.deleteIfExists(outputPath);
        }
    }
    
    @Test
    public void testCreateSimpleStlBinary() throws IOException {
        Path testPath = Files.createTempFile("test_binary", ".stl");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] header = new byte[80];
            byte[] countBytes = new byte[]{1, 0, 0, 0};
            byte[] faceData = new byte[50];
            
            baos.write(header);
            baos.write(countBytes);
            baos.write(faceData);
            
            Files.write(testPath, baos.toByteArray());
            
            Scene scene = Scene.fromFile(testPath.toString(), new StlLoadOptions());
            assertNotNull(scene);
            
            Node rootNode = scene.getRootNode();
            assertNotNull(rootNode);
        } finally {
            Files.deleteIfExists(testPath);
        }
    }
    
    @Test
    public void testCreateSimpleStlAscii() throws IOException {
        Path testPath = Files.createTempFile("test_ascii", ".stl");
        try {
            String stlContent = "solid test\n" +
                               " facet normal 0 0 1\n" +
                               "  outer loop\n" +
                               "   vertex 0 0 0\n" +
                               "   vertex 1 0 0\n" +
                               "   vertex 0 1 0\n" +
                               "  endloop\n" +
                               " endfacet\n" +
                               "endsolid test\n";
            
            Files.writeString(testPath, stlContent);
            
            Scene scene = Scene.fromFile(testPath.toString(), new StlLoadOptions());
            assertNotNull(scene);
            
            Node rootNode = scene.getRootNode();
            assertNotNull(rootNode);
        } finally {
            Files.deleteIfExists(testPath);
        }
    }
    
    @Test
    public void testStlLoadOptions() {
        StlLoadOptions options = new StlLoadOptions();
        assertNotNull(options);
        
        options.setFlipCoordinateSystem(true);
        assertTrue(options.getFlipCoordinateSystem());
        
        // Note: getContentType/setContentType don't exist in On-Premise
        // Content type is determined by FileFormat during save/load
    }
    
    @Test
    public void testStlSaveOptions() {
        StlSaveOptions options = new StlSaveOptions();
        assertNotNull(options);
        
        options.setFlipCoordinateSystem(true);
        assertTrue(options.getFlipCoordinateSystem());
        
        // Note: getContentType/setContentType don't exist in On-Premise
        // Content type is determined by FileFormat during save/load
    }
}
