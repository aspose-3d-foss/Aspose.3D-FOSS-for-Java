package com.aspose.threed;

/**
 * Save options for universal 3d.
 */
public class U3dSaveOptions extends SaveOptions {
    private boolean flipCoordinateSystem = false;
    private boolean meshCompression = false;
    private boolean exportNormals = true;
    private boolean exportTextureCoordinates = true;
    private boolean exportVertexDiffuse = true;
    private boolean exportVertexSpecular = true;
    private boolean embedTextures = false;

    /**
     * Constructor of U3dSaveOptions.
     */
    public U3dSaveOptions() {
    }

    /**
     * Gets whether flip coordinate system of control points/normal during importing/exporting.
     * @return true if flip coordinate system.
     */
    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    /**
     * Sets whether flip coordinate system of control points/normal during importing/exporting.
     * @param value New value.
     */
    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    /**
     * Gets whether to enable mesh data compression.
     * @return true if enable mesh compression.
     */
    public boolean getMeshCompression() {
        return meshCompression;
    }

    /**
     * Sets whether to enable mesh data compression.
     * @param value New value.
     */
    public void setMeshCompression(boolean value) {
        this.meshCompression = value;
    }

    /**
     * Gets whether to export normal data.
     * @return true if export normals.
     */
    public boolean getExportNormals() {
        return exportNormals;
    }

    /**
     * Sets whether to export normal data.
     * @param value New value.
     */
    public void setExportNormals(boolean value) {
        this.exportNormals = value;
    }

    /**
     * Gets whether to export texture coordinates.
     * @return true if export texture coordinates.
     */
    public boolean getExportTextureCoordinates() {
        return exportTextureCoordinates;
    }

    /**
     * Sets whether to export texture coordinates.
     * @param value New value.
     */
    public void setExportTextureCoordinates(boolean value) {
        this.exportTextureCoordinates = value;
    }

    /**
     * Gets whether to export vertex's diffuse color.
     * @return true if export vertex diffuse color.
     */
    public boolean getExportVertexDiffuse() {
        return exportVertexDiffuse;
    }

    /**
     * Sets whether to export vertex's diffuse color.
     * @param value New value.
     */
    public void setExportVertexDiffuse(boolean value) {
        this.exportVertexDiffuse = value;
    }

    /**
     * Gets whether to export vertex's specular color.
     * @return true if export vertex specular color.
     */
    public boolean getExportVertexSpecular() {
        return exportVertexSpecular;
    }

    /**
     * Sets whether to export vertex's specular color.
     * @param value New value.
     */
    public void setExportVertexSpecular(boolean value) {
        this.exportVertexSpecular = value;
    }

    /**
     * Embed the external textures into the U3D file, default value is false.
     * @return true if embed textures.
     */
    public boolean getEmbedTextures() {
        return embedTextures;
    }

    /**
     * Embed the external textures into the U3D file, default value is false.
     * @param value New value.
     */
    public void setEmbedTextures(boolean value) {
        this.embedTextures = value;
    }
}
