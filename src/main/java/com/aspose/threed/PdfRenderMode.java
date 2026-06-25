package com.aspose.threed;

/**
 * Render mode specifies the style in which the 3D artwork is rendered.
 */
public enum PdfRenderMode {
    /**
     * Displays textured and lit geometric shapes.
     */
    SOLID,
    /**
     * Displays textured and lit geometric shapes (triangles) with single color edges on top of them.
     */
    SOLID_WIREFRAME,
    /**
     * Displays textured and lit geometric shapes (triangles) with an added level of transparency.
     */
    TRANSPARENT,
    /**
     * Displays textured and lit geometric shapes (triangles) with an added level of transparency, with single color opaque edges on top of it.
     */
    TRANSPARENT_WIREFRAME,
    /**
     * Displays the bounding box edges of each node, aligned with the axes of the local coordinate space for that node.
     */
    BOUNDING_BOX,
    /**
     * Displays bounding boxes faces of each node, aligned with the axes of the local coordinate space for that node, with an added level of transparency.
     */
    TRANSPARENT_BOUNDING_BOX,
    /**
     * Displays bounding boxes edges and faces of each node, aligned with the axes of the local coordinate space for that node, with an added level of transparency.
     */
    TRANSPARENT_BOUNDING_BOX_OUTLINE,
    /**
     * Displays only edges in a single color.
     */
    WIREFRAME,
    /**
     * Displays only edges, though interpolates their color between their two vertices and applies lighting.
     */
    SHADED_WIREFRAME,
    /**
     * Displays edges in a single color, though removes back-facing and obscured edges.
     */
    HIDDEN_WIREFRAME,
    /**
     * Displays only vertices in a single color.
     */
    VERTICES,
    /**
     * Displays only vertices, though uses their vertex color and applies lighting.
     */
    SHADED_VERTICES,
    /**
     * Displays silhouette edges with surfaces, removes obscured lines.
     */
    ILLUSTRATION,
    /**
     * Displays silhouette edges with lit and textured surfaces, removes obscured lines.
     */
    SOLID_OUTLINE,
    /**
     * Displays silhouette edges with lit and textured surfaces and an additional emissive term to remove poorly lit areas of the artwork.
     */
    SHADED_ILLUSTRATION;
}
