package com.aspose.threed;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class FormatDetectionTests {
    @Test
    public void detectObjFormatFromStream_ShouldReturnObjFormat() throws IOException {
        String testFile = "testdata/input/cube.obj";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "cube.obj");
        stream.close();

        assertEquals("obj", format.getExtension());
    }

    @Test
    public void detectStlFormatFromStream_ShouldReturnStlFormat() throws IOException {
        String testFile = "testdata/stl/stl_ascii.stl";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "stl_ascii.stl");
        stream.close();

        assertEquals("stl", format.getExtension());
    }

    @Test
    public void detectGltfFormatFromStream_ShouldReturnGltfFormat() throws IOException {
        String testFile = "testdata/gltf/simple_cube.gltf";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "test.gltf");
        stream.close();

        assertEquals("gltf", format.getExtension());
    }

    @Test
    public void openStreamWithAutoDetectionObj_ShouldLoadCorrectly() throws IOException {
        String testFile = "testdata/input/cube.obj";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        Scene scene = new Scene();
        FileFormat format = FileFormat.getFormatByExtension(".obj");
        scene.open(Stream.wrap(stream), format);

        stream.close();
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
        assertTrue(scene.getRootNode().getChildNodes().size() > 0);

        Node node = scene.getRootNode().getChildNodes().get(0);
        assertNotNull(node.getEntities());
        assertTrue(node.getEntities().size() > 0);

        Mesh mesh = (Mesh) node.getEntities().get(0);
        assertNotNull(mesh);
        assertEquals(8, mesh.getControlPoints().size());
        assertEquals(3, mesh.getPolygonCount());
    }

    @Test
    public void openStreamWithAutoDetectionStl_ShouldLoadCorrectly() throws IOException {
        String testFile = "testdata/stl/stl_ascii.stl";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        Scene scene = new Scene();
        FileFormat format = FileFormat.getFormatByExtension(".stl");
        scene.open(Stream.wrap(stream), format);

        stream.close();
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
        assertTrue(scene.getRootNode().getChildNodes().size() > 0);

        Node node = scene.getRootNode().getChildNodes().get(0);
        assertNotNull(node.getEntities());
        assertTrue(node.getEntities().size() > 0);

        Mesh mesh = (Mesh) node.getEntities().get(0);
        assertNotNull(mesh);
        assertEquals(3, mesh.getControlPoints().size());
        assertEquals(1, mesh.getPolygonCount());
    }

    @Test
    public void openStreamWithAutoDetectionGltf_ShouldLoadCorrectly() throws IOException, ImportException {
        String testFile = "testdata/gltf/simple_cube.gltf";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        Scene scene = new Scene();
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "simple_cube.gltf");
        scene.open(Stream.wrap(stream), format, format.createLoadOptions());

        stream.close();
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
    }

    @Test
    public void openStreamWithFilename_ShouldDetectFormatFromFilename() throws IOException, ImportException {
        String testFile = "testdata/input/cube.obj";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        Scene scene = new Scene();
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "cube.obj");
        scene.open(Stream.wrap(stream), format, format.createLoadOptions());

        stream.close();
        assertNotNull(scene);
        assertNotNull(scene.getRootNode());
        assertTrue(scene.getRootNode().getChildNodes().size() > 0);

        Node node = scene.getRootNode().getChildNodes().get(0);
        assertNotNull(node.getEntities());
        assertTrue(node.getEntities().size() > 0);

        Mesh mesh = (Mesh) node.getEntities().get(0);
        assertNotNull(mesh);
        assertEquals(8, mesh.getControlPoints().size());
        assertEquals(3, mesh.getPolygonCount());
    }

    @Test
    public void detectObjFormatFromStreamWithFilename_ShouldReturnObjFormat() throws IOException {
        String testFile = "testdata/input/cube.obj";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "test.obj");
        stream.close();

        assertEquals("obj", format.getExtension());
    }

    @Test
    public void detectStlFormatFromStreamWithFilename_ShouldReturnStlFormat() throws IOException {
        String testFile = "testdata/stl/stl_ascii.stl";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "test.stl");
        stream.close();

        assertEquals("stl", format.getExtension());
    }

    @Test
    public void detectGltfFormatFromStreamWithFilename_ShouldReturnGltfFormat() throws IOException {
        String testFile = "testdata/gltf/simple_cube.gltf";

        File file = new File(testFile);
        if (!file.exists()) {
            throw new IOException("Test file not found: " + testFile);
        }

        FileInputStream stream = new FileInputStream(file);
        FileFormat format = FileFormat.detect(Stream.wrap(stream), "test.gltf");
        stream.close();

        assertEquals("gltf", format.getExtension());
    }
}
