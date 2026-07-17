package com.aspose.threed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GltfFormatTest {
    @Test
    public void testGltfLoadOptions() {
        // GltfLoadOptions constructor takes no args in .NET FOSS but On-Premise might not have it
        // The API has changed, using no-arg constructor
        GltfLoadOptions options = new GltfLoadOptions();
        assertNotNull(options);
        
        // FlipTexCoordV is the new property name for flip texture coordinate V
        options.setFlipTexCoordV(true);
        assertTrue(options.getFlipTexCoordV());
    }
    
    @Test
    public void testGltfSaveOptions() {
        // GltfSaveOptions might not have no-arg constructor in On-Premise
        // Need to use FileFormat or FileContentType constructor
        GltfSaveOptions options = new GltfSaveOptions(FileFormat.GLTF2);
        assertNotNull(options);
        
        // Test new property names
        options.setPrettyPrint(true);
        assertTrue(options.getPrettyPrint());
        
        // BufferFile is the new property name (not BufferFilePrefix)
        options.setBufferFile("buffer_");
        assertEquals("buffer_", options.getBufferFile());
        
        // SaveExtras is now a boolean, not a String
        options.setSaveExtras(true);
        assertTrue(options.getSaveExtras());
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
