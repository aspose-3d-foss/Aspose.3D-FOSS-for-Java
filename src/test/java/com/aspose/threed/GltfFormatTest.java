package com.aspose.threed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GltfFormatTest {
    @Test
    public void testGltfLoadOptions() {
        GltfLoadOptions options = new GltfLoadOptions();
        assertNotNull(options);
        
        options.setFlipCoordinateSystem(true);
        assertTrue(options.getFlipCoordinateSystem());
        
        options.setPrettyPrint(true);
        assertTrue(options.getPrettyPrint());
    }
    
    @Test
    public void testGltfSaveOptions() {
        GltfSaveOptions options = new GltfSaveOptions();
        assertNotNull(options);
        
        options.setFlipCoordinateSystem(true);
        assertTrue(options.getFlipCoordinateSystem());
        
        options.setPrettyPrint(true);
        assertTrue(options.getPrettyPrint());
        
        options.setBufferFilePrefix("buffer_");
        assertEquals("buffer_", options.getBufferFilePrefix());
        
        options.setSaveExtras("custom");
        assertEquals("custom", options.getSaveExtras());
    }
    
    @Test
    public void testGltfFormatDetection() {
        FileFormat gltfFormat = FileFormat.getFormatByExtension("model.gltf");
        assertNotNull(gltfFormat);
        assertTrue(gltfFormat.getCanImport());
        assertTrue(gltfFormat.getCanExport());
        
        FileFormat glbFormat = FileFormat.getFormatByExtension("model.glb");
        assertNotNull(glbFormat);
        assertTrue(glbFormat.getCanImport());
        assertTrue(glbFormat.getCanExport());
    }
}
