package com.aspose.threed;

/**
 * Save options for FBX format.
 */
public class FbxSaveOptions extends SaveOptions {
    private boolean reusePrimitiveMesh = false;
    private boolean enableCompression = true;
    private Boolean foldRepeatedCurveData = null;
    private boolean exportLegacyMaterialProperties = true;
    private boolean videoForTexture = false;
    private boolean embedTextures = false;
    private boolean generateVertexElementMaterial = false;

    /**
     * Initializes a FbxSaveOptions.
     */
    public FbxSaveOptions() {
        super();
    }

    /**
     * Initializes a FbxSaveOptions.
     * @param format Instance of IOConfig.getFileFormat(), it should be a valid FBX format.
     */
    public FbxSaveOptions(FileFormat format) {
        super(format);
    }

    /**
     * Initialize a FbxSaveOptions with a content type.
     * @param contentType The file content type.
     */
    public FbxSaveOptions(FileContentType contentType) {
        super(contentType);
        // For FBX, the file format is determined by the content type
        if (contentType == FileContentType.BINARY) {
            setFileFormat(FileFormat.FBX7700_BINARY);
        } else {
            setFileFormat(FileFormat.FBX7700ASCII);
        }
    }

    /**
     * Reuse the mesh for the primitives with same parameters, this will significantly reduce the size of FBX output which scene was constructed by large set of primitive shapes(like imported from CAD files).
     * Default value is false
     * @return true if reuse primitive mesh.
     */
    public boolean getReusePrimitiveMesh() {
        return reusePrimitiveMesh;
    }

    /**
     * Sets whether to reuse the mesh for the primitives with same parameters.
     * @param value New value.
     */
    public void setReusePrimitiveMesh(boolean value) {
        this.reusePrimitiveMesh = value;
    }

    /**
     * Compression large binary data in the FBX file(e.g. animation data, control points, vertex element data, indices), default value is true.
     * @return true if enable compression.
     */
    public boolean getEnableCompression() {
        return enableCompression;
    }

    /**
     * Sets whether to compress large binary data in the FBX file.
     * @param value New value.
     */
    public void setEnableCompression(boolean value) {
        this.enableCompression = value;
    }

    /**
     * Gets or sets whether reuse repeated curve data by increasing last data's ref count
     * @return Boolean value or null.
     */
    public Boolean getFoldRepeatedCurveData() {
        return foldRepeatedCurveData;
    }

    /**
     * Sets whether to reuse repeated curve data.
     * @param value New value.
     */
    public void setFoldRepeatedCurveData(Boolean value) {
        this.foldRepeatedCurveData = value;
    }

    /**
     * Gets or sets whether export legacy material properties, used for back compatibility.
     * This option is turned on by default.
     * @return true if export legacy material properties.
     */
    public boolean getExportLegacyMaterialProperties() {
        return exportLegacyMaterialProperties;
    }

    /**
     * Sets whether to export legacy material properties.
     * @param value New value.
     */
    public void setExportLegacyMaterialProperties(boolean value) {
        this.exportLegacyMaterialProperties = value;
    }

    /**
     * Gets or sets whether generate a Video instance for texture when exporting as FBX.
     * @return true if video for texture.
     */
    public boolean getVideoForTexture() {
        return videoForTexture;
    }

    /**
     * Sets whether to generate a Video instance for texture when exporting as FBX.
     * @param value New value.
     */
    public void setVideoForTexture(boolean value) {
        this.videoForTexture = value;
    }

    /**
     * Gets or sets whether to embed the texture to the final output file.
     * FBX Exporter will try to find the texture's raw data from the scene, and embed the file to final FBX file.
     * Default value is false.
     * @return true if embed textures.
     */
    public boolean getEmbedTextures() {
        return embedTextures;
    }

    /**
     * Sets whether to embed the texture to the final output file.
     * @param value New value.
     */
    public void setEmbedTextures(boolean value) {
        this.embedTextures = value;
    }

    /**
     * Gets or sets whether always generate a VertexElementMaterial for geometries if the attached node contains materials.
     * This is turned off by default.
     * @return true if generate vertex element material.
     */
    public boolean getGenerateVertexElementMaterial() {
        return generateVertexElementMaterial;
    }

    /**
     * Sets whether to always generate a VertexElementMaterial for geometries.
     * @param value New value.
     */
    public void setGenerateVertexElementMaterial(boolean value) {
        this.generateVertexElementMaterial = value;
    }
}
