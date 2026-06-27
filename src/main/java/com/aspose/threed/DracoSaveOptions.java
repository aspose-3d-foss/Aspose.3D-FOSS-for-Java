package com.aspose.threed;

/**
 * Options for Draco compression.
 */
public class DracoSaveOptions extends SaveOptions {
    private int positionBits = 14;
    private int textureCoordinateBits = 12;
    private int colorBits = 10;
    private int normalBits = 10;
    private DracoCompressionLevel compressionLevel = DracoCompressionLevel.STANDARD;
    private boolean applyUnitScale = false;
    private boolean pointCloud = false;

    /**
     * Constructor of DracoSaveOptions.
     */
    public DracoSaveOptions() {
    }

    /**
     * Quantization bits for position, default value is 14.
     * @return Quantization bits for position.
     */
    public int getPositionBits() {
        return positionBits;
    }

    /**
     * Quantization bits for position, default value is 14.
     * @param value New value.
     */
    public void setPositionBits(int value) {
        this.positionBits = value;
    }

    /**
     * Quantization bits for texture coordinate, default value is 12.
     * @return Quantization bits for texture coordinate.
     */
    public int getTextureCoordinateBits() {
        return textureCoordinateBits;
    }

    /**
     * Quantization bits for texture coordinate, default value is 12.
     * @param value New value.
     */
    public void setTextureCoordinateBits(int value) {
        this.textureCoordinateBits = value;
    }

    /**
     * Quantization bits for vertex color, default value is 10.
     * @return Quantization bits for vertex color.
     */
    public int getColorBits() {
        return colorBits;
    }

    /**
     * Quantization bits for vertex color, default value is 10.
     * @param value New value.
     */
    public void setColorBits(int value) {
        this.colorBits = value;
    }

    /**
     * Quantization bits for normal vectors, default value is 10.
     * @return Quantization bits for normal vectors.
     */
    public int getNormalBits() {
        return normalBits;
    }

    /**
     * Quantization bits for normal vectors, default value is 10.
     * @param value New value.
     */
    public void setNormalBits(int value) {
        this.normalBits = value;
    }

    /**
     * Compression level, default value is DracoCompressionLevel.STANDARD.
     * @return Compression level.
     */
    public DracoCompressionLevel getCompressionLevel() {
        return compressionLevel;
    }

    /**
     * Compression level, default value is DracoCompressionLevel.STANDARD.
     * @param value New value.
     */
    public void setCompressionLevel(DracoCompressionLevel value) {
        this.compressionLevel = value;
    }

    /**
     * Apply AssetInfo.getUnitScaleFactor() to the mesh. Default value is false.
     * @return true if apply unit scale.
     */
    public boolean getApplyUnitScale() {
        return applyUnitScale;
    }

    /**
     * Apply AssetInfo.getUnitScaleFactor() to the mesh. Default value is false.
     * @param value New value.
     */
    public void setApplyUnitScale(boolean value) {
        this.applyUnitScale = value;
    }

    /**
     * Export the scene as point cloud, default value is false.
     * @return true if export as point cloud.
     */
    public boolean getPointCloud() {
        return pointCloud;
    }

    /**
     * Export the scene as point cloud, default value is false.
     * @param value New value.
     */
    public void setPointCloud(boolean value) {
        this.pointCloud = value;
    }
}
