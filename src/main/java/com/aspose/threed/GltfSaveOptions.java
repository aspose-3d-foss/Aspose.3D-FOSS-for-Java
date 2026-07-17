package com.aspose.threed;

/**
 * Save options for glTF format.
 */
public class GltfSaveOptions extends SaveOptions {
    private boolean prettyPrint = false;
    private Vector3 fallbackNormal = new Vector3(0, 1, 0);
    private boolean embedAssets = false;
    private GltfEmbeddedImageFormat imageFormat = GltfEmbeddedImageFormat.PNG;
    private MaterialConverter materialConverter = null;
    private boolean useCommonMaterials = false;
    private String externalDracoEncoder = null;
    private boolean flipTexCoordV = true;
    private String bufferFile = null;
    private boolean saveExtras = false;
    private boolean applyUnitScale = false;
    private boolean dracoCompression = false;

    /**
     * Constructor of GltfSaveOptions.
     * @param contentType The content type.
     */
    public GltfSaveOptions(FileContentType contentType) {
        super();
        // For glTF, the file format is determined by the content type
        // Binary -> GLTF_BINARY, ASCII -> GLTF
        if (contentType == FileContentType.BINARY) {
            setFileFormat(FileFormat.GLTF_BINARY);
        } else {
            setFileFormat(FileFormat.GLTF);
        }
    }

    /**
     * Constructor of GltfSaveOptions.
     * @param format The file format.
     */
    public GltfSaveOptions(FileFormat format) {
        super(format);
    }

    /**
     * The JSON content of GLTF file is indented for human reading, default value is false.
     * @return true if pretty print.
     */
    public boolean getPrettyPrint() {
        return prettyPrint;
    }

    /**
     * Sets whether the JSON content of GLTF file should be indented for human reading.
     * @param value New value.
     */
    public void setPrettyPrint(boolean value) {
        this.prettyPrint = value;
    }

    /**
     * When GLTF2 exporter detected an invalid normal, this will be used instead of its original value to bypass the validation.
     * Default value is (0, 1, 0)
     * @return The fallback normal vector.
     */
    public Vector3 getFallbackNormal() {
        return fallbackNormal;
    }

    /**
     * Sets the fallback normal vector when GLTF2 exporter detects an invalid normal.
     * @param value New value.
     */
    public void setFallbackNormal(Vector3 value) {
        this.fallbackNormal = value;
    }

    /**
     * Embed all external assets as base64 into single file in ASCII mode, default value is false.
     * @return true if embed assets.
     */
    public boolean getEmbedAssets() {
        return embedAssets;
    }

    /**
     * Sets whether to embed all external assets as base64 into single file.
     * @param value New value.
     */
    public void setEmbedAssets(boolean value) {
        this.embedAssets = value;
    }

    /**
     * Standard glTF only supports PNG/JPG as its texture format, this option will guide how Aspose.3D
     * convert the non-standard images to supported format during the exporting.
     * Default value is GltfEmbeddedImageFormat.PNG
     * @return The image format.
     */
    public GltfEmbeddedImageFormat getImageFormat() {
        return imageFormat;
    }

    /**
     * Sets the image format for texture conversion during export.
     * @param value New value.
     */
    public void setImageFormat(GltfEmbeddedImageFormat value) {
        this.imageFormat = value;
    }

    /**
     * Custom converter to convert the geometry's material to PBR material.
     * If this is unassigned, glTF 2.0 exporter will automatically convert the standard material to PBR material.
     * Default value is null.
     * @return The material converter.
     */
    public MaterialConverter getMaterialConverter() {
        return materialConverter;
    }

    /**
     * Sets the material converter to convert geometry's material to PBR material.
     * @param value New value.
     */
    public void setMaterialConverter(MaterialConverter value) {
        this.materialConverter = value;
    }

    /**
     * Serialize materials using KHR common material extensions, default value is false.
     * @return true if use common materials.
     */
    public boolean getUseCommonMaterials() {
        return useCommonMaterials;
    }

    /**
     * Sets whether to serialize materials using KHR common material extensions.
     * @param value New value.
     */
    public void setUseCommonMaterials(boolean value) {
        this.useCommonMaterials = value;
    }

    /**
     * Use external draco encoder to accelerate the draco compression speed.
     * @return The external draco encoder path.
     */
    public String getExternalDracoEncoder() {
        return externalDracoEncoder;
    }

    /**
     * Sets the external draco encoder path to accelerate compression.
     * @param value New value.
     */
    public void setExternalDracoEncoder(String value) {
        this.externalDracoEncoder = value;
    }

    /**
     * Flip texture coordinate v(t) component, default value is true.
     * @return true if flip texture coordinate V.
     */
    public boolean getFlipTexCoordV() {
        return flipTexCoordV;
    }

    /**
     * Sets whether to flip texture coordinate v(t) component.
     * @param value New value.
     */
    public void setFlipTexCoordV(boolean value) {
        this.flipTexCoordV = value;
    }

    /**
     * The file name of the external buffer file used to store binary data.
     * If this file is not specified, Aspose.3D will generate a name for you.
     * This is ignored when export glTF in binary mode.
     * @return The buffer file name.
     */
    public String getBufferFile() {
        return bufferFile;
    }

    /**
     * Sets the file name of the external buffer file.
     * @param value New value.
     */
    public void setBufferFile(String value) {
        this.bufferFile = value;
    }

    /**
     * Save scene object's dynamic properties into 'extra' fields in the generated glTF file.
     * This is useful to provide application-specific data.
     * Default value is false.
     * @return true if save extras.
     */
    public boolean getSaveExtras() {
        return saveExtras;
    }

    /**
     * Sets whether to save scene object's dynamic properties into 'extra' fields.
     * @param value New value.
     */
    public void setSaveExtras(boolean value) {
        this.saveExtras = value;
    }

    /**
     * Apply AssetInfo.getUnitScaleFactor() to the mesh.
     * Default value is false.
     * @return true if apply unit scale.
     */
    public boolean getApplyUnitScale() {
        return applyUnitScale;
    }

    /**
     * Sets whether to apply AssetInfo.getUnitScaleFactor() to the mesh.
     * @param value New value.
     */
    public void setApplyUnitScale(boolean value) {
        this.applyUnitScale = value;
    }

    /**
     * Gets or sets whether to enable draco compression.
     * @return true if draco compression enabled.
     */
    public boolean getDracoCompression() {
        return dracoCompression;
    }

    /**
     * Sets whether to enable draco compression.
     * @param value New value.
     */
    public void setDracoCompression(boolean value) {
        this.dracoCompression = value;
    }
}
