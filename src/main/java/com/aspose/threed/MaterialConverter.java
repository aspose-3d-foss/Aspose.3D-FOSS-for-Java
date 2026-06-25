package com.aspose.threed;

/**
 * Custom converter to convert the geometry's original material to GLTF's PBR material.
 */
public interface MaterialConverter {
    /**
     * Custom converter to convert the geometry's original material to GLTF's PBR material.
     * @param mat Old material instance
     * @return New material instance
     */
    Material call(Material mat);
}
